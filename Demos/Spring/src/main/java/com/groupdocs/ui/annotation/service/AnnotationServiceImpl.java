package com.groupdocs.ui.annotation.service;

import com.groupdocs.annotation.licenses.License;
import com.groupdocs.annotation.models.annotationmodels.AnnotationBase;
import com.groupdocs.annotation.Annotator;
import com.groupdocs.annotation.IDocumentInfo;
import com.groupdocs.annotation.exceptions.AnnotatorException;
import com.groupdocs.annotation.models.PageInfo;
import com.groupdocs.annotation.options.LoadOptions;
import com.groupdocs.annotation.options.pagepreview.PreviewFormats;
import com.groupdocs.annotation.options.export.AnnotationType;
import com.groupdocs.annotation.options.export.SaveOptions;
import com.groupdocs.annotation.options.pagepreview.CreatePageStream;
import com.groupdocs.annotation.options.pagepreview.PreviewOptions;
import com.groupdocs.ui.annotation.annotator.AnnotatorFactory;
import com.groupdocs.ui.annotation.annotator.BaseAnnotator;
import com.groupdocs.ui.annotation.config.AnnotationConfiguration;
import com.groupdocs.ui.annotation.entity.web.AnnotatedDocumentEntity;
import com.groupdocs.ui.annotation.entity.web.AnnotationDataEntity;
import com.groupdocs.ui.annotation.entity.web.AnnotationPostedDataEntity;
import com.groupdocs.ui.annotation.entity.web.PageDataDescriptionEntity;
import com.groupdocs.ui.annotation.util.AnnotationMapper;
import com.groupdocs.ui.annotation.util.DocumentTypesConverter;
import com.groupdocs.ui.annotation.util.SupportedAnnotations;
import com.groupdocs.ui.config.GlobalConfiguration;
import com.groupdocs.ui.exception.TotalGroupDocsException;
import com.groupdocs.ui.model.request.FileTreeRequest;
import com.groupdocs.ui.model.request.LoadDocumentPageRequest;
import com.groupdocs.ui.model.request.LoadDocumentRequest;
import com.groupdocs.ui.model.response.FileDescriptionEntity;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import javax.annotation.PostConstruct;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Base64;
import java.util.Iterator;

@Service
public class AnnotationServiceImpl implements AnnotationService {

    private static final Logger logger = LoggerFactory.getLogger(AnnotationServiceImpl.class);
    private final List<String> SupportedImageFormats = new ArrayList<>();

    @Autowired
    private GlobalConfiguration globalConfiguration;

    @Autowired
    private AnnotationConfiguration annotationConfiguration;

    private final List<PageDataDescriptionEntity> annotationPageDescriptionEntityList = new ArrayList<>();

    // ============================================================
    // Document session cache - keeps Annotator open to avoid
    // re-parsing the document (~60s) on every page request
    // ============================================================
    private static final ConcurrentHashMap<String, DocumentSession> documentSessionCache = new ConcurrentHashMap<>();
    private static final long SESSION_EXPIRY_MS = 30 * 60 * 1000; // 30 minutes

    private static class DocumentSession {
        final Annotator annotator;
        final IDocumentInfo info;
        final List<AnnotationBase> annotations;
        final String documentType;
        final long lastModified;
        volatile long lastAccessTime;
        final Object renderLock = new Object();

        DocumentSession(Annotator annotator, IDocumentInfo info, List<AnnotationBase> annotations,
                         String documentType, long lastModified) {
            this.annotator = annotator;
            this.info = info;
            this.annotations = annotations;
            this.documentType = documentType;
            this.lastModified = lastModified;
            this.lastAccessTime = System.currentTimeMillis();
        }

        boolean isExpired() {
            return System.currentTimeMillis() - lastAccessTime > SESSION_EXPIRY_MS;
        }

        void touch() {
            this.lastAccessTime = System.currentTimeMillis();
        }

        byte[] renderPage(int pageNumber) {
            synchronized (renderLock) {
                return renderPageToBytes(annotator, pageNumber);
            }
        }

        void dispose() {
            try {
                annotator.dispose();
            } catch (Exception e) {
                // ignore dispose errors
            }
        }
    }

    private static String buildSessionKey(String guid) {
        return guid;
    }

    private DocumentSession getOrCreateSession(String guid, String password) {
        String key = buildSessionKey(guid);
        long currentLastModified = new File(guid).lastModified();

        DocumentSession session = documentSessionCache.get(key);
        if (session != null && !session.isExpired() && session.lastModified == currentLastModified) {
            session.touch();
            return session;
        }

        // Evict old session if exists
        if (session != null) {
            documentSessionCache.remove(key);
            session.dispose();
        }

        // Clean up expired sessions
        cleanExpiredSessions();

        logger.debug("Creating new document session for: {}", guid);
        long startTime = System.currentTimeMillis();

        try {
            Annotator annotator = new Annotator(guid, getLoadOptions(password));
            IDocumentInfo info = annotator.getDocument().getDocumentInfo();
            List<AnnotationBase> annotations = annotator.get();

            String documentType = "";
            if (info.getFileType() != null) {
                documentType = SupportedImageFormats.contains(info.getFileType().getExtension()) ? "image" : info.getFileType().toString();
            } else {
                documentType = "Portable Document Format";
            }

            long elapsed = System.currentTimeMillis() - startTime;
            logger.debug("Document session created in {}ms: pageCount={}, fileType={}", elapsed, info.getPageCount(), info.getFileType());

            DocumentSession newSession = new DocumentSession(annotator, info, annotations, documentType, currentLastModified);
            documentSessionCache.put(key, newSession);
            return newSession;
        } catch (Exception e) {
            logger.error("Failed to create document session for: {}", guid, e);
            throw new TotalGroupDocsException(e.getMessage(), e);
        }
    }

    private void invalidateSession(String guid) {
        DocumentSession session = documentSessionCache.remove(buildSessionKey(guid));
        if (session != null) {
            session.dispose();
        }
    }

    private static void cleanExpiredSessions() {
        documentSessionCache.entrySet().removeIf(entry -> {
            if (entry.getValue().isExpired()) {
                entry.getValue().dispose();
                return true;
            }
            return false;
        });
    }

    // ============================================================
    // Page image cache
    // ============================================================
    private static final ConcurrentHashMap<String, CacheEntry> pageImageCache = new ConcurrentHashMap<>();
    private static final long CACHE_EXPIRY_MS = 30 * 60 * 1000; // 30 minutes

    private static class CacheEntry {
        final byte[] data;
        final long createdAt;

        CacheEntry(byte[] data) {
            this.data = data;
            this.createdAt = System.currentTimeMillis();
        }

        boolean isExpired() {
            return System.currentTimeMillis() - createdAt > CACHE_EXPIRY_MS;
        }
    }

    private static String buildImageCacheKey(String guid, long lastModified, int pageNumber) {
        return guid + "|" + lastModified + "|" + pageNumber;
    }

    private static void cleanExpiredImageCache() {
        pageImageCache.entrySet().removeIf(entry -> entry.getValue().isExpired());
    }

    private byte[] getCachedOrRenderPage(DocumentSession session, String guid, int pageNumber) {
        String cacheKey = buildImageCacheKey(guid, session.lastModified, pageNumber);
        CacheEntry cached = pageImageCache.get(cacheKey);
        if (cached != null && !cached.isExpired()) {
            return cached.data;
        }

        byte[] bytes = session.renderPage(pageNumber);
        pageImageCache.put(cacheKey, new CacheEntry(bytes));

        if (pageImageCache.size() > 500) {
            cleanExpiredImageCache();
        }
        return bytes;
    }

    // ============================================================
    // Rendering helper
    // ============================================================
    private static byte[] renderPageToBytes(Annotator annotator, int pageNumberToRender) {
        try {
            final ByteArrayOutputStream result = new ByteArrayOutputStream();
            PreviewOptions previewOptions = new PreviewOptions(
                new CreatePageStream() {
                    @Override
                    public OutputStream invoke(int pageNumber) {
                        return result;
                    }
                }
            );
            previewOptions.setPreviewFormat(PreviewFormats.PNG);
            previewOptions.setPageNumbers(new int[]{pageNumberToRender});
            previewOptions.setRenderComments(false);

            annotator.getDocument().generatePreview(previewOptions);
            return result.toByteArray();
        } catch (Exception ex) {
            throw new TotalGroupDocsException(ex);
        }
    }

    private static LoadOptions getLoadOptions(String password) {
        LoadOptions loadOptions = new LoadOptions();
        loadOptions.setPassword(password);
        return loadOptions;
    }

    // ============================================================
    // Initialization
    // ============================================================
    @PostConstruct
    public void init() {
        try {
            SupportedImageFormats.add(".bmp");
            SupportedImageFormats.add(".jpeg");
            SupportedImageFormats.add(".jpg");
            SupportedImageFormats.add(".tiff");
            SupportedImageFormats.add(".tif");
            SupportedImageFormats.add(".png");
            SupportedImageFormats.add(".dwg");
            SupportedImageFormats.add(".dcm");
            SupportedImageFormats.add(".dxf");

            // set GroupDocs license
            License license = new License();
            license.setLicense(globalConfiguration.getApplication().getLicensePath());
        } catch (Throwable exc) {
            logger.error("Can not verify Annotation license!");
        }
    }

    @Override
    public GlobalConfiguration getGlobalConfiguration() {
        return globalConfiguration;
    }

    @Override
    public AnnotationConfiguration getAnnotationConfiguration() {
        return annotationConfiguration;
    }

    // ============================================================
    // File list
    // ============================================================
    @Override
    public List<FileDescriptionEntity> getFileList(FileTreeRequest fileTreeRequest) {
        String path = fileTreeRequest.getPath();
        if (StringUtils.isEmpty(path)) {
            path = annotationConfiguration.getFilesDirectory();
        }
        try {
            File directory = new File(path);
            List<File> filesList = Arrays.asList(directory.listFiles());

            List<FileDescriptionEntity> fileList = getFileDescriptionEntities(filesList);
            return fileList;
        } catch (Exception ex) {
            logger.error("Exception in getting file list", ex);
            throw new TotalGroupDocsException(ex.getMessage(), ex);
        }
    }

    public List<FileDescriptionEntity> getFileDescriptionEntities(List<File> filesList) {
        List<FileDescriptionEntity> fileList = new ArrayList<>();
        for (File file : filesList) {
            String guid = file.getAbsolutePath();
            String extension = FilenameUtils.getExtension(guid);
            if (file.isDirectory() || (!StringUtils.isEmpty(extension))) {
                FileDescriptionEntity fileDescription = new FileDescriptionEntity();
                fileDescription.setGuid(guid);
                fileDescription.setName(file.getName());
                fileDescription.setDirectory(file.isDirectory());
                fileDescription.setSize(file.length());
                fileList.add(fileDescription);
            }
        }
        return fileList;
    }

    // ============================================================
    // Document loading (initial open)
    // ============================================================
    @Override
    public AnnotatedDocumentEntity getDocumentDescription(LoadDocumentRequest loadDocumentRequest) {
        try {
            return loadDocument(
                loadDocumentRequest,
                annotationConfiguration.getPreloadPageCount() == 0
            );
        } catch (Throwable ex) {
            throw new TotalGroupDocsException(ex);
        }
    }

    public final AnnotatedDocumentEntity loadDocument(LoadDocumentRequest loadDocumentRequest, boolean loadAllPages) {
        AnnotatedDocumentEntity description = new AnnotatedDocumentEntity();
        String guid = loadDocumentRequest.getGuid();
        String password = loadDocumentRequest.getPassword();

        try {
            DocumentSession session = getOrCreateSession(guid, password);

            description.setGuid(guid);
            description.supportedAnnotations = SupportedAnnotations.getSupportedAnnotations(session.documentType);

            List<String> pagesContent = new ArrayList<>();
            if (loadAllPages) {
                pagesContent = getAllPagesContent(session, guid);
            }

            for (int i = 0; i < session.info.getPageCount(); i++) {
                PageDataDescriptionEntity page = new PageDataDescriptionEntity();
                page.setNumber(i + 1);
                page.setHeight(session.info.getPagesInfo().get(i).getHeight());
                page.setWidth(session.info.getPagesInfo().get(i).getWidth());

                if (session.annotations != null && session.annotations.size() > 0) {
                    page.setAnnotations(AnnotationMapper.mapForPage(session.annotations, i + 1, session.info.getPagesInfo().get(i)));
                }

                if (pagesContent.size() > 0) {
                    page.setData(pagesContent.get(i));
                }
                description.getPages().add(page);
            }
        } catch (Exception e) {
            logger.error("Error loading document: {}", guid, e);
            throw new TotalGroupDocsException(e.getMessage(), e);
        }

        return description;
    }

    public static String getStringFromStream(InputStream inputStream) throws IOException {
        inputStream.reset();
        inputStream.skip(0);

        byte[] bytes = IOUtils.toByteArray(inputStream);
        // encode ByteArray into String
        return Base64.getEncoder().encodeToString(bytes);
    }

    // ============================================================
    // Single page loading
    // ============================================================
    @Override
    public PageDataDescriptionEntity getDocumentPage(LoadDocumentPageRequest loadDocumentPageRequest) {
        try {
            String documentGuid = loadDocumentPageRequest.getGuid();
            int pageNumber = loadDocumentPageRequest.getPage();
            String password = loadDocumentPageRequest.getPassword();
            PageDataDescriptionEntity loadedPage = new PageDataDescriptionEntity();

            DocumentSession session = getOrCreateSession(documentGuid, password);

            if (session.annotations != null && session.annotations.size() > 0) {
                loadedPage.setAnnotations(AnnotationMapper.mapForPage(
                    session.annotations, pageNumber,
                    session.info.getPagesInfo().get(pageNumber - 1)));
            }

            byte[] bytes = getCachedOrRenderPage(session, documentGuid, pageNumber);
            loadedPage.setData(Base64.getEncoder().encodeToString(bytes));
            loadedPage.setHeight(session.info.getPagesInfo().get(pageNumber - 1).getHeight());
            loadedPage.setWidth(session.info.getPagesInfo().get(pageNumber - 1).getWidth());
            loadedPage.setNumber(pageNumber);

            return loadedPage;
        } catch (Exception ex) {
            throw new TotalGroupDocsException(ex);
        }
    }

    // ============================================================
    // Streaming image endpoint (raw PNG)
    // ============================================================
    @Override
    public byte[] getPageImageBytes(String guid, int pageNumber, String password) {
        DocumentSession session = getOrCreateSession(guid, password);
        return getCachedOrRenderPage(session, guid, pageNumber);
    }

    // ============================================================
    // Annotation operations
    // ============================================================
    public InputStream annotateDocument(String documentGuid, String documentType, List<AnnotationBase> annotations) throws FileNotFoundException {
        // Invalidate session since document will be modified
        invalidateSession(documentGuid);

        Annotator annotator = new Annotator(documentGuid);

        SaveOptions saveOptions = new SaveOptions();
        saveOptions.setAnnotationTypes(AnnotationType.NONE);

        annotator.save(documentGuid, saveOptions);

        if (annotations.size() > 0) {
            annotator.add(annotations);
            annotator.save(documentGuid, new SaveOptions());
        }

        return new FileInputStream(documentGuid);
    }

    @Override
    public AnnotatedDocumentEntity annotate(AnnotationPostedDataEntity annotateDocumentRequest) {
        AnnotatedDocumentEntity annotatedDocument = new AnnotatedDocumentEntity();
        try {
            String documentGuid = annotateDocumentRequest.getGuid();
            String password = annotateDocumentRequest.getPassword();

            // Invalidate cached session since we're modifying the document
            invalidateSession(documentGuid);

            String documentType = SupportedImageFormats.contains(
                FilenameUtils.getExtension(annotateDocumentRequest.getGuid())
            ) ? "image" : annotateDocumentRequest.getDocumentType();

            String tempPath = getTempPath(documentGuid);

            AnnotationDataEntity[] annotationsData = annotateDocumentRequest.getAnnotationsData();
            List<AnnotationBase> annotations = new ArrayList<>();

            final Annotator annotator = new Annotator(documentGuid, getLoadOptions(password));
            try {
                IDocumentInfo info = annotator.getDocument().getDocumentInfo();

                for (int i = 0; i < annotationsData.length; i++) {
                    AnnotationDataEntity annotationData = annotationsData[i];
                    PageInfo pageInfo = info.getPagesInfo().get(annotationsData[i].getPageNumber() - 1);
                    try {
                        BaseAnnotator baseAnnotator = AnnotatorFactory.createAnnotator(annotationData, pageInfo);
                        if (baseAnnotator.isSupported(documentType)) {
                            annotations.add(baseAnnotator.getAnnotationBase(documentType));
                        }
                    } catch (java.lang.RuntimeException ex) {
                        throw new AnnotatorException(ex.getMessage(), ex);
                    }
                }
            } finally {
                if (annotator != null) {
                    annotator.dispose();
                }
            }

            removeAnnotations(documentGuid, password);
            if (annotations.size() != 0) {
                final Annotator annotator1 = new Annotator(documentGuid, getLoadOptions(password));
                try {
                    Iterator tmp0 = (annotations).iterator();

                    while (tmp0.hasNext()) {
                        AnnotationBase annotation = (AnnotationBase) tmp0.next();
                        annotator1.add(annotation);
                    }

                    annotator1.save(tempPath);
                } finally {
                    if (annotator1 != null) {
                        annotator1.dispose();
                    }
                }

                try (OutputStream fileStream = new FileOutputStream(documentGuid)) {
                    InputStream inputStream1 = new FileInputStream(tempPath);
                    IOUtils.copyLarge(inputStream1, fileStream);
                }
            }

            annotatedDocument = new AnnotatedDocumentEntity();
            annotatedDocument.setGuid(documentGuid);
            if (annotateDocumentRequest.getPrint()) {
                annotatedDocument.setPages(getAnnotatedPagesForPrint(password, documentGuid));
                Files.move(Paths.get(documentGuid), Paths.get(annotateDocumentRequest.getGuid()));
            }
        } catch (Exception ex) {
            throw new TotalGroupDocsException(ex);
        }

        return annotatedDocument;
    }

    private List<PageDataDescriptionEntity> getAnnotatedPagesForPrint(String password, String documentGuid) {
        AnnotatedDocumentEntity description = new AnnotatedDocumentEntity();
        try {
            DocumentSession session = getOrCreateSession(documentGuid, password);
            List<String> pagesContent = getAllPagesContent(session, documentGuid);

            for (int i = 0; i < session.info.getPageCount(); i++) {
                PageDataDescriptionEntity page = new PageDataDescriptionEntity();

                if (pagesContent.size() > 0) {
                    page.setData(pagesContent.get(i));
                }

                description.getPages().add(page);
            }

            return description.getPages();
        } catch (Exception ex) {
            throw new TotalGroupDocsException(ex.getMessage(), ex);
        }
    }

    private static String getTempPath(String documentGuid) {
        File fileName = new File(documentGuid);
        return fileName.getParentFile().getPath() + "//tmp_" + fileName.getName();
    }

    public static void removeAnnotations(String documentGuid, String password) {
        String tempPath = getTempPath(documentGuid);

        try {
            final InputStream inputStream = new FileInputStream(documentGuid);
            try {
                final Annotator annotator = new Annotator(inputStream, getLoadOptions(password));
                try {
                    SaveOptions tmp0 = new SaveOptions();
                    tmp0.setAnnotationTypes(AnnotationType.NONE);
                    annotator.save(tempPath, tmp0);
                } finally {
                    if (annotator != null) {
                        annotator.dispose();
                    }
                }
            } finally {
                if (inputStream != null) {
                    inputStream.close();
                }
            }


            try (PrintWriter writer = new PrintWriter(documentGuid)) {
                writer.print("");
            }

            try (OutputStream fileStream = new FileOutputStream(documentGuid)) {
                InputStream inputStream1 = new FileInputStream(tempPath);
                IOUtils.copyLarge(inputStream1, fileStream);
            }
        } catch (Exception ex) {
            throw new TotalGroupDocsException(ex.getMessage(), ex);
        }
    }

    private List<String> getAllPagesContent(DocumentSession session, String documentGuid) {
        List<String> allPages = new ArrayList<>();

        for (int i = 0; i < session.info.getPageCount(); i++) {
            byte[] bytes = getCachedOrRenderPage(session, documentGuid, i + 1);
            allPages.add(Base64.getEncoder().encodeToString(bytes));
        }

        return allPages;
    }

    public List<AnnotationBase> getAnnotationInfos(AnnotationPostedDataEntity annotateDocumentRequest, String documentType) {
        try {
            AnnotationDataEntity[] annotationsData = annotateDocumentRequest.getAnnotationsData();

            List<AnnotationBase> annotations = new ArrayList<>();
            for (AnnotationDataEntity annotationData : annotationsData) {
                PageDataDescriptionEntity pageData = annotationPageDescriptionEntityList.get(annotationData.getPageNumber() - 1);

                PageInfo pageInfo = new PageInfo();
                pageInfo.setHeight((int) pageData.getHeight());
                pageInfo.setWidth((int) pageData.getWidth());

                try {
                    annotations.add(AnnotatorFactory.createAnnotator(annotationData, pageInfo).getAnnotationBase(documentType));
                } catch (Throwable ex) {
                    throw new TotalGroupDocsException(ex.getMessage(), ex);
                }
            }
            return annotations;
        } catch (Exception ex) {
            throw new TotalGroupDocsException(ex.getMessage(), ex);
        }
    }

    @Override
    public InputStream annotateByStream(AnnotationPostedDataEntity annotateDocumentRequest) {
        String documentGuid = annotateDocumentRequest.getGuid();
        String documentType = DocumentTypesConverter.checkedDocumentType(documentGuid, annotateDocumentRequest.getDocumentType());
        List<AnnotationBase> annotations = getAnnotationInfos(annotateDocumentRequest, documentType);
        try {
            return annotateDocument(documentGuid, documentType, annotations);
        } catch (FileNotFoundException ex) {
            throw new TotalGroupDocsException(ex.getMessage(), ex);
        }
    }
}

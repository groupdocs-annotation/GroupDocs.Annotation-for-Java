package GroupDocs.Annotation.Examples.Java;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public abstract class JsonFile<T> {
	protected Object _syncRoot = new Object();
	private String _filePath;
	private T _data;

	public JsonFile(String filePath) throws Exception {
		if (filePath == null || filePath.trim().isEmpty()) {
			throw new Exception("filePath");
		}
		_filePath = filePath;
	}

	protected void serialize() throws Exception {
		if (_data == null) {
			return;
		}
		synchronized (_syncRoot) {
			if (_data != null) {
				try {
					OutputStream stream = new FileOutputStream(_filePath);
					ObjectMapper xmlMapper = new XmlMapper();
					xmlMapper.writeValue(stream, _data);
				} catch (Exception e) {
					throw new Exception("Failed to serialize an object to file: '{0}'.", e);
				}
			}
		}
	}

	protected void deserialize() throws Exception {
		synchronized (_syncRoot) {
			try {
				if (!new File(_filePath).exists()) {
					InputStream fileStream = new FileInputStream(_filePath);
					fileStream.close();
					_data = newInstance();
					return;
				}
				InputStream stream = new FileInputStream(_filePath);
				ObjectMapper xmlMapper = new XmlMapper();
				if (xmlMapper.canDeserialize(xmlMapper.constructType(getClazz().getType()))) {
					_data = (T) xmlMapper.readValue(stream, getClazz());
				}
			} catch (Exception e) {
				throw new Exception("Failed to deserialize an object from file: '{0}'.", e);
			}
			if (_data == null) {
				_data = newInstance();
			}
		}
	}

	protected abstract T newInstance();

	protected abstract TypeReference<T> getClazz();

	protected T getData() throws Exception {
		synchronized (_syncRoot) {
			if (_data == null) {
				deserialize();
			}
			return _data;
		}
	}
}
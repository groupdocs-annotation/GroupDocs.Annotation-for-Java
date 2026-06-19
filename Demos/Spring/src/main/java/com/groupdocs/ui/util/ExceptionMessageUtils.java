package com.groupdocs.ui.util;

import com.groupdocs.annotation.options.export.AnnotationType;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class ExceptionMessageUtils {

    private static final Pattern TRIAL_ANNOTATION_PATTERN = Pattern.compile(
            "Unfortunately, you are not able to add (\\d+) annotation in trial mode",
            Pattern.CASE_INSENSITIVE);

    private ExceptionMessageUtils() {
    }

    public static String toUserMessage(Throwable throwable) {
        if (throwable == null) {
            return "";
        }

        String trialMessage = findTrialModeMessage(throwable);
        if (trialMessage != null) {
            return formatTrialModeMessage(trialMessage);
        }

        String rootMessage = extractRootCauseMessage(throwable);
        return rootMessage != null ? rootMessage : throwable.toString();
    }

    public static boolean isUserFacingMessage(String message) {
        return message != null && TRIAL_ANNOTATION_PATTERN.matcher(message).find();
    }

    private static String findTrialModeMessage(Throwable throwable) {
        Throwable current = throwable;
        while (current != null) {
            String message = current.getMessage();
            if (message != null) {
                Matcher matcher = TRIAL_ANNOTATION_PATTERN.matcher(message);
                if (matcher.find()) {
                    return matcher.group();
                }
            }
            current = current.getCause();
        }
        return null;
    }

    private static String formatTrialModeMessage(String message) {
        Matcher matcher = TRIAL_ANNOTATION_PATTERN.matcher(message);
        if (!matcher.find()) {
            return message;
        }

        int typeId = Integer.parseInt(matcher.group(1));
        String typeName = resolveAnnotationTypeName(typeId);
        return "Unfortunately, you are not able to add " + typeName + " annotation in trial mode";
    }

    private static String resolveAnnotationTypeName(int typeId) {
        try {
            String name = AnnotationType.getName(typeId);
            if (name != null && !name.trim().isEmpty()) {
                return humanizeAnnotationTypeName(name);
            }
        } catch (Exception ignored) {
            // fall back to numeric id
        }
        return String.valueOf(typeId);
    }

    private static String humanizeAnnotationTypeName(String name) {
        if (name.contains("_")) {
            String[] parts = name.toLowerCase().split("_");
            StringBuilder result = new StringBuilder();
            for (String part : parts) {
                if (part.isEmpty()) {
                    continue;
                }
                if (result.length() > 0) {
                    result.append(' ');
                }
                result.append(Character.toUpperCase(part.charAt(0)));
                if (part.length() > 1) {
                    result.append(part.substring(1));
                }
            }
            return result.toString();
        }

        if (name.length() == 1) {
            return name.toUpperCase();
        }
        return Character.toUpperCase(name.charAt(0)) + name.substring(1).toLowerCase();
    }

    private static String extractRootCauseMessage(Throwable throwable) {
        Throwable root = throwable;
        while (root.getCause() != null && root.getCause() != root) {
            root = root.getCause();
        }

        String message = root.getMessage();
        if (message != null && !message.trim().isEmpty()) {
            int colonIndex = message.indexOf(": ");
            if (colonIndex > 0 && message.substring(0, colonIndex).contains(".")) {
                return message.substring(colonIndex + 2).trim();
            }
            return message.trim();
        }
        return null;
    }
}

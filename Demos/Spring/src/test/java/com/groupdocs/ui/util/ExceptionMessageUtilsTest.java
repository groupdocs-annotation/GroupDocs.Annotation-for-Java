package com.groupdocs.ui.util;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ExceptionMessageUtilsTest {

    @Test
    public void toUserMessage_formatsTrialModeMessageWithAnnotationTypeName() {
        Throwable cause = new RuntimeException(
                "Unfortunately, you are not able to add 1024 annotation in trial mode");
        Throwable wrapper = new RuntimeException("com.groupdocs.annotation.exceptions.AnnotatorException", cause);

        String message = ExceptionMessageUtils.toUserMessage(wrapper);

        assertTrue(message.startsWith("Unfortunately, you are not able to add "));
        assertTrue(message.endsWith(" annotation in trial mode"));
        assertFalse(message.contains("1024"));
        assertFalse(message.contains("AnnotatorException"));
    }

    @Test
    public void isUserFacingMessage_detectsTrialModeMessage() {
        assertTrue(ExceptionMessageUtils.isUserFacingMessage(
                "Unfortunately, you are not able to add Watermark annotation in trial mode"));
        assertFalse(ExceptionMessageUtils.isUserFacingMessage("Can't list files"));
    }

    @Test
    public void toUserMessage_stripsExceptionClassPrefix() {
        Throwable throwable = new RuntimeException(
                "class com.groupdocs.annotation.internal.System.ArgumentException: Something went wrong");

        assertEquals("Something went wrong", ExceptionMessageUtils.toUserMessage(throwable));
    }
}

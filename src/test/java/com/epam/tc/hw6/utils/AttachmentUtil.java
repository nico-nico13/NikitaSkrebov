package com.epam.tc.hw6.utils;

import io.qameta.allure.Attachment;
import lombok.experimental.UtilityClass;

@UtilityClass
public class AttachmentUtil {
    @Attachment(type = "image/png", value = "{attachmentName}")
    public byte[] attachPngImage(String attachmentName, byte[] source) {
        return source;
    }
}

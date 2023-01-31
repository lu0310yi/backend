package com.mypro.utils;

import io.micrometer.common.util.StringUtils;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * 加解密
 */
public class Encrypt {

    /**
     * 加密
     */
    public static String encrypt(String src) {
        if (StringUtils.isBlank(src))
            return null;
        try {
            return Base64.getEncoder().encodeToString(src.getBytes(StandardCharsets.UTF_8));
        } catch (Exception e) {
            throw new RuntimeException("encrypt fail!", e);
        }
    }

    /**
     * 解密
     */
    public static String decrypt(String src) {
        if (StringUtils.isBlank(src))
            return null;
        try {
            byte[] asBytes = Base64.getDecoder().decode(src);
            return new String(asBytes, StandardCharsets.UTF_8);
        } catch (Exception e) {
            throw new RuntimeException("decrypt fail!", e);
        }
    }

}

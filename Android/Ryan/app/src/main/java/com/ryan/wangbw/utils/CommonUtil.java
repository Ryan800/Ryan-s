package com.ryan.wangbw.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * author: wangbw
 * Date: 2015-12-15
 * Time: 17:12
 * Desc:
 */
public class CommonUtil {
    /**
     * MD5 32位加密
     * @param string
     * @return
     */
    public static String md5(String string) {

        byte[] hash;

        try {

            hash = MessageDigest.getInstance("MD5").digest(string.getBytes("UTF-8"));

        } catch (NoSuchAlgorithmException e) {

            throw new RuntimeException("Huh, MD5 should be supported?", e);

        } catch (UnsupportedEncodingException e) {

            throw new RuntimeException("Huh, UTF-8 should be supported?", e);

        }
        StringBuilder hex = new StringBuilder(hash.length * 2);

        for (byte b : hash) {

            if ((b & 0xFF) < 0x10) hex.append("0");

            hex.append(Integer.toHexString(b & 0xFF));

        }

        return hex.toString();

    }
}

package com.zhuancheng.sanhedefence.utils;

import android.text.TextUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5 {

    /**
     * 将字符串进行MD5加密
     * 
     * @param string
     *            要加密的字符串
     * @return 加密后的字符串
     */
    public static String md5(String string) {
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        MessageDigest messageDigest;
        StringBuffer md5StrBuff = new StringBuffer();
        try {
            messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset();
            messageDigest.update(string.getBytes("UTF-8"));

            byte[] byteArray = messageDigest.digest();
            for (int i = 0; i < byteArray.length; i++) {
                md5StrBuff.append(String.format("%02X", byteArray[i]));
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return md5StrBuff.toString();
    }

    /**
     * 读取文件的MD5值
     * 
     * @param file
     *            文件路径
     * @return 文件的MD5值
     */
    public static String fileMd5(String file) {

        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e1) {
            e1.printStackTrace();
            return null;
        }

        FileInputStream fileInputStream = null;
        String ret = null;
        try {
            fileInputStream = new FileInputStream(file);
            byte[] buffer = new byte[8192];
            int length;
            while ((length = fileInputStream.read(buffer)) != -1) {
                md5.update(buffer, 0, length);
            }

            byte[] byteArray = md5.digest();
            StringBuffer md5StrBuff = new StringBuffer();
            for (int i = 0; i < byteArray.length; i++) {
                md5StrBuff.append(String.format("%02X", byteArray[i]));
            }
            ret = md5StrBuff.toString();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        if (TextUtils.isEmpty(ret)) {
            return null;
        } else {
            return ret;
        }
    }
}

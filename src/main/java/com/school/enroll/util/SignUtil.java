package com.school.enroll.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class SignUtil {

    /**
     * 校验签名
     *
     * @param signature 微信加密签名.
     * @param timestamp 时间戳.
     * @param nonce     随机数.
     * @return
     */
    public static boolean checkSignature(String signature, String timestamp, String nonce) {
        // 对token、timestamp、和nonce按字典排序.
        // 与开发模式接口配置信息中的Token保持一致.
        String wxToken = "wechat";
        String[] paramArr = new String[]{wxToken, timestamp, nonce};
        Arrays.sort(paramArr);

        // 将排序后的结果拼接成一个字符串.
        String content = paramArr[0].concat(paramArr[1]).concat(paramArr[2]);

        String ciphertext = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            // 对拼接后的字符串进行sha1加密.
            byte[] digest = md.digest(content.toString().getBytes());
            ciphertext = byteToStr(digest);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        // 将sha1加密后的字符串与signature进行对比.
        return ciphertext != null && ciphertext.equals(signature.toUpperCase());
    }

    /**
     * 将字节数组转换为十六进制字符串.
     *
     * @param byteArray
     * @return
     */
    private static String byteToStr(byte[] byteArray) {
        StringBuilder strDigest = new StringBuilder();
        for (byte aByteArray : byteArray) {
            strDigest.append(byteToHexStr(aByteArray));
        }
        return strDigest.toString();
    }

    /**
     * 将字节转换为十六进制字符串.
     *
     * @param mByte
     * @return
     */
    private static String byteToHexStr(byte mByte) {
        char[] digit = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        char[] tempArr = new char[2];
        tempArr[0] = digit[(mByte >>> 4) & 0X0F];
        tempArr[1] = digit[mByte & 0X0F];
        return new String(tempArr);
    }
}

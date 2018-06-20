package com.xszheng.core.utils;

import java.security.MessageDigest;

public class EncryptUtils {

	/**
	 * md5 加密
	 * @author xszheng
	 * @date 2018年5月12日下午1:50:25
	 * @description
	 * @param
	 */
	public static String getMD5Str(String str) throws Exception{
		char hexDigits[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};         
        byte[] btInput = str.getBytes();  
        // 获得MD5摘要算法的 MessageDigest 对象  
        MessageDigest mdInst = MessageDigest.getInstance("MD5");  
        // 使用指定的字节更新摘要  
        mdInst.update(btInput);  
        // 获得密文  
        byte[] md = mdInst.digest();  
        // 把密文转换成十六进制的字符串形式  
        int j = md.length;  
        char strArr[] = new char[j * 2];  
        int k = 0;  
        for (int i = 0; i < j; i++) {  
            byte byte0 = md[i];  
            strArr[k++] = hexDigits[byte0 >>> 4 & 0xf];  
            strArr[k++] = hexDigits[byte0 & 0xf];  
        }  
        return new String(strArr);  
	}
	
	public static void main(String[] args) throws Exception {
		System.out.println(getMD5Str("123456"));
	}
}

package com.greatyu.utils;

import java.util.UUID;

/**
 * 
 * @ClassName: Utils 
 * @Description: TODO 
 * @author yuanyang
 * @date 2018年12月13日
 */
public class Utils {
	
	
   /**
    * 
    * @Title: parseInt 
    * @Description: TODO 
    * @param value
    * @return
    */
   public static int parseInt(String value) {
		int res = 0;
		try {
			res = Integer.parseInt(value);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return res;
   }
   
   
   
   /**
    * 
    * @Title: getUUID 
    * @Description: 获取主键32位UUID 
    * @return
    */
   public static String getUUID() {
	   String id = null;
	    try {
	    	UUID uuid = UUID.randomUUID();
			id = uuid.toString().toUpperCase().replaceAll("-", "");
		} catch (Exception e) {
			// TODO: handle exception
		}
	    return id;
  }
   
   
   public static void main(String[] args) throws Exception {
	   System.err.println(Utils.getUUID());
   }

	/**
	 * @Title: notNull
	 * @Description: 将String以非null形式返回，如果String为null，则返回一个空字符串""
	 * @param str
	 *            字符串
	 * @return 转化后的字符串
	 */
	public static String notNull(String str) {
		return str == null || "null".equalsIgnoreCase(str) ? "" : str;
	}

	/**
	 * @Title: specialCharacterEscape
	 * @Description: 文本输入特殊字符转义，防止脚本注入
	 * @param str
	 *            字符串
	 * @return 转义后的字符串
	 */
	public static String specialCharacterEscape(String str) {
		String value = str;
		value = value.replaceAll("&", "&amp;");
		value = value.replaceAll("\"", "&quot;");
		value = value.replaceAll("'", "&#x27;");
		value = value.replaceAll("/", "&#x2F;");
		value = value.replaceAll("<", "&lt;");
		value = value.replaceAll(">", "&gt;");
		return value;
	}

	/**
	 * @Title: jsAttackFilter
	 * @Description: 富文本输入特殊字符转义，防止脚本注入
	 * @param str
	 *            字符串
	 * @return 过滤后的字符串
	 */
	public static String jsAttackFilter(String str) {
		String value = str;
		value = value.replaceAll("(?i)<script", "&lt;script");
		value = value.replaceAll("(?i)</script>", "&lt;/script&gt;");
		value = value.replaceAll("(?i)<iframe", "&lt;iframe");
		value = value.replaceAll("(?i)</iframe>", "&lt;/iframe&gt;");
		return value;
	}

	/**
	 * @Title: bytesToHex
	 * @Description: 字节数组转十六进制
	 * @param bArray
	 *            字节数组
	 * @param upper
	 *            是否转大写
	 * @return 十六进制
	 */
	public static String bytesToHex(byte[] bArray, boolean upper) {
		StringBuffer sb = new StringBuffer(bArray.length);
		String sTemp;
		for (int i = 0; i < bArray.length; i++) {
			sTemp = Integer.toHexString(0xFF & bArray[i]);
			if (sTemp.length() < 2)
				sb.append(0);
			sb.append(sTemp.toLowerCase());
		}
		return upper ? sb.toString().toUpperCase() : sb.toString();
	}
}

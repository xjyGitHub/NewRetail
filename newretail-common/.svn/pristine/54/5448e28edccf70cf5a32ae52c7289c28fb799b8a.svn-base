package com.newretail.common.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 读取后缀名为“.properties”的文件
 * @author 
 *
 */
public class SystemConfig {
	private static final String config_private="aliyun-oss/config_private.properties";
	private static final String config_public="aliyun-oss/config_public.properties";
	public static String getConfigResource(String key) throws IOException{
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		Properties properties = new Properties();
		InputStream in = loader.getResourceAsStream(config_private);
		properties.load(in);
		String value = properties.getProperty(key);
		// 编码转换，从ISO-8859-1转向指定编码
		value = new String(value.getBytes("ISO-8859-1"), "UTF-8");
		in.close();
		return value;
	}
	/**
	 * 私有
	 * @param key
	 * @return
	 * @throws IOException
	 */
	public static String getConfigResourcePrivate(String key) throws IOException{
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		Properties properties = new Properties();
		InputStream in = loader.getResourceAsStream(config_private);
		properties.load(in);
		String value = properties.getProperty(key);
		// 编码转换，从ISO-8859-1转向指定编码
		value = new String(value.getBytes("ISO-8859-1"), "UTF-8");
		in.close();
		return value;
	}
	/**
	 * 公共读写
	 * @param key
	 * @return
	 * @throws IOException
	 */
	public static String getConfigResourcePublic(String key) throws IOException{
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		Properties properties = new Properties();
		InputStream in = loader.getResourceAsStream(config_public);
		properties.load(in);
		String value = properties.getProperty(key);
		// 编码转换，从ISO-8859-1转向指定编码
		value = new String(value.getBytes("ISO-8859-1"), "UTF-8");
		in.close();
		return value;
	}
}

package com.jay.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


import com.jay.uiframework.Log;

public class PropertiesUtils {
	private static Properties properties = null;
	private String propertiesFileName;
	protected static Log log = new Log(PropertiesUtils.class);
	public PropertiesUtils(String path){
		this.propertiesFileName = path;
		log.info("读取配置文件："+propertiesFileName);
	}
	public  String getPropertieValue(String keyName){
		properties = new Properties();
		InputStream in = PropertiesUtils.class.getClassLoader()
                .getResourceAsStream("com/jay/config/" + propertiesFileName);
		String value = null;
		try {
			properties.load(in);
			value = properties.getProperty(keyName);
		} catch (IOException e) {
			e.printStackTrace();
		}
		log.info("读取配置文件参数："+keyName+"  成功");
		return value;
	}
}

package com.jay.config;

import com.jay.utils.PropertiesUtils;

public class LocalConfig {
	
	static PropertiesUtils propertiesUtils = new PropertiesUtils("local.properties");
	public static final String URL = propertiesUtils.getPropertieValue("url");
	public static final String CHROME_PATH = propertiesUtils.getPropertieValue("chromeDriverPath");
	public static final String FIREFOX_PATH = propertiesUtils.getPropertieValue("fireFoxDriverPath");
	public static final String IE_PATH = propertiesUtils.getPropertieValue("ieDriverPath");
	public static final String SHOTPATH = propertiesUtils.getPropertieValue("shotPath");
	public static final String MAX_TRY_COUNT = propertiesUtils.getPropertieValue("maxTryCount");
	public static final String DEFAULT_COUNT = propertiesUtils.getPropertieValue("defaultCount");
	
}

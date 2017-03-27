package com.jay.utils;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;


import com.jay.uiframework.Locator;
import com.jay.uiframework.Log;
import com.jay.uiframework.Locator.ByType;

public class xmlUtils {
	private static Log log = new Log(xmlUtils.class);
	public static HashMap<String,Locator> readElementInfo(String fileName) throws DocumentException{
		String xfp = System.getProperty("user.dir")+"/webelementdata/"+fileName;
		log.info("读取xml文件，路径为："+xfp);
		Map<String,Locator> elementinfos= new HashMap<String,Locator>(); 
		SAXReader saxReader = new SAXReader();
		Document document = saxReader.read(new File(xfp));
		Element root = document.getRootElement();
		@SuppressWarnings("unchecked")//为了去警告而加，可不加!
		List<Element> childList = root.elements("locator");
		for(Element e:childList){
			String value = e.attributeValue("value").toString();
			int timeOut = Integer.parseInt(e.attributeValue("timeout"));
			String name = e.attributeValue("name").toString();
			String type = e.attributeValue("type").toString(); 
			Locator locator = new Locator(value,timeOut,getType(type),name);
			String keyName = e.getText();
			elementinfos.put(keyName, locator);
		}
		log.info("读取xml文件成功！");
		return (HashMap<String, Locator>) elementinfos;
	}
	
	public static ByType getType(String value){
		ByType type = null;
		switch(value){
		case "css":
			type = ByType.cssSelector;
			break;
		case "xpath":
			type = ByType.xpath;
			break;
		case "linkText":
			type = ByType.linkText;
			break;
		case "name":
			type = ByType.name;
			break;
		case "className":
			type = ByType.className;
			break;
		case "partialLinkText":
			type = ByType.partialLinkText;
			break;
		case "tagName":
			type = ByType.tagName;
			break;
		default:
			type = ByType.cssSelector;
			break;	
		}
		return type;
	}

}

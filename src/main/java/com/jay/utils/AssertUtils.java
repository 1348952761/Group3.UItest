package com.jay.utils;

import org.testng.Assert;

import com.jay.uiframework.Log;

public class AssertUtils {
	protected static Log log = new Log(AssertUtils.class);
	//整型做比较 、字符串做比较、字符串包含、非空、实型断言
	
	public static void checkIntNum(int actual, int expected,String... com){
		try{
		Assert.assertEquals(actual, expected);
		log.info("测试通过！");
		}catch(Exception e){
			log.error("测试失败！IntNum不匹配！");
			Assert.fail("测试失败！IntNum不匹配！");
		}
	}
	
	public static void checkString(String actual, String expected,String... com){
		try{
		Assert.assertEquals(actual, expected);
		log.info("测试通过！");
		}catch(Exception e){
			log.error("测试失败！String不匹配！");
			Assert.fail("测试失败！String不匹配！");
		}
	}
	
	public static void checkStringContains(String actual, String expected,String... com){
		try{
			Assert.assertEquals(true, actual.contains(expected));
		log.info("测试通过！");
		}catch(Exception e){
			log.error("测试失败！StringContain失败！");
			Assert.fail("测试失败！StringContain失败！");
		}
	}
	
	public static void checkNotNull(Object actual,String... com){
		try{
		Assert.assertNotNull(actual);
		log.info("测试通过！");
		}catch(Exception e){
			log.error("测试失败！NotNull失败！");
			Assert.fail("测试失败！NotNull失败！");
		}
	}
	
	public static void checkBoolean(boolean actual,boolean expected,String... com){
		try{
		Assert.assertEquals(actual, expected);
		log.info("测试通过！");
		}catch(Exception e){
			log.error("测试失败！NotNull失败！");
			Assert.fail("测试失败！NotNull失败！");
		}
	}

}

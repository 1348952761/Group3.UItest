package com.jay.demo;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.jay.actions.LoginOperate;
import com.jay.uiframework.DriverFactory;

public class TestRetryAndScreenShot {
	WebDriver driver;

	@BeforeMethod
	public void setUp(){
		try{
			driver = DriverFactory.getChromeDriver();
			driver.manage().window().maximize();
		}catch(Exception e){
			Assert.fail("初始化出错，不再执行该用例");
		}
		LoginOperate.setDriver(driver);
	}
	
	@Test
	public void f() {
		LoginOperate.loginOperate("admin", "123456");
	}
}

package com.jay.testcases;

import java.util.List;

import org.openqa.selenium.WebDriver;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.jay.actions.AddBug;
import com.jay.actions.LoginOperate;
import com.jay.uiframework.DriverFactory;
import com.jay.utils.AssertUtils;

public class TestAddBug {
	WebDriver driver;
	@BeforeMethod
	public void setup(){
		driver = DriverFactory.getChromeDriver();
		LoginOperate.setDriver(driver);
	}
	
	@Test
	public void addBugSuccess(){
		LoginOperate.loginSuccess("admin", "123456");
		AddBug.setDriver(driver);
		List<String> addBugList = AddBug.addBugSuccess("哈哈哈123",3);
		AssertUtils.checkBoolean(addBugList.contains("哈哈哈123"),true);
	}
	@AfterMethod
	public void close() throws InterruptedException{
		Thread.sleep(2000);
		driver.close();
	}
}

package com.jay.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.jay.actions.LoginOperate;
import com.jay.uiframework.DriverFactory;
import com.jay.utils.AssertUtils;

public class TestLogin {
	WebDriver driver;
	@BeforeMethod
	public void setup(){
		driver = DriverFactory.getChromeDriver();
		LoginOperate.setDriver(driver);
	}
	@Test
	public void loginSuccess() {
		String value = LoginOperate.loginSuccessGetUsername("admin", "123456");
		AssertUtils.checkStringContains(value, "admin", "测试正确登入失败");
	}
	@Test
	public void loginFail() {
		String value = LoginOperate.loginFailGetAlert("admin", "123");
		AssertUtils.checkString(value, "登录失败，请检查您的用户名或密码是否填写正确。","测试错误登入失败");
	}
	@Test
	public void loginFail2() {
		String value = LoginOperate.loginFailGetAlert("adm", "123456");
		AssertUtils.checkString(value, "登录失败，请检查您的用户名或密码是否填写正确。","测试错误登入失败");
	}
	@AfterMethod
	public void close() throws InterruptedException{
		Thread.sleep(2000);
		driver.quit();
	}
}

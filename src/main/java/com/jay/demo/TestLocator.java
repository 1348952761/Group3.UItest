package com.jay.demo;

import org.openqa.selenium.WebDriver;

import com.jay.actions.LoginOperate;
import com.jay.pages.MyplaceIndexPage;
import com.jay.uiframework.DriverFactory;

public class TestLocator {

	public static void main(String[] args) {
		
		WebDriver driver = DriverFactory.getChromeDriver();
		LoginOperate.setDriver(driver);
		MyplaceIndexPage mi = LoginOperate.loginOperate("admin", "123456");
		mi.wait(3);
		System.out.println(mi.getPageTitle());
	}

}

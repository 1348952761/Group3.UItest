package com.jay.demo;

import org.openqa.selenium.WebDriver;

import com.jay.config.LocalConfig;
import com.jay.uiframework.DriverFactory;
import com.jay.uiframework.DriverUtils;

public class TestConfigAndDriver {

	public static void main(String[] args) {
//		WebDriver driver = DriverFactory.getChromeDriver();
//		DriverUtils d = new DriverUtils(driver);
//		d.openWeb(LocalConfig.URL);
	
		WebDriver driver1 = DriverFactory.getFirefoxDriver();
		DriverUtils d1 = new DriverUtils(driver1);
		d1.openWeb(LocalConfig.URL);
		
//		WebDriver driver2 = DriverFactory.getIEDriver();
//		DriverUtils d2 = new DriverUtils(driver2);
//		d2.openWeb(LocalConfig.URL);
		
	}

}

package com.jay.uiframework;

import java.io.IOException;
import java.util.Arrays;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.jay.config.LocalConfig;


public class DriverFactory {
	private static WebDriver driver;
	static Runtime runtime = Runtime.getRuntime();
	private static Log log = new Log(DriverFactory.class);
	public static WebDriver getChromeDriver(){
		//杀死现有谷歌进程
		try {
			runtime.exec("taskkill /F /IM chrome.exe");
			log.info("杀死chrome浏览器成功");
		} catch (IOException e) {
			log.error("杀死chrome浏览器出现异常");
			e.printStackTrace();
		}
		String driverPath = System.getProperty("user.dir")+LocalConfig.CHROME_PATH;
		System.setProperty("webdriver.chrome.driver",driverPath);
		ChromeOptions options = new ChromeOptions();
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability("chrome.switches",
				Arrays.asList("--start-maximized"));
		options.addArguments("--test-type", "--start-maximized");
		driver = new ChromeDriver(options);
		log.info("创建chrome浏览器成功");
		return driver;
	}
	public static WebDriver getFirefoxDriver() {
		//杀死现有火狐进程
		try {
			runtime.exec("taskkill /F /IM firefox.exe");
			log.info("杀死firefox浏览器成功");
		} catch (IOException e) {
			log.error("杀死firefox浏览器出现异常");
			e.printStackTrace();
		}
		String path = System.getProperty("user.dir")+LocalConfig.FIREFOX_PATH;
		System.setProperty("webdriver.firefox.driver",path);
		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("extensions.firebug.currentVersion", "2.0.4");
		profile.setPreference("extensions.firebug.allPagesActivation",
				"off");
		profile.setPreference("browser.download.folderList", 2);
		profile.setPreference("browser.download.dir", "C:\\selenium");
		profile.setPreference(
				"browser.helperApps.neverAsk.saveToDisk",
				"application/octet-stream, applicationnd.ms-excel, text/csv, application/zip,application/exe");
		driver = new FirefoxDriver(profile);
		log.info("创建firefox浏览器成功");
		driver.manage().window().maximize();
		return driver;
	}
	public static WebDriver getIEDriver() {
		//杀死现有火狐进程
		try {
			runtime.exec("taskkill /F /IM iexplore.exe");
			log.info("杀死IE浏览器成功");
		} catch (IOException e) {
			log.error("杀死IE浏览器出现异常");
			e.printStackTrace();
		}
		String path = System.getProperty("user.dir")+LocalConfig.IE_PATH;
		System.setProperty("webdriver.ie.driver", path);
//		String PROXY = "http://proxy:8083";
//		org.openqa.selenium.Proxy proxy = new org.openqa.selenium.Proxy();
//		proxy.setHttpProxy(PROXY).setFtpProxy(PROXY).setSslProxy(PROXY);

		DesiredCapabilities ds = DesiredCapabilities.internetExplorer();
		ds.setCapability(
				InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
				true);
		ds.setCapability("ignoreProtectedModeSettings", true);
		//ds.setCapability(CapabilityType.PROXY, proxy);
		WebDriver driver = new InternetExplorerDriver(ds);
		log.info("创建IE浏览器成功");
		driver.manage().window().maximize();
		return driver;
	}
}

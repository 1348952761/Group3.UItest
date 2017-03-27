package com.jay.uiframework;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;







public class DriverUtils {
	
	protected  WebDriver driver;
	protected Runtime runtime = Runtime.getRuntime();
	protected MouseUtils mouse;
	protected KeyBoardUtils keyboard;
	protected static Log log = new Log(DriverUtils.class);
	
	public DriverUtils(WebDriver dr){
		driver = dr;
		mouse = new MouseUtils(driver);
		keyboard = new KeyBoardUtils(driver);
	}
	
	public void wait(int seconds){
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void openWeb(String url){
		driver.get(url);
		log.info("打开网址："+url);
	}
	
	public void back(){
		driver.navigate().back();
		log.info("返回上一页");
	}
	
	public void forword(){
		driver.navigate().forward();
		log.info("向前进一页");
	}
	
	public void refresh(){
		driver.navigate().refresh();
	}
	
	public void maxWindow(){
		driver.manage().window().maximize();
	}
	
	public String getCurrentUrl(){
		return driver.getCurrentUrl();
	}
	
	public void closeBrower(){
		try {
			
			runtime.exec("taskkill /F /IM firefox.exe");
			runtime.exec("taskkill /F /IM chrome.exe");
			runtime.exec("taskkill /F /IM iexplore.exe");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void takeScreenShot(String... pngName) {
    	String fileName ;
    	String filePath = com.jay.config.LocalConfig.SHOTPATH;
    	File file = new File(filePath);
    	if(!file.exists()) {
    	    file.mkdir();
    	}
        if (pngName.length == 0) {
        	fileName = "shotImage";
        } else {
        	fileName = pngName[0];
        }
        SimpleDateFormat sf = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
        Calendar cal = Calendar.getInstance();
        Date date = cal.getTime();
        String dateStr = sf.format(date);
        String path =  "\\"+ filePath +"\\" + fileName + "_" + dateStr + ".png";
        takeScreenShot(driver, path);    	
    }
    
    public void takeScreenShot(WebDriver drivername, String path) {
        String currentPath = System.getProperty("user.dir"); // get current work
        File scrFile = ((TakesScreenshot) drivername).getScreenshotAs(OutputType.FILE);
        File picFile = new File(currentPath + path);
        try {
            FileUtils.copyFile(scrFile, picFile);
            log.info("截图成功，图片保存路径为："+currentPath + path);
        } catch (Exception e) {
        	log.error("截图失败");
        } 
        log.screenShotLog("截图：" + scrFile, picFile);
    }
}

package com.jay.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

public class QaIndexPage {
	private WebDriver driver;
	
	public QaIndexPage(WebDriver dr){
		this.driver = dr;
		getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	public WebDriver getDriver() {
		return this.driver;
	}
	
	public String getPageTitle(){
		String title = getDriver().getTitle();
		return title;
	}
}

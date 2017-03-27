package com.jay.pages;

import org.openqa.selenium.WebDriver;

import com.jay.config.LocalConfig;
import com.jay.uiframework.BasePage;
import com.jay.uiframework.Locator;

public class LoginPage extends BasePage{
	private Locator usernameTypeBox = getLocator("usernameTypeBox");
	private Locator passwordTypeBox = getLocator("passwordTypeBox");
	private Locator loginButton = getLocator("loginButton");
	
	
	public WebDriver getDriver() {
		return this.driver;
	}
	
	public LoginPage(WebDriver dr){
		super(dr);
		openWeb(LocalConfig.URL);
	}
	public void typeUsername(String userName){
		input(usernameTypeBox,userName);
	}
	public void typePassword(String password){
		input(passwordTypeBox,password);
	}
	public void clickLoginButon(){
		click(loginButton);
	}
}

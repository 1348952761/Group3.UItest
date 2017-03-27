package com.jay.actions;

import org.openqa.selenium.WebDriver;

import com.jay.pages.LoginPage;
import com.jay.pages.MainPage;
import com.jay.pages.MyplaceIndexPage;
public class LoginOperate {
	private static WebDriver driver;
	private static LoginPage lp;
	
	public static WebDriver getDriver() {
		return driver;
	}

	public static void setDriver(WebDriver dr){
		driver = dr;
	}
	
	public static MyplaceIndexPage loginOperate(String userName,String passWd){
		lp = new LoginPage(getDriver());
		lp.typeUsername(userName);
		lp.typePassword(passWd);
		lp.clickLoginButon();
		return new MyplaceIndexPage(getDriver());
	}
	public static void loginSuccess(String userName,String passWd){
		lp = new LoginPage(getDriver());
		lp.typeUsername(userName);
		lp.typePassword(passWd);
		lp.clickLoginButon();
	}
	public static String loginSuccessGetUsername(String userName,String passWd){
		loginSuccess(userName,passWd);
		MainPage mp = new MainPage(getDriver());
		return mp.getLoginUsername();
	}
	
	public static String loginFailGetAlert(String userName,String passWd){
		loginSuccess(userName,passWd);
		return lp.getAlertText();
	}
	
}

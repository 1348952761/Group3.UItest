package com.jay.uiframework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class MouseUtils {

	private Actions action;
	
	public MouseUtils(WebDriver dr){
		action = new Actions(dr);
	}
	
	public void doubleClick(WebElement el){
		action.doubleClick(el).perform();
	}
	
	public void rightClick(WebElement el){
		action.contextClick(el).perform();
	}
	//-------------------------------------------
	public void clickAndHold(WebElement el){
		action.clickAndHold(el).perform();
	}
	
}

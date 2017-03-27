package com.jay.pages;

import org.openqa.selenium.WebDriver;

import com.jay.uiframework.BasePage;
import com.jay.uiframework.Locator;
public class MainPage  extends BasePage{
	
	private Locator userMenu = locatorMap.get("userMenu");
	private Locator exitButton = locatorMap.get("exitButton");
	private Locator myplace = locatorMap.get("myplace");
	private Locator product = locatorMap.get("product");
	private Locator project = locatorMap.get("project");
	private Locator qa = locatorMap.get("qa");
	
	
	public MainPage(WebDriver dr){
		super(dr);
	}
	
	public String getLoginUsername(){
		return getText(userMenu);
	}
	public void clickExitButton(){
		click(exitButton);
	}
	public void clickMyplace(){
		click(myplace);
	}
	public void clickProduct(){
		click(product);
	}
	public void clickProject(){
		click(project);
	}
	public void clickQa(){
		click(qa);
	}

}

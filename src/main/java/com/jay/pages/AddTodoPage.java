package com.jay.pages;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.jay.uiframework.BasePage;
import com.jay.uiframework.Locator;



public class AddTodoPage extends BasePage{

	private Locator typeDropdown = locatorMap.get("typeDropdown");
	private Locator nameTypeBox = locatorMap.get("nameTypeBox");
	private Locator describeIframe = locatorMap.get("describeIframe");
	private Locator saveButton = locatorMap.get("saveButton");
	private Locator priorityDropdown = locatorMap.get("priorityDropdown");
	
	public AddTodoPage(WebDriver dr){
		super(dr);
	}
	
	
	public void selectType(String value){
	   	selectByValue(typeDropdown, value);
	}
	
	public void selectPriority(String value){
	   	selectByValue(priorityDropdown, value);
	}
	
	public void typeName(String name){
		input(nameTypeBox,name);
	}
	
	public void typeDescribeIframe(String content){
		//跳到iFrame
		switchFrameByElement(describeIframe);
		//定位frame中的body
		driver.findElement(By.cssSelector("body.article-content")).sendKeys(content);
		//跳出iFrame
		switchDefaultFrame();
	}
	
	public MyplaceMyTodoPage clickSaveButton(){
		submit(saveButton);
		return new MyplaceMyTodoPage(driver);
	}
	
	
}

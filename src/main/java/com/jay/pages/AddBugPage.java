package com.jay.pages;


import org.openqa.selenium.WebDriver;
import com.jay.uiframework.BasePage;
import com.jay.uiframework.Locator;
public class AddBugPage extends BasePage{
	private Locator versionBox = getLocator("versionBox");
	private Locator titleInputBox = getLocator("titleInputBox");
	private Locator priorityButton = getLocator("priorityButton");
	private Locator saveButton = getLocator("saveButton");
	
	public AddBugPage(WebDriver dr) {
		super(dr);
	}

	public void selectVersionTrunk(){
		click(versionBox);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		keyboard.sendEnterKey(1);
	}
	public void inputTitleBox(String title){
		input(titleInputBox,title);
	}
	public void selectPriority(int pri){
		if(pri>4) return;
		click(priorityButton);
		keyboard.sendTableKey(pri+1);
		keyboard.sendEnterKey(1);
	}
	public void clickSaveButton(){
		click(saveButton);
	}
}

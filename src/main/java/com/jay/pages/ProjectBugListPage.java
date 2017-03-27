package com.jay.pages;


import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.jay.uiframework.BasePage;
import com.jay.uiframework.Locator;
public class ProjectBugListPage extends BasePage{

	private Locator addBugButton = getLocator("addBugButton");
	
	public ProjectBugListPage(WebDriver dr) {
		super(dr);
	}

	public void clickAddBugButton(){
		click(addBugButton);
	}
	
	public List<String> getBugList(){
		List<String> bugList = new ArrayList<String>();
		bugList.clear();
		List<WebElement> els = driver.findElements(By.cssSelector("td.text-left a"));
		for(WebElement el:els){
			bugList.add(el.getText());
		}
		return bugList;
	}
}

package com.jay.pages;


import org.openqa.selenium.WebDriver;
import com.jay.uiframework.BasePage;
import com.jay.uiframework.Locator;
public class ProjectIndexPage extends BasePage{
	private Locator bugLink = getLocator("bugLink");
	public ProjectIndexPage(WebDriver dr) {
		super(dr);
	}

	public void clickBugLink(){
		click(bugLink);
	}
}

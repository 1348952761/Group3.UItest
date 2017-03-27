package com.jay.actions;

import java.util.List;

import org.openqa.selenium.WebDriver;

import com.jay.pages.AddBugPage;
import com.jay.pages.MainPage;
import com.jay.pages.ProjectBugListPage;
import com.jay.pages.ProjectIndexPage;

public class AddBug {
	private static WebDriver driver;
	private static MainPage mainPage;
	
	
	public static WebDriver getDriver() {
		return driver;
	}

	public static void setDriver(WebDriver driver) {
		AddBug.driver = driver;
	}
	
	public static List<String> addBugSuccess(String title,int pri){
		mainPage = new MainPage(getDriver());
		mainPage.wait(1);
		mainPage.clickProject();
		mainPage.wait(1);
		ProjectIndexPage pIndexPage = new ProjectIndexPage(getDriver());
		pIndexPage.clickBugLink();
		pIndexPage.wait(1);
		ProjectBugListPage pBugList = new ProjectBugListPage(getDriver()); 
		pBugList.clickAddBugButton();
		pBugList.wait(1);
		AddBugPage addBugPage = new AddBugPage(getDriver());
		addBugPage.selectVersionTrunk();
		addBugPage.inputTitleBox(title);
		addBugPage.selectPriority(pri);
		addBugPage.clickSaveButton();
		addBugPage.wait(1);
		ProjectBugListPage pBugList1 = new ProjectBugListPage(getDriver());
		return pBugList1.getBugList();
	}
	
}

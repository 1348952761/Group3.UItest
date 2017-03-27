package com.jay.pages;


import org.openqa.selenium.WebDriver;


import com.jay.uiframework.BasePage;
import com.jay.uiframework.Locator;

public class MyplaceIndexPage extends BasePage{

	private Locator indexLink = locatorMap.get("indexLink");
	private Locator todoLink = locatorMap.get("todoLink");
	private Locator taskLink = locatorMap.get("taskLink");
	
	public MyplaceIndexPage(WebDriver dr){
		super(dr);
	}
	
	public void clickIndexLink(){//在首页点首页=刷新，不在返回页面对象，就是本身
		click(indexLink);
	}
	public void clickTodoLink(){
		click(todoLink);
	}
	public void clickTaskLink(){
		click(taskLink);
	}
}

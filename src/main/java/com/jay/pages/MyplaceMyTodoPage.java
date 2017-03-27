package com.jay.pages;


import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.jay.uiframework.BasePage;
import com.jay.uiframework.Locator;


public class MyplaceMyTodoPage extends BasePage{

	private Locator addTodo = locatorMap.get("addTodo");
	private Locator batchAddTodo = locatorMap.get("batchAddTodo");

	public MyplaceMyTodoPage(WebDriver dr){
		super(dr);
	}
	
	public void clickAddTodo(){
		click(addTodo);
	}
	public void clickBatchAddTodo(){
		click(batchAddTodo);
	}
	
	public List<String> getTodoList(){
		List<String> todoList = new ArrayList<String>();
		todoList.clear();
		List<WebElement> els = driver.findElements(By.cssSelector("a[data-title='待办详情']"));
		for(WebElement el:els){
			todoList.add(el.getText());
		}
		return todoList;
	}
	
}

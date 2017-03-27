package com.jay.actions;

import java.util.List;

import org.openqa.selenium.WebDriver;

import com.jay.pages.AddTodoPage;
import com.jay.pages.BatchAddTodoPage;
import com.jay.pages.MyplaceIndexPage;
import com.jay.pages.MyplaceMyTodoPage;

public class AddTodo {
	private static WebDriver driver;
	private static MyplaceIndexPage myIndex;
	
	public static WebDriver getDriver() {
		return driver;
	}

	public static void setDriver(WebDriver driver) {
		AddTodo.driver = driver;
	}

	public static void inputTodoInfo(String type,String priority,String name){
		myIndex = new MyplaceIndexPage(getDriver());
		myIndex.wait(1);
		myIndex.clickTodoLink();
		myIndex.wait(1);
		MyplaceMyTodoPage myTodoPage = new MyplaceMyTodoPage(getDriver());
		myTodoPage.clickAddTodo();
		myTodoPage.wait(1);
		AddTodoPage addTodoPage = new AddTodoPage(getDriver());
		addTodoPage.selectType(type);
		addTodoPage.selectPriority(priority);
		addTodoPage.typeName(name);
		addTodoPage.clickSaveButton();
	}
	public static List<String> addtodoSuccess(String type,String priority,String name){
		inputTodoInfo(type,priority,name);
		MyplaceMyTodoPage myTodoPage2 = new MyplaceMyTodoPage(getDriver());
		myTodoPage2.wait(1);
		return myTodoPage2.getTodoList();
	}
	public static String addtodoNameNull(String type,String priority){
		inputTodoInfo(type,priority,"");
		MyplaceMyTodoPage myTodoPage = new MyplaceMyTodoPage(getDriver());
		myTodoPage.wait(1);
		return myTodoPage.getAlertText();
	}
	
	
	public static List<String> batchAddtodoSuccessCustom(int pri,String name,String desc){
		myIndex = new MyplaceIndexPage(getDriver());
		myIndex.wait(1);
		myIndex.clickTodoLink();
		myIndex.wait(1);
		MyplaceMyTodoPage myTodoPage = new MyplaceMyTodoPage(getDriver());
		myTodoPage.clickBatchAddTodo();
		myTodoPage.wait(1);
		BatchAddTodoPage batchAddPage = new BatchAddTodoPage(getDriver());
		for(int i=0;i<=7;i++){
			batchAddPage.selectType(i,"custom");
		}
		batchAddPage.wait(1);
		for(int i=0;i<=7;i++){
			batchAddPage.selectPriority(i, Integer.toString(pri));
		}
		batchAddPage.wait(1);
		for(int i=0;i<=7;i++){
			batchAddPage.inputName(i, name+Integer.toString(i));
		}
		batchAddPage.wait(1);
		for(int i=0;i<=7;i++){
			batchAddPage.inputDesc(i,desc+Integer.toString(i));
		}
		batchAddPage.clickSaveButton();
		batchAddPage.wait(1);
		MyplaceMyTodoPage myTodoPage1 = new MyplaceMyTodoPage(getDriver());
		return myTodoPage1.getTodoList();
	}
	public static List<String> batchAddtodoSuccessBug(int pri,int index,String desc){
		myIndex = new MyplaceIndexPage(getDriver());
		myIndex.wait(1);
		myIndex.clickTodoLink();
		myIndex.wait(1);
		MyplaceMyTodoPage myTodoPage = new MyplaceMyTodoPage(getDriver());
		myTodoPage.clickBatchAddTodo();
		myTodoPage.wait(1);
		BatchAddTodoPage batchAddPage = new BatchAddTodoPage(getDriver());
		for(int i=0;i<=7;i++){
			batchAddPage.selectType(i,"bug");
		}
		batchAddPage.wait(1);
		for(int i=0;i<=7;i++){
			batchAddPage.selectPriority(i, Integer.toString(pri));
		}
		batchAddPage.wait(1);
		for(int i=0;i<=7;i++){
			batchAddPage.selectBugname(i,Integer.toString(index));
		}
		batchAddPage.wait(1);
		for(int i=0;i<=7;i++){
			batchAddPage.inputDesc(i,desc+Integer.toString(i));
		}
		batchAddPage.clickSaveButton();
		batchAddPage.wait(1);
		MyplaceMyTodoPage myTodoPage1 = new MyplaceMyTodoPage(getDriver());
		return myTodoPage1.getTodoList();
	}
	
}

package com.jay.testcases;

import java.util.List;

import org.openqa.selenium.WebDriver;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.jay.actions.AddTodo;
import com.jay.actions.LoginOperate;
import com.jay.uiframework.DriverFactory;
import com.jay.utils.AssertUtils;

public class TestAddTodo {
	WebDriver driver;
	@BeforeMethod
	public void setup(){
		driver = DriverFactory.getChromeDriver();
		LoginOperate.setDriver(driver);
	}
//-------------通过测试	
	@Test
	public void addTodoSuccess(){
		LoginOperate.loginSuccess("admin", "123456");
		AddTodo.setDriver(driver);
		List<String> todoList = AddTodo.addtodoSuccess("custom", "4", "2017-03-27TODO0");
		AssertUtils.checkBoolean(todoList.contains("2017-03-27TODO0"),true);
	}
//-------------名称为空
	@Test
	public void addTodoNameNull(){
		LoginOperate.loginSuccess("admin", "123456");
		AddTodo.setDriver(driver);
		String alert = AddTodo.addtodoNameNull("custom", "4");
		AssertUtils.checkBoolean(alert.contains("名称")&&alert.contains("不能为空"),true);
	}
//-------------批量添加：类型为custom，优先级1,2,3,4
	@Test
	public void batchAddTodoSuccessC1(){
		LoginOperate.loginSuccess("admin", "123456");
		AddTodo.setDriver(driver);
		List<String> todoList = AddTodo.batchAddtodoSuccessCustom(1,"批量添加代办1-","完成批量添加代办3-");
		System.out.println(todoList);
		AssertUtils.checkBoolean(todoList.contains("批量添加代办1-"+Integer.toString(0)),true);
	}
	@Test
	public void batchAddTodoSuccessC2(){
		LoginOperate.loginSuccess("admin", "123456");
		AddTodo.setDriver(driver);
		List<String> todoList = AddTodo.batchAddtodoSuccessCustom(2,"批量添加代办2-","完成批量添加代办3-");
		System.out.println(todoList);
		AssertUtils.checkBoolean(todoList.contains("批量添加代办2-"+Integer.toString(0)),true);
	}
	@Test
	public void batchAddTodoSuccessC3(){
		LoginOperate.loginSuccess("admin", "123456");
		AddTodo.setDriver(driver);
		List<String> todoList = AddTodo.batchAddtodoSuccessCustom(3,"批量添加代办3-","完成批量添加代办3-");
		System.out.println(todoList);
		AssertUtils.checkBoolean(todoList.contains("批量添加代办3-"+Integer.toString(0)),true);
	}
	@Test
	public void batchAddTodoSuccessC4(){
		LoginOperate.loginSuccess("admin", "123456");
		AddTodo.setDriver(driver);
		List<String> todoList = AddTodo.batchAddtodoSuccessCustom(4,"批量添加代办4-","完成批量添加代办3-");
		System.out.println(todoList);
		AssertUtils.checkBoolean(todoList.contains("批量添加代办4-"+Integer.toString(0)),true);
	}
//-------------批量添加：类型为bug，优先级：2
	@Test
	public void batchAddTodoSuccessB1(){
		LoginOperate.loginSuccess("admin", "123456");
		AddTodo.setDriver(driver);
		List<String> todoList = AddTodo.batchAddtodoSuccessBug(2, 0, "批量添加bug类型的待办-");
		System.out.println(todoList);
		AssertUtils.checkBoolean(todoList.contains("哈哈哈"),true);
	}
	@Test
	public void batchAddTodoSuccessB2(){
		LoginOperate.loginSuccess("admin", "123456");
		AddTodo.setDriver(driver);
		List<String> todoList = AddTodo.batchAddtodoSuccessBug(2, 1, "批量添加bug类型的待办-");
		System.out.println(todoList);
		AssertUtils.checkBoolean(todoList.contains("123"),true);
	}
	@Test
	public void batchAddTodoSuccessB3(){
		LoginOperate.loginSuccess("admin", "123456");
		AddTodo.setDriver(driver);
		List<String> todoList = AddTodo.batchAddtodoSuccessBug(2, 2, "批量添加bug类型的待办-");
		System.out.println(todoList);
		AssertUtils.checkBoolean(todoList.contains("大飒飒的"),true);
	}
	@AfterMethod
	public void close() throws InterruptedException{
		Thread.sleep(2000);
		driver.close();
	}
}

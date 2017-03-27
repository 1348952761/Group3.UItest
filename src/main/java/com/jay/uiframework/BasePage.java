package com.jay.uiframework;



import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;




public class BasePage extends WebElemntUtils{

	
	
	public BasePage(WebDriver dr) {
		super(dr);

	}
	
	public String getPageTitle(){
		String title = driver.getTitle();
		return title;
	}
	
	//获取页面源代码
	//js弹窗的处理
	//frame
	
	public String getPageSource(){
		return driver.getPageSource();
	}
	
	public void confirmAlert(){
		wait(3);
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}
	
	public void cancelAlert(){
		wait(3);
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
	}
	
	public void inputAlert(String value){
		wait(3);
		Alert alert = driver.switchTo().alert();
		alert.sendKeys(value);
	}
	
	public String getAlertText(){
		wait(3);
		Alert alert = driver.switchTo().alert();
		return alert.getText();
	}
	
	public void switchFrameByIdorName(String value){
		driver.switchTo().frame(value);		
	}
	
	public void switchFrameByElement(Locator loc){
		WebElement el = findElement(loc);
		driver.switchTo().frame(el);
	}
	
	public void switchDefaultFrame(){
		driver.switchTo().defaultContent();
	}
	


}

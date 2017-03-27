package com.jay.uiframework;

import java.util.HashMap;
import java.util.Set;

import org.dom4j.DocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.jay.utils.xmlUtils;



public class WebElemntUtils extends DriverUtils{

	protected HashMap<String,Locator> locatorMap;
	
	public WebElemntUtils(WebDriver dr) {
		super(dr);
		try {
			locatorMap = xmlUtils.readElementInfo(this.getClass().getSimpleName()+".xml");
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Locator getLocator(String locName){
		return locatorMap.get(locName);
	}
	//查找元素xpath\css\id\name\classname
	//点击、输入、提交、获取元素属性、获取元素文本、下拉框选择
	public WebElement getElement(Locator loc){
		WebElement el = null;
		try{
		switch(loc.getByType()){
			case id:	
				el = driver.findElement(By.id(loc.getLocatorInfo()));
				break;
			case name:
				el = driver.findElement(By.name(loc.getLocatorInfo()));
				break;
			case xpath:
				el = driver.findElement(By.xpath(loc.getLocatorInfo()));
				break;
			case cssSelector:
				el = driver.findElement(By.cssSelector(loc.getLocatorInfo()));
				break;
			default:
				el = driver.findElement(By.cssSelector(loc.getLocatorInfo()));		
		}}catch(Exception e){
			log.error("元素："+loc.getElementName()+" 识别异常");
			takeScreenShot("findElementErrorImage");			
			Assert.fail("查找元素异常，退出当前测试用例");
		}
		return el;		
	}
	
	protected WebElement findElement(Locator loc){
		WebDriverWait wait = new WebDriverWait(driver, loc.getTimeOut());
		WebElement el = wait.until(new ExpectedCondition<WebElement>() {   
            public WebElement apply(WebDriver d) {
                return getElement(loc);  
//                return driver.findElement(By.cssSelector("..."));
            }  
        });
		return el;
	}
	
	public void click(Locator loc){
		WebElement el = findElement(loc);
		el.click();
		log.info("页面元素："+loc.getElementName()+" 点击 成功");
	}
	
	public void input(Locator loc,String value){
		WebElement el = findElement(loc);
		el.sendKeys(value);
		log.info("页面元素："+loc.getElementName()+"  输入："+value+" 成功");
	}
	
	public void submit(Locator loc){
		WebElement el = findElement(loc);
		el.submit();
		log.info("页面元素："+loc.getElementName()+" 提交 成功");
	}
	
	public String getAttriue(Locator loc,String key){
		WebElement el = findElement(loc);
		log.info("页面元素："+loc.getElementName()+"  获取属性："+key+" 成功");
		return el.getAttribute(key);
	}

	public String getText(Locator loc){
		WebElement el = findElement(loc);
		log.info("页面元素："+loc.getElementName()+"  获取标签文本  成功");
		return el.getText();
	}
	
	public void selectByIndex(Locator loc,int index){
		WebElement el = findElement(loc);
		Select select = new Select(el);
		select.selectByIndex(index);
		log.info("页面元素："+loc.getElementName()+"  select  成功");
	}
	
	public void selectByText(Locator loc,String text){
		WebElement el = findElement(loc);
		Select select = new Select(el);
		select.selectByVisibleText(text);
		log.info("页面元素："+loc.getElementName()+"  select  成功");
	}
	
	public void selectByValue(Locator loc,String value){
		WebElement el = findElement(loc);
		Select select = new Select(el);
		select.selectByValue(value);
		log.info("页面元素："+loc.getElementName()+"  select  成功");
	}
	
	
	//-------------------------------------------------------
	public int getElemmentHeight(Locator loc){
		WebElement el = findElement(loc);
		return el.getSize().height;
	}
	
	public int getElemmentWidth(Locator loc){
		WebElement el = findElement(loc);
		return el.getSize().width;
	}
	
	public boolean isDisplayed(Locator loc){
		WebElement el = findElement(loc);
		return el.isDisplayed();
	}
	
	public boolean isEnabled(Locator loc){
		WebElement el = findElement(loc);
		return el.isEnabled();
	}
	
	public boolean isSelected(Locator loc){
		WebElement el = findElement(loc);
		return el.isSelected();
	}
	
	public String getTagName(Locator loc){
		WebElement el = findElement(loc);
		return el.getTagName();
	}
	
	public Point getLocation(Locator loc){
		WebElement el = findElement(loc);
		return el.getLocation();
	}
	
	public Set<Cookie> getCookies(){
		return driver.manage().getCookies();
	}
}

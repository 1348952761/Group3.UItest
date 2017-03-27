package com.jay.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.jay.uiframework.BasePage;
import com.jay.uiframework.Locator;

public class BatchAddTodoPage extends BasePage{

	public BatchAddTodoPage(WebDriver dr){
		super(dr);
	}
	private Locator typeDropdown0 = locatorMap.get("typeDropdown0");
	private Locator typeDropdown1 = locatorMap.get("typeDropdown1");
	private Locator typeDropdown2 = locatorMap.get("typeDropdown2");
	private Locator typeDropdown3 = locatorMap.get("typeDropdown3");
	private Locator typeDropdown4 = locatorMap.get("typeDropdown4");
	private Locator typeDropdown5 = locatorMap.get("typeDropdown5");
	private Locator typeDropdown6 = locatorMap.get("typeDropdown6");
	private Locator typeDropdown7 = locatorMap.get("typeDropdown7");	
	public void selectType(int typeId,String value){
		switch(typeId){
		case 0:selectByValue(typeDropdown0,value);break;
		case 1:selectByValue(typeDropdown1,value);break;
		case 2:selectByValue(typeDropdown2,value);break;
		case 3:selectByValue(typeDropdown3,value);break;
		case 4:selectByValue(typeDropdown4,value);break;
		case 5:selectByValue(typeDropdown5,value);break;
		case 6:selectByValue(typeDropdown6,value);break;
		case 7:selectByValue(typeDropdown7,value);break;
		}
	}
	private Locator priDropdown0 = locatorMap.get("priDropdown0");
	private Locator priDropdown1 = locatorMap.get("priDropdown1");
	private Locator priDropdown2 = locatorMap.get("priDropdown2");
	private Locator priDropdown3 = locatorMap.get("priDropdown3");
	private Locator priDropdown4 = locatorMap.get("priDropdown4");
	private Locator priDropdown5 = locatorMap.get("priDropdown5");
	private Locator priDropdown6 = locatorMap.get("priDropdown6");
	private Locator priDropdown7 = locatorMap.get("priDropdown7");
	public void selectPriority(int prisId,String value){
		switch(prisId){
		case 0:selectByValue(priDropdown0,value);break;
		case 1:selectByValue(priDropdown1,value);break;
		case 2:selectByValue(priDropdown2,value);break;
		case 3:selectByValue(priDropdown3,value);break;
		case 4:selectByValue(priDropdown4,value);break;
		case 5:selectByValue(priDropdown5,value);break;
		case 6:selectByValue(priDropdown6,value);break;
		case 7:selectByValue(priDropdown7,value);break;
		}
	}
	private Locator nameInputBox0 = locatorMap.get("nameInputBox0");
	private Locator nameInputBox1 = locatorMap.get("nameInputBox1");
	private Locator nameInputBox2 = locatorMap.get("nameInputBox2");
	private Locator nameInputBox3 = locatorMap.get("nameInputBox3");
	private Locator nameInputBox4 = locatorMap.get("nameInputBox4");
	private Locator nameInputBox5 = locatorMap.get("nameInputBox5");
	private Locator nameInputBox6 = locatorMap.get("nameInputBox6");
	private Locator nameInputBox7 = locatorMap.get("nameInputBox7");
	public void inputName(int nameId,String value){
		switch(nameId){
		case 0:input(nameInputBox0,value);break;
		case 1:input(nameInputBox1,value);break;
		case 2:input(nameInputBox2,value);break;
		case 3:input(nameInputBox3,value);break;
		case 4:input(nameInputBox4,value);break;
		case 5:input(nameInputBox5,value);break;
		case 6:input(nameInputBox6,value);break;
		case 7:input(nameInputBox7,value);break;
		}
	}
	private Locator descs0 = locatorMap.get("descs0");
	private Locator descs1 = locatorMap.get("descs1");
	private Locator descs2 = locatorMap.get("descs2");
	private Locator descs3 = locatorMap.get("descs3");
	private Locator descs4 = locatorMap.get("descs4");
	private Locator descs5 = locatorMap.get("descs5");
	private Locator descs6 = locatorMap.get("descs6");
	private Locator descs7 = locatorMap.get("descs7");
	public void inputDesc(int descsId,String value){
		switch(descsId){
		case 0:input(descs0,value);break;
		case 1:input(descs1,value);break;
		case 2:input(descs2,value);break;
		case 3:input(descs3,value);break;
		case 4:input(descs4,value);break;
		case 5:input(descs5,value);break;
		case 6:input(descs6,value);break;
		case 7:input(descs7,value);break;
		}
	}
	private Locator bugnameDropdown0 = locatorMap.get("bugnameDropdown0");
	private Locator bugnameDropdown1 = locatorMap.get("bugnameDropdown1");
	private Locator bugnameDropdown2 = locatorMap.get("bugnameDropdown2");
	private Locator bugnameDropdown3 = locatorMap.get("bugnameDropdown3");
	private Locator bugnameDropdown4 = locatorMap.get("bugnameDropdown4");
	private Locator bugnameDropdown5 = locatorMap.get("bugnameDropdown5");
	private Locator bugnameDropdown6 = locatorMap.get("bugnameDropdown6");
	private Locator bugnameDropdown7 = locatorMap.get("bugnameDropdown7");
	public void selectBugname(int nameId,String index){
		switch(nameId){
		case 0:click(bugnameDropdown0);
			driver.findElement(By.cssSelector("div#bugs1_chosen li[data-option-array-index='"+index+"']")).click();
		break;
		case 1:click(bugnameDropdown1);
			driver.findElement(By.cssSelector("div#bugs2_chosen li[data-option-array-index='"+index+"']")).click();
		break;
		case 2:click(bugnameDropdown2);
			driver.findElement(By.cssSelector("div#bugs3_chosen li[data-option-array-index='"+index+"']")).click();
		break;
		case 3:click(bugnameDropdown3);
			driver.findElement(By.cssSelector("div#bugs4_chosen li[data-option-array-index='"+index+"']")).click();
		break;
		case 4:click(bugnameDropdown4);
			driver.findElement(By.cssSelector("div#bugs5_chosen li[data-option-array-index='"+index+"']")).click();
		break;
		case 5:click(bugnameDropdown5);
			driver.findElement(By.cssSelector("div#bugs6_chosen li[data-option-array-index='"+index+"']")).click();
		break;
		case 6:click(bugnameDropdown6);
			driver.findElement(By.cssSelector("div#bugs7_chosen li[data-option-array-index='"+index+"']")).click();
		break;
		case 7:click(bugnameDropdown7);
			driver.findElement(By.cssSelector("div#bugs8_chosen li[data-option-array-index='"+index+"']")).click();
		break;
		}
	}
	private Locator saveButton = locatorMap.get("saveButton");
	public void clickSaveButton(){
		submit(saveButton);
	}
	
	
}

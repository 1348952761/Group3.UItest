package com.jay.uiframework;


import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.interactions.Actions;

public class KeyBoardUtils {
	
	private Actions action;
	
	public KeyBoardUtils(WebDriver dr){
		action = new Actions(dr);
	}
	
	//Robot
	public void pressDownKey(int times) {
		try {
			Robot robot = new Robot();
			for(int i=0;i<times;i++){
				robot.keyPress(KeyEvent.VK_DOWN);
				Thread.sleep(1000);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//--------------------------------------
	public void pressUpKey(int times){
		try {
			Robot robot = new Robot();
			for(int i=0;i<times;i++){
				robot.keyPress(KeyEvent.VK_UP);
				Thread.sleep(1000);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void pressTableKey(int times){
		try {
			Robot robot = new Robot();
			for(int i=0;i<times;i++){
				robot.keyPress(KeyEvent.VK_TAB);
				Thread.sleep(1000);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void pressEnterKey(int times){
		try {
			Robot robot = new Robot();
			for(int i=0;i<times;i++){
				robot.keyPress(KeyEvent.VK_ENTER);
				Thread.sleep(1000);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void sendTableKey(int times){
		try {
			for(int i=0;i<times;i++){
				action.sendKeys(Keys.TAB).perform();
				Thread.sleep(1000);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void sendEnterKey(int times){
		try {
			for(int i=0;i<times;i++){
				action.sendKeys(Keys.ENTER).perform();
				Thread.sleep(1000);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
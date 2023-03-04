package com.qa.facebook.automation_6th.utils;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.qa.facebook.automation_6th.factory.DriverFactory;

public class ElementActions extends DriverFactory{

	public ElementActions(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getElement(By locator) {
		WebElement element = null;
		try {
		element = driver.findElement(locator);
		}catch (Exception e) {
			System.out.println("Some exception is occur while creating WebElement : " + locator);
			e.printStackTrace();
		}
		return element;
	}
	
	public void elementClick(By locator) {
		getElement(locator).click();
	}
	
	public void elementSendKeys(By locator, String value) {
		getElement(locator).sendKeys(value);
	}
	
	public String getPageTitle() {
		String title = null;
		try {
		title = driver.getTitle();
		}catch (Exception e) {
			System.out.println("Some exception occur while getting the title of the page : " +title);
			e.printStackTrace();
		}
		return title;
	}
	
	public String getNormalized(String stdTextStr) {
		String normalizedText = stdTextStr.replaceAll("[-,;!|\\s]", "").toLowerCase();
		return normalizedText;
	}
	
	public void unconditionalWait(int second) {
		try {
			Thread.sleep(second * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public String getText(By locator) {
		String text = null;
		try {
		text = driver.findElement(locator).getText();
		}catch (WebDriverException web) {
			System.out.println("Some Exception occur while getting text : " +locator) ;
			web.printStackTrace();
		}
		return text;	
	}
	
	public void scrollToElement(By locator) {
		try {
		WebElement element = getElement(locator);
		JavascriptExecutor javascriptExecutor = ((JavascriptExecutor)driver);
		javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
		}catch (Exception e) {
			System.out.println("Scroll Into View :: WebElement does not exists with the path :  "+locator);
			e.printStackTrace();
		}
	}
	
	public String getAlertText() {
		String text = driver.switchTo().alert().getText();
		return text;
	}
	
	
	public void elementClickByActions(By locator) {
		WebElement element = getElement(locator);
		Actions actions = new Actions(driver);
		actions.moveToElement(element).click().build().perform();
	}
	
	public void moveToElementUsingAction(By locator) {
		WebElement element = getElement(locator);
		Actions actions = new Actions(driver);
		actions.moveToElement(element).build().perform();
	}
	
	public boolean elementEnabled(By locator) {
		WebElement element = getElement(locator);
		
		if(element.isEnabled())
			return true;
		else
			return false;
	}
	
	public void implicitWait(int sec) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(sec));
	}
	
	public void fluentWait(int sec) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20))
				.pollingEvery(Duration.ofSeconds(2)).ignoring(NoSuchElementException.class);
	}
	
	
}

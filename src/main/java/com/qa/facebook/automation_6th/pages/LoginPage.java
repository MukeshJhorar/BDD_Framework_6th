package com.qa.facebook.automation_6th.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.facebook.automation_6th.factory.DriverFactory;
import com.qa.facebook.automation_6th.utils.ElementActions;

public class LoginPage extends DriverFactory{

	public WebDriver driver;
	public ElementActions elementActions;
	
	
	@FindBy(id = "email")
	WebElement usernameTextBox;
	
	@FindBy(name = "pass")
	WebElement passwordTextBox;
	
	@FindBy(name = "login")
	WebElement loginButton;
	
	public LoginPage(WebDriver driver) {
	this.driver = driver;
	elementActions = new ElementActions(driver);
	}
	
	public boolean verifyLoginButton() {
		return loginButton.isDisplayed();
	}
	
	public String verifyLoginTitle() {
		return driver.getTitle();
	}
	
	public void doLogin(String username, String password) {
		usernameTextBox.sendKeys(username);
		passwordTextBox.sendKeys(password);
		loginButton.click();
	}
	
	
	
	
	
}

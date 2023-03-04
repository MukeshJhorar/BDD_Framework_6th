package com.qa.facebook.automation_6th.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.facebook.automation_6th.factory.DriverFactory;
import com.qa.facebook.automation_6th.utils.ElementActions;

public class LoginPageWithoutUsingDriverFactory extends DriverFactory{

	ElementActions elementActions;
	
	By usernameTextBox = By.id("email");
	By passwordTextBox = By.name("pass");
	By loginButton = By.name("login");
	
	public LoginPageWithoutUsingDriverFactory(WebDriver driver) {
		this.driver = driver;
		elementActions = new ElementActions(driver); 
	}	
	
	
	
}

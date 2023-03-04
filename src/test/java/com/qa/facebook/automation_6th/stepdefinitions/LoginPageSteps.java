package com.qa.facebook.automation_6th.stepdefinitions;

import org.openqa.selenium.WebDriver;



import com.qa.facebook.automation_6th.constants.Constants;
import com.qa.facebook.automation_6th.factory.DriverFactory;
import com.qa.facebook.automation_6th.pages.LoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class LoginPageSteps {

	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	WebDriver driver;
	@Given("user is already on {string} page")
	public void user_is_already_on_page(String string) {
	    DriverFactory.getDriver().get(string);
	}

	@When("title of the facebook login page")
	public void title_of_the_facebook_login_page() {
	    String title = loginPage.verifyLoginTitle();
	    Assert.assertEquals(title, Constants.LOGIN_PAGE_TITLE);
	}
	
	@Then("close the browser")
	public void close_the_browser() {
//	    driver.close();
	}

}

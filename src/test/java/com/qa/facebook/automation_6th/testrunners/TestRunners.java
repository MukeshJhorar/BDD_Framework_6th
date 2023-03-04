package com.qa.facebook.automation_6th.testrunners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		
		features = "./src/test/resources/AppFeatures",
		glue = {"com.qa.facebook.automation_6th.stepdefinitions", "com.qa.facebook.automation_6th.apphooks"},
		tags = "@RegressionTest",
		monochrome = true,
		plugin = {"pretty", "json:target/json-report/cucumber.json",
				        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
		
		)





public class TestRunners {

}

package com.qa.facebook.automation_6th.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	
	public WebDriver driver;
//	public DesiredCapabilities desireCapabilities = null;
	
	public static ThreadLocal tlDriver = new ThreadLocal();
	
	public WebDriver initialize_Driver(String browser) {
		
	System.out.println("Browser Value is : " +browser);	
		
	if(browser.equalsIgnoreCase("chrome")) {
//		WebDriverManager.chromedriver().driverVersion("110.0.5481.178").setup();
//		ChromeOptions chromeOptions = new ChromeOptions();
//		chromeOptions.addArguments("--start--maximized");
//		chromeOptions.addArguments("--incognito");
//		chromeOptions.addArguments("--headless");
//		tlDriver.set(new ChromeDriver(chromeOptions));
		WebDriverManager.chromedriver().driverVersion("110.0.5481.178").setup();
		tlDriver.set(new ChromeDriver());
	}
	else if (browser.equalsIgnoreCase("firefox")) {
		WebDriverManager.firefoxdriver().driverVersion("110.0.1").setup();
		FirefoxOptions firefoxOptions = new FirefoxOptions();
		firefoxOptions.addArguments("--start--maximized");
		firefoxOptions.addArguments("--incognito");
		firefoxOptions.addArguments("--headless");
		tlDriver.set(new FirefoxDriver(firefoxOptions));
	}
	else if (browser.equalsIgnoreCase("edge")) {
		WebDriverManager.edgedriver().driverVersion("110.0.1587.57 ").setup();
		EdgeOptions edgeOptions = new EdgeOptions();
		edgeOptions.addArguments("--start--maximized");
		edgeOptions.addArguments("--incognito");
		edgeOptions.addArguments("--headless");
		tlDriver.set(new EdgeDriver(edgeOptions));
	}
	else {
		System.out.println("Please provide browser name : "+browser);
	}
		
	getDriver().manage().deleteAllCookies();
	getDriver().manage().window().maximize();
	
	return getDriver();
		
	}
		
	
	public static synchronized WebDriver getDriver() {
		return (WebDriver) tlDriver.get();
	}

}

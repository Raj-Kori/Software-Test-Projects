package com.demoweb.shop;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass {
private static ThreadLocal<WebDriver>driver = new ThreadLocal<>();
private static final String Base_URL= "https://demowebshop.tricentis.com/?utm_source=chatgpt.com";

public static void driverconfig()
{
WebDriver localDriver =new ChromeDriver();
driver.set(localDriver);
getDriver().manage().window().maximize();
getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
getDriver().get(Base_URL);
}
public static WebDriver getDriver()
{
	return driver.get();
}
public static void tearDownDriver()
{
	if(driver.get()!=null)
	{
		driver.get().quit();
		driver.remove();
	}
}
}

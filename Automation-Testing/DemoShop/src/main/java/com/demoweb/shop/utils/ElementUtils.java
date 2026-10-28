package com.demoweb.shop.utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.demoweb.shop.BaseClass;

public class ElementUtils {
private static final int TIMEOUT = 15;

public static WebElement waitForElementToBeVisible(By locator)
{
	WebDriverWait wait = new WebDriverWait(BaseClass.getDriver(), Duration.ofSeconds(TIMEOUT));
	return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
}

public static WebElement waitForElementToBeClickable(By locator)
{
	WebDriverWait wait = new WebDriverWait(BaseClass.getDriver(), Duration.ofSeconds(TIMEOUT));
	return wait.until(ExpectedConditions.elementToBeClickable(locator));
}

public static void clickElement(By locator)
{
	System.out.println("[ACTION] Clicking element: " + locator);
	waitForElementToBeClickable(locator).click();
}

public static void enterText(By locator, String text)
{
	System.out.println("[ACTION] Entering text '" + text + "' into field: " + locator);
	WebElement element = waitForElementToBeVisible(locator);
	element.clear();
	element.click();
	element.sendKeys(text);
}

public static String getElementText(By locator)
{
	return waitForElementToBeVisible(locator).getText();
}
}
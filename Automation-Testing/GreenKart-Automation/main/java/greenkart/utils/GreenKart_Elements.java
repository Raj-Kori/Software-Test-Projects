package greenkart.utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import greenkart.base.GreenKart_Base;

public class GreenKart_Elements {

private static final int Timeout= 15;
public static boolean waitforTextToBePresent(By locator, String text)
{
	WebDriverWait wait= new WebDriverWait(GreenKart_Base.getDriver(),Duration.ofSeconds(Timeout));
	return wait.until(ExpectedConditions.textToBePresentInElementLocated(locator, text));
}
public static WebElement waitforElementtobeVisible(By locator)
{
	WebDriverWait wait = new WebDriverWait(GreenKart_Base.getDriver(),Duration.ofSeconds(Timeout));
	return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
}
public static WebElement waitForElementToBeClickable(By locator)
{
	WebDriverWait wait= new WebDriverWait(GreenKart_Base.getDriver(),Duration.ofSeconds(Timeout));
	return wait.until(ExpectedConditions.elementToBeClickable(locator));
}
public static void clickElement(By locator)
{
	System.out.println("[ACTION] Clicking Element : "+locator);
	waitforElementtobeVisible(locator).click();
}
public static void entertext(By locator, String text)
{
	System.out.println("[ACTION] Entering Text "+text+"Into Field:"+locator);
	WebElement element =waitforElementtobeVisible(locator);
	element.clear();
	element.click();
	element.sendKeys(text);
}
public static String getElementText(By locator)
{
	return waitforElementtobeVisible(locator).getText();
}
public static boolean isElementSelected (By locator)
{
	return waitforElementtobeVisible(locator).isSelected();
}
public static void SelectCheckbox(By locator)
{
	WebElement checkbox=waitForElementToBeClickable(locator);
	if(!checkbox.isSelected())
	{
		checkbox.click();
	}
}
public static void selectDropDownvalue(By locator, String value)
{
	WebElement element= waitforElementtobeVisible(locator);
	Select select= new Select(element);
	select.selectByValue(value);
}
}

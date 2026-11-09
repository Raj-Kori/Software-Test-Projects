package cura.utils;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import cura.base.Cura_Base;

public class Cura_Elements {
    private static final int DEFAULT_TIMEOUT = 15;

    public static void jsClick(By locator) {
        WebElement element = waitForElementToBeVisible(locator);
        org.openqa.selenium.JavascriptExecutor js =
            (org.openqa.selenium.JavascriptExecutor) Cura_Base.getdriver();
        js.executeScript("arguments[0].click();", element);
    }

    public static WebElement waitForElementToBeVisible(By locator) {
        WebDriverWait wait = new WebDriverWait(Cura_Base.getdriver(), Duration.ofSeconds(DEFAULT_TIMEOUT));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static WebElement waitForElementToBeClickable(By locator) {
        WebDriverWait wait = new WebDriverWait(Cura_Base.getdriver(), Duration.ofSeconds(DEFAULT_TIMEOUT));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static void enterText(By locator, String text) {
        WebElement element = waitForElementToBeVisible(locator);
        element.clear();
        element.sendKeys(text);
    }

    public static void clickButton(By locator) {
        waitForElementToBeClickable(locator).click();
    }

    public static void selectDropdownByVisibleText(By locator, String text) {
        new Select(waitForElementToBeVisible(locator)).selectByVisibleText(text);
    }

    public static void selectDropdownByValue(By locator, String value) {
        new Select(waitForElementToBeVisible(locator)).selectByValue(value);
    }

    public static void selectCheckbox(By locator, boolean shouldBeChecked) {
        WebElement element = waitForElementToBeClickable(locator);
        if (element.isSelected() != shouldBeChecked) element.click();
    }

    public static void selectRadioButton(By locator) {
        WebElement element = waitForElementToBeClickable(locator);
        if (!element.isSelected()) element.click();
    }

    public static void selectDate(By locator, String dateValue) {
        WebElement element = waitForElementToBeVisible(locator);
        element.clear();
        element.sendKeys(dateValue);
    }
}
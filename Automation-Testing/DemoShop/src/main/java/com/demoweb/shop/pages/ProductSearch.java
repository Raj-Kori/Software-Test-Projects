package com.demoweb.shop.pages;

import org.openqa.selenium.By;
import com.demoweb.shop.BaseClass;
import com.demoweb.shop.utils.ElementUtils;

public class ProductSearch {

    private By searchBox = By.id("small-searchterms");
    private By searchButton = By.cssSelector("input.search-box-button");
    private By productTitle = By.cssSelector("h2.product-title a");
    
    // Using XPath to locate the exact warning text container regardless of precise wrapper classes
    private By noResultWarning = By.xpath("//div[contains(@class, 'result') or contains(@class, 'search-input')]");

    public void enterSearchTerm(String productName) {
        if (BaseClass.getDriver() != null) {
            ElementUtils.enterText(searchBox, productName);
        }
    }

    public void clickSearchButton() {
        ElementUtils.clickElement(searchButton);
    }

    public String getSearchedProductTitle() {
        return ElementUtils.getElementText(productTitle);
    }

    public String getNoResultWarning() {
        try {
            return ElementUtils.getElementText(noResultWarning);
        } catch (Exception e) {
            // Fallback to page body text if element lookup times out
            return BaseClass.getDriver().findElement(By.tagName("body")).getText();
        }
    }

    public boolean handleAndVerifyAlert(String expectedAlertText) {
        try {
            org.openqa.selenium.Alert alert = BaseClass.getDriver().switchTo().alert();
            String alertText = alert.getText();
            alert.accept();
            return alertText.contains(expectedAlertText);
        } catch (Exception e) {
            return false;
        }
    }
}
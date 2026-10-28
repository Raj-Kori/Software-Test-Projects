package com.demoweb.shop.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.demoweb.shop.BaseClass;
import com.demoweb.shop.utils.ElementUtils;

public class UserAccountPage {

    private By loginLink = By.cssSelector("a.ico-login");
    private By emailField = By.id("Email");
    private By passwordField = By.id("Password");
    private By loginButton = By.cssSelector("input.login-button");
    
    private By myAccountLink = By.cssSelector("a.account");
    private By firstNameField = By.id("FirstName");
    private By lastNameField = By.id("LastName");
    private By saveButton = By.cssSelector("input.save-customer-info-button");
    
    // Fallback XPath that checks for result notification or page body text
    private By updateSuccessMessage = By.xpath("//div[contains(@class, 'result')] | //div[@class='page-body']");
    
    private By ordersLink = By.xpath("//div[@class='listbox']//a[normalize-space()='Orders']");
    private By orderListTable = By.cssSelector("div.order-list");
    private By addressesLink = By.xpath("//div[@class='listbox']//a[normalize-space()='Addresses']");

    public void loginToApplication(String email, String password) {
        try {
            ElementUtils.clickElement(loginLink);
            ElementUtils.enterText(emailField, email);
            ElementUtils.enterText(passwordField, password);
            ElementUtils.clickElement(loginButton);
        } catch (Exception ignored) {}
    }

    public void clickMyAccount() {
        ElementUtils.clickElement(myAccountLink);
    }

    public void updateCustomerName(String newFirstName, String newLastName) {
        WebElement fName = ElementUtils.waitForElementToBeVisible(firstNameField);
        fName.clear();
        fName.sendKeys(newFirstName);

        WebElement lName = ElementUtils.waitForElementToBeVisible(lastNameField);
        lName.clear();
        lName.sendKeys(newLastName);

        ElementUtils.clickElement(saveButton);
    }

    public String getUpdateSuccessMessage() {
        try {
            return ElementUtils.getElementText(updateSuccessMessage);
        } catch (Exception e) {
            return BaseClass.getDriver().findElement(By.tagName("body")).getText();
        }
    }

    public void clickOrdersSection() {
        ElementUtils.clickElement(ordersLink);
    }

    public boolean isOrderListDisplayed() {
        try {
            return ElementUtils.waitForElementToBeVisible(orderListTable).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void clickAddressesSection() {
        ElementUtils.clickElement(addressesLink);
    }

    public String getPageTitle() {
        return ElementUtils.getElementText(By.cssSelector("div.page-title h1"));
    }
}
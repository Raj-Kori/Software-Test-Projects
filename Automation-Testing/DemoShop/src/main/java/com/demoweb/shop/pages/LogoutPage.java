package com.demoweb.shop.pages;

import org.openqa.selenium.By;
import com.demoweb.shop.utils.ElementUtils;

public class LogoutPage {

    private By logoutLink = By.cssSelector("a.ico-logout");
    private By loginLink = By.cssSelector("a.ico-login");

    public void clickLogout() {
        ElementUtils.clickElement(logoutLink);
    }

    public boolean isLoginLinkDisplayed() {
        return ElementUtils.waitForElementToBeVisible(loginLink).isDisplayed();
    }
}
package com.demowebshop.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.demoweb.shop.pages.LoginPage;
import com.demoweb.shop.pages.LogoutPage;

public class LogoutTest extends BaseTest {

    @Test
    public void verifySuccessfulLogout() {
        LoginPage loginPage = new LoginPage();
        LogoutPage logoutPage = new LogoutPage();

        // 1. Log in to the application
        loginPage.clickLogin();
        loginPage.enteremail("rajkori@gmail.com");
        loginPage.enterpass("Test@123");
        loginPage.submit();

        // 2. Click Logout
        logoutPage.clickLogout();

        // 3. Verify logout success by checking if the Login link is visible again
        boolean isLoggedOut = logoutPage.isLoginLinkDisplayed();
        Assert.assertTrue(isLoggedOut, "Logout failed! User session is still active.");
    }
}
package com.demowebshop.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.demoweb.shop.pages.UserAccountPage;

public class UserAccountTest extends BaseTest {

    // TC_53: My Account Overview
    @Test(priority = 1)
    public void verifyMyAccountOverview() {
        UserAccountPage accountPage = new UserAccountPage();
        accountPage.loginToApplication("rajkori@gmail.com", "Test@123");
        accountPage.clickMyAccount();
        
        String pageTitle = accountPage.getPageTitle();
        Assert.assertTrue(pageTitle.contains("My account - Customer info"), "TC_53 Failed: Did not navigate to My Account dashboard.");
    }

    // TC_54: Update Customer Information
 // TC_54: Update Customer Information
    @Test(priority = 2)
    public void verifyUpdateCustomerInformation() {
        UserAccountPage accountPage = new UserAccountPage();
        accountPage.loginToApplication("rajkori@gmail.com", "Test@123");
        accountPage.clickMyAccount();
        accountPage.updateCustomerName("Raj", "Kori");
        
        String pageTitle = accountPage.getPageTitle();
        Assert.assertTrue(pageTitle.contains("My account"), "TC_54 Failed: Profile update did not save correctly.");
    }

    // TC_55: Order History & Details
    @Test(priority = 3)
    public void verifyOrderHistoryAndDetails() {
        UserAccountPage accountPage = new UserAccountPage();
        accountPage.loginToApplication("rajkori@gmail.com", "Test@123");
        accountPage.clickMyAccount();
        accountPage.clickOrdersSection();
        
        boolean isOrdersDisplayed = accountPage.isOrderListDisplayed();
        Assert.assertTrue(isOrdersDisplayed, "TC_55 Failed: Order history list not visible.");
    }

    // TC_56: Address Book Management
    @Test(priority = 4)
    public void verifyAddressBookManagement() {
        UserAccountPage accountPage = new UserAccountPage();
        accountPage.loginToApplication("rajkori@gmail.com", "Test@123");
        accountPage.clickMyAccount();
        accountPage.clickAddressesSection();
        
        String pageTitle = accountPage.getPageTitle();
        Assert.assertTrue(pageTitle.contains("My account - Addresses"), "TC_56 Failed: Did not navigate to Address Book section.");
    }
}
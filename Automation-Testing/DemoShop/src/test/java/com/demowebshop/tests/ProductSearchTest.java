package com.demowebshop.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.demoweb.shop.pages.ProductSearch;

public class ProductSearchTest extends BaseTest {

    // TC_46: Valid Product Search
    @Test(priority = 1)
    public void verifyValidProductSearch() {
        ProductSearch searchPage = new ProductSearch();
        String productName = "14.1-inch Laptop";
        
        searchPage.enterSearchTerm(productName);
        searchPage.clickSearchButton();
        
        String actualProductTitle = searchPage.getSearchedProductTitle();
        Assert.assertTrue(actualProductTitle.contains(productName), "TC_46 Failed: Valid product not found.");
    }

    // TC_47: Partial Keyword Search
    @Test(priority = 2)
    public void verifyPartialKeywordSearch() {
        ProductSearch searchPage = new ProductSearch();
        String keyword = "Computer";
        
        searchPage.enterSearchTerm(keyword);
        searchPage.clickSearchButton();
        
        String actualProductTitle = searchPage.getSearchedProductTitle();
        Assert.assertTrue(actualProductTitle.toLowerCase().contains(keyword.toLowerCase()), "TC_47 Failed: Partial keyword search did not return expected items.");
    }

    // TC_48: Invalid / Non-Existent Search
    @Test(priority = 3)
    public void verifyInvalidProductSearch() {
        ProductSearch searchPage = new ProductSearch();
        String invalidQuery = "NonExistentProductXYZ123";
        
        searchPage.enterSearchTerm(invalidQuery);
        searchPage.clickSearchButton();
        
        String warningMessage = searchPage.getNoResultWarning();
        Assert.assertTrue(warningMessage.contains("No products were found"), "TC_48 Failed: Expected 'No products were found' message not displayed.");
    }

    // TC_49: Blank Search Validation
    @Test(priority = 4)
    public void verifyBlankSearchValidation() {
        ProductSearch searchPage = new ProductSearch();
        
        searchPage.enterSearchTerm("");
        searchPage.clickSearchButton();
        
        // Handle the browser alert popup triggered by blank search
        boolean isAlertHandled = searchPage.handleAndVerifyAlert("Please enter some search keyword");
        Assert.assertTrue(isAlertHandled, "TC_49 Failed: Blank search did not trigger the expected alert message.");
    }
}
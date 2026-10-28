package com.demowebshop.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.demoweb.shop.pages.CompareProductsPage;
import com.demoweb.shop.pages.ProductSearch;

public class CompareProductsTest extends BaseTest {

    @Test
    public void verifyProductComparisonFlow() {
    	ProductSearch searchPage = new ProductSearch();
        CompareProductsPage comparePage = new CompareProductsPage();

        String productName = "14.1-inch Laptop";

        // 1. Search for a product
        searchPage.enterSearchTerm(productName);
        searchPage.clickSearchButton();

        // 2. Open product details and add to comparison list
        comparePage.clickProductTitle();
        comparePage.clickAddToCompare();

        // 3. Open Compare Products page via footer link
        comparePage.openCompareProductsPage();

        // 4. Validate that the comparison page loaded successfully
        String pageTitle = comparePage.getComparisonPageTitle();
        Assert.assertEquals(pageTitle, "Compare products", "Product comparison page title mismatch!");

        // 5. Clean up comparison list
        comparePage.clearComparisonList();
    }
}
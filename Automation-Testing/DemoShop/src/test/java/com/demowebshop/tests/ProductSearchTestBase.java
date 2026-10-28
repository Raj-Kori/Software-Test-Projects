package com.demowebshop.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.demoweb.shop.pages.ProductSearch;

public class ProductSearchTestBase extends BaseTest {
	@Test
    public void verifyProductSearch() {
		ProductSearch searchPage = new ProductSearch();
        
        String productName = "14.1-inch Laptop";
        searchPage.enterSearchTerm(productName);
        searchPage.clickSearchButton();
        
        String actualProductTitle = searchPage.getSearchedProductTitle();
        Assert.assertTrue(actualProductTitle.contains(productName), "Product Search Test failed! Product not found.");
    }

}

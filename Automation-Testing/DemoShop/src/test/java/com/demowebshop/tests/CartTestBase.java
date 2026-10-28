package com.demowebshop.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.demoweb.shop.pages.CartPage;
import com.demoweb.shop.pages.ProductSearch;

public class CartTestBase extends BaseTest {

    @Test
    public void verifyAddToCart() {
    	ProductSearch searchPage = new ProductSearch();
        CartPage cartPage = new CartPage();
        
        String productName = "14.1-inch Laptop";
        
        // 1. Search for product
        searchPage.enterSearchTerm(productName);
        searchPage.clickSearchButton();
        
        // 2. Open product detail page & click Add to Cart
        cartPage.clickProductTitle();
        cartPage.clickAddToCart();
        
        // 3. Navigate to Shopping Cart & verify
        cartPage.openShoppingCart();
        String actualCartProduct = cartPage.getProductNameInCart();
        
        Assert.assertTrue(actualCartProduct.contains(productName), "Add to Cart failed! Product not in cart.");
    }
}
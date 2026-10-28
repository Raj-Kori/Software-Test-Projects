package com.demowebshop.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.demoweb.shop.pages.CartPage;
import com.demoweb.shop.pages.CheckoutPage;
import com.demoweb.shop.pages.LoginPage;
import com.demoweb.shop.pages.ProductSearch;

public class CheckoutTest extends BaseTest {

    @Test
    public void verifyEndToEndOrderPlacement() {
        LoginPage loginPage = new LoginPage();
        ProductSearch searchPage = new ProductSearch();
        CartPage cartPage = new CartPage();
        CheckoutPage checkoutPage = new CheckoutPage();

        String productName = "14.1-inch Laptop";

        // 1. Log in
        loginPage.clickLogin();
        loginPage.enteremail("rajkori@gmail.com");
        loginPage.enterpass("Test@123");
        loginPage.submit();

        // 2. Search & Add product to cart
        searchPage.enterSearchTerm(productName);
        searchPage.clickSearchButton();
        cartPage.clickProductTitle();
        cartPage.clickAddToCart();

        // 3. Navigate to Cart & Initiate Checkout
        cartPage.openShoppingCart();
        checkoutPage.acceptTermsAndCheckout();

        // 4. Complete dynamic 6-step accordion checkout
        checkoutPage.completeBillingAddressIfRequired("United States", "New York", "123 Main St", "10001", "1234567890");
        checkoutPage.proceedShippingAddress();
        checkoutPage.proceedShippingMethod();
        checkoutPage.proceedPaymentMethod();
        checkoutPage.proceedPaymentInfo();
        checkoutPage.confirmOrder();

        // 5. Verify Successful Order
        String confirmation = checkoutPage.getOrderConfirmationText();
        Assert.assertEquals(confirmation, "Your order has been successfully processed!", "Checkout failed!");
    }
}
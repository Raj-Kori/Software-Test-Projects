package com.demoweb.shop.pages;

import org.openqa.selenium.By;
import com.demoweb.shop.utils.ElementUtils;

public class CartPage {

    private By productTitleLink = By.cssSelector("h2.product-title a");
    private By addToCartButton = By.cssSelector("input.add-to-cart-button");
    private By successNotification = By.cssSelector("div.bar-notification.success");
    private By shoppingCartHeaderLink = By.cssSelector("a.ico-cart");
    private By productNameInCart = By.cssSelector("td.product a.product-name");
    
    // Locators for TC_36 to TC_39
    private By qtyTextBox = By.cssSelector("input.qty-input");
    private By updateCartButton = By.name("updatecart");
    private By removeCheckbox = By.name("removefromcart");
    private By cartContentArea = By.cssSelector("div.order-summary-content");
    private By discountTextBox = By.name("discountcouponcode");
    private By applyCouponButton = By.name("applydiscountcouponcode");
    private By zipPostalCodeBox = By.id("ZipPostalCode");
    private By estimateShippingButton = By.name("estimateshipping");

    public void clickProductTitle() {
        ElementUtils.clickElement(productTitleLink);
    }

    public void clickAddToCart() {
        ElementUtils.clickElement(addToCartButton);
        ElementUtils.waitForElementToBeVisible(successNotification);
    }

    public void openShoppingCart() {
        ElementUtils.clickElement(shoppingCartHeaderLink);
    }

    public String getProductNameInCart() {
        return ElementUtils.getElementText(productNameInCart);
    }

    public void updateQuantity(String qty) {
        ElementUtils.enterText(qtyTextBox, qty); // This will clear and enter the new quantity cleanly
        ElementUtils.clickElement(updateCartButton);
    }

    public void removeItem() {
        ElementUtils.clickElement(removeCheckbox);
        ElementUtils.clickElement(updateCartButton);
    }

    public String getCartMessage() {
        return ElementUtils.getElementText(cartContentArea);
    }

    public void applyCoupon(String couponCode) {
        ElementUtils.enterText(discountTextBox, couponCode);
        ElementUtils.clickElement(applyCouponButton);
    }

    public void estimateShipping(String zipCode) {
        ElementUtils.enterText(zipPostalCodeBox, zipCode);
        ElementUtils.clickElement(estimateShippingButton);
    }
}
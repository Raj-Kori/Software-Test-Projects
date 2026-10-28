package com.demoweb.shop.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import com.demoweb.shop.BaseClass;
import com.demoweb.shop.utils.ElementUtils;
import java.util.List;

public class CheckoutPage {

    private By termsOfServiceCheckbox = By.id("termsofservice");
    private By checkoutButton = By.id("checkout");

    // Billing Locators
    private By billingAddressSelect = By.id("billing-address-select");
    private By countryDropdown = By.id("BillingNewAddress_CountryId");
    private By cityInput = By.id("BillingNewAddress_City");
    private By address1Input = By.id("BillingNewAddress_Address1");
    private By zipInput = By.id("BillingNewAddress_ZipPostalCode");
    private By phoneNumberInput = By.id("BillingNewAddress_PhoneNumber");
    private By billingContinueBtn = By.cssSelector("#billing-buttons-container input.button-1");

    // Accordion Continue Buttons
    private By shippingContinueBtn = By.cssSelector("#shipping-buttons-container input.button-1");
    private By shippingMethodContinueBtn = By.cssSelector("#shipping-method-buttons-container input.button-1");
    private By paymentMethodContinueBtn = By.cssSelector("#payment-method-buttons-container input.button-1");
    private By paymentInfoContinueBtn = By.cssSelector("#payment-info-buttons-container input.button-1");
    private By confirmOrderBtn = By.cssSelector("#confirm-order-buttons-container input.button-1");

    private By orderCompletedHeader = By.cssSelector("div.section.order-completed strong");

    public void acceptTermsAndCheckout() {
        ElementUtils.clickElement(termsOfServiceCheckbox);
        ElementUtils.clickElement(checkoutButton);
    }

    public void completeBillingAddressIfRequired(String country, String city, String address1, String zip, String phone) {
        List<WebElement> selectDropdown = BaseClass.getDriver().findElements(billingAddressSelect);
        
        if (selectDropdown.isEmpty() || selectDropdown.get(0).getText().contains("New Address")) {
            if (!selectDropdown.isEmpty()) {
                new Select(selectDropdown.get(0)).selectByVisibleText("New Address");
            }
            new Select(BaseClass.getDriver().findElement(countryDropdown)).selectByVisibleText(country);
            
            ElementUtils.enterText(cityInput, city);
            ElementUtils.enterText(address1Input, address1);
            ElementUtils.enterText(zipInput, zip);
            ElementUtils.enterText(phoneNumberInput, phone);
        }
        
        ElementUtils.clickElement(billingContinueBtn);
    }

    public void proceedShippingAddress() {
        ElementUtils.clickElement(shippingContinueBtn);
    }

    public void proceedShippingMethod() {
        ElementUtils.clickElement(shippingMethodContinueBtn);
    }

    public void proceedPaymentMethod() {
        ElementUtils.clickElement(paymentMethodContinueBtn);
    }

    public void proceedPaymentInfo() {
        ElementUtils.clickElement(paymentInfoContinueBtn);
    }

    public void confirmOrder() {
        ElementUtils.clickElement(confirmOrderBtn);
    }

    public String getOrderConfirmationText() {
        return ElementUtils.getElementText(orderCompletedHeader);
    }
}
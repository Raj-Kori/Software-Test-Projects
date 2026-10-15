package stepdefination;

import base.GK_BaseTest;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.GreenKart.GK_AddToCart;
import pages.GreenKart.GK_SearchField;

public class GreenKart extends GK_BaseTest {
    private GK_SearchField searchPage;
    private GK_AddToCart cartPage;

    @Given("User navigates to the GreenKart home page {string}")
    public void user_navigates_to_the_greenkart_home_page(String url) {
        initializeBrowser(url);
        searchPage = new GK_SearchField(driver);
        cartPage = new GK_AddToCart(driver);
    }

    @When("User searches for product {string}")
    public void user_searches_for_product(String productName) {
        searchPage.searchProduct(productName);
    }

    @When("User adds {string} to the cart")
    public void user_adds_product_to_cart(String productName) {
        searchPage.clickAddToCart(productName);
    }

    @Then("The cart item count should be {int}")
    public void cart_item_count_should_be(int expectedCount) {
        Assert.assertEquals(cartPage.getCartCount(), expectedCount,
                "Cart item count did not match the expected value.");
    }

    @Then("The cart price total should update accordingly")
    public void cart_price_total_should_update_accordingly() {
        Assert.assertTrue(cartPage.getCartPrice() > 0,
                "Cart total should be greater than zero after adding a product.");
    }

    @When("User clicks on the cart icon")
    public void user_clicks_on_the_cart_icon() {
        cartPage.openCart();
    }

    @When("User clicks {string}")
    public void user_clicks_button_by_text(String buttonText) {
        if ("PROCEED TO CHECKOUT".equalsIgnoreCase(buttonText)) {
            cartPage.proceedToCheckout();
        } else if ("Place Order".equalsIgnoreCase(buttonText)) {
            cartPage.clickPlaceOrder();
        } else if ("Proceed".equalsIgnoreCase(buttonText)) {
            cartPage.clickProceed();
        } else {
            throw new IllegalArgumentException("Unsupported button: " + buttonText);
        }
    }

    @Then("User should be navigated to the Order Checkout page")
    public void user_should_be_navigated_to_order_checkout_page() {
        Assert.assertTrue(cartPage.isCheckoutPageLoaded(),
                "Order checkout page was not displayed.");
    }

    @When("User applies promo code {string}")
    public void user_applies_promo_code(String promoCode) {
        cartPage.applyPromoCode(promoCode);
    }

    @When("User selects country {string} and accepts Terms & Conditions")
    public void user_selects_country_and_accepts_terms(String countryName) {
        cartPage.selectCountryAndAcceptTerms(countryName);
    }

    @Then("User should see the order confirmation message")
    public void user_should_see_order_confirmation_message() {
        Assert.assertTrue(cartPage.isOrderSuccessDisplayed(),
                "Order confirmation message was not displayed.");
    }

    @After
    public void closeBrowser() {
        tearDownBrowser();
    }
}
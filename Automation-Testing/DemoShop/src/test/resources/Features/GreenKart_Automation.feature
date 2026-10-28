@GK
Feature: GreenKart E-Commerce Shopping and Checkout

  Scenario: Search product, add to cart, apply promo, and place order successfully
    Given User navigates to the GreenKart home page "https://rahulshettyacademy.com/seleniumPractise/#/"
    When User searches for product "Cucumber"
    And User adds "Cucumber" to the cart
    Then The cart item count should be 1
    And The cart price total should update accordingly
    When User clicks on the cart icon
    And User clicks "PROCEED TO CHECKOUT"
    Then User should be navigated to the Order Checkout page
    When User applies promo code "rahulshettyacademy"
    And User clicks "Place Order"
    And User selects country "India" and accepts Terms & Conditions
    And User clicks "Proceed"
    Then User should see the order confirmation message
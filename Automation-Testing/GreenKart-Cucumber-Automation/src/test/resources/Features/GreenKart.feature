Feature: GreenKart E-Commerce Product Search and Checkout

  As an online shopper
  I want to search for items, add them to the cart, and proceed through checkout
  So that I can purchase organic groceries online

  Scenario: Complete end-to-end checkout process
    Given User navigates to the GreenKart home page "https://rahulshettyacademy.com/seleniumPractise/#/"
    When User searches for product "Cucumber"
    And User clicks on "ADD TO CART" for "Cucumber"
    And User clicks on the cart icon
    And User clicks on "PROCEED TO CHECKOUT"
    Then User should be navigated to the Order Checkout page
    When User applies promo code "rahulshettyacademy"
    And User clicks on "Place Order"
    And User selects country "India" and accepts Terms & Conditions
    And User clicks "Proceed"
    Then User should see the order confirmation message

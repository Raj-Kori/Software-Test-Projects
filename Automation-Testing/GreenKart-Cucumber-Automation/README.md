# GreenKart E-Commerce — Cucumber Automation

A beginner-friendly end-to-end UI automation project for the GreenKart demo e-commerce application.

> This is my first Cucumber automation project. The framework intentionally keeps the Selenium actions and Cucumber step definitions together while I build my understanding of BDD automation. Page Object Model will be introduced in a later project.

## Application Under Test

**GreenKart Demo Store:**  
https://rahulshettyacademy.com/seleniumPractise/#/

## Tech Stack

- Java 21
- Selenium WebDriver 4.49.0
- Cucumber 7.20.1
- TestNG 7.12.0
- Maven
- Chrome / Selenium Manager

## Automated End-to-End Scenario

The project automates the complete shopping workflow:

1. Launch GreenKart
2. Search for Cucumber
3. Add Cucumber to the cart
4. Open the cart
5. Proceed to checkout
6. Verify the Order Checkout page
7. Apply promo code rahulshettyacademy
8. Place the order
9. Select country India
10. Accept Terms & Conditions
11. Proceed with the order
12. Verify the order confirmation message

## Framework Structure

    GreenKart-Cucumber-Automation
    ├── pom.xml
    ├── testng.xml
    ├── .gitignore
    ├── README.md
    └── src
        └── test
            ├── java
            │   ├── runner
            │   │   └── Testrunner.java
            │   └── stepdefinations
            │       └── GreenKart_Automation.java
            └── resources
                └── Features
                    └── GreenKart.feature

## How to Run

From this project directory:

    mvn clean test

Or run Testrunner.java through TestNG in Eclipse.

Cucumber reports are generated under:

    target/cucumber-reports/cucumber.html
    target/cucumber-reports/cucumber.json

## Testing Practices Demonstrated

- Cucumber BDD feature/scenario design
- Selenium WebDriver browser automation
- Explicit waits with WebDriverWait
- Dynamic XPath locators
- Parameterized Cucumber steps
- TestNG assertions
- End-to-end checkout automation
- HTML and JSON Cucumber reporting

## Note

GreenKart is a public demo application. Its UI, DOM structure, or behavior may change over time, so locators may require maintenance.

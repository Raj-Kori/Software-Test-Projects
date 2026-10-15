# GreenKart — Cucumber BDD + Selenium Page Object Model

A learning-focused UI automation project for the GreenKart demo grocery store. It combines readable Cucumber/Gherkin scenarios with Selenium page classes so locators and browser actions are kept separate from the step definitions.

**Application under test:** https://rahulshettyacademy.com/seleniumPractise/#/

## Technology stack
- Java 21
- Selenium WebDriver 4.49.0
- Cucumber BDD / Gherkin 7.20.1
- TestNG 7.12.0
- Maven
- Page Object Model (POM)

## Scenario coverage
- Open the GreenKart home page
- Search for Cucumber
- Add the product to the cart
- Validate cart item count and price
- Open cart and navigate to checkout
- Apply the demo promo code
- Select India and accept Terms & Conditions
- Place the order and validate the confirmation message

## Project structure
```text
GreenKart-POM-Cucumber-Automation/
├── pom.xml
├── README.md
├── testng.xml
└── src/
    └── test/
        ├── java/
        │   ├── base/
        │   │   └── GK_BaseTest.java
        │   ├── pages/
        │   │   ├── GK_BasePage.java
        │   │   └── GreenKart/
        │   │       ├── GK_SearchField.java
        │   │       └── GK_AddToCart.java
        │   ├── runner/
        │   │   └── Testrunner.java
        │   └── stepdefination/
        │       └── GreenKart.java
        └── resources/
            └── Features/
                └── GreenKart_Automation.feature
```

## Run the tests
Requirements: JDK 21+, Maven, and Google Chrome.

From this project directory, run:
```bash
mvn clean test
```

The runner writes Cucumber HTML and JSON reports under `target/cucumber-reports/`. Selenium Manager handles the compatible ChromeDriver in supported Selenium setups.

## Learning note
This project demonstrates the progression from basic Cucumber step definitions to a Page Object Model structure. The demo website may change, so selectors and expected messages may need maintenance. Run the scenario against the public demo site and review the report before treating the test as passing.
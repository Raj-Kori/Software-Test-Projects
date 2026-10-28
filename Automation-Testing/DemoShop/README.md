# DemoShop — Final Software Testing Course Project

**Application under test:** https://demowebshop.tricentis.com/

This repository contains the Demo Web Shop automation framework built during my Software Testing course. The local Eclipse project uses Java, Selenium WebDriver, TestNG, Maven, Page Object Model (POM), CSV test data, and Extent Reports.

## Current progress
- [x] Test scenarios prepared
- [x] Test cases prepared
- [ ] Execute test cases and compare expected results with actual results
- [ ] Complete defect report from reproducible findings
- [ ] Complete Requirements Traceability Matrix (RTM)
- [ ] Re-run and verify the automation suite and reports

## Modules represented in the source project
- Registration
- Login and logout
- Product search and category navigation
- Product details / user account
- Shopping cart
- Wishlist
- Product comparison
- Checkout

## Framework components
The supplied project ZIP includes:
- Page objects under `src/main/java/com/demoweb/shop/pages/`
- Shared browser setup in `BaseClass.java`
- Utility classes for element interactions, CSV/Excel data reading, and Extent Reports
- TestNG test classes under `src/test/java/com/demowebshop/tests/`
- Test suite configuration in `src/test/resources/testng.xml`
- CSV test cases in `src/test/resources/testdata/DemoWeb - Test_Cases.csv`

## Running locally
Requirements: JDK compatible with the project, Maven, and Google Chrome. From the project root:

```bash
mvn clean test
```

The supplied `testng.xml` configures the regression suite and Extent Reports listener. Review test execution locally before treating the suite as passing.

## Backup status
This README describes the source ZIP reviewed for the project. The source ZIP includes unrelated CURA and GreenKart classes in the same Eclipse workspace; the DemoShop project scope is the `com.demoweb.shop` and `com.demowebshop.tests` packages plus the Demo Web Shop test data. Generated `target/` and `test-output/` files are build artifacts and should not be committed as source.

## QA documentation status
Test scenarios and test cases are complete according to my current progress. Actual-result verification, defect reporting, and RTM completion remain in progress. Defects should be recorded only after they are reproduced and supported by evidence.

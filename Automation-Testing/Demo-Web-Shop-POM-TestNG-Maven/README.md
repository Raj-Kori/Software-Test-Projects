# Demo Web Shop — Selenium Java Automation Framework

**Status:** Base framework under development; test scenario and test case documentation are reported as complete. Expected-vs-actual result comparison, defect report, and RTM are still in progress.

**Application:** https://demowebshop.tricentis.com/

> Backup note: This GitHub folder documents the project structure visible in the supplied screenshot and the requirements in the supplied project brief. The original Java source files were not included as uploadable source files, so this is not yet a byte-for-byte backup of the Eclipse project. Upload the project as a ZIP to add the exact source files safely.

## Technology stack
- Java (project screenshot shows JavaSE-21)
- Selenium WebDriver
- TestNG
- Maven
- Page Object Model (POM)
- Data-driven testing planned per the project brief

## Modules visible in the current Eclipse project

### Page classes
- `BaseClass.java`
- `CartPage.java`
- `CheckoutPage.java`
- `CompareProductsPage.java`
- `LoginPage.java`
- `LogoutPage.java`
- `ProductSearch.java`
- `RegisterPage.java`
- `WishlistPage.java`
- `ElementUtils.java`

### Test classes
- `BaseTest.java`
- `CartTest.java`
- `CheckoutTest.java`
- `CompareProductsTest.java`
- `LoginTest.java`
- `LogoutTest.java`
- `ProductSearchTest.java`
- `RegistrationTest.java`
- `WishlistTest.java`

The screenshot also shows existing project folders for CURA and GreenKart Cucumber step definitions. Those folders are not part of the Demo Web Shop package shown above.

## Planned functional coverage
Based on the supplied course project brief:
1. Registration — valid registration, mandatory fields, duplicate email
2. Login — valid, invalid, empty credentials
3. Product search — valid/invalid product and result verification
4. Product categories — Books, Computers, Electronics, Apparel
5. Product details — name, price, description, availability
6. Shopping cart — add, update quantity, remove
7. Wishlist — add and remove
8. Product comparison
9. Checkout — billing, shipping, payment, order confirmation
10. Logout

## Current progress (as reported)
- [x] Test scenarios completed
- [x] Test cases completed
- [ ] Execute test cases and compare expected vs actual results
- [ ] Complete defect report based on observed failures
- [ ] Complete Requirements Traceability Matrix (RTM)
- [ ] Verify automation suite execution and capture reports/screenshots
- [ ] Add the actual Eclipse source project to this GitHub folder

## Suggested repository layout
Keep page objects and tests in separate packages. A conventional layout would be:

```text
Demo-Web-Shop-POM-TestNG-Maven/
├── pom.xml
├── testng.xml
├── README.md
├── src/
│   ├── main/java/com/demoweb.shop/
│   │   ├── BaseClass.java
│   │   ├── pages/
│   │   └── utils/
│   └── test/java/com/demowebshop.tests/
│       ├── BaseTest.java
│       └── *Test.java
└── test-output/
```

This is a suggested layout based on the screenshot, not a verified copy of every local file.

## Before publishing as a completed project
- Run the suite from a clean checkout using Maven.
- Verify that each test uses meaningful assertions and stable waits.
- Do not report a defect unless it was reproduced and documented.
- Keep credentials and personal data out of the repository.
- Include only reports/screenshots that do not expose private data.

## Project reference
The course brief supplied for this project specifies Selenium WebDriver, Java, TestNG, Maven, POM, DataProvider, testng.xml, failure screenshots, and HTML reports. It suggests at least 30 test cases across the core e-commerce modules.

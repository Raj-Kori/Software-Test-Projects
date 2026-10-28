# DemoShop — Final Software Testing Course Project

**Application under test:** https://demowebshop.tricentis.com/

This project covers the manual testing and automation testing workflow for Demo Web Shop. The automation framework uses Java, Selenium WebDriver, TestNG, Maven, Page Object Model (POM), CSV test data, and Extent Reports.

## Project work completed

### 1. Manual testing
- [x] Test scenarios
- [x] Test cases
- [x] Defect report
- [x] Requirements Traceability Matrix (RTM)

### 2. Automation testing
- [x] Automated test scripts to check application flows covered by the test cases
- [x] TestNG suite execution

### 3. Test reporting
- [x] Generated HTML test report (`Test reports.html`)

**Latest execution result shared:** 34 tests run, 34 passed, 0 failed, 0 skipped. See [Test Execution Summary](./TEST-EXECUTION-SUMMARY.md). This result reflects the console output for that run; it is not a claim that every application requirement is defect-free.

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
- Page objects under `src/main/java/com/demoweb/shop/pages/`
- Shared browser setup in `BaseClass.java`
- Utility classes for element interactions, CSV/Excel data reading, and Extent Reports
- TestNG test classes under `src/test/java/com/demowebshop/tests/`
- Test suite configuration in `src/test/resources/testng.xml`
- CSV test data under `src/test/resources/testdata/`

## Running locally
Requirements: a compatible JDK, Maven, and Google Chrome. From the project root:

```bash
mvn clean test
```

Review the TestNG and HTML report output after execution. Browser/CDP compatibility and logging warnings may need cleanup even when tests pass.

## Repository notes
Keep source code, test data, manual testing documents, and useful HTML report artifacts organized in this project. Avoid committing generated build folders such as `target/` and temporary output folders unless they are intentionally required as evidence.

**Report upload note:** The HTML report is documented here, but the report file itself must be committed to this repository separately if it is not already present.

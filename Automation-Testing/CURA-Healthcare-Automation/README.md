# CURA Healthcare — Maven + TestNG + POM Automation

Automated UI testing project for the [CURA Healthcare Service demo application](https://katalon-demo-cura.herokuapp.com/).

## Technology stack
- Java 21
- Maven
- Selenium WebDriver 4.51.0
- TestNG 7.12.0
- Page Object Model (POM)
- ExtentReports 5.1.2

## Framework structure
```
CURA-Healthcare-Automation/
├── pom.xml
├── CURA_Report.html
└── src/
    ├── main/java/cura/
    │   ├── base/       # WebDriver setup and teardown
    │   ├── pages/      # Login and appointment page actions
    │   └── utils/      # Reusable element methods and ExtentReports
    └── test/
        ├── java/cura/test/   # TestNG tests and test lifecycle
        └── resources/CURA.xml
```

## Current automated coverage
- Login flow using the demo credentials
- Appointment booking flow: facility, readmission checkbox, Medicaid program, visit date and comment
- TestNG listener integration for pass/fail/skip reporting
- Extent Spark HTML report generation

## Run locally
Prerequisites: JDK 21, Maven, and Google Chrome.

```bash
mvn clean test
```

The TestNG suite is configured in `src/test/resources/CURA.xml`. A fresh Extent report is generated at `test-output/CURA_Report.html` after execution.

## Notes
- This repository contains the framework and test scripts supplied in the project archive, with the Maven configuration cleaned up for this TestNG/POM implementation.
- The uploaded source includes Cucumber dependencies in its original POM, but no Cucumber feature files or step definitions. Those unused dependencies are excluded here.
- Test execution has not been independently rerun as part of this repository update. Review assertions and test outcomes from a fresh local run before presenting execution totals.

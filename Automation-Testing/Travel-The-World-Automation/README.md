# Travel The World — Selenium Automation

Automated UI coverage for the corresponding manual-testing project.

**AUT:** https://blazedemo.com/index.php

## Stack
Java 21 • Maven • Selenium 4.49.0 • TestNG 7.12.0 • Page Object Model

## Automated coverage
Select departure/destination, search flights, select a flight, enter passenger/payment data and verify purchase confirmation.

## Structure
- `src/test/java/base` — WebDriver lifecycle
- `src/test/java/pages` — Page Objects
- `src/test/java/tests` — TestNG tests
- `pom.xml` — Maven dependencies and build configuration

## Run
`mvn test`

> Demo sites can change their DOM or behavior. Locators should be maintained as part of normal automation maintenance.
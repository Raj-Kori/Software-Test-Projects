# YouTube — Selenium Automation

Automated UI coverage for the corresponding manual-testing project.

**AUT:** https://www.youtube.com/

## Stack
Java 21 • Maven • Selenium 4.49.0 • TestNG 7.12.0 • Page Object Model

## Automated coverage
Search for a video, verify results are rendered, and exercise basic player/search workflow.

## Structure
- `src/test/java/base` — WebDriver lifecycle
- `src/test/java/pages` — Page Objects
- `src/test/java/tests` — TestNG tests
- `pom.xml` — Maven dependencies and build configuration

## Run
`mvn test`

> Demo sites can change their DOM or behavior. Locators should be maintained as part of normal automation maintenance.
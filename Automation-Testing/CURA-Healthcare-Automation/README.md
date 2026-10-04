# CURA Healthcare — Selenium Automation
Automated regression coverage for the CURA Healthcare Service manual-testing project.

**AUT:** https://katalon-demo-cura.herokuapp.com/

## Stack
Java 21 • Maven • Selenium 4.49.0 • TestNG 7.12.0 • Page Object Model

## Automated flow
- Open CURA
- Navigate to Make Appointment
- Login with the demo credentials
- Select facility and healthcare program
- Enter visit date and comment
- Book appointment
- Assert Appointment Confirmation

## Run
`mvn test`

The automation complements the existing manual test artifacts; defect observations remain documented separately in the Manual-Testing project.
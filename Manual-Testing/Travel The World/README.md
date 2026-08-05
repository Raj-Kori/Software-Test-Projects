# Travel The World (BlazeDemo) — Manual Testing Portfolio Project

## 📌 Project Overview
**Application Under Test (AUT):** [BlazeDemo - Travel The World](https://blazedemo.com/index.php)

**BlazeDemo (Travel The World)** is a web-based flight search and reservation application designed to test booking flows, destination selection, passenger detail input, and payment processing. 

This manual testing project focuses on evaluating core flight search logic, form validation, data persistence across booking steps, and payment confirmation workflows.

---

## 🎯 Scope of Testing
* **Modules Tested:**
  * **Flight Search Engine:** Departure/destination dropdown selection and search submission.
  * **Flight Selection Matrix:** Flight list rendering, price display accuracy, and flight choice triggers.
  * **Passenger Information & Payment Form:** Input field validation (Name, Address, City, State, Zip, Card Number, Name on Card), and checkbox controls.
  * **Booking Confirmation:** Ticket receipt generation, transaction ID creation, and data matching between booking inputs and confirmation output.

---

## 🛠️ Testing Methodology & Deliverables
* **Test Case Design Techniques:** Boundary Value Analysis (BVA), Equivalence Partitioning (EP), Decision Table Testing.
* **Test Artifacts Included in Excel (`Raj Kori_Practical1.xlsx`):**
  * **Test Scenarios:** High-level coverage for the end-to-end flight booking journey.
  * **Test Cases:** Step-by-step test cases covering positive, negative, UI, and functional checks.
  * **Execution Results:** Status logs mapped with execution dates and pass/fail criteria.
  * **Defect Log:** Formatted bug reports with steps to reproduce, severity, and expected vs. actual outcomes.

---

## 🐛 Sample Bug Report

| Defect ID | Summary | Severity | Priority | Status |
| :--- | :--- | :--- | :--- | :--- |
| **BUG-TTW-001** | Departure and Destination cities allow matching selection without throwing a validation error | Medium | High | Open |

**Steps to Reproduce:**
1. Navigate to [BlazeDemo - Travel The World](https://blazedemo.com/index.php).
2. Set `Choose your departure city:` to `Boston`.
3. Set `Choose your destination city:` to `Boston`.
4. Click **Find Flights**.

* **Expected Result:** The system should prevent identical departure and destination selections and display a validation error: *"Departure and Destination cities cannot be the same."*
* **Actual Result:** The search processes normally and opens a list of flights originating and landing in the same city.

---

## 📂 Deliverables File
📄 **[Download Complete Practical Test Execution Sheet](./Raj%20Kori_Practical1.xlsx)**

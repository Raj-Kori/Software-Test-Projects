# CURA Health Care Services — Manual Testing Portfolio Project

## 📌 Project Overview
**Application Under Test (AUT):** [CURA Healthcare Service](https://katalon-demo-cura.herokuapp.com/)

**CURA Health Care Service** is a web-based healthcare portal designed for patients to book appointment slots with doctors, select facility locations, apply healthcare programs (Medicare, Medicaid, None), and manage booking schedules. 

The goal of this manual testing project was to perform end-to-end functional validation, UI testing, and boundary scenario execution to ensure system reliability and seamless user experience.

---

## 🎯 Scope of Testing
* **Modules Tested:**
  * **User Authentication:** Login verification with valid/invalid credentials, session persistence, and error handling.
  * **Appointment Booking Engine:** Facility selection, readmission checkbox verification, healthcare program radio buttons, date picker validation, and comment fields.
  * **Confirmation & Summary Page:** Data accuracy validation between booking input and confirmation output.
  * **History & Profile Management:** Appointment history accuracy and logout functionality.

---

## 🛠️ Testing Methodology & Deliverables
* **Test Case Design Techniques:** Equivalence Partitioning (EP), Boundary Value Analysis (BVA), State Transition.
* **Test Artifacts Included in Excel (`Project_Manual_Testing.xlsx`):**
  * **Test Scenarios:** High-level functional coverage maps.
  * **Test Suite & Execution Sheet:** Detailed step-by-step test cases including Test ID, Description, Pre-conditions, Test Steps, Expected Result, Actual Result, and Pass/Fail Status.
  * **Defect Log / Bug Reports:** Detailed bug reports mapped with Steps to Reproduce, Severity, Priority, and Screenshots/Notes.

---

## 🐛 Sample Bug Report

| Defect ID | Summary | Severity | Priority | Status |
| :--- | :--- | :--- | :--- | :--- |
| **BUG-CURA-001** | Booking confirmation allows submission without selecting a mandatory appointment date | High | High | Open |

**Steps to Reproduce:**
1. Navigate to [CURA Health Care Login](https://katalon-demo-cura.herokuapp.com/profile.php#login) and log in with valid credentials.
2. Select any facility (e.g., `Tokyo CURA Healthcare Center`).
3. Leave the `Visit Date` field completely blank.
4. Click the `Book Appointment` button.

* **Expected Result:** The system should throw a validation error: *"Please fill out this field."*
* **Actual Result:** The system processes the request and navigates to the confirmation screen with an empty date field.

---

## 📂 Deliverables File
📄 **[Download Complete Test Execution & Defect Sheet](./Project_Manual_Testing.xlsx)**

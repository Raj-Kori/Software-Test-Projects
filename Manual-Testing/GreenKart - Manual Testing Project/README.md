# GreenKart — E-Commerce Manual Testing Portfolio Project

## 📌 Project Overview
**Application Under Test (AUT):** [GreenKart Demo Store](https://rahulshettyacademy.com/seleniumPractise/#/)

**GreenKart** is an e-commerce web application designed for online grocery shopping. The platform allows users to search for fresh produce, filter items, increment/decrement item quantities, manage shopping cart items, apply promo codes, and proceed through country-specific checkout flows.

This manual testing project focuses on verifying core functional workflows, validating UI/UX controls, and performing Boundary Value Analysis (BVA) on item counters and checkout fields.

---

## 🎯 Scope of Testing
* **Modules Tested:**
  * **Product Catalog & Search:** Live keyword filtering, item cards display, and image validation.
  * **Cart Management:** Increment/decrement quantity controls, "ADD TO CART" state changes, and top bar cart summary calculations.
  * **Checkout & Promo Applied:** Items list verification in order summary, promo code box interactions, and final price adjustments.
  * **Order Placement:** Country selection dropdown, terms and conditions checkbox validation, and order completion modal.

---

## 🛠️ Testing Methodology & Deliverables
* **Test Case Design Techniques:** Boundary Value Analysis (BVA), Equivalence Partitioning (EP), Decision Table Testing.
* **Test Artifacts Included in Excel (`Green Kart_ ST.xlsx`):**
  * **Test Scenarios:** End-to-end shopping journey coverage maps.
  * **Test Cases:** Detailed step-by-step test cases covering functional, UI, and edge scenarios.
  * **Execution Results:** Mapped Pass/Fail results with execution dates.
  * **Defect Log:** Documented bugs with reproduction steps, severity levels, and actual outcomes.

---

## 🐛 Sample Bug Report

| Defect ID | Summary | Severity | Priority | Status |
| :--- | :--- | :--- | :--- | :--- |
| **BUG-GK-001** | Item quantity counter accepts zero (0) and negative values on manual input | Medium | High | Open |

**Steps to Reproduce:**
1. Navigate to [GreenKart Demo Store](https://rahulshettyacademy.com/seleniumPractise/#/).
2. Locate any product card (e.g., `Brocolli - 1 Kg`).
3. Click into the quantity text input field, delete the default `1`, and manually type `-5` or `0`.
4. Click **ADD TO CART**.

* **Expected Result:** The input box should reject negative/zero inputs or default back to `1`. The "ADD TO CART" button should be disabled for invalid quantities.
* **Actual Result:** The system accepts negative quantities and adds invalid item calculations to the cart header total.

---

## 📂 Deliverables File
📄 **[Download Complete Test Execution Sheet](./Green%20Kart_%20ST.xlsx)**

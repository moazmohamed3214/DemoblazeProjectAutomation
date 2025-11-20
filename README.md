🧠 Demoblaze Automation Framework – Selenium Hybrid Automation 🚀

A complete hybrid automation framework for testing the Demoblaze e-commerce website using Selenium WebDriver, TestNG, Cucumber BDD, and Page Object Model (POM).

Java • Selenium • TestNG • Cucumber • Maven • Extent Reports • Data-Driven Testing

🎯 About The Project

This repository contains end-to-end automated test cases for the Demoblaze online store.
The framework is designed to handle real-world automation scenarios including:

Login and Signup

Add/Delete products from cart

Payment and checkout workflow

Contact form flow

Full end-to-end purchase scenario

This is a Hybrid Automation Framework that combines:

✔ Selenium WebDriver
✔ TestNG
✔ Cucumber BDD
✔ Page Object Model (POM)
✔ Excel test data
✔ Extent Reports

💡 Perfect For

Learning advanced Selenium WebDriver

Preparing for Automation Testing interviews

Understanding hybrid automation architecture

Practicing BDD (Cucumber + Gherkin)

Building real-world automation frameworks

Generating professional reports

Improving testing skills with structured POM design

🏆 Features Covered
🔐 Authentication

Login (Valid / Invalid scenarios)

Signup

Negative validations

🛒 Cart & Shopping

Add product to cart

Delete product from cart

Validate total price

End-to-end purchase scenario

💳 Payment & Contact

Payment form automation

Contact form automation

📁 Extra Features

Excel-based test data

Parallel execution using TestNG

HTML reporting using Extent Reports

Screenshots on failures

Cucumber feature file execution

🧩 Project Structure
src
│
├── main
│   └── java
│       ├── base
│       ├── pages
│       ├── stepsDefination
│       └── utils
│
├── resources
│   └── features
│       ├── Login.feature
│       └── Signup.feature
│
└── test
    └── java
        ├── resources (Excel test data)
        └── test (TestNG test classes)

testng.xml (parallel execution + suites)

🧰 Technologies Used
Tool	Purpose
Java	Core programming language
Selenium WebDriver	Browser automation
TestNG	Test runner + parallel execution
Cucumber BDD	BDD scenarios using Gherkin
Maven	Build & dependency management
POM Design Pattern	Framework structure
Extent Reports	HTML reporting
Excel (Apache POI)	Data-driven testing
Test Listeners	Logs, screenshots, events
🚀 How To Run
▶️ Run All Tests
mvn clean test

▶️ Run Specific Test Suite (testng.xml)

Right-click testng.xml → Run

▶️ Run Cucumber Scenarios

Run TestRunner.java inside stepsDefination.

📊 Reporting

The framework generates an HTML Extent Report after each execution:

ExtentReport_<DATE>.html


The report includes:
✔ Detailed test results
✔ Screenshots on failure
✔ Execution timeline
✔ Step-by-step logs

# 🏦 ParaBank Selenium Automation Framework

A portfolio-grade test automation framework built with **Java + Selenium + TestNG**,
testing the [ParaBank](https://parabank.parasoft.com) banking demo application.

> Built in public as part of my QA Engineering portfolio.
> This is the Selenium counterpart to my Cypress automation project on the same
> application — built to demonstrate cross-framework automation skill, a more
> advanced SDLC process, and a Data Driven testing architecture.

---

## 🧪 Application Under Test

**ParaBank by Parasoft** — a full-featured banking simulation covering:
- User registration and authentication
- Account management (checking and savings)
- Fund transfers between accounts
- Bill payments
- Loan applications and approvals

**URL:** https://parabank.parasoft.com/parabank/index.htm

---

## 🏗️ Project Structure

    Parabank-Project-Selenium/
    ├── src/
    │   ├── main/
    │   │   ├── java/
    │   │   └── resources/
    │   └── test/
    │       ├── java/
    │       │   ├── pageObject/
    │       │   │   ├── BasePage.java
    │       │   │   ├── HomePage.java
    │       │   │   ├── LoginPage.java
    │       │   │   └── RegisterPage.java
    │       │   ├── testBase/
    │       │   ├── testCases/
    │       │   └── utilities/
    │       └── resources/
    │           └── config.properties
    ├── pom.xml
    ├── .github/workflows/ci.yml
    └── README.md

---

## ✅ Test Suites

| Module | Status |
|--------|--------|
| Authentication | 🔄 In Progress |
| Accounts | 📋 Planned |
| Transfers | 📋 Planned |
| Bill Pay | 📋 Planned |
| Loans | 📋 Planned |

> Page objects built so far: `HomePage`, `LoginPage`, `RegisterPage`, `BasePage`
> All test cases are documented as GitHub Issues with labels, milestones, and priorities.

---

## 🛠️ Tech Stack

| Tool | Purpose |
|------|---------|
| Java | Programming language |
| Selenium WebDriver | Browser automation |
| TestNG | Test framework, assertions, data providers |
| Apache POI | Reading test data from Excel |
| ExtentReports | Rich HTML test reporting |
| Log4j | Logging |
| Maven | Build and dependency management |
| GitHub Actions | Continuous integration pipeline |

---

## 🏛️ Architecture

This framework follows the **Page Object Model + Data Driven** pattern:

- **One Page Object per distinct screen** — each class represents exactly one page
  with its own elements and actions, never combining multiple screens into one class
- **Data Driven via Excel** — test inputs and expected results will be read at
  runtime through a custom `ExcelReader` utility using TestNG's `@DataProvider`
- **Centralised base class** — `BasePage` handles WebDriver setup and PageFactory
  initialisation, so every page object simply extends it and gets its elements
  initialised automatically through `initElements()`
- **testBase** holds the TestNG setup and teardown logic shared across all test
  classes, including `@BeforeMethod` and `@AfterMethod` driver handling
- **testCases** holds the actual `@Test` classes, one per module

---

## 🌳 Git Workflow

This project follows a feature-branch SDLC process:

1. Each module is developed on its own branch — `feature/auth-module`,
   `feature/accounts-module`, etc.
2. A Pull Request is opened against `main`
3. The CI/CD pipeline runs automatically on the Pull Request
4. The branch is merged into `main` only once the pipeline passes

`main` is a protected branch — no direct pushes are made to it.

---

## 🚀 Getting Started

### Prerequisites
- Java JDK 17+
- Maven 3.8+
- IntelliJ IDEA or Eclipse

### Installation

```bash
git clone https://github.com/qa-eden/Parabank-Project-Selenium.git
cd Parabank-Project-Selenium
mvn clean install
```

### Running Tests

```bash
# Run the full suite via TestNG XML
mvn test

# Run a specific TestNG suite file
mvn test -DsuiteXmlFile=testng.xml
```

### Viewing Reports

After a test run, the ExtentReports HTML report is generated at:
```
test-output/ExtentReport.html
```

---

## 🔐 Test Credentials

| Role | Username | Password |
|------|----------|----------|
| Standard User | john | demo |

> These are public demo credentials for the ParaBank sandbox application.

---

## 🔗 Related Project

This project is the Selenium + Java counterpart to my Cypress + JavaScript
automation framework built on the same application:

[ParaBank Cypress E2E Framework →](https://github.com/qa-eden/Parabank-Project-Cypress)

---

## 👤 Author

**Emmanuel Adeniran**
QA Engineer

[![LinkedIn](https://img.shields.io/badge/LinkedIn-Connect-blue)](www.linkedin.com/in/edenqa)
[![GitHub](https://img.shields.io/badge/GitHub-qa--eden-black)](https://github.com/qa-eden)

---

## 📌 Project Status

> 🔄 **Active build** — this project is being built and documented publicly.
> Follow along on LinkedIn for daily progress updates.

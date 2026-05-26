# Cucumber Selenium TestNG Framework

A robust, scalable **Behavior-Driven Development (BDD)** test automation framework built with **Cucumber**, **Selenium WebDriver**, and **TestNG** — powered by **Java 21** and **Maven**.

---

## 📋 Table of Contents

- [Overview](#overview)
- [Tech Stack](#tech-stack)
- [Project Structure](#project-structure)
- [Prerequisites](#prerequisites)
- [Getting Started](#getting-started)
- [Running Tests](#running-tests)
- [CI/CD Pipeline](#cicd-pipeline)
- [Writing Tests](#writing-tests)
- [Contributing](#contributing)

---

## Overview

This framework enables end-to-end UI test automation using the BDD approach. Tests are written in plain English using **Gherkin syntax**, making them readable and maintainable by both technical and non-technical stakeholders.

Key capabilities:

- **BDD-first** — Feature files written in Gherkin act as living documentation
- **Cross-browser** — Leverages Selenium WebDriver for flexible browser support
- **CI-ready** — Integrated GitHub Actions pipeline for automated test execution on every push

---

## Tech Stack

| Tool | Version | Purpose |
|------|---------|---------|
| Java | 21 | Core language |
| Maven | Latest | Build & dependency management |
| Cucumber | 7.34.3 | BDD framework |
| Selenium WebDriver | 4.44.0 | Browser automation |
| TestNG | Latest | Test runner & assertions |
| GitHub Actions | — | CI/CD pipeline |

---

## Project Structure

```
cucumber-project/
├── .github/
│   └── workflows/          # GitHub Actions CI pipeline
├── src/
│   └── test/
│       ├── java/
│       │   ├── runners/    # TestNG + Cucumber runner classes
│       │   ├── steps/      # Step definition classes
│       │   └── pages/      # Page Object Model classes
│       └── resources/
│           └── features/   # Gherkin feature files
├── pom.xml                 # Maven project configuration
└── README.md
```

---

## Prerequisites

Make sure you have the following installed before setting up the project:

- **Java JDK 21+** — [Download](https://www.oracle.com/java/technologies/downloads/)
- **Apache Maven 3.8+** — [Download](https://maven.apache.org/download.cgi)
- **Git** — [Download](https://git-scm.com/)
- A supported browser (Chrome, Firefox, Edge) with the matching WebDriver

---

## Getting Started

### 1. Clone the repository

```bash
git clone https://github.com/antoniosgerges94/cucumber-project.git
cd cucumber-project
```

### 2. Install dependencies

```bash
mvn clean install -DskipTests
```

---

## Running Tests

### Run all tests

```bash
mvn test
```

### Run a specific feature file

```bash
mvn test -Dcucumber.features="src/test/resources/features/your_feature.feature"
```

### Run tests by tag

```bash
mvn test -Dcucumber.filter.tags="@smoke"
```

### Run tests by tag (excluding a tag)

```bash
mvn test -Dcucumber.filter.tags="@regression and not @wip"
```

---

## CI/CD Pipeline

This project includes a **GitHub Actions** workflow that automatically runs the full test suite on every push or pull request to the `main` branch.

The pipeline:
1. Checks out the repository
2. Sets up Java 21
3. Installs Maven dependencies
4. Executes all tests via `mvn test`

You can view pipeline results under the [Actions tab](https://github.com/antoniosgerges94/cucumber-project/actions).

---

## Writing Tests

### 1. Create a Feature File

Add a new `.feature` file under `src/test/resources/features/`:

```gherkin
Feature: Login functionality

  Scenario: Successful login with valid credentials
    Given the user is on the login page
    When the user enters valid credentials
    Then the user should be redirected to the dashboard
```

### 2. Implement Step Definitions

Create a matching step definition class under `src/test/java/steps/`:

```java
public class LoginSteps {

    @Given("the user is on the login page")
    public void userIsOnLoginPage() {
        // navigation logic
    }

    @When("the user enters valid credentials")
    public void userEntersValidCredentials() {
        // input logic
    }

    @Then("the user should be redirected to the dashboard")
    public void userIsRedirectedToDashboard() {
        // assertion logic
    }
}
```

### 3. Register the Runner

Ensure your TestNG runner class includes the new feature in its glue/features path:

```java
@CucumberOptions(
    features = "src/test/resources/features",
    glue = "steps",
    plugin = {"pretty", "html:target/cucumber-reports"}
)
public class TestRunner extends AbstractTestNGCucumberTests {}
```

---

## Contributing

Contributions are welcome! Please follow these steps:

1. Fork the repository
2. Create a feature branch: `git checkout -b feature/your-feature-name`
3. Commit your changes: `git commit -m "feat: add your feature"`
4. Push to your branch: `git push origin feature/your-feature-name`
5. Open a Pull Request

---

## Author

**Antonio Gerges Hakim**
[GitHub Profile](https://github.com/antoniosgerges94)

---

> Built with ❤️ using Cucumber, Selenium, and TestNG

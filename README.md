# Md Mehedi Hasan — Portfolio & Test Automation Suite

> Senior SDET · Test Automation Architect · CI/CD Pipeline Engineer  
> Live site: **[mhdhasan.netlify.app](https://mhdhasan.netlify.app/)**

---

## Repository Structure

```
├── index.html                  # Portfolio website (single-page)
├── portfolio/                  # Netlify-ready deployment build
│   ├── index.html
│   ├── assets/
│   └── ...
└── test-automation/            # End-to-end test automation framework
    ├── build.gradle
    ├── gradlew.bat
    └── src/test/
        ├── java/com/portfolio/ # Page Objects + Step Definitions
        └── resources/features/ # Cucumber feature files
```

---

## Test Automation Framework

A production-grade E2E test suite built to verify every section of the portfolio website.

### Tech Stack

| Layer | Technology |
|---|---|
| Language | Java 11 |
| Browser Automation | Selenium WebDriver 4.27 |
| Test Framework | Cucumber 7 (BDD) + JUnit 4 |
| Build Tool | Gradle 8.8 |
| Driver Management | WebDriverManager (auto-downloads ChromeDriver) |
| Design Pattern | Page Object Model (POM) |
| Reporting | Cucumber HTML / JSON / JUnit XML |

### Test Coverage

| Feature Area | Scenarios |
|---|---|
| Navigation | 14 |
| Hero Section | 13 |
| About Section | 12 |
| Skills Section | 14 |
| Experience Timeline | 11 |
| Achievements | 8 |
| Education & Credentials | 12 |
| Publications | 10 |
| Contact Form & Links | 18 |
| Footer | 6 |
| **Total** | **125 scenarios / 373 steps** |

---

## Running the Tests

**Prerequisites:** Java 11+, Google Chrome — no manual driver setup needed.

```bat
cd test-automation

# Full regression suite
gradlew.bat cucumberTest

# Smoke suite only (~26 scenarios)
gradlew.bat cucumberTest -Dtags="@smoke"

# Single section
gradlew.bat cucumberTest -Dtags="@contact"

# Headless mode (CI/Jenkins)
gradlew.bat cucumberTest -Dheadless=true

# Firefox
gradlew.bat cucumberTest -Dbrowser=firefox

# Against local file
gradlew.bat cucumberTest "-Dbase.url=file:///D:/Work/My Website/index.html"
```

Reports are generated at `test-automation/build/cucumber-reports/cucumber.html`.

### Jenkins Pipeline

```groovy
pipeline {
    agent any
    stages {
        stage('Checkout') {
            steps { checkout scm }
        }
        stage('Test') {
            steps {
                dir('test-automation') {
                    bat 'gradlew.bat cucumberTest -Dheadless=true'
                }
            }
        }
        stage('Reports') {
            steps {
                cucumber 'test-automation/build/cucumber-reports/cucumber.json'
            }
        }
    }
}
```

---

## About

**Md Mehedi Hasan** is a Senior SDET at General Motors with 5+ years of experience building
test automation platforms, CI/CD pipelines, and quality infrastructure at scale.

- Email: mhasan.kme@gmail.com  
- LinkedIn: [linkedin.com/in/mehedihasan91](https://linkedin.com/in/mehedihasan91)
- IEEE Member · DFSS Black Belt · U.S. Citizen · Remote Ready

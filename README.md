# pTestng — TestNG + Selenium Automation Framework (Java)

A Page-Object-Model test automation framework built with **Selenium 4**,
**TestNG**, and **Maven**, targeting [EventHub](https://eventhub.rahulshettyacademy.com)
(a practice event-management web app) as the system under test.

## Stack

| Concern | Tool |
|---|---|
| Browser automation | Selenium WebDriver 4.49 |
| Test framework | TestNG 7.7 |
| API testing | REST Assured |
| Reporting | ExtentReports + Allure |
| Assertions | Hamcrest |
| Build | Maven |
| CI | Jenkins (`Jenkinsfile`) |

## What this demonstrates

- **Page Object Model** with a central `PageObjectManager` handing out page
  objects (`LoginPO`, `HomePO`, `EventPO`) rather than instantiating them
  ad hoc in test classes.
- **Custom TestNG extensions**: a `RetryAnalyzer` for automatically retrying
  flaky tests, and an `AnnotationTransformer` that applies it suite-wide
  without annotating every `@Test` individually.
- **Structured reporting**: an `ExtentReportListener` wired into TestNG's
  listener framework for HTML test reports, alongside Allure for
  trend/history reporting.
- **Data-driven testing** via TestNG `@DataProvider`.
- **CI-ready**: a `Jenkinsfile` runs the suite as part of a pipeline, not
  just from a local IDE.

## Project layout

```
src/
├── main/java/
│   ├── pageObjects/        # LoginPO, HomePO, EventPO, PageObjectManager
│   └── resources/          # TestBase, GenericUtils
└── test/java/
    ├── practiceTestng/pTestng/   # Test classes (e.g. CreateEventTest)
    └── utils/                    # RetryAnalyzer, AnnotationTransformer,
                                   # ExtentReportListener, TestContextSetup
smoke-testng.xml            # TestNG suite definition
Jenkinsfile                 # CI pipeline
```

## Setup

Requires **Java 17** and **Maven**.

```bash
git clone <this-repo-url>
cd pTestng
```

Credentials for the app under test are **not** hardcoded — set them via
environment variables (or your local, gitignored config file, depending on
which approach you're running) before executing tests. Do not commit real
credentials to this repo.

## Running the tests

```bash
mvn clean test
```

Run a specific suite:

```bash
mvn test -DsuiteXmlFile=smoke-testng.xml
```

Test reports are generated under `test-output/` (TestNG/Extent) after a run;
Allure results can be viewed with:

```bash
allure serve target/allure-results
```

## Notes

- Build artifacts (`target/`), test reports (`test-output/`, `allure-*`),
  and IDE metadata (`.classpath`, `.project`, `.settings/`) are excluded via
  `.gitignore` and are not checked in.
- This project was built while completing structured Selenium/TestNG
  training against a practice application, then extended with the retry
  and reporting infrastructure above.

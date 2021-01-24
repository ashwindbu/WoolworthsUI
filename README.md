# Automated test example in Java with Cucumber and Selenium WebDriver #

This project is to Create an automated smoke test suite for the below Acceptance Criteria
Acceptance Criteria: I want to be able to add 2 items to the cart and place an order

Go To URL: http://automationpractice.com/index.php

Test scenarios are described in the feature file located here .cucumber-test-sample/features/WooliesChallenge.feature.


## Installation ##

This test runs in Chrome browser.

cucumber-test-sample/src/test/java/stepDefinition/TestScenario.java


To install all dependencies, run 

```console
$ mvn clean install
```

## Running tests ##

```console
$ mvn test
```

After tests are run, reports are generated at : /target/cucumber-reports/

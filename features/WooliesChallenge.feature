# WooliesX QA Code Challenge
@WooliesUI @Regression @All

Feature: Woolworth QA Challenge (UI)

  Scenario: Shopping cart

    Given Open chrome and start application
    When User adds the short sleeve tshirt to cart
    Then User adds the Blouse to cart
    Then User proceeds to checkout
    Then User proceeds to checkout in shopping cart summary
    Then User enters the credential signing in and proceeds to checkout in Addresses screen
    Then User agrees for terms of service and clicks on proceed in shipping screen
    Then User selects pay by bank wire option in payment method screen and confirms order
    And Validate the order confirmation screen is displayed



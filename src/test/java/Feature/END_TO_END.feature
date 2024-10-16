Feature: end to end testing

  Scenario: Navigate to the website and verify that you are on the correct landing page.
            Given you are on the sourced demo website
            Then tittle must be "Swag Labs"

  Scenario: Create a script that will Login successfully and verify that you have logged in successfully.
            Given you are on the sourced demo website
            When user log in with username: "standard_user" and Password: "secret_sauce"
            Then user must see "Products"

  Scenario: Create A negative Login test to check for an unsuccessful Login attempt.
    Given you are on the sourced demo website
    When user log in with username: "standard_user" and Password: "musa"
    Then user must see error message "Epic sadface: Username and password do not match any user in this service"

  Scenario: Create a script that will add 2 Items to the Cart and continue to checkout and verify that you have checked out successfully.
    Given you are on the sourced demo website
    When user log in with username: "standard_user" and Password: "secret_sauce"
    And they add two items to cart: "Sauce Labs Backpack" and "Sauce Labs Bolt T-Shirt"
    And navigate to the checkout page
    Then items added should match items on cart: "Sauce Labs Backpack" and "Sauce Labs Bolt T-Shirt"
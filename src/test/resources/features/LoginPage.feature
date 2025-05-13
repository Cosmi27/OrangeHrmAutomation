Feature: Login page authentication

  Scenario: Login page
    Given user is into login page
    When user insert valid credentials
    Then user can access the site
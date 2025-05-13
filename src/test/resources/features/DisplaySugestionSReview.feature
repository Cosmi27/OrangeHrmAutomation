Feature: Supervisor Reviewer field displays suggestions in Manage Reviews

  Background:
    Given the user is logged into OrangeHRM with valid credentials

  @Positive
  Scenario Outline: Supervisor name suggestions displayed based on input in the Supervisor Reviewer field
    When the user navigates to the Performance module
    And clicks on Manage Reviews
    And the user clicks on the Supervisor Reviewer field
    And starts typing <input>
    Then matching supervisor names are displayed as suggestions based on the user’s input in the Supervisor Reviewer field
    Examples:
      | input |
      | John  |
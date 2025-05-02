Feature: Termination confirmation when ending employee contract

  Background:
    Given the user is logged into OrangeHRM

  @Positive
  Scenario: User receives a confirmation message when terminating an employee
    When the user navigates to the PIM module
    And selects an employee from the list
    And the user navigate to the Job section and clicks on Terminate Employee
    And fills in the required termination fields
    And clicks the [Save] button
    Then a confirmation message is displayed before finalizing the termination
Feature: The user is prevented from assigning leave for past dates

  Background:
    Given the user is logged into OrangeHRM

  @Negative
  Scenario Outline: User cannot assign leave for dates in the past
    When the user navigates to the Leave module and selects Assign Leave section
    And the user types and selects for an employee <name>
    And the user selects Leave Type
    And the user selects past dates for the <fromDate> and <toDate> fields
    And the user clicks on the [Assign] button
    Then the system displays a warning message
    Examples:
      | name                    | fromDate   | toDate     |
      | Ravi M B | 2024-11-03 | 2024-13-03 |
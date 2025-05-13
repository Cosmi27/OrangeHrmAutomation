Feature: The user is able to change successfully password

  Background:
    Given the user is on the Change password page

  @Positive
  Scenario Outline: The user can change password
    When the user enters the correct "<currentpassword>"
    And sets a "<newpassword>"
    And confirm the "<newpassword>"
    And clicks on the "Save" button
    Then the new password is accepted as valid
    Examples:
      | currentpassword | newpassword |
      | admin123        | cosmina123  |
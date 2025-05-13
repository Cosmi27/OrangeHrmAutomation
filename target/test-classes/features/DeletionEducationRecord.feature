@runThis
Feature: The user can delete an education record from the Qualifications section

  Background:
    Given the user is logged into OrangeHRM
    And at least one education record exists in the Education section under Qualifications in the My Info module

  @Positive
  Scenario: Deleting an education record from the Qualifications section
    When the user navigates to the Education section under Qualifications in the My Info module
    And the user selects an existing education record
    And the user clicks on the trash icon to delete the entry
    And the user confirms the deletion
    Then the selected education record is deleted successfully
    When the user updates the page
    Then the page displays the updated list without the deleted record
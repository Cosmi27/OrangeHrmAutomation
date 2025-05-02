package StepDefinition;

import POM.AssignLeaveForPastDates;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AssignLeaveForPastDatesSteps {
    AssignLeaveForPastDates assignLeaveForPastDates = new AssignLeaveForPastDates();

    @When("the user navigates to the Leave module and selects Assign Leave section")
    public void user_navigates_LeaveModule_andSelectsAssignLeaveSection() {
        assignLeaveForPastDates.navigateToLeaveModule();
    }

    @And("the user types and selects for an employee {}")
    public void the_user_selects_an_employee(String name) {
        assignLeaveForPastDates.typeForAnEmployee(name);
    }

    @And("the user selects Leave Type")
    public void user_selectsLeaveType() {
        assignLeaveForPastDates.selectLeaveType();
    }

    @And("the user selects past dates for the {} and {} fields")
    public void user_selectsPastDates(String fromDate, String toDate) {
        assignLeaveForPastDates.selectsFromDateToDate(fromDate, toDate);
    }

    @And("the user clicks on the [Assign] button")
    public void the_user_clicksAssignButton() {
        assignLeaveForPastDates.clickOnAssignButton();
    }

    @Then("the system displays a warning message")
    public void system_displays_warning_message() {
        assignLeaveForPastDates.isDisplayedWarningForPastLeaveDates();
    }

}

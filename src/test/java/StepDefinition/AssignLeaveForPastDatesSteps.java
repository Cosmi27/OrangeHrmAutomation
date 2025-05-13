package StepDefinition;

import pages.AssignLeaveForPastDates;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AssignLeaveForPastDatesSteps {
    AssignLeaveForPastDates assignLeaveForPastDates = new AssignLeaveForPastDates();

    @When("the user navigates to the Leave module and selects Assign Leave section")
    public void navigateToLeaveModuleAndSelectAssignLeaveSection() {
        assignLeaveForPastDates.navigateToLeaveModule();
    }

    @When("the user types and selects for an employee {}")
    public void selectAnEmployee(String name) {
        assignLeaveForPastDates.typeForAnEmployee(name);
    }

    @When("the user selects Leave Type")
    public void selectLeaveType() {
        assignLeaveForPastDates.selectLeaveType();
    }

    @When("the user selects past dates for the {} and {} fields")
    public void selectPastDates(String fromDate, String toDate) {
        assignLeaveForPastDates.selectsFromDateToDate(fromDate, toDate);
    }

    @When("the user clicks on the \"Assign\" button")
    public void clickAssignButton() {
        assignLeaveForPastDates.clickOnAssignButton();
    }

    @Then("the system displays a warning message")
    public void systemDisplaysWarningMessage() {
        assignLeaveForPastDates.isDisplayedWarningForPastLeaveDates();
    }

}

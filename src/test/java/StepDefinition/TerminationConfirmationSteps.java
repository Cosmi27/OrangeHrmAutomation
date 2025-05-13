package StepDefinition;

import POM.TerminationConfirmation;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TerminationConfirmationSteps {
    TerminationConfirmation terminationConfirmation = new TerminationConfirmation();

    @When("the user navigates to the PIM module")
    public void user_navigates_toPIM_module() {
        terminationConfirmation.navigateToPIM();
    }

    @And("selects an employee from the list")
    public void user_selects_an_employeeFromList() {
        terminationConfirmation.selectEmployee();
    }

    @And("the user navigate to the Job section and clicks on Terminate Employee")
    public void user_clicksOnTerminateEmployee() {
        terminationConfirmation.navigateToJobAndTerminateAnEmployee();
    }

    @And("fills in the required termination fields")
    public void user_fills_in_theRequiredTerminationFields() {
        terminationConfirmation.fillsTerminationDateReason();
    }

    @And("clicks the [Save] button")
    public void click_the_SaveButton() {
        terminationConfirmation.clickOnSaveButton();
    }

    @Then("a confirmation message is displayed before finalizing the termination")
    public void confirmation_message_is_displayed_beforeTermination() {
        terminationConfirmation.isDisplayedConfirmationMessage();

    }
}

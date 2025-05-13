package StepDefinition;

import pages.TerminationConfirmation;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TerminationConfirmationSteps {
    TerminationConfirmation terminationConfirmation = new TerminationConfirmation();

    @When("the user navigates to the PIM module")
    public void navigateToPIMModule() {
        terminationConfirmation.navigateToPIM();
    }

    @When("selects an employee from the list")
    public void selectAnEmployeeFromList() {
        terminationConfirmation.selectEmployee();
    }

    @When("the user navigate to the Job section and clicks on Terminate Employee")
    public void clickOnTerminateEmployee() {
        terminationConfirmation.navigateToJobAndTerminateAnEmployee();
    }

    @When("fills in the required termination fields")
    public void fillInTheRequiredTerminationFields() {
        terminationConfirmation.fillsTerminationDateReason();
    }

    @When("clicks the \"Save\" button")
    public void clickTheSaveButton() {
        terminationConfirmation.clickOnSaveButton();
    }

    @Then("a confirmation message is displayed before finalizing the termination")
    public void confirmationMessageIsDisplayedBeforeTermination() {
        terminationConfirmation.isDisplayedConfirmationMessage();
    }
}

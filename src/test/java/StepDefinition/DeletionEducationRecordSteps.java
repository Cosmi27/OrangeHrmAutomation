package StepDefinition;

import pages.DeletionEducationRecord;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class DeletionEducationRecordSteps {
    DeletionEducationRecord deletionEducationRecord = new DeletionEducationRecord();

    @Given("the user is logged into OrangeHRM")
    public void userIsLoggedIntoOrangeHRM() {
        deletionEducationRecord.open();
    }

    @And("at least one education record exists in the Education section under Qualifications in the My Info module")
    public void oneEducationRecordExists() {
    }

    @When("the user navigates to the Education section under Qualifications in the My Info module")
    public void navigateToTheEducationSection() {
        deletionEducationRecord.goToTheQualification();
    }

    @When("the user selects an existing education record")
    public void selectAnExistingEducation() {
        deletionEducationRecord.existEducationRecord();
        deletionEducationRecord.selectEducationRecord();
    }

    @When("the user clicks on the trash icon to delete the entry")
    public void clickOnTheTrashIcon() {
        deletionEducationRecord.clickOnTheTrashIcon();
    }

    @When("the user confirms the deletion")
    public void confirmTheDelection() {
        deletionEducationRecord.confirmationTheDeletionTrashIcon();
    }

    @Then("the selected education record is deleted successfully")
    public void selectedEducationRecordIsDeleted() {
        deletionEducationRecord.isDisplayedAnSuccessMessage();
    }

    @When("the user updates the page")
    public void updateThePage() {
        deletionEducationRecord.refreshThePage();
    }

    @Then("the page displays the updated list without the deleted record")
    public void pageDisplaysTheUpdatedList() {
    }
}

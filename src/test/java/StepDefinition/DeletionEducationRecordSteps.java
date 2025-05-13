package StepDefinition;

import POM.DeletionEducationRecord;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class DeletionEducationRecordSteps {
    DeletionEducationRecord deletionEducationRecord = new DeletionEducationRecord();

    @Given("the user is logged into OrangeHRM")
    public void the_user_is_logged_into_OrangeHRM() {
        deletionEducationRecord.open();
    }

    @And("at least one education record exists in the Education section under Qualifications in the My Info module")
    public void one_education_record_exists() {
    }

    @When("the user navigates to the Education section under Qualifications in the My Info module")
    public void the_user_navigates_to_the_Education_section() {
        deletionEducationRecord.gototheQualification();
    }

    @And("the user selects an existing education record")
    public void the_user_selects_an_existing_education() {
        deletionEducationRecord.existEducationRecord();
        deletionEducationRecord.selectEducationRecord();
    }

    @And("the user clicks on the trash icon to delete the entry")
    public void the_user_clicks_on_the_trashIcon() {
        deletionEducationRecord.clickOnTheTrashIcon();
    }

    @And("the user confirms the deletion")
    public void the_user_confirms_theDelection() {
        deletionEducationRecord.confirmationTheDeletionTrashIcon();
    }

    @Then("the selected education record is deleted successfully")
    public void theSelected_education_record_is_deleted() {
        deletionEducationRecord.isDisplayedAnSuccessMessage();
    }

    @When("the user updates the page")
    public void the_user_updates_thePage() {
        deletionEducationRecord.refreshThePage();
    }

    @Then("the page displays the updated list without the deleted record")
    public void the_page_displays_the_updatedList() {
    }

}

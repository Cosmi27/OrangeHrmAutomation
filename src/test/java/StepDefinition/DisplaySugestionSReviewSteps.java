package StepDefinition;

import POM.DisplaySugestionSReview;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DisplaySugestionSReviewSteps {
    DisplaySugestionSReview displaySugestionSReview = new DisplaySugestionSReview();

    @Given("the user is logged into OrangeHRM with valid credentials")
    public void the_user_is_logged_into_OrangeHRM() {
        displaySugestionSReview.open();

    }

    @When("the user navigates to the Performance module")
    public void the_user_navigates_to_the_Performance_module() {

        displaySugestionSReview.navigatePerformanceModule();
    }

    @And("clicks on Manage Reviews")
    public void clicks_onManageReviews() {
        displaySugestionSReview.clickManageReviews();
    }

    @And("the user clicks on the Supervisor Reviewer field")
    public void user_clicks_on_theSupervisorReviewer_field() {
        displaySugestionSReview.clickManageReviewsField();
    }

    @And("starts typing {}")
    public void starts_typing_anyNameorLatter(String input) {
        displaySugestionSReview.typeAnyName(input);
    }

    @Then("matching supervisor names are displayed as suggestions based on the user’s input in the Supervisor Reviewer field")
    public void displayedSupervizor_names() {
        displaySugestionSReview.verifySuggestionsDisplayed();

    }
}

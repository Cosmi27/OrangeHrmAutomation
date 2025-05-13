package StepDefinition;

import pages.DisplaySugestionSReview;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DisplaySugestionSReviewSteps {
    DisplaySugestionSReview displaySugestionSReview = new DisplaySugestionSReview();

    @Given("the user is logged into OrangeHRM with valid credentials")
    public void userIsLoggedIntoOrangeHRM() {
        displaySugestionSReview.open();
    }

    @When("the user navigates to the Performance module")
    public void navigateToThePerformanceModule() {
        displaySugestionSReview.navigatePerformanceModule();
    }

    @When("clicks on Manage Reviews")
    public void clickOnManageReviews() {
        displaySugestionSReview.clickManageReviews();
    }

    @When("the user clicks on the Supervisor Reviewer field")
    public void clickOnTheSupervisorReviewerField() {
        displaySugestionSReview.clickManageReviewsField();
    }

    @When("starts typing {}")
    public void startTypingAnyNameOrLatter(String input) {
        displaySugestionSReview.typeAnyName(input);
    }

    @Then("matching supervisor names are displayed as suggestions based on the user’s input in the Supervisor Reviewer field")
    public void displayedSupervisorNames() {
        displaySugestionSReview.verifySuggestionsDisplayed();
    }
}

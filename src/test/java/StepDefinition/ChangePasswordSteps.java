package StepDefinition;

import pages.ChangePasswordPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ChangePasswordSteps {
    ChangePasswordPage changePasswordPage = new ChangePasswordPage();

    @Given("the user is on the Change password page")
    public void userIsOnTheChangePasswordPage() {
        changePasswordPage.open();
    }

    @When("the user enters the correct {string}")
    public void enterTheCorrectCurrentPassword(String currentpassword) {
        changePasswordPage.enterCurrentPassword(currentpassword);
    }

    @When("sets a {string}")
    public void setNewPassword(String newpassword) {
        changePasswordPage.enterNewPassword(newpassword);
    }

    @When("confirm the {string}")
    public void confirmTheNewPassword(String newpassword) {
        changePasswordPage.confirmNewPassword(newpassword);
    }

    @When("clicks on the \"Save\" button")
    public void clickOnTheSaveButton() {
        changePasswordPage.clickSaveButton();
    }

    @Then("the new password is accepted as valid")
    public void newPasswordIsAcceptedAsValid() {
        assertTrue(changePasswordPage.isSuccessMessageDisplayed(), "Success message not displayed!");
    }
}
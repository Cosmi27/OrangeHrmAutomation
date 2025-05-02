package StepDefinition;

import POM.ChangePasswordPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ChangePasswordSteps {
    ChangePasswordPage changePasswordPage = new ChangePasswordPage();


    @Given("the user is on the Change password page")
    public void user_is_on_the_Change_password_page() {
        changePasswordPage.open();
        System.out.println("User is on the Change Password page");
    }

    @When("the user enters the correct {string}")
    public void user_enters_the_correct_currentPassword(String currentpassword) {
        changePasswordPage.enterCurrentPassword(currentpassword);
        System.out.println("Enters the correct current password");
    }

    @And("sets a {string}")
    public void sets_a_new_password(String newpassword) {
        changePasswordPage.enterNewPassword(newpassword);
        System.out.println("New password");
    }

    @And("confirm the {string}")
    public void confirm_the_new_password(String newpassword) {
        changePasswordPage.confirmNewPassword(newpassword);
    }

    @And("clicks on the [Save] button")
    public void clicks_on_the_Save_button() {
        changePasswordPage.clickSaveButton();
    }

    @Then("the new password is accepted as valid")
    public void the_new_password_is_accepted_as_valid() {
        assertTrue(changePasswordPage.isSuccessMessageDisplayed(), "Success message not displayed!");
        System.out.println("Accepted");
    }

}
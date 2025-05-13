package StepDefinition;

import pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class LoginPageSteps {

    LoginPage loginPage = new LoginPage();

    @Given("user is into login page")
    public void userIsIntoLoginPage() {
        loginPage.login();
    }

    @When("user insert valid credentials")
    public void insertValidCredentials() {
        loginPage.login();
    }

    @Then("user can access the site")
    public void userCanAccessTheSite() {
    }
}

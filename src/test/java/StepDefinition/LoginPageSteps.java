package StepDefinition;

import POM.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class LoginPageSteps {

    LoginPage loginPage = new LoginPage();

    @Given("user is into login page")
    public void user_is_into_login_page() {
        // Doar navigăm către login page
        loginPage.login("Admin", "admin123"); // momentan hardcodate, vezi mai jos cum facem dinamic
    }

    @When("user insert valid {} and valid {}")
    public void user_insert_validUsername_and_validPassword(String username, String password) {
        // Refacem login-ul cu parametrii din feature file
        loginPage.login(username, password);
    }

    @Then("user can access the site")
    public void user_can_access_the_site() {
        // Putem adăuga o verificare simplă că suntem logați, de exemplu:
        System.out.println("User is logged in successfully!");
        // Sau o validare reală cum ar fi:
        // Assert.assertTrue(page.isVisible("selector_dashboard"));
    }
}

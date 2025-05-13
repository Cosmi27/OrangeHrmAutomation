package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import utilis.DriverManager;
import utilis.UIActions;

public class DisplaySugestionSReview {
    private final Page page = DriverManager.getPage();
    private final Logger logger = LogManager.getLogger(DisplaySugestionSReview.class);

    public void open() {
        LoginPage loginPage = new LoginPage();
        loginPage.login();
        UIActions.waitAndClick(page, "text=Dashboard", 2000);
        logger.info("The page has the correct title: Dashboard");
    }

    public void navigatePerformanceModule() {
        UIActions.waitAndClick(page, "text=Performance", 3000);
    }

    public void clickManageReviews() {
        page.locator(".oxd-icon.bi-chevron-down").nth(1).click();
        UIActions.waitForPageLoad(page);
    }

    public void clickManageReviewsField() {
        UIActions.waitAndClick(page, "text=Manage Reviews", 2000);
        logger.info("The Manage Performance Reviews page was displayed");
    }

    public void typeAnyName(String inputValue) {
        Locator input = page.locator("input[placeholder='Type for hints...']");
        input.fill(inputValue);
        assert input.inputValue().equals(inputValue) : "Input value is not correct!";
        logger.info("Input successfully filled with {} ", inputValue);
        UIActions.waitForPageLoad(page);
    }

    public void verifySuggestionsDisplayed() {
        Locator suggestions = page.locator(".oxd-autocomplete-option");
        UIActions.waitAndClick(page, ".oxd-autocomplete-option", 3000);
        int count = suggestions.count();
        assert count > 0 : "No suggestions displayed!";
        logger.info("Suggestions displayed {} ", count);
    }
}
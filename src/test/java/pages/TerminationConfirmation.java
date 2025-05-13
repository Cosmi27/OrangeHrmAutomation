package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.junit.jupiter.api.Assertions;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import utilis.DriverManager;
import utilis.UIActions;

public class TerminationConfirmation {
    private final Page page = DriverManager.getPage();
    private final Logger logger = LogManager.getLogger(TerminationConfirmation.class);

    public void navigateToPIM() {
        UIActions.waitAndClick(page, "text=PIM", 2000);
        logger.info("Clicked on the PIM module");
    }

    public void selectEmployee() {
        Locator firstRow = page.locator(".oxd-table-row.oxd-table-row--with-border.oxd-table-row--clickable").first();
        firstRow.click();
        logger.info("Clicked on the first employee");
        UIActions.waitForPageLoad(page);
    }

    public void navigateToJobAndTerminateAnEmployee() {
        UIActions.waitAndClick(page, "text=Job", 2000);
        assert page.title().contains("Job Details");
        logger.info("The title of the page: Job Details");
        UIActions.waitAndClick(page, "text=Terminate Employment", 2000);
    }

    public void fillsTerminationDateReason() {
        Locator terminationDate = page.locator(".oxd-input.oxd-input--active").nth(2);
        terminationDate.fill("2025-05-01");
        Locator terminationReason = page.locator(".oxd-icon.bi-caret-down-fill.oxd-select-text--arrow").nth(5);
        terminationReason.click();
        UIActions.waitAndClick(page, "text=Other", 2000);
    }

    public void clickOnSaveButton() {
        Locator saveButton = page.locator("button[type='submit']").nth(1);
        saveButton.click();
        logger.info("The Save button was clicked");
        UIActions.waitForPageLoad(page);
    }

    public void isDisplayedConfirmationMessage() {
        Locator confirmationMessage = page.locator(".oxd-text.oxd-text--p.oxd-text--toast-title.oxd-toast-content-text");
        confirmationMessage.waitFor(new Locator.WaitForOptions().setTimeout(2000));
        String messageText = confirmationMessage.textContent();
        logger.info("Actual message {}", messageText);
        Assertions.assertTrue(messageText != null && messageText.contains("Confirmation"), "Expected a confirmation message for termination an employee, but got: " + messageText);
    }
}


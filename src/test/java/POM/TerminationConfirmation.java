package POM;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.junit.jupiter.api.Assertions;
import utilis.DriverManager;


public class TerminationConfirmation {
    private final Page page = DriverManager.getPage();

    public void navigateToPIM() {
        page.click("text=PIM");
        page.waitForTimeout(2000);
        System.out.println("Clicked on the PIM module");
    }

    public void selectEmployee() {
        Locator firstRow = page.locator(".oxd-table-row.oxd-table-row--with-border.oxd-table-row--clickable").first();
        firstRow.click();
        System.out.println("Clicked on the first employee");
        page.waitForTimeout(3000);
    }

    public void navigateToJobAndTerminateAnEmployee() {
        page.waitForSelector("text=Job").click();
        assert page.title().contains("Job Details");
        System.out.println("The title of the page: Job Details");
        page.waitForSelector("text=Terminate Employment").click();
        page.waitForTimeout(2000);
    }

    public void fillsTerminationDateReason() {
        Locator terminationDate = page.locator(".oxd-input.oxd-input--active").nth(2);
        terminationDate.fill("2025-05-01");
        Locator terminationReason = page.locator(".oxd-icon.bi-caret-down-fill.oxd-select-text--arrow").nth(5);
        terminationReason.click();
        page.click("text=Other");
        page.waitForTimeout(2000);
    }

    public void clickOnSaveButton() {
        Locator saveButton = page.locator("button[type='submit']").nth(1);
        saveButton.click();
        System.out.println("The Save button was clicked");
        page.waitForTimeout(2000);
    }

    public void isDisplayedConfirmationMessage() {
        Locator confirmationMessage = page.locator(".oxd-text.oxd-text--p.oxd-text--toast-title.oxd-toast-content-text");
        confirmationMessage.waitFor(new Locator.WaitForOptions().setTimeout(2000));
        String messageText = confirmationMessage.textContent();
        System.out.println("Actual message " + messageText);
        Assertions.assertTrue(
                messageText != null && messageText.contains("Confirmation"),
                "Expected a confirmation message for termination an employee, but got: " + messageText);
    }
}


package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import utilis.DriverManager;
import utilis.UIActions;

public class AssignLeaveForPastDates {
    private final Page page = DriverManager.getPage();
    private final Logger logger = LogManager.getLogger(AssignLeaveForPastDates.class);

    public void navigateToLeaveModule() {
        UIActions.waitAndClick(page, "text=Leave", 2000);
        assert page.title().contains("text=Leave List");
        logger.info("We are on Leave List page");
        UIActions.waitAndClick(page, "text=Assign Leave", 2000);
        assert page.title().contains("text=Assign Leave");
        logger.info("The Assign Leave page was displayed");
        UIActions.waitForPageLoad(page);
    }

    public void typeForAnEmployee(String name) {
        Locator input = page.locator("input[placeholder='Type for hints...']");
        input.fill(name);
        System.out.println("Input successfully filled with: " + name);
        UIActions.waitUntilVisible(page, "text=" + name, 2000);
    }

    public void selectLeaveType() {
        UIActions.waitAndClick(page, ".oxd-icon.bi-caret-down-fill.oxd-select-text--arrow", 2000);
        logger.info("Clicked on Leave Type field");
        UIActions.waitAndClick(page, "text=CAN - Personal", 2000);
        logger.info("Clicked on Personal Leave Type");
    }

    public void selectsFromDateToDate(String dateFrom, String dateTo) {
        Locator fromDate = page.locator("input[placeholder='yyyy-dd-mm']").first();
        fromDate.fill("");
        fromDate.fill(dateFrom);
        logger.info("From Date was filled with {}", dateFrom);
        Locator toDate = page.locator("input[placeholder='yyyy-dd-mm']").nth(1);
        toDate.waitFor(new Locator.WaitForOptions().setTimeout(30000));
        toDate.fill("");
        toDate.fill(dateTo);
        logger.info("To Date was filled with {}", dateTo);
        UIActions.waitForPageLoad(page);
    }

    public void clickOnAssignButton() {
        Locator button = page.locator("button[type='submit']");
        button.filter(new Locator.FilterOptions().setHasText("Assign")).click();
        logger.info("Clicked on Submit Button");
        UIActions.waitForPageLoad(page);
    }

    public void isDisplayedWarningForPastLeaveDates() {
        Locator warningMessage = page.locator(".oxd-text.oxd-text--p.oxd-text--card-title");
        warningMessage.waitFor(new Locator.WaitForOptions().setTimeout(2000));
        String messageText = warningMessage.textContent();
        logger.info("Actual message {}", messageText);
        Assertions.assertTrue(
                messageText != null && messageText.contains("Warning"),
                "BUG: Expected a warning message for past leave dates, but got: " + messageText);
    }
}

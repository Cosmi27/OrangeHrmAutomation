package POM;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.junit.jupiter.api.Assertions;
import utilis.DriverManager;


public class AssignLeaveForPastDates {
    private final Page page = DriverManager.getPage();

    public void navigateToLeaveModule() {
        page.waitForSelector("text=Leave").click();
        assert page.title().contains("text=Leave List");
        System.out.println("We are on Leave List page");
        page.waitForSelector("text=Assign Leave").click();
        assert page.title().contains("text=Assign Leave");
        System.out.println("The Assign Leave page was displayed");
        page.waitForTimeout(2000);
    }

    public void typeForAnEmployee(String name) {
        Locator input = page.locator("input[placeholder='Type for hints...']");
        input.fill(name);
        System.out.println("Input successfully filled with: " + name);
        page.click("text=" + name);
        page.waitForTimeout(2000);
    }

    public void selectLeaveType() {
        page.waitForSelector(".oxd-icon.bi-caret-down-fill.oxd-select-text--arrow").click();
        System.out.println("Clicked on Leave Type field");
        page.click("text=CAN - Personal");
        System.out.println("Clicked on Personal Leave Type");
    }

    public void selectsFromDateToDate(String dateFrom, String dateTo) {
        Locator fromDate = page.locator("input[placeholder='yyyy-dd-mm']").first();
        fromDate.fill("");
        fromDate.fill(dateFrom);
        System.out.println("From Date was filled with: " + dateFrom);
        Locator toDate = page.locator("input[placeholder='yyyy-dd-mm']").nth(1);
        toDate.waitFor(new Locator.WaitForOptions().setTimeout(30000));
        toDate.fill("");
        toDate.fill(dateTo);
        System.out.println("To Date was filled with: " + dateTo);
        page.waitForTimeout(2000);
    }

    public void clickOnAssignButton() {
        Locator button = page.locator("button[type='submit']");
        button.filter(new Locator.FilterOptions().setHasText("Assign")).click();
        System.out.println("Clicked on Submit Button");
        page.waitForTimeout(2000);
    }

    public void isDisplayedWarningForPastLeaveDates() {
        Locator warningMessage = page.locator(".oxd-text.oxd-text--p.oxd-text--card-title");
        warningMessage.waitFor(new Locator.WaitForOptions().setTimeout(2000));
        String messageText = warningMessage.textContent();
        System.out.println("Actual message: " + messageText);
        Assertions.assertTrue(
                messageText != null && messageText.contains("Warning"),
                "BUG: Expected a warning message for past leave dates, but got: " + messageText);
    }

}

package POM;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.junit.jupiter.api.Assertions;
import utilis.DriverManager;

public class DeletionEducationRecord {
    private final Page page = DriverManager.getPage();

    public void open() {
        LoginPage loginPage = new LoginPage();
        loginPage.login("Admin", "admin123");
        page.waitForSelector("text=Dashboard");
        System.out.println("The page has correct title: Dashboard");
    }

    public void gototheQualification() {
        page.click("text=My Info");
        System.out.println("My info module was clicked");
        page.getByText("text=Personal Details");
        System.out.println("The text was displayed correctly");
        page.click("text=Qualifications");
        page.waitForSelector("text=Qualifications");
    }

    public void existEducationRecord() {
        Locator records = page.locator(".oxd-text.oxd-text--span");
        Locator recordText = records.nth(2);
        String recordTextContent = recordText.textContent();
        if (recordTextContent != null && recordTextContent.contains("(1) Record Found")) {
            System.out.println("Record found: " + recordTextContent);
        } else {
            System.out.println("No record found.");
        }
        page.waitForTimeout(2000);
    }

    public void selectEducationRecord() {
        Locator selectRecord = page.locator(".oxd-checkbox-wrapper").nth(2);
        selectRecord.click();
        System.out.println("Click on the record checkbox");
        page.waitForTimeout(2000);
    }

    public void clickOnTheTrashIcon() {
        page.waitForSelector(".oxd-button.oxd-button--medium.oxd-button--label-danger.orangehrm-horizontal-margin").click();
        System.out.println("Clicked on the trash icon");
        page.waitForTimeout(2000);
    }

    public void confirmationTheDeletionTrashIcon() {
        page.waitForSelector(".oxd-button.oxd-button--medium.oxd-button--label-danger.orangehrm-button-margin", new Page.WaitForSelectorOptions().setTimeout(2000)).click();
        System.out.println("Confirm the deletion");
    }

    public void isDisplayedAnSuccessMessage() {
        Locator successMessage = page.locator(".oxd-text.oxd-text--p.oxd-text--toast-title.oxd-toast-content-text");
        successMessage.waitFor(new Locator.WaitForOptions().setTimeout(2000));
        String messageText = successMessage.textContent();
        System.out.println("Actual message: " + messageText);
        Assertions.assertTrue(
                messageText != null && messageText.contains("Success"),
                "Expected a successful message, but got " + messageText);
    }

    public void refreshThePage() {
        page.reload();
        System.out.println("Page was refreshed.");
        page.waitForTimeout(2000);
    }
}
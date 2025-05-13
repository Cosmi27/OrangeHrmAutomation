package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import utilis.DriverManager;
import utilis.UIActions;

public class DeletionEducationRecord {
    private final Page page = DriverManager.getPage();
    private final Logger logger = LogManager.getLogger(DeletionEducationRecord.class);

    public void open() {
        LoginPage loginPage = new LoginPage();
        loginPage.login();
        UIActions.waitAndClick(page, "text=Dashboard", 2000);
        logger.info("The page has correct title: Dashboard");
    }

    public void goToTheQualification() {
        UIActions.waitAndClick(page, "text=My Info", 2000);
        logger.info("The text was displayed correctly");
        UIActions.waitAndClick(page, "text=Qualifications", 2000);
    }

    public void existEducationRecord() {
        Locator records = page.locator(".oxd-text.oxd-text--span");
        Locator recordText = records.nth(2);
        String recordTextContent = recordText.textContent();
        if (recordTextContent != null && recordTextContent.contains("(1) Record Found")) {
            logger.info("Record found {}", recordTextContent);
        } else {
            logger.info("No record found");
        }
        UIActions.waitForPageLoad(page);
    }

    public void selectEducationRecord() {
        Locator selectRecord = page.locator(".oxd-checkbox-wrapper").nth(2);
        selectRecord.click();
        logger.info("Click on the record checkbox");
        UIActions.waitForPageLoad(page);
    }

    public void clickOnTheTrashIcon() {
        UIActions.waitAndClick(page, ".oxd-button.oxd-button--medium.oxd-button--label-danger.orangehrm-horizontal-margin", 2000);
        logger.info("Clicked on the trash icon");
    }

    public void confirmationTheDeletionTrashIcon() {
        UIActions.waitAndClick(page, ".oxd-button.oxd-button--medium.oxd-button--label-danger.orangehrm-button-margin", 2000);
        logger.info("Confirm the deletion");
    }

    public void isDisplayedAnSuccessMessage() {
        Locator successMessage = page.locator(".oxd-text.oxd-text--p.oxd-text--toast-title.oxd-toast-content-text");
        successMessage.waitFor(new Locator.WaitForOptions().setTimeout(2000));
        String messageText = successMessage.textContent();
        logger.info("Actual message {}", messageText);
        Assertions.assertTrue(
                messageText != null && messageText.contains("Success"),
                "Expected a successful message, but got " + messageText);
    }

    public void refreshThePage() {
        page.reload();
        logger.info("Page was refreshed");
        UIActions.waitForPageLoad(page);
    }
}
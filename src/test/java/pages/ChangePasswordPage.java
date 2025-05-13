package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import utilis.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import utilis.UIActions;

public class ChangePasswordPage {
    private final Page page = DriverManager.getPage();
    private final Logger logger = LogManager.getLogger(ChangePasswordPage.class);

    public void open() {
        LoginPage loginPage = new LoginPage();
        loginPage.login();
        UIActions.waitAndClick(page, ".oxd-userdropdown-tab", 2000);
        UIActions.waitAndClick(page, "text=Change Password", 2000);
        logger.info("Clicked on change password");
    }

    public void enterCurrentPassword(String currentpassword) {
        Locator currentPassword = page.locator(".oxd-form-row input[type='password']").nth(0);
        currentPassword.fill(currentpassword);
        logger.debug("Filled current password");
    }

    public void enterNewPassword(String newpassword) {
        Locator newPassword = page.locator(".oxd-form-row input[type='password']").nth(1);
        newPassword.fill(newpassword);
    }

    public void confirmNewPassword(String newpassword) {
        Locator confirmPassword = page.locator(".oxd-form-row input[type='password']").nth(2);
        confirmPassword.fill(newpassword);
    }

    public void clickSaveButton() {
        UIActions.clickSaveButton(page);
    }

    public boolean isSuccessMessageDisplayed() {
        try {
            UIActions.waitAndClick(page, ".oxd-text.oxd-text--p.oxd-text--toast-title.oxd-toast-content-text", 2000);
            String messageText = page.locator(".oxd-text.oxd-text--p.oxd-text--toast-title.oxd-toast-content-text").innerText();
            logger.info("Message text: {}", messageText);
            return messageText.contains("Success");
        } catch (Exception e) {
            logger.info("Message not found or timed out", e);
            return false;
        }
    }
}
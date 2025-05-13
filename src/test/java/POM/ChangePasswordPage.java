package POM;

import POM.LoginPage;
import StepDefinition.LoginPageSteps;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import utilis.DriverManager;

public class ChangePasswordPage {
    private final Page page = DriverManager.getPage();

    public void open() {
        LoginPage loginPage = new LoginPage();
        loginPage.login("Admin", "admin123");
        System.out.println("User is on the Dashboard");
        page.getByText("Dashboard");
        System.out.println("Text is visible on new page");
        page.click(".oxd-userdropdown-tab");
        System.out.println("I clicked on user icon");
        page.click("text=Change Password");
        System.out.println("I clicked on change password");
        assert page.title().contains("Update Password");
        System.out.println("The page contains title: Update Password");
    }

    public void enterCurrentPassword(String currentpassword) {
        Locator currentPassword = page.locator(".oxd-form-row input[type='password']").nth(0); // Selectează primul câmp de parolă
        currentPassword.fill(currentpassword);
    }

    public void enterNewPassword(String newpassword) {
        Locator newPassword = page.locator(".oxd-form-row input[type='password']").nth(1); // Selectează al doilea câmp de parolă
        newPassword.fill(newpassword);
        System.out.println("New password was saved successfully");
    }

    public void confirmNewPassword(String newpassword) {
        Locator confirmPassword = page.locator(".oxd-form-row input[type='password']").nth(2);
        confirmPassword.fill(newpassword);
    }

    public void clickSaveButton() {
        page.click("button[type='submit']");
        page.waitForTimeout(2000);
    }

    public boolean isSuccessMessageDisplayed() {
        try {
            page.waitForSelector(".oxd-text.oxd-text--p.oxd-text--toast-title.oxd-toast-content-text", new Page.WaitForSelectorOptions().setTimeout(5000));
            String messageText = page.locator(".oxd-text.oxd-text--p.oxd-text--toast-title.oxd-toast-content-text").innerText();
            System.out.println("Message text: " + messageText);
            return messageText.contains("Success");
        } catch (Exception e) {
            System.out.println("Message not found or timed out");
            return false;
        }

    }

}
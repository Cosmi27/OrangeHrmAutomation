package POM;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import utilis.DriverManager;

public class DisplaySugestionSReview {
    private final Page page = DriverManager.getPage();

    public void open() {
        LoginPage loginPage = new LoginPage();
        loginPage.login("Admin", "admin123");
        page.waitForSelector("text=Dashboard");
        System.out.println("The page has the correct title: Dashboard");
    }

    public void navigatePerformanceModule() {
        page.waitForSelector("text=Performance", new Page.WaitForSelectorOptions().setTimeout(3000)).click();
        assert page.title().contains("Performance");
        System.out.println("Page has the correct title");
    }

    public void clickManageReviews() {
        page.locator(".oxd-icon.bi-chevron-down").nth(1).click();
        page.waitForTimeout(2000);
    }

    public void clickManageReviewsField() {
        page.waitForSelector("text=Manage Reviews").click();
        assert page.title().contains("Manage Performance Reviews");
        System.out.println("The Manage Performance Reviews page was displayed");
    }

    public void typeAnyName(String inputValue) {
        Locator input = page.locator("input[placeholder='Type for hints...']");
        input.fill(inputValue);
        assert input.inputValue().equals(inputValue) : "Input value is not correct!";
        System.out.println("Input successfully filled with: " + inputValue);
        page.waitForTimeout(2000);
    }

    public void verifySuggestionsDisplayed() {
        Locator suggestions = page.locator(".oxd-autocomplete-option");
        page.waitForSelector(".oxd-autocomplete-option", new Page.WaitForSelectorOptions().setTimeout(3000));
        int count = suggestions.count();
        assert count > 0 : "No suggestions displayed!";
        System.out.println("Suggestions displayed: " + count);
    }
}
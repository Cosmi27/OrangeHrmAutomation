package POM;

import com.microsoft.playwright.Page;
import utilis.DriverManager;

public class LoginPage {
    private final Page page = DriverManager.getPage();
    public void login(String username, String password){
        page.navigate("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        System.out.println("Page was opened");
        page.fill("input[name='username']", username);
        page.fill("input[name='password']", password);
        page.click("button[type='submit']");
        assert page.title().contains("OrangeHRM");
        System.out.println("Page has correct title");
    }
}

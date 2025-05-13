package pages;

import com.microsoft.playwright.Page;
import config.PropertyReader;
import utilis.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoginPage {
    private static final Logger logger = LogManager.getLogger(LoginPage.class);
    private final Page page = DriverManager.getPage();

    public void login() {
        PropertyReader.loadProperties();
        String urlOrangeHRM = PropertyReader.getProperty("app.url");
        String username = PropertyReader.getProperty("username");
        String password = PropertyReader.getProperty("password");
        page.navigate(urlOrangeHRM);
        logger.info("Navigate to {}", urlOrangeHRM);
        page.fill("input[name='username']", username);
        page.fill("input[name='password']", password);
        page.click("button[type='submit']");
        assert page.title().contains("OrangeHRM");
    }
}

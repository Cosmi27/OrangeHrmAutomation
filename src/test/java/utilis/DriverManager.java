package utilis;

import com.microsoft.playwright.*;
import config.PropertyReader;

public class DriverManager {
    private static Playwright playwright;
    private static Browser browser;
    private static BrowserContext context;
    static Page page;

    public static Page startBrowser() {
        if (playwright == null) {
            PropertyReader.loadProperties();
            boolean headless = Boolean.parseBoolean(PropertyReader.getProperty("headless"));
            String browserName = PropertyReader.getProperty("browser");

            playwright = Playwright.create();
            BrowserType.LaunchOptions options = new BrowserType.LaunchOptions().setHeadless(headless);

            switch (browserName.toLowerCase()) {
                case "firefox":
                    browser = playwright.firefox().launch(options);
                    break;
                case "webkit":
                    browser = playwright.webkit().launch(options);
                    break;
                default:
                    browser = playwright.chromium().launch(options);
                    break;
            }

            context = browser.newContext();
            page = context.newPage();
        }
        return page;
    }

    public static Page getPage() {
        return page;
    }

    public static void closeBrowser() {
    }
}

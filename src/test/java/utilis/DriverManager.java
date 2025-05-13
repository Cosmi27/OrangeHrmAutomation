package utilis;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class DriverManager { private static Playwright playwright;
    private static Browser browser;
    private static Page page;

    public static void startBrowser(){
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        page= browser.newPage();
    }

    public static void closeBrowser(){
        if(browser != null) browser.close();
        if(playwright != null) playwright.close();
    }
    public static Page getPage(){
        return page;
    }
}

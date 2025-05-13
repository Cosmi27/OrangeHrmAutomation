package utilis;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.WaitForSelectorState;
import config.PropertyReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UIActions {
    private static final Logger logger = LogManager.getLogger(UIActions.class);

    public static void waitAndClick(Page page, String selector, int timeoutMs) {
        page.waitForSelector(selector, new Page.WaitForSelectorOptions().setTimeout(timeoutMs)).click();
        logger.debug("Clicked element after waiting for selector: {}", selector);
    }

    public static void waitForPageLoad(Page page) {
        int timeout = Integer.parseInt(PropertyReader.getProperty("timeout.pageLoad"));
        page.waitForTimeout(timeout);
    }

    public static void clickSaveButton(Page page) {
        String saveButtonSelector = PropertyReader.getProperty("saveButton");
        page.click(saveButtonSelector);
        logger.info("Clicked Save button using selector: {}", saveButtonSelector);
    }

    public static void waitUntilVisible(Page page, String selector, int timeoutMs) {
        Locator locator = page.locator(selector);
        locator.waitFor(new Locator.WaitForOptions().setTimeout(timeoutMs).setState(WaitForSelectorState.VISIBLE));
        logger.debug("Element is visible: {}", selector);
    }
}
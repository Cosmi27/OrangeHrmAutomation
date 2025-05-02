package StepDefinition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utilis.DriverManager;

public class Hooks {
    @Before
    public void setUp(){
        DriverManager.startBrowser();
    }

    @After
    public void tearDown(){
        DriverManager.closeBrowser();
    }
}

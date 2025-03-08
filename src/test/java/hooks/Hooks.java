package hooks;

import io.cucumber.java.After;
import org.openqa.selenium.WebDriver;
import utility.DriverFactory;

public class Hooks {

    private WebDriver driver = DriverFactory.getDriver();

    @After
    public void closeBrowser() {
        // Close the browser after each scenario
        if (driver != null) {
            driver.quit();
            DriverFactory.quitDriver();  // Ensures driver is set to null after quit
        }
    }
}

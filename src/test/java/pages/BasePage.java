package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;
import java.time.Duration;
import java.util.ArrayList;

public class BasePage {

    protected WebDriver driver;
    private WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public WebElement waitVisibility(By by) {
        return wait.until(ExpectedConditions.elementToBeClickable(by));
    }
    public void scrollIntoView(By by) {
        WebElement element = driver.findElement(by);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }
    public void click(By by) {
        waitVisibility(by).click();

    }
    public static void switchToNextTab(WebDriver driver, String text) {
        ArrayList<String> tab = new ArrayList<>(driver.getWindowHandles());

        for (int i = 0; i < tab.size(); i++) {
            driver.switchTo().window(tab.get(i));
            if (driver.getTitle().contains(text)) {
                break;
            }
        }
    }
    public void jsClick(By by) {
        WebElement element = driver.findElement(by);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }
    public void type(By by, String text) {
        waitVisibility(by).sendKeys(text);
    }
    public String readText(By by) throws InterruptedException {

       return waitVisibility(by).getText();
    }
    public void textChange(By by, String actual) throws InterruptedException {
        for (int i = 0; i < 30; i++) {
            if (!(readText(by).contains(actual))) {
                Thread.sleep(1000);
            } else {
                break;
            }
        }

    }

    public String getText(By by) {
        return waitVisibility(by).getText();
    }
    public boolean elementexists(By by) throws InterruptedException {
        Thread.sleep(5000);
        boolean size = driver.findElements(by).size() != 0;
        return size;
    }
}

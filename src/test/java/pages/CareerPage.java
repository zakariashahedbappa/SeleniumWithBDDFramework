package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CareerPage extends BasePage {
    //Locators for login Page
    By aboutUs = By.xpath("(//li[@class='score-megamenu-dropdown']/a)[1]");
    By Careers = By.xpath("//h4[.='Careers']/following::a[@class='score-button btn-clickable-area'][1]");

    @FindBy(xpath = "//h4[normalize-space()='Careers']")
    private WebElement careermenu;

    @FindBy(xpath = "//input[@id='input-email']")
    private WebElement email_Input;

    @FindBy(xpath = "//input[@id='input-password']")
    private WebElement password_Input;

    @FindBy(xpath = "(//a[text()='Forgotten Password'])[1]")
    private WebElement forgottenPassword_Link;

    @FindBy(xpath = "//input[@value='Login']")
    private WebElement login_Button;

    public CareerPage(WebDriver driver) {
        super(driver);
    }


    //check title of my Account homepage
    By cookiePolicy = By.id("onetrust-accept-btn-handler");

    public void clickOntheAboutUs() throws InterruptedException {
        if(elementexists(cookiePolicy)){
            click(cookiePolicy);
        }
        click(aboutUs);
    }

    public void clickOnTheCareer() throws InterruptedException {
        click(Careers);
    }

    By searchJob = By.xpath("//a[normalize-space()='Search jobs']");
    By cookieBanner = By.id("onetrust-pc-btn-handler");
    By confirmMychoices = By.xpath("//button[normalize-space()='Confirm My Choices']");

    public void clickOnSearchJob() throws InterruptedException {
            click(cookieBanner);
            click(confirmMychoices);
            jsClick(searchJob);
    }

    By jobSearchInputBox = By.xpath("//input[@placeholder='Search for jobs or keywords']");

    public void searchJob(String jobTitle) throws InterruptedException {
        type(jobSearchInputBox, jobTitle);
    }
    By searchResults=By.xpath("//div[contains(@id,'search-results-statistics-')]");
    public String getSearchResults() throws InterruptedException {
        textChange(searchResults, "Showing");
       return readText(searchResults);
    }
    public int extractNumber(String text) {
        System.out.printf(text);
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(text);
        if (matcher.find()) {
            return Integer.parseInt(matcher.group());
        }
        throw new RuntimeException("No number found in the text!");
    }
By searchBtn=By.id("search-box-button");
    public void clickOnTheSearchBtn() {
        click(searchBtn);

    }
}


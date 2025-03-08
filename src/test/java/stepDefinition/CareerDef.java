package stepDefinition;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CareerPage;
import utility.DriverFactory;

import static org.junit.Assert.assertTrue;

public class CareerDef {
    private CareerPage careerPage;

    public CareerDef() {
        try {
            careerPage = new CareerPage(DriverFactory.getDriver());
        } catch (IllegalStateException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to initialize LoginPage due to WebDriver issues.");
        }
    }

    @Given("User open the browser and open the {string}")
    public void OpenUrl(String url) {
        DriverFactory.getDriver().get(url);
    }

    @When("User click on the About Us from top menu")
    public void user_clicks_on_the_login_option() throws InterruptedException {
        careerPage.clickOntheAboutUs();
    }

    @When("when user click on the career option")
    public void user_clicks_on_the_career_page() throws InterruptedException {
        careerPage.clickOnTheCareer();
    }
    @When("User switch to the career tab")
    public void user_switch_to_the_career_tab() {
        CareerPage.switchToNextTab(DriverFactory.getDriver(), "Careers");
    }
    @Then("User click on the search job button")
    public void user_click_on_the_search_job_button() throws InterruptedException {
        careerPage.clickOnSearchJob();
    }
    @And("User search for the job {string}")
    public void user_search_for_the_job_title(String jobTitle) throws InterruptedException {
        ExtentCucumberAdapter.addTestStepLog("User search for the job title");

        careerPage.searchJob(jobTitle);
    }
    @And("verify the search results not zero")
    public void verify_the_search_results() throws InterruptedException {

        assertTrue(careerPage.extractNumber(careerPage.getSearchResults()) > 0);
    }

    @And("click on the search button")
    public void clickOnTheSearchButton() {
        careerPage.clickOnTheSearchBtn();
    }



}
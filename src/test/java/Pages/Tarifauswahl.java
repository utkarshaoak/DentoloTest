package Pages;

import Utils.BasePage;
import Utils.Browser;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.Map;

public class Tarifauswahl extends BasePage {
private WebDriver driver;
    public Tarifauswahl(Browser browser) {

        super( browser.getDriver());
        this.driver = browser.getDriver();
    }

    By Links = By.tagName("a");
    By  Images =By.tagName("img");
    By tariff = By.xpath("//select[@class='select-sm select-primary']");
    By DOB_day = By.xpath("//select[@class='select-primary select-sm'][@name = 'day']");
    By DOB_month = By.xpath("//select[@class='select-primary select-sm'][@name = 'month']");
    By DOB_year = By.xpath("//select[@class='select-primary select-sm'][@name = 'year']");
    By weiter_button = By.xpath("//button[@class='btn btn-primary btn-md dtl-trk']");
    By Vertragsangaben_page = By.xpath("//div[@class='form-titles']//p[text()='Vertragsangaben']");
    By monatlich = By.xpath("//label[normalize-space()='Monatlicher Beitrag:']/following-sibling::p[@class='listing']");


    @Given("^I navigate to the faircare registration$")
    public void i_navigate_to_the_Open_Weather() throws Throwable {

        driver.get("https://s3.eu-central-1.amazonaws.com/faircare-registration-beta/beta12/index.html?\n" +
                "flow=schema_da_direkt_bas_qa_challenge&showDaTheme=true");
        isDisplayed(monatlich,20);
        //Thread.sleep(10000);

    }

    @When("^I select tariff$")
    public void selectTariff(DataTable data) throws InterruptedException {
        List<Map<String, String>> userDetails = data.asMaps(String.class, String.class);
        isDisplayed(tariff,20);
        selectFromDropDown(tariff, userDetails.get(0).get("tariff_option"));
    }
    @When("^I select a date of birth$")
    public void selectDOB(DataTable data) throws InterruptedException {
        List<Map<String, String>> userDetails = data.asMaps(String.class, String.class);
        selectFromDropDown(DOB_day, userDetails.get(0).get("Tag"));
        selectFromDropDown(DOB_month, userDetails.get(0).get("Monat"));
        selectFromDropDown(DOB_year, userDetails.get(0).get("Jahr"));
    }
    @Then("^I click on weiter and I verify I system should navigate to Vertragsangaben page$")
    public void verifyVertragsangabenPage() throws InterruptedException {
        clickOn(weiter_button);
        isDisplayed(Vertragsangaben_page,20);
        //Thread.sleep(10000);
        Assert.assertEquals("Vertragsangaben",getText(Vertragsangaben_page));
    }


//    @When("^I search for the city \"([^\"]*)\"$")
//    public void iSearchForTheCity(String cityName) throws Throwable {
//
//        clickOn(WeatherInYourCitySearchIcon);
//        enterText(WeatherInYourCitySearchTextBox,cityName);
//        clickOn(WeatherInYourCitySearchButton);
//        System.out.println("searched");
//
//    }
//
//
//
//
//    @Then("^I should see searched city Result contains \"([^\"]*)\"$")
//    public void iShouldSeeSearchedCityWeatherOf(String cityname) throws Throwable {
//
//        String SearchResultValue = getText(searchResult);
//        Assert.assertTrue(SearchResultValue.contains(cityname));
//
//    }


}

package Pages;

import Utils.BasePage;
import Utils.Browser;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.Map;

public class PolicyholderDetails extends BasePage {
private WebDriver driver;
    public PolicyholderDetails(Browser browser) {

        super( browser.getDriver());
        this.driver = browser.getDriver();
    }

    By Links = By.tagName("a");
    By  Images =By.tagName("img");
//    By WeatherInYourCitySearchIcon = By.id("nav-search");
//    By WeatherInYourCitySearchTextBox = By.xpath("//form[@id='nav-search-form']//input[@type='text']");
//    By WeatherInYourCitySearchButton = By.xpath("//button[@type='submit']");
//    By searchResult = By.xpath("//div[@id='forecast_list_ul']");
    By female_radio = By.xpath("//div[@class = 'listing'][normalize-space() = 'Frau']/preceding-sibling::input");
    By male_radio = By.xpath("//div[@class='listing']//font//font[normalize-space()='Herr']");
    By first_name = By.xpath("//div[@class='f8-input-wrapper f8-da-direkt-input']//input[@id='first_name']");
    By last_name = By.xpath("//div[@class='f8-input-wrapper f8-da-direkt-input']//input[@id='last_name']");
    By DOB_Tag =  By.xpath("//select[@class='select-primary select-sm'][@name='day']");
    By DOB_month =  By.xpath("//select[@class='select-primary select-sm'][@name = 'month']");
    By DOB_year =  By.xpath("//select[@class='select-primary select-sm'][@name = 'year']");
    By email = By.xpath("//input[@class = 'input-sm input-primary'][@name='email']");
    By tel_no = By.xpath("//input[@id='phone_number']");
    By address_streetName = By.xpath("//input[@id='street_name'][@name='street-address']");
    By address_houseNo= By.xpath("//input[@id='street_name'][@name='house-number']");
    By address_postalcode  = By.xpath("//div[@class='f8-postal-code-input']//input[@id='postalcode_city']");
    By address_postalcode_city  = By.xpath("//div[@class='f8-city-input']//input[@id='postalcode_city']");
    By weiter = By.xpath("//button[@class = 'btn btn-primary btn-md dtl-trk']");
    By monatlicher_beitrag = By.xpath("//div[@class='f8-input-wrapper f8-listing-wrapper price-loader-wrapper f8_da_direkt_policy_price']//p");
    By zahlungsdaten_page = By.xpath("//div[@class = 'form-titles']//p");


    @And("^fill the details in policy details$")
    public void policyDetails(DataTable data) throws InterruptedException{
        isDisplayed(monatlicher_beitrag,20);
        List<Map<String, String>> userDetails = data.asMaps(String.class, String.class);
        clickOn(female_radio);
        enterText(first_name,userDetails.get(0).get("Vorname"));
        enterText(last_name, userDetails.get(0).get("Nachname"));
        selectFromDropDown(DOB_Tag, userDetails.get(0).get("Tag"));
        selectFromDropDown(DOB_month, userDetails.get(0).get("Monat"));
        selectFromDropDown(DOB_year, userDetails.get(0).get("Jahr"));
        enterText(email,userDetails.get(0).get("Email"));
        enterText(tel_no,userDetails.get(0).get("Tel_no"));
        enterText(address_streetName,userDetails.get(0).get("street_name"));
        enterText(address_houseNo,userDetails.get(0).get("street_no"));
        enterText(address_postalcode,userDetails.get(0).get("postcode_5"));
        enterText(address_postalcode_city,userDetails.get(0).get("postcode_name"));
        scrolldown();
        clickOn(weiter);
        isDisplayed(zahlungsdaten_page,20);
        //Thread.sleep(10000);
        Assert.assertEquals("Zahlungsdaten",getText(zahlungsdaten_page));
    }


//    @When("^I select tariffs and date$")
//    public void selectTariffAndDate()
//    {
//        clickOn(tariff(10));
//        clickOn(DOB_day("1."));
//        clickOn(DOB_month("Januar"));
//        clickOn(DOB_year("2009"));
//        clickOn(weiter_button);
//
//    }
//
//
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
//    @Then("^I should see searched city Result contains \"([^\"]*)\"$")
//    public void iShouldSeeSearchedCityWeatherOf(String cityname) throws Throwable {
//
//        String SearchResultValue = getText(searchResult);
//        Assert.assertTrue(SearchResultValue.contains(cityname));
//
//    }


}

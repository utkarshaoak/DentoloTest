package Pages;

import Utils.BasePage;
import Utils.Browser;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import org.apache.commons.lang3.RandomStringUtils;
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
    By zahlungsdaten_page = By.xpath("//div[@class = 'form-titles']//p[text()='Zahlungsdaten']");


    @And("^fill the details in policy details$")
    public void policyDetails(DataTable data) throws InterruptedException{
        isDisplayed(monatlicher_beitrag,20);
        String randonNumber = RandomStringUtils.randomNumeric(3);
        List<Map<String, String>> userDetails = data.asMaps(String.class, String.class);
        clickOn(female_radio);
        enterText(first_name,getRandomValue(userDetails.get(0).get("Vorname")));
        enterText(last_name, getRandomValue(userDetails.get(0).get("Nachname")));
        selectFromDropDown(DOB_Tag, userDetails.get(0).get("Tag"));
        selectFromDropDown(DOB_month, userDetails.get(0).get("Monat"));
        selectFromDropDown(DOB_year, userDetails.get(0).get("Jahr"));
        enterText(email,userDetails.get(0).get("Email").replace("@", randonNumber + "@"));
        enterText(tel_no,userDetails.get(0).get("Tel_no")+randonNumber);
        enterText(address_streetName,getRandomValue(userDetails.get(0).get("street_name")));
        enterText(address_houseNo,userDetails.get(0).get("street_no"));
        enterText(address_postalcode,userDetails.get(0).get("postcode_5")+randonNumber);
        enterText(address_postalcode_city,userDetails.get(0).get("postcode_name"));
        scrolldown();
        clickOn(weiter);
        isDisplayed(zahlungsdaten_page,20);
    }

}

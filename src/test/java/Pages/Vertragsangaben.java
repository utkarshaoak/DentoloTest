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

public class Vertragsangaben extends BasePage {
private WebDriver driver;
    public Vertragsangaben(Browser browser) {

        super( browser.getDriver());
        this.driver = browser.getDriver();
    }

    By Links = By.tagName("a");
    By  Images =By.tagName("img");
    By ausgewählter_Tarif = By.xpath("//div[@class = 'f8-input-wrapper f8-listing-wrapper f8_da_direkt_policy_name']//p");
    By monatlicher_beitrag = By.xpath("//div[@class = 'f8-input-wrapper f8-listing-wrapper price-loader-wrapper f8_da_direkt_policy_price_v2']//p");
    By male_radio = By.xpath("//input[@class='input-sm input-primary'][@value='male']");
    By female_radio = By.xpath("//input[@class='input-sm input-primary'][@value='female']");
    By first_name_text = By.xpath("//div[@class = 'f8-input-wrapper f8-da-direkt-input']//input[@name='first_name']");
    By last_name_text = By.xpath("//div[@class = 'f8-input-wrapper f8-da-direkt-input']//input[@name='last_name']");
    By weiter = By.xpath("//button[@class = 'btn btn-primary btn-md dtl-trk']");
    By angaben_zum_Versicherungsnehmer_page =  By.xpath("//div[@class='form-titles']//p[text()='Angaben zum Versicherungsnehmer']");


    @And("^I select Anrede, fill the data in Vorname and Nachname$")
    public void selectTariff(DataTable data) throws InterruptedException {
        isDisplayed(monatlicher_beitrag,20);
        List<Map<String, String>> userDetails = data.asMaps(String.class, String.class);
        scrolldown();
        clickOn(female_radio);
        enterText(first_name_text, getRandomValue(userDetails.get(0).get("Vorname")));
        enterText(last_name_text,getRandomValue(userDetails.get(0).get("Nachname")));
        clickOn(weiter);
        isDisplayed(angaben_zum_Versicherungsnehmer_page,20);
    }


}

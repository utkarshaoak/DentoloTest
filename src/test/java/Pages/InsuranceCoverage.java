package Pages;

import Utils.BasePage;
import Utils.Browser;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InsuranceCoverage extends BasePage {
private WebDriver driver;
    public InsuranceCoverage(Browser browser) {

        super( browser.getDriver());
        this.driver = browser.getDriver();
    }

    By Links = By.tagName("a");
    By  Images =By.tagName("img");
    By Monatlicher = By.xpath("//div[@class='f8-input-wrapper f8-listing-wrapper price-loader-wrapper f8_da_direkt_policy_price_v2']//p");
    By jetzt_kostenpflichtig_beantragen = By.xpath("//button[@class= 'btn btn-primary btn-md dtl-trk']");
    By thankyou_msg = By.xpath("//div[@class='f8-input-wrapper f8-listing-wrapper f8-da-direkt-listingText d8-success-description']//label");

    @Then("^I apply for insurance and I verify the insurance has been applied successfully$")
    public void aplyforinsurance() throws InterruptedException{
        isDisplayed(Monatlicher,30);
        clickOn(jetzt_kostenpflichtig_beantragen);
        isDisplayed(thankyou_msg,60);
        Assert.assertEquals("Vielen Dank! Der Abschluss war erfolgreich.",getText(thankyou_msg));
    }






}

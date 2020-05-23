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

public class PaymentDetails extends BasePage {
private WebDriver driver;
    public PaymentDetails(Browser browser) {

        super( browser.getDriver());
        this.driver = browser.getDriver();
    }

    By Links = By.tagName("a");
    By  Images =By.tagName("img");
    By IBAN = By.xpath("//input[@class='input-primary input-sm']");
    By weiter = By.xpath("//button[@class='btn btn-primary btn-md dtl-trk']");
    By monatlicher_beitrag = By.xpath("//div[@class='f8-input-wrapper f8-listing-wrapper price-loader-wrapper f8_da_direkt_policy_price']//p");
    By ausgewählter_Versicherungsschutz_page = By.xpath("//div[@class='form-titles']//p");

    @And("^I will add IBAN no and cleck on weiter$")
    public void payment(DataTable data) throws InterruptedException
    {
        List<Map<String, String>> userDetails = data.asMaps(String.class, String.class);
        isDisplayed(monatlicher_beitrag,20);
        enterText(IBAN, userDetails.get(0).get("IBAN"));
        clickOn(weiter);
        isDisplayed(ausgewählter_Versicherungsschutz_page,60);
      //  Thread.sleep(10000);
        Assert.assertEquals("Ausgewählter Versicherungsschutz",getText(ausgewählter_Versicherungsschutz_page));

    }

}

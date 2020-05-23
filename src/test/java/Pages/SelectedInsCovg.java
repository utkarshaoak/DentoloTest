package Pages;

import Utils.BasePage;
import Utils.Browser;
import cucumber.api.java.en.And;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SelectedInsCovg extends BasePage {
private WebDriver driver;
    public SelectedInsCovg(Browser browser) {

        super( browser.getDriver());
        this.driver = browser.getDriver();
    }

    By Links = By.tagName("a");
    By  Images =By.tagName("img");
    By documents_accepted_at_check = By.xpath("//input[@id = 'documents_accepted_at']");
    By assert_documents_accepted_at_check = By.xpath("//div[@class='btn btn-primary btn-md dtl-trk']//span//font//font");
    By assert_documents_accepted_at_check_agree = By.xpath("//div[@class = 'f8-next-btn-container']//div[@class='btn btn-primary btn-md dtl-trk']//span");
    By email_check = By.xpath("//input[@name = 'e_mail']");
    By telephone_check = By.xpath("//input[@name = 'telephone']");
    By weiter = By.xpath("//button[@class='btn btn-primary btn-md dtl-trk']");
    By Versicherungsschutz_page = By.xpath("//div[@class='form-titles']//p");

    @And("^I select insurance coverage$")
    public void select_insurance_coverage() throws InterruptedException{
        clickOn(documents_accepted_at_check);
        isDisplayed(assert_documents_accepted_at_check,20);
        javaScriptClickOn(assert_documents_accepted_at_check_agree);
        clickOn(email_check);
        scrolldown();
        clickOn(telephone_check);
        scrolldown();
        clickOn(weiter);
        isDisplayed(Versicherungsschutz_page,30);
        //Thread.sleep(10000);
        Assert.assertEquals("Versicherungsschutz", getText(Versicherungsschutz_page));

    }
 


}

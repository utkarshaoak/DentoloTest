package Pages;

import Utils.BasePage;
import Utils.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ThankYou extends BasePage {
private WebDriver driver;
    public ThankYou(Browser browser) {

        super( browser.getDriver());
        this.driver = browser.getDriver();
    }

    By Links = By.tagName("a");
    By  Images =By.tagName("img");







}

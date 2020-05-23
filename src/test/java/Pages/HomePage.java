package Pages;

import Utils.BasePage;
import Utils.Browser;
import com.jayway.restassured.RestAssured;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Set;

public class HomePage extends BasePage {
private WebDriver driver;
    public HomePage(Browser browser) {

        super( browser.getDriver());
        this.driver = browser.getDriver();
    }

    By Links = By.tagName("a");
    By  Images =By.tagName("img");
    By WeatherInYourCitySearchIcon = By.id("nav-search");
    By WeatherInYourCitySearchTextBox = By.xpath("//form[@id='nav-search-form']//input[@type='text']");
    By WeatherInYourCitySearchButton = By.xpath("//button[@type='submit']");
    By searchResult = By.xpath("//div[@id='forecast_list_ul']");







    @Given("^I navigate to the Open Weather$")
    public void i_navigate_to_the_Open_Weather() throws Throwable {

        driver.get("https://openweathermap.org/");

    }


    @Then("^I verify all links are working on landing page$")
    public void iVerifyAllLinksAreWorkingOnLandingPage() {
        Set<String> urls = getUrl(Links,"href");

      for(String url :urls)
      {  if(url!=null && url.contains("http") && !url.contains("linkedin")) {
          System.out.println(url);
          RestAssured.given().get(url).then().statusCode(200);
      }
      }
    }

    @And("^I verify all images are loading properly on landing page$")
    public void iVerifyAllImagesAreLoadingProperlyOnLandingPage() {

        Set<String> urls = getUrl(Images,"src");

        for(String url :urls)
        {  if(url!=null && url.contains("http") && !url.contains("linkedin")) {
            System.out.println(url);
            RestAssured.given().get(url).then().statusCode(200);
        }
        }

    }

    @When("^I search for the city \"([^\"]*)\"$")
    public void iSearchForTheCity(String cityName) throws Throwable {
        
        clickOn(WeatherInYourCitySearchIcon);
        enterText(WeatherInYourCitySearchTextBox,cityName);
        clickOn(WeatherInYourCitySearchButton);
        System.out.println("searched");

    }




    @Then("^I should see searched city Result contains \"([^\"]*)\"$")
    public void iShouldSeeSearchedCityWeatherOf(String cityname) throws Throwable {

        String SearchResultValue = getText(searchResult);
        Assert.assertTrue(SearchResultValue.contains(cityname));

    }


}

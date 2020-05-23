package Utils;



/*This is base class having selenium webdriver based functionality- which interacts with browser*/

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;


public class BasePage {
protected WebDriver driver;
    public BasePage(WebDriver driver) {
        this.driver = driver;

    }
    protected void selectFromDropDown(By Locator, String value){
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(driver.findElement(Locator),By.xpath("//option")));
        Select dropdown = new Select(driver.findElement(Locator));
        dropdown.selectByVisibleText(value);
    }
    public void javaScriptClickOn(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        WebElement element =  wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);

    }

  protected  Set<String> getUrl(By Locator, String attribute) {
      Set<String> UrlList = new HashSet<String>();

      List<WebElement> webElements = driver.findElements(Locator);
      for (WebElement element : webElements) {
          UrlList.add(   element.getAttribute(attribute));
      }
      return  UrlList;


  }


    protected void clickOn(By Locator) {

        driver.findElement(Locator).click();


    }


    protected String getText(By Locator) {
       return driver.findElement(Locator).getText();

    }


    protected void enterText(By Locator, String ValueToBeEnter) {
        driver.findElement(Locator).sendKeys(ValueToBeEnter);
    }

    public boolean isDisplayed(By Locator, int timeOutinSec) {
        WebDriverWait wait = new WebDriverWait(driver, timeOutinSec);
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(Locator)).isDisplayed();
        } catch (NoSuchElementException e) {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(Locator)).isDisplayed();
        } catch (Exception e) {
            return false;
        }

    }

    public WebElement isclickable(By Locator, int timeOutinSec) {
        WebDriverWait wait = new WebDriverWait(driver, timeOutinSec);

            return wait.until(ExpectedConditions.elementToBeClickable(Locator));

    }
    public void bringElementIntoView(By Locator) {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(Locator));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", element);
    }
    public void scrollUp() {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,-500)", "");

    }
    public void scrolldown() {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,1000)", "");

    }
    public String getRandomValue(String value)
    {
        if(value.contains("(+)")) {
            return value.replace("(+)", Browser.RandomValue);
        }
        else{
            return   value;
        }
    }


}

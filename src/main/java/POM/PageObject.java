package POM;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageObject {
    WebDriver driver;
    public PageObject(WebDriver driver) {
        this.driver = driver;
    }
    public void Wait1S(){
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
    }
    public void Wait2S(){
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }
    public void Wait5S(){
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
    public void Wait10S(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    //navbar
    By btnTransports = By.xpath("//div[text()='Transports']");
    By btnFlights = By.xpath("(//div[text()='Flights'])[1]");
    public void clickNavbarTransports(){
        driver.findElement(btnTransports).click();
    }
    public void clickFlights(){
        driver.findElement(btnFlights).click();
    }

    //flights
    By checkboxOneWayRoundTrip = By.xpath("(//div[@role='radio'])[1]");
    By checkboxMultiCity = By.xpath("(//div[@role='radio'])[2]");
    By txtFrom = By.xpath("//input[@placeholder='Origin']");
    By txtTo = By.xpath("//input[@placeholder='Destination']");
    By btnSearchFlights = By.xpath("//div[normalize-space()='Search Flights']//child::div");
    public WebElement checkBoxOneWayRoundTrip(){
        return driver.findElement(checkboxOneWayRoundTrip);
    }
    public WebElement checkBoxMultiCity(){
        return driver.findElement(checkboxMultiCity);
    }
    public void inputOriginFlights(String value) throws Exception {
        final String checkOS = System.getProperty("os.name").toLowerCase();
        System.out.println("current OS = " + checkOS);
        if (checkOS.contains("mac")) {
            driver.findElement(txtFrom).sendKeys(Keys.COMMAND+"a");
        } else {
            driver.findElement(txtFrom).sendKeys(Keys.CONTROL+"a");
        }
        Thread.sleep(500);
        driver.findElement(txtFrom).sendKeys(Keys.DELETE);
        Thread.sleep(1000);
        driver.findElement(txtFrom).sendKeys(value);
        Thread.sleep(1000);
        driver.findElement(txtFrom).sendKeys(Keys.ENTER);
        Thread.sleep(500);
    }
    public void inputDestinationFlights(String value) throws Exception {
        final String checkOS = System.getProperty("os.name").toLowerCase();
        if (checkOS.contains("mac")) {
            driver.findElement(txtTo).sendKeys(Keys.COMMAND+"a");
        } else {
            driver.findElement(txtTo).sendKeys(Keys.CONTROL+"a");
        }
        Thread.sleep(500);
        driver.findElement(txtTo).sendKeys(Keys.DELETE);
        Thread.sleep(1000);
        driver.findElement(txtTo).sendKeys(value);
        Thread.sleep(1000);
        driver.findElement(txtTo).sendKeys(Keys.ENTER);
        Thread.sleep(500);
    }
    public void clickSearchFlights(){
        driver.findElement(btnSearchFlights).click();
    }

    //result
    By btnChangeSearch = By.xpath("(//div[text()='Change search'])[2]");
    By flightsNotAvailable = By.xpath("//h2[text()='No flights available']");
    public void clickChangeSearch(){
        driver.findElement(btnChangeSearch).click();
    }
    public WebElement checkFlightsNotAvailable(){
        return driver.findElement(flightsNotAvailable);
    }
}

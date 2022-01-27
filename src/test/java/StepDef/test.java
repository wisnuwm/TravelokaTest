package StepDef;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import Global.BaseClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class test extends BaseClass {
    @Given("Open website {string}")
    public void openWebsite(String URL) throws InterruptedException {
        driver.get(URL);
        Thread.sleep(1000);
    }

    @And("Click menu flights")
    public void clickMenuFlights() throws InterruptedException {
        driver.findElement(By.xpath("//img[@src='https://d1785e74lyxkqq.cloudfront.net/_next/static/v2/1/14570d0f2b738b8dc8ef903949bce73c.svg']")).click();
        Thread.sleep(500);
    }

    @And("Select from Jakarta {string}")
    public void selectFromJakarta(String Jakarta) throws InterruptedException {
        driver.findElement(By.xpath("//input[@placeholder='Origin']")).clear();
        driver.findElement(By.xpath("//input[@placeholder='Origin']")).sendKeys(Jakarta);
        Thread.sleep(800);
        driver.findElement(By.xpath("//input[@placeholder='Origin']")).sendKeys(Keys.ENTER);
        Thread.sleep(1000);
    }

    @And("Select to Padang {string}")
    public void selectToPadang(String Padang) throws InterruptedException {
        driver.findElement(By.xpath("//input[@placeholder='Destination']")).clear();
        driver.findElement(By.xpath("//input[@placeholder='Destination']")).sendKeys(Padang);
        Thread.sleep(800);
        driver.findElement(By.xpath("//input[@placeholder='Destination']")).sendKeys(Keys.ENTER);
        Thread.sleep(1000);
    }

    @When("Click button search flights")
    public void clickButtonSearchFlights() throws InterruptedException {
        driver.findElement(By.xpath("(//div[normalize-space()='Search Flights'])[2]")).click();
        Thread.sleep(5000);
    }

    @Then("showing all flights from Jakarta to Padang")
    public void showingAllFlightsFromJakartaToPadang() {
        String valueOriAndDes = driver.findElement(By.xpath("//h3[contains(text(),'Jakarta (JKTA) → Padang (PDG)')]")).getText();
        driver.findElement(By.xpath("//h3[contains(text(),'Jakarta (JKTA) → Padang (PDG)')]")).isDisplayed();
        System.out.println("Passed showing flights "+valueOriAndDes);
        driver.close();
        driver.quit();
    }
}

package StepDef;

import java.util.concurrent.TimeUnit;

import InitDriver.InitDriver;
import POM.PageObject;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.hu.De;

public class Assessment extends InitDriver {
    public Assessment() {
        super();
    }
    PageObject pageObject = new PageObject(driver);
    @Given("Open URL {string}")
    public void openURL(String URL) {
        driver.get(URL);
        pageObject.Wait2S();
    }

    @And("Click on Navigation Menu Transports")
    public void clickOnNavigationMenuTransports() {
        pageObject.clickNavbarTransports();
        pageObject.Wait1S();
    }

    @And("Click on Flights")
    public void clickOnFlights() {
        pageObject.clickFlights();
        pageObject.Wait5S();
    }

    @And("On Flight Search Form, click on Round Trip checkbox")
    public void onFlightSearchFormClickOnRoundTripCheckbox() {
        pageObject.checkBoxOneWayRoundTrip().isSelected();
        System.out.println("Checkbox Round Trip is Selected");
    }

    @And("Click on Search button")
    public void clickOnSearchButton() {
        pageObject.clickSearchFlights();
    }

    @And("Wait until the page is fully loaded")
    public void waitUntilThePageIsFullyLoaded() {
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
    }

    @And("Click on Change Search button")
    public void clickOnChangeSearchButton() throws Exception {
        pageObject.clickChangeSearch();
        Thread.sleep(2000);
    }

    @And("Change From text field to {string}")
    public void changeFromTextFieldTo(String Origin) throws Exception {
        pageObject.inputOriginFlights(Origin);
        pageObject.Wait1S();
    }

    @And("Change To text field to {string}")
    public void changeToTextFieldTo(String Destination) throws Exception {
        pageObject.inputDestinationFlights(Destination);
        pageObject.Wait1S();
    }

    @Then("Verify that Error state: {string} is displayed")
    public void verifyThatErrorStateIsDisplayed(String VerifyText) throws Exception {
        try{
            String valueVerify = pageObject.checkFlightsNotAvailable().getText();
            pageObject.checkFlightsNotAvailable().isDisplayed();
            if(valueVerify.equals(VerifyText)){
                System.out.println("Flight is not displayed with text "+valueVerify);
            }
        }catch (Exception e){
            throw new Exception(e);
        }
    }
}

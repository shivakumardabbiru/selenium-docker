package com.flightbook.test;

import com.flighbook.tours.*;
import com.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BookFlight extends BaseTest {

    private String noofpass;
    private String expectedprice;

    @BeforeTest
    @Parameters({"noofpass","expectedprice"})
    public void setupParameters(String noofpass,String expectedprice) {
        this.noofpass = noofpass;
        this.expectedprice =expectedprice;
    }

    @Test
    public void RegistrationPageTest() {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.goTo();
        registrationPage.enterdetails("selenium","docker");
        registrationPage.entercredentials("selenium","docker","docker");
        registrationPage.submitbtn();
    }

    @Test(dependsOnMethods = "RegistrationPageTest")
    public void RegistrationConfirmPageTest() {
        RegistrationConfirmPage registrationConfirmPage = new RegistrationConfirmPage(driver);
        registrationConfirmPage.clickflightlink();
    }

    @Test(dependsOnMethods = "RegistrationConfirmPageTest")
    public void FlightDetailsPageTest() {
        FlightDetailsPage flightDetailsPage = new FlightDetailsPage(driver);
        flightDetailsPage.enterpasscnt(noofpass);
        flightDetailsPage.gotoselectflights();

    }
    @Test(dependsOnMethods = "FlightDetailsPageTest")
    public void selectflightPageTest() {
        SelectFlightPage selectFlightPage = new SelectFlightPage(driver);
        selectFlightPage.submitflightselection();
        selectFlightPage.submitfinalorder();
    }

    @Test(dependsOnMethods = "selectflightPageTest")
    public void FlightConfirmPageTest() {
        FlightConfirmPage flightConfirmPage = new FlightConfirmPage(driver);
        String ActualPrice = flightConfirmPage.getPrice();
        Assert.assertEquals(ActualPrice,expectedprice);
    }

    @AfterTest

    public void quitbrowser() {
        this.driver.quit();
    }



}

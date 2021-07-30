package com.flighbook.tours;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationConfirmPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(partialLinkText = "sign-in")
    private WebElement signinlnktxt;

    @FindBy(id="flight-link")
    private WebElement flightlnk;

    public RegistrationConfirmPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver,30);
        PageFactory.initElements(driver,this);
    }

    public void clickflightlink() {
        this.wait.until(ExpectedConditions.visibilityOf(this.signinlnktxt));
        this.flightlnk.click();
    }


}

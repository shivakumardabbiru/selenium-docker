package com.flighbook.tours;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SelectFlightPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(name ="reserveFlights")
    private WebElement fstSubmitBtn;

    @FindBy(name = "buyFlights")
    private WebElement sndSubmitBtn;

    public SelectFlightPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }
    public void submitflightselection(){
        this.wait.until(ExpectedConditions.elementToBeClickable(this.fstSubmitBtn));
        this.fstSubmitBtn.click();
    }

    public void submitfinalorder(){
        this.sndSubmitBtn.click();
    }


}

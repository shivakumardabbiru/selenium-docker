package com.flighbook.tours;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class FlightConfirmPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//font[contains(text(),'Flight Confirmation')]")
    private WebElement flightconfirmationheader;

    @FindBy(xpath = "//font[contains(text(),'USD')]")
    private List<WebElement> prices;

    @FindBy(linkText = "SIGN-OFF")
    private WebElement signoff;

    public FlightConfirmPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver,this);
    }

    public String getPrice() {
        this.wait.until(ExpectedConditions.visibilityOf(this.flightconfirmationheader));
        System.out.println(this.flightconfirmationheader.getText());
        String Price = this.prices.get(1).getText();
        this.signoff.click();
        return Price;
    }


}

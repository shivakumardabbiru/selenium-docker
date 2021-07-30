package com.flighbook.tours;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(name = "firstName")
    private WebElement firstNametxt;

    @FindBy(name ="lastName")
    private WebElement lastNameTxt;

    @FindBy(name ="email")
    private WebElement userNameTxt;

    @FindBy(name ="password")
    private WebElement passwordTxt;

    @FindBy(name ="confirmPassword")
    private WebElement confirmPasswordTxt;

    @FindBy(name ="register")
    private WebElement submitbtn;




    public RegistrationPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver,30);
        PageFactory.initElements(driver,this);
    }

    public void goTo() {
        this.driver.get("https://vins-udemy.s3.amazonaws.com/docker/docker-book-flight.html#");
        this.wait.until(ExpectedConditions.visibilityOf(this.firstNametxt));
    }

    public void enterdetails(String firstName, String lastName) {
        this.firstNametxt.sendKeys(firstName) ;
        this.lastNameTxt.sendKeys(lastName);
    }

    public void entercredentials(String userName, String password, String confirmPassword) {
        this.userNameTxt.sendKeys(userName);
        this.passwordTxt.sendKeys(password);
        this.confirmPasswordTxt.sendKeys(confirmPassword);

    }

    public void submitbtn() {
        this.submitbtn.click();
    }
}

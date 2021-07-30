package com.searchmodule.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//import sun.jvm.hotspot.debugger.Page;

import java.util.List;

public class searchvideos {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(name="q")
    private WebElement search;

    @FindBy(id="search_button_homepage")
    private WebElement clicksearch;

    @FindBy(linkText = "Videos")
    private WebElement videolnk;

    @FindBy(className = "tile--vid")
    private List<WebElement> allvideos;


    public searchvideos(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }

    public void gotosearchpage(){
        this.driver.get("https://duckduckgo.com/");
    }

    public void searchtext(String searchtxt) {
        this.wait.until(ExpectedConditions.visibilityOf(this.search));
        this.search.sendKeys(searchtxt);
        this.clicksearch.click();

    }

    public void gotovideos() {
        this.wait.until(ExpectedConditions.elementToBeClickable(this.videolnk));
        this.videolnk.click();
    }

    public Integer getcnt() {
        By by = By.className("tile--vid");
        this.wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(by,0));
        System.out.println(this.allvideos.size());
        return this.allvideos.size();
    }


}

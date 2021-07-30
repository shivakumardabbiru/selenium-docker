package com.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {

    protected WebDriver driver;

    @BeforeTest
    public void setDriver() throws MalformedURLException {
        //System.setProperty("webdriver.chrome.driver","D:\\IntellijWorkspace\\chromedriver.exe");
        //this.driver = new ChromeDriver();
        //BROWSER = chrome/firefox; need to define the default values for browser , hubhost incase
        //HUB_HOST = localhost; user doesn't pass those values.

        String host = "localhost";
        DesiredCapabilities dc;

        if (System.getProperty("BROWSER") != null &&
                System.getProperty("BROWSER").equalsIgnoreCase("Firefox")) {
             dc = DesiredCapabilities.firefox();
        } else {
            dc = DesiredCapabilities.chrome();
        }

        if (System.getProperty("HUB_HOST") != null) {
            host = System.getProperty("HUB_HOST");
        }

          String completeurl =  "http://" + host + ":4444/wd/hub";
          this.driver = new RemoteWebDriver(new URL(completeurl),dc);

    }

    @AfterTest
    public void quitdriver(){
        this.driver.quit();
    }
}

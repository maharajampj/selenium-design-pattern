package com.seleniumDesign.test.srp;


import com.seleniumDesign.factory.Driverfactory.BrowserType;
import com.seleniumDesign.factory.Driverfactory.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

/**
 * Unit test for simple App.
 */
public class BaseTest
{
    protected WebDriver driver;
    @BeforeTest
    public void setUpdriver()
    {
        driver= DriverFactory.getDriver(BrowserType.CHROME);
        driver.manage().window().maximize();
    }


    @AfterTest
    public void quitDriver()
    {
        driver.quit();
    }
}

package com.seleniumDesign.test.command;

import com.seleniumDesign.command.HomePage;
import com.seleniumDesign.test.srp.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest
{
    private HomePage homePage;
    @BeforeTest
    public void setHomePage()
    {
        this.homePage=new HomePage(driver);
    }
    @Test
    public void homePageTest()
    {
        this.homePage.goTo();
        this.homePage.getElementValidator().stream().map((e)->e.validate()).forEach((b)-> Assert.assertTrue(b));
    }
}

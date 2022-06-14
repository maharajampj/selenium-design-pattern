package com.seleniumDesign.test.factory;

import com.seleniumDesign.Pagefactory.GoogleFactory;
import com.seleniumDesign.Pagefactory.GooglePage;
import com.seleniumDesign.test.srp.BaseTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class GoogleSearchTest extends BaseTest
{
    private GooglePage googlePage;
    @Test(dataProvider="getData")
    public void searchTest(String language,String keyword)
    {
        this.googlePage= GoogleFactory.get(language,this.driver);
        this.googlePage.launchSite();
        this.googlePage.search(keyword);
        String result=this.googlePage.getResultCount();
        System.out.println("Result Count : "+result);
    }
    @DataProvider
    public Object[][] getData()
    {
        return new Object[][]{
                {"ENG","Selenium"},{"FR","Docker"}
        };
    }
}

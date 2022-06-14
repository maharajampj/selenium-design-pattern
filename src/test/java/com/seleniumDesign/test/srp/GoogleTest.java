package com.seleniumDesign.test.srp;

import com.seleniumDesign.srp.main.GoogleMainPage;
import com.seleniumDesign.srp.result.GoogleResultPage;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class GoogleTest extends BaseTest{
    private GoogleMainPage mainPage;
    private GoogleResultPage resultPage;

    @BeforeTest
    public void setUpMainPage()
    {
        this.mainPage=new GoogleMainPage(driver);
        this.resultPage=new GoogleResultPage(driver);
    }

    @Test(dataProvider = "getData")
    public void searchByWord(String keyword,int index) throws InterruptedException {
        mainPage.goTo();
        Assert.assertTrue(mainPage.getSearchWidget().isDisplayed());
        mainPage.getSearchWidget().enter(keyword);
        Assert.assertTrue(mainPage.getSearchSuggestion().isDisplayed());
        mainPage.getSearchSuggestion().clickSuggestionByIndex(index);
        Assert.assertTrue(resultPage.getNavigationBar().isDisplayed());
        System.out.println(resultPage.getResultStat().getStat());
    }
    @DataProvider
    public Object[][] getData()
    {
        return new Object[][]{
                {"selenium",3},{"docker",2}
        };
    }
}

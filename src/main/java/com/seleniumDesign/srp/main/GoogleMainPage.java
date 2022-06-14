package com.seleniumDesign.srp.main;

import com.seleniumDesign.srp.common.searchSuggestion;
import com.seleniumDesign.srp.common.searchWidget;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class GoogleMainPage {
    private WebDriver driver;
    private com.seleniumDesign.srp.common.searchSuggestion searchSuggestion;
    private com.seleniumDesign.srp.common.searchWidget searchWidget;

    public GoogleMainPage(final WebDriver driver)
    {
        this.driver=driver;
        this.searchWidget=PageFactory.initElements(driver,searchWidget.class);
        this.searchSuggestion=PageFactory.initElements(driver,searchSuggestion.class);
    }

    public void goTo()
    {
        driver.get("https://www.google.com");
    }

    public searchWidget getSearchWidget() {
        return searchWidget;
    }

    public searchSuggestion getSearchSuggestion() {
        return searchSuggestion;
    }

}

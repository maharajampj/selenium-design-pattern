package com.seleniumDesign.srp.result;

import com.seleniumDesign.srp.common.searchSuggestion;
import com.seleniumDesign.srp.common.searchWidget;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class GoogleResultPage {
    private com.seleniumDesign.srp.common.searchSuggestion searchSuggestion;
    private com.seleniumDesign.srp.common.searchWidget searchWidget;
    private com.seleniumDesign.srp.result.navigationBar navigationBar;
    private com.seleniumDesign.srp.result.resultStat resultStat;
    public GoogleResultPage(final WebDriver driver)
    {
        this.searchWidget= PageFactory.initElements(driver,searchWidget.class);
        this.searchSuggestion=PageFactory.initElements(driver,searchSuggestion.class);
        this.navigationBar=PageFactory.initElements(driver,navigationBar.class);
        this.resultStat=PageFactory.initElements(driver,resultStat.class);
    }

    public searchSuggestion getSearchSuggestion() {
        return searchSuggestion;
    }

    public navigationBar getNavigationBar() {
        return navigationBar;
    }

    public searchWidget getSearchWidget() {
        return searchWidget;
    }

    public resultStat getResultStat() {
        return resultStat;
    }
}

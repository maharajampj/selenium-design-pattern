package com.seleniumDesign.srp.common;

import com.seleniumDesign.srp.common.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class searchSuggestion extends AbstractComponent
{

    @FindBy(css = "li.sbct")
    private List<WebElement> suggestions;

    public searchSuggestion(final WebDriver driver)
    {
         super(driver);
    }

    public void clickSuggestionByIndex(int index)
    {
        suggestions.get(index-1).click();
    }
    @Override
    public boolean isDisplayed() {
        this.wait.until((d)->this.suggestions.size()>2);
        return true;
    }
}

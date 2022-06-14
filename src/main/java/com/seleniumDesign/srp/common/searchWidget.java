package com.seleniumDesign.srp.common;

import com.seleniumDesign.srp.common.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class searchWidget extends AbstractComponent {


    @FindBy(name = "q")
    private WebElement searchBox;

    public searchWidget(final WebDriver driver)
    {
        super(driver);
    }

    public void enter(String text)
    {
        searchBox.sendKeys(text);
    }
    @Override
    public boolean isDisplayed() {
        this.wait.until(ExpectedConditions.visibilityOf(searchBox));
        return searchBox.isDisplayed();
    }
}

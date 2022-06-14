package com.seleniumDesign.Pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

class GoogleFrench extends GoogleEnglish
{
    @FindBy(id = "SIvCob")
    private WebElement languageBar;
    public GoogleFrench(WebDriver driver) {
        super(driver);
    }

    @Override
    public void launchSite()
    {
        this.driver.get("https://www.google.fr");
    }
}

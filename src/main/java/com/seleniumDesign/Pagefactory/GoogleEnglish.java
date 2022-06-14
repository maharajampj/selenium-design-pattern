package com.seleniumDesign.Pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

class GoogleEnglish extends GooglePage{

    protected WebDriver driver;
    protected WebDriverWait wait;
    @FindBy(name = "q")
    private WebElement searchBox;
    @FindBy(name = "btnK")
    private WebElement searchBtn;
    @FindBy(id = "result-stats")
    private WebElement resultStats;


    public GoogleEnglish(final WebDriver driver)
    {
        this.driver=driver;
        this.wait=new WebDriverWait(driver,30);
        PageFactory.initElements(driver,this);
    }
    @Override
    public void launchSite() {
        this.driver.get("https://www.google.com");
    }

    @Override
    public void search(String Keyword) {
        this.searchBox.sendKeys(Keyword);
        this.wait.until((d)->this.searchBtn.isDisplayed());
        this.searchBtn.click();
    }

    @Override
    public String getResultCount() {
        this.wait.until((d)->this.resultStats.isDisplayed());
            return resultStats.getText();
    }
}

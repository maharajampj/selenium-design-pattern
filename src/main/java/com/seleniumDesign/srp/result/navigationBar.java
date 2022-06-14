package com.seleniumDesign.srp.result;

import com.seleniumDesign.srp.common.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class navigationBar extends AbstractComponent {

    @FindBy(id="hdtb")
    private WebElement bar;
    @FindBy(linkText = "Images")
    private WebElement images;
    @FindBy(linkText = "News")
    private WebElement news;
    public  navigationBar(final WebDriver driver)
    {
      super(driver);
    }
    public void goToImages()
    {
        this.images.click();
    }
    public void goToNews()
    {
        this.news.click();
    }
    @Override
    public boolean isDisplayed() {
        return this.wait.until((d)->bar.isDisplayed());
    }
}

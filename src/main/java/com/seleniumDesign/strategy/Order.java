package com.seleniumDesign.strategy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Order {

    @FindBy(id = "buy")
    private WebElement buynow;
    @FindBy(id = "ordernumber")
    private WebElement ordernumber;
    public Order(final WebDriver driver)
    {
        PageFactory.initElements(driver,this);
    }
    public String placeOrder()
    {
        this.buynow.click();
        return this.ordernumber.getText();
    }
}

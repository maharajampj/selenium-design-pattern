package com.seleniumDesign.strategy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Map;

public class Paypal implements PaymentOption {

    @FindBy(id = "paypal_username")
    private WebElement paypalUsername;
    @FindBy(id = "paypal_password")
    private WebElement paypalPassword;

    @Override
    public void enterPaymentInformation(Map<String, String> option) {
        this.paypalUsername.sendKeys(option.get("paypalusername"));
        this.paypalPassword.sendKeys(option.get("paypalPassword"));

    }
}
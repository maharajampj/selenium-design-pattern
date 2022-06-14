package com.seleniumDesign.strategy;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.Map;

public class NetBanking implements PaymentOption{

    @FindBy(id = "bank")
    private WebElement bank;
    @FindBy(id="acc_number")
    private WebElement acc;
    @FindBy(id = "pin")
    private WebElement pin;
    @Override
    public void enterPaymentInformation(Map<String, String> option) {
        Select bankDropdown=new Select(bank);
        bankDropdown.selectByValue(option.get("bank"));
        this.acc.sendKeys(option.get("acc"));
        this.pin.sendKeys(option.get("pin"));

    }
}

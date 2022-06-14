package com.seleniumDesign.command;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class DismissalAlertValidator extends ElementValidator{

    private final WebElement dismissAlert;

    public DismissalAlertValidator(WebElement dismissAlert) {
        this.dismissAlert = dismissAlert;
    }

    @Override
    public boolean validate() {
        boolean result=this.dismissAlert.isDisplayed();
        this.dismissAlert.findElement(By.cssSelector("button.close")).click();
        boolean result1=this.dismissAlert.isDisplayed();
        return result && (!result1);
    }
}

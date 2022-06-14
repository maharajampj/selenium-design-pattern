package com.seleniumDesign.command;

import com.google.common.util.concurrent.Uninterruptibles;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class NotificationValidator extends ElementValidator{
    private final WebElement btn;
    private final WebElement alert;

    public NotificationValidator(WebElement btn,WebElement alert) {
        this.btn = btn;
        this.alert=alert;
    }

    @Override
    public boolean validate() {
        this.btn.click();
        boolean alertPresence=this.alert.isDisplayed();
        Uninterruptibles.sleepUninterruptibly(4, TimeUnit.SECONDS);
        boolean alertNotPresent=this.alert.isDisplayed();
        return alertPresence&&(!alertNotPresent);
    }
}

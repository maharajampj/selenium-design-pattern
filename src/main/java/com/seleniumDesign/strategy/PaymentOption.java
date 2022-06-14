package com.seleniumDesign.strategy;

import java.util.Map;

public interface PaymentOption
{
    public void enterPaymentInformation(Map<String,String> option);
}

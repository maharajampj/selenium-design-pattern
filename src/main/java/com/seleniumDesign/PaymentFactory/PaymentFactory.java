package com.seleniumDesign.PaymentFactory;

import com.seleniumDesign.strategy.CreditCard;
import com.seleniumDesign.strategy.NetBanking;
import com.seleniumDesign.strategy.PaymentOption;
import com.seleniumDesign.strategy.Paypal;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class PaymentFactory {
    private final static Supplier<PaymentOption> CC=()->new CreditCard();
    private final static Supplier<PaymentOption> NB=()->new NetBanking();
    private final static Supplier<PaymentOption> PP=()->new Paypal();
    private static final Map<String ,Supplier<PaymentOption>> map=new HashMap<>();
    static {
        map.put("CC",CC);
        map.put("NB",NB);
        map.put("PP",PP);
    }
    public static PaymentOption get(String option)
    {
        return map.get(option).get();
    }
}

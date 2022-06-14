package com.seleniumDesign.test.strategy;

import com.seleniumDesign.PaymentFactory.PaymentFactory;
import com.seleniumDesign.strategy.*;
import com.seleniumDesign.test.srp.BaseTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class PaymentTest extends BaseTest
{
    private PaymentScreen paymentScreen;

    @BeforeTest
    public void setPaymentScreen()
    {
        this.paymentScreen=new PaymentScreen(this.driver);
    }
    @Test(dataProvider = "getData")
    public void paymentTest(String option, Map<String,String> paymentDetails)
    {
        this.paymentScreen.goTo();
        this.paymentScreen.getUserInformation().enterDetails("Maha","Raja","maha@mail.com");
        this.paymentScreen.setPaymentOption(PaymentFactory.get(option));
        this.paymentScreen.pay(paymentDetails);
        String orderno=this.paymentScreen.getOrder().placeOrder();
        System.out.println("OrderNo : "+orderno);
    }
    @DataProvider
    public Object[][] getData()
    {
        Map<String,String> cc=new HashMap<>();
        cc.put("cc","123456");
        cc.put("year","2022");
        cc.put("cvv","123");

        Map<String,String> nb=new HashMap<>();
        nb.put("bank","WELLS FARGO");
        nb.put("acc","myacc1234");
        nb.put("pin","7890");

        Map<String,String> paypal=new HashMap<>();
        paypal.put("paypalUsername","maharaja");
        paypal.put("paypalPassword","paypalpass");

        return new Object[][]{
                {"CC",cc},{"NB",nb},{"PP",paypal}
        };
    }
}

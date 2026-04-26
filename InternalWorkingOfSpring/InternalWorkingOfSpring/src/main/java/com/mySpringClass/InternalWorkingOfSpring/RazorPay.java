package com.mySpringClass.InternalWorkingOfSpring;


import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(name = "payment.provider", havingValue = "razorpay")
public class RazorPay implements PaymentService {

    public String pay(){
        String pay = "RazorPay Payment";
        System.out.println("Payment Through : " + pay);
        return pay;
    }
}

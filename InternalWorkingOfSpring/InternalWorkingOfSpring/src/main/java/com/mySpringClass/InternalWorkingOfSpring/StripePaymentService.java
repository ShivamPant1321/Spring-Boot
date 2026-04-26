package com.mySpringClass.InternalWorkingOfSpring;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(name = "payment.provider", havingValue = "stripe")
public class StripePaymentService implements PaymentService {
    public String pay(){
        String pay = "Stripe Payment";
        System.out.println("Payment Through : " + pay);
        return pay;
    }
}

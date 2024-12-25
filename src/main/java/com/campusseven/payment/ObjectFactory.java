package com.campusseven.payment;

public class ObjectFactory {
    public PaymentService paymentService() {
        return new PaymentService(new SimpleExRateProvider());
    }
}

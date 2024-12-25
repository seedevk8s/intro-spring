package com.campusseven;

import com.campusseven.payment.Payment;
import com.campusseven.payment.PaymentService;
import com.campusseven.payment.SimpleExRateProvider;

import java.io.IOException;
import java.math.BigDecimal;

public class Client {
    public static void main(String[] args) throws IOException {
        //PaymentService paymentService = new WebApiExRatePaymentService();
        PaymentService paymentService = new PaymentService();
        Payment payment = paymentService.prepare(100L,"USD", BigDecimal.valueOf(50.7));
        System.out.println(payment);
    }
}

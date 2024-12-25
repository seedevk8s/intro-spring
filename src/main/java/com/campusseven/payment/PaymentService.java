package com.campusseven.payment;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class PaymentService {
    //private final WebApiExRateProvider exRateProvider;
    private final SimpleExRateProvider exRateProvider;

    public PaymentService() {
        //this.exRateProvider = new WebApiExRateProvider();
        this.exRateProvider = new SimpleExRateProvider();
    }

    public Payment prepare(Long orderId, String currency, BigDecimal foreignCurrencyAmount) throws IOException {
        //BigDecimal exRate = exRateProvider.getWebExRate(currency);
        BigDecimal exRate = exRateProvider.getExRate(currency);
        // 금액 계산
        BigDecimal convertedAmount = foreignCurrencyAmount.multiply(exRate);
        // 유효 시간 계산
        LocalDateTime validUntil = LocalDateTime.now().plusMinutes(30);

        return new Payment(orderId, currency, foreignCurrencyAmount, exRate, convertedAmount, validUntil);
    }

}

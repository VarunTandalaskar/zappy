package com.corp.zappy.payment.processor.strategy;

import com.corp.zappy.payment.processor.PaymentProcessor;
import com.corp.zappy.payment.processor.dto.PaymentProcessorRequest;
import com.corp.zappy.payment.processor.dto.PaymentProcessorResponse;

public class CardPaymentProcessor implements PaymentProcessor {
    @Override
    public PaymentProcessorResponse charge(PaymentProcessorRequest request) {
        return null;
    }
}

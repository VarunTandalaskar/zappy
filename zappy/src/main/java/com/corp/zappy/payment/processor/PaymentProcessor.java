package com.corp.zappy.payment.processor;

import com.corp.zappy.payment.processor.dto.PaymentProcessorRequest;
import com.corp.zappy.payment.processor.dto.PaymentProcessorResponse;

public interface PaymentProcessor {
    PaymentProcessorResponse charge(PaymentProcessorRequest request);
}

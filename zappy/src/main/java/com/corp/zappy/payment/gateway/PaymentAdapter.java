package com.corp.zappy.payment.gateway;

import com.corp.zappy.payment.gateway.dto.PaymentRequest;
import com.corp.zappy.payment.gateway.dto.PaymentResult;

import java.util.UUID;

public interface PaymentAdapter {

    PaymentResult initiate(PaymentRequest request);
    PaymentResult capture(UUID paymentId);

}

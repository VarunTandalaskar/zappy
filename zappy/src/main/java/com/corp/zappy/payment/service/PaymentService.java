package com.corp.zappy.payment.service;

import com.corp.zappy.payment.dto.request.PaymentInitRequest;
import com.corp.zappy.payment.dto.response.PaymentResponse;

import java.util.UUID;

public interface PaymentService {
    PaymentResponse initiate(UUID merchantId, PaymentInitRequest request);
}

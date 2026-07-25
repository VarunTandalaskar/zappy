package com.corp.zappy.vault.service;

import com.corp.zappy.common.entity.Money;
import com.corp.zappy.payment.processor.dto.PaymentProcessorResponse;
import com.corp.zappy.vault.dto.request.TokenizeRequest;
import com.corp.zappy.vault.dto.response.TokenizeResponse;

import java.util.Map;
import java.util.UUID;

public interface VaultService {
    TokenizeResponse tokenize(TokenizeRequest request, UUID merchantId);

    PaymentProcessorResponse charge(UUID paymentId, String token, Money amount, Map<String, Object> methodDetails);
}

package com.corp.zappy.payment.gateway.adapter;

import com.corp.zappy.payment.gateway.PaymentAdapter;
import com.corp.zappy.payment.gateway.dto.PaymentRequest;
import com.corp.zappy.payment.gateway.dto.PaymentResult;

public class NetBankingAdapter implements PaymentAdapter {
    @Override
    public PaymentResult initiate(PaymentRequest request) {
        return null;
    }
}

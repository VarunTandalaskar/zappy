package com.corp.zappy.payment.service;

import com.corp.zappy.payment.dto.request.CreateOrderRequest;
import com.corp.zappy.payment.dto.response.OrderResponse;
import com.corp.zappy.payment.dto.response.PaymentResponse;

import java.util.List;
import java.util.UUID;

public interface OrderService {
    OrderResponse create(UUID merchantId, CreateOrderRequest request);
    OrderResponse getById(UUID merchantId, UUID orderId);
    OrderResponse cancel(UUID merchantId, UUID orderId);
    List<PaymentResponse> listPayments(UUID merchantId, UUID orderId);

}

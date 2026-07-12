package com.corp.zappy.payment.mapper;

import com.corp.zappy.payment.dto.response.PaymentResponse;
import com.corp.zappy.payment.entity.Payment;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.mapstruct.Mapping;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public interface PaymentMapper {
    @Mapping(target = "orderId", source = "order.id")
    PaymentResponse toResponse(Payment payment);

    @Mapping(target = "orderId", source = "order.id")
    List<PaymentResponse> toResponseList(List<Payment> paymentList);
}

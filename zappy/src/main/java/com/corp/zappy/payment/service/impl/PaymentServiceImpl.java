package com.corp.zappy.payment.service.impl;

import com.corp.zappy.common.enums.OrderStatus;
import com.corp.zappy.common.enums.PaymentStatus;
import com.corp.zappy.common.exception.BusinessRuleViolationException;
import com.corp.zappy.common.exception.ResourceNotFoundException;
import com.corp.zappy.payment.dto.request.PaymentInitRequest;
import com.corp.zappy.payment.dto.response.PaymentResponse;
import com.corp.zappy.payment.entity.OrderRecord;
import com.corp.zappy.payment.entity.Payment;
import com.corp.zappy.payment.gateway.PaymentGatewayRouter;
import com.corp.zappy.payment.gateway.dto.PaymentRequest;
import com.corp.zappy.payment.gateway.dto.PaymentResult;
import com.corp.zappy.payment.mapper.PaymentMapper;
import com.corp.zappy.payment.repository.OrderRepository;
import com.corp.zappy.payment.repository.PaymentRepository;
import com.corp.zappy.payment.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final OrderRepository orderRepository;
    private final PaymentRepository paymentRepository;
    private final PaymentGatewayRouter paymentGatewayRouter;
    private final PaymentMapper paymentMapper;

    @Override
    public PaymentResponse initiate(UUID merchantId, PaymentInitRequest request) {
        OrderRecord orderRecord = orderRepository.findByIdAndMerchantId(request.orderId(), merchantId)
                .orElseThrow(() -> new ResourceNotFoundException("Order", request.orderId()));

        if (orderRecord.getOrderStatus() != OrderStatus.CREATED && orderRecord.getOrderStatus() != OrderStatus.ATTEMPTED){
            throw new BusinessRuleViolationException("ORDER_NOT_PAYABLE",
                    "Order cannot accept payment in status: " + orderRecord.getOrderStatus());
        }

        orderRecord.setOrderStatus(OrderStatus.ATTEMPTED);
        orderRecord.setAttempts(orderRecord.getAttempts() + 1);

        Payment payment = Payment.builder()
                .order(orderRecord)
                .merchantId(merchantId)
                .amount(orderRecord.getAmount())
                .status(PaymentStatus.CREATED)
                .method(request.method())
                .methodDetails(request.methodDetails())
                .build();

        payment = paymentRepository.save(payment);

        PaymentRequest paymentRequest = new PaymentRequest(payment.getId(),
                request.orderId(), merchantId, payment.getAmount(),
                payment.getMethod(),
                payment.getMethodDetails());

        PaymentResult result = paymentGatewayRouter.initiate(paymentRequest);

        switch (result) {
            case PaymentResult.Pending pending -> payment.setProcessorReference(pending.registrationRef());
            case PaymentResult.Failure failure -> {
                payment.setStatus(PaymentStatus.FAILED);
                payment.setErrorCode(failure.errorCode());
                payment.setErrorDescription(failure.errorDescription());
            }

        }

        payment = paymentRepository.save(payment);
        orderRepository.save(orderRecord);

        return paymentMapper.toResponse(payment);
    }
}

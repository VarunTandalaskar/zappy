package com.corp.zappy.payment.gateway;

import com.corp.zappy.common.enums.PaymentMethod;
import com.corp.zappy.payment.gateway.dto.PaymentRequest;
import com.corp.zappy.payment.gateway.dto.PaymentResult;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@RequiredArgsConstructor
public class PaymentGatewayRouter {

    private final Map<PaymentMethod, PaymentAdapter> paymentAdapterMap;

    public PaymentResult initiate(PaymentRequest request) {
        PaymentAdapter adapter = paymentAdapterMap.get(request.method());
        if (adapter == null) {
            throw new IllegalArgumentException("No payment adapter registered for method: "+request.method());
        }
        return adapter.initiate(request);
    }
}

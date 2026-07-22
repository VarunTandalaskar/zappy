package com.corp.zappy.payment.config;

import com.corp.zappy.common.enums.PaymentMethod;
import com.corp.zappy.payment.processor.PaymentProcessor;
import com.corp.zappy.payment.processor.strategy.CardPaymentProcessor;
import com.corp.zappy.payment.processor.strategy.NetBankingPaymentProcessor;
import com.corp.zappy.payment.processor.strategy.UpiPaymentProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
public class PaymentProcessorConfig {

    @Bean
    public Map<PaymentMethod, PaymentProcessor> paymentProcessorMap() {
        return Map.of(
                PaymentMethod.CARD, new CardPaymentProcessor(),
                PaymentMethod.NETBANKING, new NetBankingPaymentProcessor(),
                PaymentMethod.UPI, new UpiPaymentProcessor()
        );
    }
}

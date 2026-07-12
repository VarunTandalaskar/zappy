package com.corp.zappy.payment.repository;

import com.corp.zappy.payment.entity.OrderRecord;
import com.corp.zappy.payment.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface PaymentRepository extends JpaRepository<Payment, UUID> {

    List<Payment> findByOrder_Id(OrderRecord order);
}

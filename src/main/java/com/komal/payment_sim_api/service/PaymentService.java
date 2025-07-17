package com.komal.payment_sim_api.service;

import com.komal.payment_sim_api.model.PaymentRequest;
import com.komal.payment_sim_api.model.PaymentResponse;
import org.springframework.stereotype.Service;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

@Service
public class PaymentService {
    private final Map<String, PaymentResponse> transactionStore = new ConcurrentHashMap<>();

    public PaymentResponse processPayment(PaymentRequest request) {
        // Generate fake transaction ID

        String txnId = UUID.randomUUID().toString().substring(0, 10);
        Random random = new Random();
        boolean approved = random.nextBoolean();

        String status = approved ? "APPROVED" : "DECLINED";
        String message = approved ? "Payment processed successfully" : "Payment declined by bank";
        // Return APPROVED response always for now
        PaymentResponse response = new PaymentResponse(status, txnId, message);
        transactionStore.put(txnId, response); // store response

        return response;
    }

    public PaymentResponse getTransaction(String transactionId) {
        return transactionStore.get(transactionId);
    }
}

package com.komal.payment_sim_api.controller;

import com.komal.payment_sim_api.model.PaymentRequest;
import com.komal.payment_sim_api.model.PaymentResponse;
import com.komal.payment_sim_api.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;


@RestController
@RequestMapping("/api")
@Validated
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @PostMapping("/payment")
    public ResponseEntity<PaymentResponse> processPayment(@Valid @RequestBody PaymentRequest request) {
        PaymentResponse response = paymentService.processPayment(request);
        return ResponseEntity.ok(response);
    }
    @GetMapping("/payment/{transactionId}")
    public ResponseEntity<PaymentResponse> getTransaction(@PathVariable String transactionId) {
        PaymentResponse response = paymentService.getTransaction(transactionId);

        if (response == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(response);
    }
}

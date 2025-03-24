package com.example.payments.controller;

import com.example.payments.entity.Payment;
import com.example.payments.service.PaymentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/payments")
@RestController
public class PaymentRestController {

    private PaymentService paymentService;

    public PaymentRestController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping()
    public void createPayment(@RequestBody Payment payment) {
        paymentService.crearPayment(payment);
    }



}

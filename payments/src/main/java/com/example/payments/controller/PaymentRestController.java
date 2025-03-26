package com.example.payments.controller;

import com.example.payments.entity.Payment;
import com.example.payments.service.PaymentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/payments")
@RestController
public class PaymentRestController {

    Logger logger = LoggerFactory.getLogger(PaymentRestController.class);

    private PaymentService paymentService;

    public PaymentRestController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping("/{id}")
    public Payment getPaymentById(String id){
        logger.info("getPaymentById " + id);
        return new Payment(id, 50.0f, "id2", "id3");
    }

    @PostMapping()
    public void createPayment(@RequestBody Payment payment) {
        paymentService.crearPayment(payment);
    }



}

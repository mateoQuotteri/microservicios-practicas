package com.example.payments.client;

import com.example.payments.entity.Payment;
import org.springframework.stereotype.Service;

@Service
public class PaymentClient {
    public Boolean createPayment(Payment payment) {
        //ejecuta una llamada a un servicio externo para crear el pago
        return true;
    }
}

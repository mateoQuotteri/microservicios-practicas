package com.checkout_service.controllers;

import com.checkout_service.entity.Checkout;
import com.checkout_service.services.ICheckoutService;
import com.checkout_service.services.impl.CheckoutService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value="/checkout")
public class CheckoutController {
    private final ICheckoutService checkoutService;
    private final Logger logger = LoggerFactory.getLogger(CheckoutController.class);

    public CheckoutController(CheckoutService checkoutService) {
        this.checkoutService = checkoutService;
    }

    @GetMapping
    public Checkout getCheckout(
            @RequestParam List<String> productIds,
            @RequestHeader(value = "X-Request-from", required = false) String requestFrom,
            @RequestHeader Map<String, String> headers)
    {
        System.out.println("Request from: " + requestFrom);
        return checkoutService.buildCheckout(productIds);
        // Sin try-catch, permitimos que el Circuit Breaker haga su trabajo
    }

    @GetMapping("/{id}")
    public Checkout getCheckoutById(@PathVariable String id) {
        return new Checkout(id);
    }
}
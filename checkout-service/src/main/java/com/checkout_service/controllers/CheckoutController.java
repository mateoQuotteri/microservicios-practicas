package com.checkout_service.controllers;

import com.checkout_service.entity.Checkout;
import com.checkout_service.services.ICheckoutService;
import com.checkout_service.services.impl.CheckoutService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping(value="/checkout")
public class CheckoutController {
    private final ICheckoutService checkoutService;


    public CheckoutController(CheckoutService checkoutService) {
        this.checkoutService = checkoutService;
    }

    @GetMapping
    public Checkout getCheckout(@RequestParam List<String> productIds, @RequestHeader("X-Request-from") String requestFrom, @RequestHeader()Map<String, String> headers) {
        System.out.println("Request from: " + requestFrom);
        //if (!requestFrom.equals("gateway")) {
       // return null;
       // }
        return checkoutService.buildCheckout(productIds);
    }

    @GetMapping("/{id}")
    public Checkout getCheckoutById(@PathVariable String id ) {
        return new Checkout(id);
    }
}
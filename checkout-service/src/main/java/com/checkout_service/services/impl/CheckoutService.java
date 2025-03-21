package com.checkout_service.services.impl;

import com.checkout_service.entity.Checkout;
import com.checkout_service.entity.Product;
import com.checkout_service.services.ICheckoutService;
import com.checkout_service.services.IProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CheckoutService implements ICheckoutService {
    private final IProductService productService;
    private final Logger logger = LoggerFactory.getLogger(CheckoutService.class);

    public CheckoutService(IProductService productService) {
        this.productService = productService;
    }

    @Override
    public Checkout buildCheckout(List<String> productsId) {
        Double total = 0.0;
        List<Product> products = new ArrayList<>();

        for(String id: productsId) {
            Product product = productService.getProduct(id);
            products.add(product);

            if (product.getPrecio() != null) {
                total += product.getPrecio();
            }
        }

        return new Checkout("234", "www.compraca.com", total.toString(), List.of("credit_card", "cash"));
    }
}
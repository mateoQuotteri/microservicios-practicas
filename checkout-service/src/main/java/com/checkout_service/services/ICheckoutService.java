package com.checkout_service.services;


import com.checkout_service.entity.Checkout;

import java.util.List;

public interface ICheckoutService {
    public Checkout buildCheckout(List<String> productsId);
}

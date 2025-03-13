package com.checkout_service.services;


import com.checkout_service.entity.Checkout;
import com.checkout_service.entity.Product;

import java.util.List;

public interface IProductService {

    public Product getProduct(String id);

}

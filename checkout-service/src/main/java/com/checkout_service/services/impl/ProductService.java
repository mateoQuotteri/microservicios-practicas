package com.checkout_service.services.impl;

import com.checkout_service.entity.Product;
import com.checkout_service.repository.FeignProductRepository;
import com.checkout_service.services.IProductService;
import org.springframework.stereotype.Service;


@Service
public class ProductService implements IProductService {

    private final FeignProductRepository feignProductRepository;

    public ProductService(FeignProductRepository feignProductRepository) {
        this.feignProductRepository = feignProductRepository;
    }

    @Override
    public Product getProduct(String id) {
        return feignProductRepository.getProductById(id);
    }
}

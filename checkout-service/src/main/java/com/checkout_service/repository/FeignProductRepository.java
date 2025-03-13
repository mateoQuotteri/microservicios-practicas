package com.checkout_service.repository;

import com.checkout_service.entity.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
@FeignClient(name="products-service", url="http://localhost:8080")
public interface FeignProductRepository {
    @GetMapping("/products")
    Product getProductById(@RequestParam String id);
}
package com.products.products_service.controllers;

import com.products.products_service.entity.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/products")
public class ProductRestController {


    @GetMapping()
    public Product getProduct(@RequestParam String id, @RequestParam() Boolean throwError){
        if (throwError){
            throw new RuntimeException("Error");
        }

        return new Product(id, "computadora", 20000.2);


    }
}

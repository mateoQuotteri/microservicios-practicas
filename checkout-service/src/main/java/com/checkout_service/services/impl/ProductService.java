package com.checkout_service.services.impl;

import com.checkout_service.entity.Product;
import com.checkout_service.repository.FeignProductRepository;
import com.checkout_service.services.IProductService;
import io.github.resilience4j.circuitbreaker.CallNotPermittedException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


@Service
public class ProductService implements IProductService {

    private final FeignProductRepository feignProductRepository;
    Logger logger =  LoggerFactory.getLogger(ProductService.class);

    public ProductService(FeignProductRepository feignProductRepository) {
        this.feignProductRepository = feignProductRepository;
    }

    @Override
    @CircuitBreaker(name = "product", fallbackMethod = "methodGetProductFallback")
    public Product getProduct(String id) {
        logger.info("Obteniendo producto con id: {}", id);
        return feignProductRepository.getProductById(id, true);
        // Deja que la excepción se propague naturalmente
    }

    public Product methodGetProductFallback(String id, Throwable ex) {
        logger.error("Fallback activado. Tipo de excepción: {}, Mensaje: {}",
                ex.getClass().getName(), ex.getMessage());
        return new Product();
    }
    public Product methodGetProductFallback(String id, feign.FeignException ex) {
        logger.error("Fallback activado para FeignException. Tipo: {}, Código: {}, Mensaje: {}",
                ex.getClass().getSimpleName(), ex.status(), ex.getMessage());
        return new Product("fallback-" + id, "Producto de respaldo", 0.0);
    }

}

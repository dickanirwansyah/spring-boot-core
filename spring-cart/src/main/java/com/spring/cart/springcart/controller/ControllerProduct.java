package com.spring.cart.springcart.controller;

import com.spring.cart.springcart.entity.Product;
import com.spring.cart.springcart.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Optional;

@RestController
@RequestMapping(value = "/api/product")
public class ControllerProduct {

    @Autowired
    private ProductService productService;

    @PostMapping(value = "/create")
    public Mono<Product> created(@RequestBody Product product){
        return productService.createdProduct(product);
    }

    @GetMapping(value = "/list")
    public Flux<Product> listProduct(){
        return productService.listProduct();
    }
}

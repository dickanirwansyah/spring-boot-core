package com.spring.cart.springcart.service;

import com.spring.cart.springcart.entity.Product;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductService {

    Mono<Product> createdProduct(Product product);

    Flux<Product> listProduct();
}

package com.spring.cart.springcart.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.spring.cart.springcart.entity.Product;

public interface ProductRepository extends ReactiveMongoRepository<Product, String>{

}

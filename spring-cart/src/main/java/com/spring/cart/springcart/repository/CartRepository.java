package com.spring.cart.springcart.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.spring.cart.springcart.entity.Cart;
import com.spring.cart.springcart.entity.Product;

public interface CartRepository extends ReactiveMongoRepository<Cart, String>{

}

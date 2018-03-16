package com.spring.cart.springcart.service;

import com.spring.cart.springcart.entity.Product;
import com.spring.cart.springcart.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Transactional
@Repository
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Mono<Product> createdProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Flux<Product> listProduct() {
        return productRepository.findAll();
    }


}

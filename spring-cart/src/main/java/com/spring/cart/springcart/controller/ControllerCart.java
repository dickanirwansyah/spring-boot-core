package com.spring.cart.springcart.controller;

import com.spring.cart.springcart.entity.Cart;
import com.spring.cart.springcart.request.*;
import com.spring.cart.springcart.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api/cart")
public class ControllerCart {

    @Autowired
    private CartService cartService;

    @PostMapping("/create")
    public Mono<Cart> createCart(@Valid @RequestBody CreateCartRequest request){
        return cartService.createdCart(request);
    }

    @PostMapping(value = "/detail")
    public Mono<Cart> cartDetail(@Valid @RequestBody GetCartDetailRequest request){
        return cartService.cartDetail(request);
    }

    @PostMapping(value = "/add")
    public Mono<Cart> addProductToCart(@Valid @RequestBody AddProductToCartRequest request){
        return cartService.addProductToCart(request);
    }

    @PostMapping(value = "/update")
    public Mono<Cart> updateProductToCart(@Valid @RequestBody UpdateProductInCartRequest request){
        return cartService.updateProductInCart(request);
    }

    @PostMapping(value = "/delete")
    public Mono<Cart> deleteProductFromCart(@Valid @RequestBody DeleteProductInCartRequest request){
        return cartService.deleteProductInCart(request);
    }
}

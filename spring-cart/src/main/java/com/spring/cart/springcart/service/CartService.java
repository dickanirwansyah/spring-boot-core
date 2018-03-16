package com.spring.cart.springcart.service;

import com.spring.cart.springcart.entity.Cart;
import com.spring.cart.springcart.request.AddProductToCartRequest;
import com.spring.cart.springcart.request.CreateCartRequest;
import com.spring.cart.springcart.request.DeleteProductInCartRequest;
import com.spring.cart.springcart.request.GetCartDetailRequest;
import com.spring.cart.springcart.request.UpdateProductInCartRequest;

import reactor.core.publisher.Mono;

public interface CartService {
	
	Mono<Cart> createdCart(CreateCartRequest request);
	
	Mono<Cart> addProductToCart(AddProductToCartRequest request);
	
	Mono<Cart> cartDetail(GetCartDetailRequest request);
	
	Mono<Cart> updateProductInCart(UpdateProductInCartRequest request);
	
	Mono<Cart> deleteProductInCart(DeleteProductInCartRequest request);
}

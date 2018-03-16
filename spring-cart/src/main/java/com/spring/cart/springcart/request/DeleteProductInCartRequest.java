package com.spring.cart.springcart.request;

import com.spring.cart.springcart.validation.CartMustExist;
import com.spring.cart.springcart.validation.ProductMustExist;
import com.spring.cart.springcart.validation.ProductMustInCart;

public class DeleteProductInCartRequest {
	
	@CartMustExist
	private String cartId;
	
	@ProductMustInCart
	@ProductMustExist
	private String productId;
	
	public String getCartId() {
		return cartId;
	}
	
	public String getProductId() {
		return productId;
	}
}

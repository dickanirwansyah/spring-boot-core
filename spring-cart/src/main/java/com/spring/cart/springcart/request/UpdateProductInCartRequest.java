package com.spring.cart.springcart.request;

import javax.validation.constraints.NotNull;

import com.spring.cart.springcart.validation.CartMustExist;
import com.spring.cart.springcart.validation.ProductMustExist;
import com.spring.cart.springcart.validation.ProductMustInCart;

public class UpdateProductInCartRequest {

	@CartMustExist
	private String cartId;
	
	@ProductMustExist
	@ProductMustInCart
	private String productId;
	
	@NotNull
	private Integer quantity;
	
	public String getCartId() {
		return cartId;
	}
	
	public String getProductId() {
		return productId;
	}
	
	public Integer getQuantity() {
		return quantity;
	}
}

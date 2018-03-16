package com.spring.cart.springcart.request;

import com.spring.cart.springcart.validation.CartMustExist;

public class GetCartDetailRequest {
	
	@CartMustExist
	private String cartId;

	public String getCartId() {
		return cartId;
	}
}

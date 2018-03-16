package com.spring.cart.springcart.request;

import com.spring.cart.springcart.validation.CartMustNotExist;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateCartRequest {

	@CartMustNotExist
	private String cartId;

	public String getCartId() {
		return cartId;
	}
}

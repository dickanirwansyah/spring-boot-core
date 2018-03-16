package com.spring.cart.springcart.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.spring.cart.springcart.entity.Cart;
import com.spring.cart.springcart.repository.CartRepository;
import com.spring.cart.springcart.validation.ProductMustInCart;
import com.spring.cart.springcart.validation.ProductMustInCart.ProductInCart;

public class ProductMustInCartValidator implements ConstraintValidator<ProductMustInCart, ProductMustInCart.ProductInCart>{

	@Autowired
	private CartRepository cartrepository;
	
	@Override
	public void initialize(ProductMustInCart constraintAnnotation) {
		
	}
	
	@Override
	public boolean isValid(ProductInCart value, ConstraintValidatorContext context) {
		if(value == null) {
			return true;
		}
		
		Cart cart = cartrepository.findById(value.getCartId()).block();
		if(cart == null) {
			return true;
		}
		
		if(cart.getItems() == null || cart.getItems().isEmpty()) {
			return false;
		}
		
		return cart.getItems().stream()
				.anyMatch(cartItem -> cartItem.getId().equals(value.getProductId()));
	}

}

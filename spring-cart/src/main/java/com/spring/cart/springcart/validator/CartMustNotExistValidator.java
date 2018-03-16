package com.spring.cart.springcart.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.spring.cart.springcart.repository.CartRepository;
import com.spring.cart.springcart.validation.CartMustNotExist;

public class CartMustNotExistValidator implements ConstraintValidator<CartMustNotExist, String>{
	
	@Autowired
	private CartRepository cartRepository;

	@Override
	public void initialize(CartMustNotExist contsraintAnnotation) {
		
	}
	
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if(value == null) {
			return true;
		}
		return !cartRepository.existsById(value).block();
	}
	
	
}

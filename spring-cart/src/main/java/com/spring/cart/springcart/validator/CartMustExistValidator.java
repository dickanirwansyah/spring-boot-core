package com.spring.cart.springcart.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.spring.cart.springcart.repository.CartRepository;
import com.spring.cart.springcart.validation.CartMustExist;

public class CartMustExistValidator implements ConstraintValidator<CartMustExist, String>{

	@Autowired 
	private CartRepository cartrepository;
	
	@Override
	public void initialize(CartMustExist constraintAnnotation) {
		
	}
	
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if(value == null) {
			return true;
		}
		return cartrepository.existsById(value).block();
	}
	
	
}

package com.spring.cart.springcart.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.spring.cart.springcart.repository.ProductRepository;
import com.spring.cart.springcart.validation.ProductMustExist;

public class ProductMustExistValidator implements ConstraintValidator<ProductMustExist, String>{

	@Autowired
	private ProductRepository productrepository;
	
	@Override
	public void initialize(ProductMustExist constraintAnnotation) {
		
	}
	
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if(value == null) {
			return true;
		}
		return productrepository.existsById(value).block();
	}

}

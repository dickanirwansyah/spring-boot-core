package com.spring.cart.springcart.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spring.cart.springcart.entity.Product;
import com.spring.cart.springcart.repository.ProductRepository;
import com.spring.cart.springcart.validation.ProductQuantityMustEnough;
import com.spring.cart.springcart.validation.ProductQuantityMustEnough.ProductQuantity;

@Component
public class ProductQuantityMustEnoughValidator implements 
ConstraintValidator<ProductQuantityMustEnough, ProductQuantityMustEnough.ProductQuantity>{
	
	@Autowired
	private ProductRepository productrepository;
	
	@Override
	public void initialize(ProductQuantityMustEnough constraintAnnotation) {
		
	}

	@Override
	public boolean isValid(ProductQuantity value, ConstraintValidatorContext context) {
		
		if(value == null || value.getProductId() == null || value.getQuantity() == null) {
			return true;
		}
		
		Product product = productrepository.findById(value.getProductId()).block();
		
		if(isProductNotExist(product)) {
			return true;
		}
		
		return isStockEnough(product, value.getQuantity());
		
	}
	
	private boolean isProductNotExist(Product product) {
		return product == null;
	}
	
	private boolean isStockEnough(Product product, Integer quantity) {
		return product.getStock() >= quantity;
	}

}

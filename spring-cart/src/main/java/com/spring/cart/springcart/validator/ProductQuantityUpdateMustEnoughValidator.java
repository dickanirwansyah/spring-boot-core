package com.spring.cart.springcart.validator;

import java.util.Optional;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spring.cart.springcart.entity.Cart;
import com.spring.cart.springcart.entity.CartItem;
import com.spring.cart.springcart.entity.Product;
import com.spring.cart.springcart.repository.CartRepository;
import com.spring.cart.springcart.repository.ProductRepository;
import com.spring.cart.springcart.validation.ProductQuantityMustEnough;
import com.spring.cart.springcart.validation.ProductQuantityMustEnough.ProductQuantityUpdate;

@Component
public class ProductQuantityUpdateMustEnoughValidator 
implements ConstraintValidator<ProductQuantityMustEnough, ProductQuantityMustEnough.ProductQuantityUpdate>{

	@Autowired
	private ProductRepository productrepository;
	
	@Autowired
	private CartRepository cartrepository;
	
	@Override
	public void initialize(ProductQuantityMustEnough constraintAnnotation) {
		
	}
	
	@Override
	public boolean isValid(ProductQuantityUpdate value, ConstraintValidatorContext context) {
		if(value == null || value.getProductId() == null || value.getQuantity() == null) {
			return true;
		}
		
		Cart cart = cartrepository.findById(value.getCartId()).block();
		
		if(cart == null || cart.getItems() == null || cart.getItems().isEmpty()) {
			return true;
		}
		
		Optional<CartItem> cartItemOptional = getCartItemByProductId(cart, value.getProductId());
		
		if(!cartItemOptional.isPresent()) {
			return true;
		}
		
		Product product = productrepository.findById(value.getProductId()).block();
		
		if(product == null) {
			return false;
		}
		
		if(product.getStock() < value.getQuantity()) {
			return false;
		}
		
		return product.getStock() >= (cartItemOptional.get().getQuantity() + value.getQuantity());
	}
	
	private Optional<CartItem> getCartItemByProductId(Cart cart, String productId){
		return cart.getItems().stream()
				.filter(cartItem -> cartItem.getId().equals(productId))
				.findFirst();
	}

}

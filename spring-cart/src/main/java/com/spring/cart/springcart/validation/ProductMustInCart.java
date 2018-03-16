package com.spring.cart.springcart.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.spring.cart.springcart.validator.ProductMustInCartValidator;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({TYPE, ANNOTATION_TYPE, METHOD, FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = {
		ProductMustInCartValidator.class
})
@Documented
public @interface ProductMustInCart {

	String message() default "ProductMustInCart";
	
	Class<?>[] group() default {};
	
	Class<? extends Payload>[] payload() default {};
	
	String[] path() default {};
	
	interface ProductInCart{
		
		String getCartId();
		
		String getProductId();
	}
}

package com.spring.cart.springcart.validation;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.spring.cart.springcart.validator.CartMustNotExistValidator;

@Target({TYPE, ANNOTATION_TYPE, METHOD, FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = {CartMustNotExistValidator.class})
@Documented
public @interface CartMustNotExist {

	String message() default "CartMustNotExist";
	
	Class<?>[] groups() default {};
	
	Class<? extends Payload>[] payload() default{};
	
	String[] path() default{};
}

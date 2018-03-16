package com.spring.cart.springcart.validation;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.spring.cart.springcart.validator.CartMustExistValidator;

@Target({TYPE, METHOD, ANNOTATION_TYPE, FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = {CartMustExistValidator.class})
@Documented
public @interface CartMustExist {

	String message() default "CartMustExist";
	
	Class<?>[] groups() default {};
	
	Class<? extends Payload>[] payload() default{};
	
	String[] path() default{};
}

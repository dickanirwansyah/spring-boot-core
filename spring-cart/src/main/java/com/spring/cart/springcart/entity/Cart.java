package com.spring.cart.springcart.entity;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.Data;

@Data
@Document
@Builder
public class Cart {

	@Id
	private String id;
	private List<CartItem> items = new ArrayList<>();

;
	public List<CartItem> getItems(){
		if(items == null) {
			new ArrayList<>();
		}
		return items;
	}
}

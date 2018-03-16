package com.springboot.pattern.springbootpattern.model;

import com.springboot.pattern.springbootpattern.entity.Category;
import com.springboot.pattern.springbootpattern.entity.Product;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Data
public class ModelProduct {

    private String idproduct;
    private String name;
    private int quantity;
    private BigDecimal price;
    private Category category;


    public ModelProduct(Product product){
        this.idproduct = product.getIdproduct();
        this.name = product.getName();
        this.quantity = product.getQuantity();
        this.price = product.getPrice();
        this.category = product.getCategory();
    }

    public ModelProduct(String idproduct, String name, int quantity, BigDecimal price, Category category){
        this.idproduct = idproduct;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.category = category;
    }
}

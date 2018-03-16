package com.springboot.pattern.springbootpattern.dto;

import com.springboot.pattern.springbootpattern.entity.Category;
import com.springboot.pattern.springbootpattern.entity.Product;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Data
@Getter
@Setter
public class ProductDto {

    private String idproduct;
    private String name;
    private int quantity;
    private BigDecimal price;
    private Category category;
    private boolean valid = false;

    public ProductDto(){
        this.valid = true;
    }

    public ProductDto(Product product){
        this.idproduct = product.getIdproduct();
        this.name = product.getName();
        this.quantity = product.getQuantity();
        this.price = product.getPrice();
        this.category = product.getCategory();
    }
}

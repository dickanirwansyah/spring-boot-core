package com.springboot.pattern.springbootpattern.service;

import com.springboot.pattern.springbootpattern.dto.ProductDto;
import com.springboot.pattern.springbootpattern.entity.Product;
import com.springboot.pattern.springbootpattern.model.ModelProduct;

import java.util.List;

public interface ProductService {

    List<Product> getList();

    Product created(ProductDto productDto);

    Product updated(ProductDto productDto);

    ModelProduct getId(String idproduct);
}

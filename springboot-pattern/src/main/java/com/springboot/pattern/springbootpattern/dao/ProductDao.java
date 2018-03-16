package com.springboot.pattern.springbootpattern.dao;

import com.springboot.pattern.springbootpattern.dto.ProductDto;
import com.springboot.pattern.springbootpattern.entity.Product;
import com.springboot.pattern.springbootpattern.model.ModelProduct;

import java.util.List;

public interface ProductDao {

    List<Product> getList();

    Product getId(String idproduct);

    ModelProduct findId(String idproduct);

    Product created(ProductDto productDto);

    Product updated(ProductDto productDto);
}

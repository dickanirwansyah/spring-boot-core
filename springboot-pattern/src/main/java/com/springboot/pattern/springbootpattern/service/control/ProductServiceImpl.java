package com.springboot.pattern.springbootpattern.service.control;

import com.springboot.pattern.springbootpattern.dao.ProductDao;
import com.springboot.pattern.springbootpattern.dto.ProductDto;
import com.springboot.pattern.springbootpattern.entity.Product;
import com.springboot.pattern.springbootpattern.model.ModelProduct;
import com.springboot.pattern.springbootpattern.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductDao productDao;

    @Override
    public List<Product> getList() {
        return productDao.getList();
    }

    @Override
    public Product created(ProductDto productDto) {
        return productDao.created(productDto);
    }

    @Override
    public Product updated(ProductDto productDto) {
        return productDao.updated(productDto);
    }

    @Override
    public ModelProduct getId(String idproduct) {
        return productDao.findId(idproduct);
    }
}

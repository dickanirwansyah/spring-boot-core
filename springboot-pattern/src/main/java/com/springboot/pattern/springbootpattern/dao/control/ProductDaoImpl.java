package com.springboot.pattern.springbootpattern.dao.control;

import com.springboot.pattern.springbootpattern.dao.ProductDao;
import com.springboot.pattern.springbootpattern.dto.ProductDto;
import com.springboot.pattern.springbootpattern.entity.Product;
import com.springboot.pattern.springbootpattern.model.ModelProduct;
import com.springboot.pattern.springbootpattern.repository.RepositoryProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public class ProductDaoImpl implements ProductDao{

    @Autowired
    private RepositoryProduct repositoryProduct;

    @Override
    public List<Product> getList() {
        return repositoryProduct.findAll();
    }

    @Override
    public Product getId(String idproduct) {
        return repositoryProduct.getOne(idproduct);
    }

    @Override
    public ModelProduct findId(String idproduct) {
        Product product = this.getId(idproduct);
        if(idproduct == null){
            return null;
        }
        return new ModelProduct(product.getIdproduct(), product.getName(),
                product.getQuantity(), product.getPrice(), product.getCategory());
    }

    @Override
    public Product created(ProductDto productDto) {
        Product product = null;
        boolean valid = false;
        String idproduct = productDto.getIdproduct();
        if(idproduct == null){
            product = new Product();
            valid = true;
        }
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setQuantity(productDto.getQuantity());
        product.setCategory(productDto.getCategory());
        return repositoryProduct.save(product);
    }

    @Override
    public Product updated(ProductDto productDto) {
        Product product= null;
        boolean valid = false;
        String idproduct = productDto.getIdproduct();
        if(idproduct != null){
            product = this.getId(idproduct);
            valid = true;
        }
        product.setIdproduct(productDto.getIdproduct());
        product.setName(productDto.getName());
        product.setQuantity(productDto.getQuantity());
        product.setPrice(productDto.getPrice());
        product.setCategory(productDto.getCategory());
        return repositoryProduct.save(product);
    }
}

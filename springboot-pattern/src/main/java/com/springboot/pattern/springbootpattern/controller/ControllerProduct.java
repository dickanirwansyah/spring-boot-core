package com.springboot.pattern.springbootpattern.controller;

import com.springboot.pattern.springbootpattern.dto.ProductDto;
import com.springboot.pattern.springbootpattern.entity.Product;
import com.springboot.pattern.springbootpattern.model.ModelProduct;
import com.springboot.pattern.springbootpattern.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
public class ControllerProduct {

    @Autowired
    private ProductService productService;

    @GetMapping(value = "/api/product")
    public ResponseEntity<List<Product>> getList(){
        return Optional.ofNullable(productService.getList())
                .map(resultset -> new ResponseEntity<>(resultset, HttpStatus.OK))
                .orElse(new ResponseEntity<List<Product>>(HttpStatus.BAD_REQUEST));
    }

    @PostMapping(value = "/api/product/created")
    public ResponseEntity<Product> created(@RequestBody ProductDto productDto){
        return Optional.ofNullable(productService.created(productDto))
                .map(resultset -> new ResponseEntity<>(resultset, HttpStatus.CREATED))
                .orElse(new ResponseEntity<Product>(HttpStatus.BAD_REQUEST));
    }

    @PostMapping(value = "/api/product/updated")
    public ResponseEntity<Product> updated(@RequestBody ProductDto productDto){
        return Optional.ofNullable(productService.updated(productDto))
                .map(resultset -> new ResponseEntity<>(resultset, HttpStatus.OK))
                .orElse(new ResponseEntity<Product>(HttpStatus.BAD_REQUEST));
    }

    @GetMapping(value = "/api/product/{idproduct}")
    public ResponseEntity<ModelProduct> getId(@PathVariable String idproduct){
        return Optional.ofNullable(productService.getId(idproduct))
                .map(resultset -> new ResponseEntity<>(resultset, HttpStatus.OK))
                .orElse(new ResponseEntity<ModelProduct>(HttpStatus.BAD_REQUEST));
    }
}

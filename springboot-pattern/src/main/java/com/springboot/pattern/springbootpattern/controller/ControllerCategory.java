package com.springboot.pattern.springbootpattern.controller;

import com.springboot.pattern.springbootpattern.dto.CategoryDto;
import com.springboot.pattern.springbootpattern.entity.Category;
import com.springboot.pattern.springbootpattern.model.ModelCategory;
import com.springboot.pattern.springbootpattern.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ControllerCategory  {

    @Autowired
    private CategoryService categoryService;

    @GetMapping(value = "/api/category")
    public ResponseEntity<List<Category>> getList(){
        return Optional.ofNullable(categoryService.getList())
                .map(resultset -> new ResponseEntity<>(resultset, HttpStatus.OK))
                .orElse(new ResponseEntity<List<Category>>(HttpStatus.BAD_REQUEST));
    }

    @GetMapping(value = "/api/category/{idcategory}")
    public ResponseEntity<ModelCategory> getId(@PathVariable String idcategory){
        return Optional.ofNullable(categoryService.getOne(idcategory))
                .map(resultset -> new ResponseEntity<>(resultset, HttpStatus.OK))
                .orElse(new ResponseEntity<ModelCategory>(HttpStatus.BAD_REQUEST));
    }


    @PostMapping(value = "/api/category/create")
    public ResponseEntity<Category> created(@RequestBody CategoryDto categoryDto){
        return Optional.ofNullable(categoryService.created(categoryDto))
                .map(resultset -> new ResponseEntity<>(resultset, HttpStatus.CREATED))
                .orElse(new ResponseEntity<Category>(HttpStatus.BAD_REQUEST));
    }

    @PostMapping(value = "/api/category/updated")
    public ResponseEntity<Category> updated(@RequestBody CategoryDto categoryDto){
        return Optional.ofNullable(categoryService.updated(categoryDto))
                .map(resultset -> new ResponseEntity<>(resultset, HttpStatus.OK))
                .orElse(new ResponseEntity<Category>(HttpStatus.BAD_REQUEST));
    }
}

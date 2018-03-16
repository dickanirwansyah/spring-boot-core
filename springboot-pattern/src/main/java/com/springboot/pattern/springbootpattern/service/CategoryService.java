package com.springboot.pattern.springbootpattern.service;

import com.springboot.pattern.springbootpattern.dto.CategoryDto;
import com.springboot.pattern.springbootpattern.entity.Category;
import com.springboot.pattern.springbootpattern.model.ModelCategory;

import java.util.List;

public interface CategoryService {

    List<Category> getList();

    ModelCategory getOne(String idcategory);

    Category created(CategoryDto categoryDto);

    Category updated(CategoryDto categoryDto);

}

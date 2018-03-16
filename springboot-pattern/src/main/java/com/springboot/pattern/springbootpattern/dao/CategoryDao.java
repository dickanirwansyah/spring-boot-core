package com.springboot.pattern.springbootpattern.dao;

import com.springboot.pattern.springbootpattern.dto.CategoryDto;
import com.springboot.pattern.springbootpattern.entity.Category;
import com.springboot.pattern.springbootpattern.model.ModelCategory;

import java.util.List;

public interface CategoryDao {

    List<Category> getList();

    Category getId(String idcategory);

    ModelCategory getOne(String idcategory);

    Category created(CategoryDto categoryDto);

    Category updated(CategoryDto categoryDto);
}

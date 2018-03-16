package com.springboot.pattern.springbootpattern.service.control;

import com.springboot.pattern.springbootpattern.dao.CategoryDao;
import com.springboot.pattern.springbootpattern.dto.CategoryDto;
import com.springboot.pattern.springbootpattern.entity.Category;
import com.springboot.pattern.springbootpattern.model.ModelCategory;
import com.springboot.pattern.springbootpattern.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    private CategoryDao categoryDao;

    @Override
    public List<Category> getList() {
        return categoryDao.getList();
    }

    @Override
    public ModelCategory getOne(String idcategory) {
        return categoryDao.getOne(idcategory);
    }

    @Override
    public Category created(CategoryDto categoryDto) {
        return categoryDao.created(categoryDto);
    }

    @Override
    public Category updated(CategoryDto categoryDto) {
        return categoryDao.updated(categoryDto);
    }


}

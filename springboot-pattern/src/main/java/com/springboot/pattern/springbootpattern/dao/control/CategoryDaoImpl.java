package com.springboot.pattern.springbootpattern.dao.control;

import com.springboot.pattern.springbootpattern.dao.CategoryDao;
import com.springboot.pattern.springbootpattern.dto.CategoryDto;
import com.springboot.pattern.springbootpattern.entity.Category;
import com.springboot.pattern.springbootpattern.model.ModelCategory;
import com.springboot.pattern.springbootpattern.repository.RepositoryCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public class CategoryDaoImpl implements CategoryDao{

    @Autowired
    private RepositoryCategory repositoryCategory;

    @Override
    public List<Category> getList() {
        return repositoryCategory.findAll();
    }

    @Override
    public Category getId(String idcategory){
        return repositoryCategory.getOne(idcategory);
    }

    @Override
    public ModelCategory getOne(String idcategory){
        Category category = this.getId(idcategory);
        if(category == null){
            new Exception("400 Bad Request");
        }
        return new ModelCategory(category.getIdcategory(),
                category.getName(),
                category.getDescription());
    }

    @Override
    public Category created(CategoryDto categoryDto) {
        Category category = null;
        boolean valid = false;
        if(category == null){
            valid = true;
            category = new Category();
            category.setName(categoryDto.getName());
            category.setDescription(categoryDto.getDescription());
            repositoryCategory.save(category);
        }
        return category;
    }

    @Override
    public Category updated(CategoryDto categoryDto) {
        String idcategory = categoryDto.getIdcategory();
        boolean valid = false;
        Category category = null;
        if(idcategory!=null){
            valid = true;
            category = this.getId(idcategory);
        }
        category.setIdcategory(categoryDto.getIdcategory());
        category.setName(categoryDto.getName());
        category.setDescription(categoryDto.getDescription());
        return repositoryCategory.save(category);
    }

}

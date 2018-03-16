package com.springboot.pattern.springbootpattern.model;

import com.springboot.pattern.springbootpattern.entity.Category;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class ModelCategory {

    private String idcategory;
    private String name;
    private String description;

    public ModelCategory(Category category){
        this.idcategory = category.getIdcategory();
        this.name = category.getName();
        this.description = category.getDescription();
    }

    public ModelCategory(String idcategory, String name, String description){
        this.idcategory = idcategory;
        this.name = name;
        this.description = description;
    }


}

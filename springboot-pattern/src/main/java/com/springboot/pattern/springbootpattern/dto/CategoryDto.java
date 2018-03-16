package com.springboot.pattern.springbootpattern.dto;

import com.springboot.pattern.springbootpattern.entity.Category;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class CategoryDto {

    private String idcategory;
    private String name;
    private String description;
    private boolean validated = false;

    public CategoryDto(){
        this.validated = true;
    }

    public CategoryDto(Category category){
        this.idcategory = category.getIdcategory();
        this.name = category.getName();
        this.description = category.getDescription();
    }
}

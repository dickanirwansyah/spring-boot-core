package com.springboot.pattern.springbootpattern.repository;

import com.springboot.pattern.springbootpattern.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryCategory extends JpaRepository<Category, String>{
}

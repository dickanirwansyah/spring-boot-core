package com.springboot.pattern.springbootpattern.repository;

import com.springboot.pattern.springbootpattern.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryProduct extends JpaRepository<Product, String> {
}

package com.BlogAppApis.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.BlogAppApis.model.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer> {

}

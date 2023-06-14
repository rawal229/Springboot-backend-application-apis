package com.BlogAppApis.service;

import java.util.List;

import com.BlogAppApis.payload.CategoryDto;

public interface CategoryService {

    CategoryDto createCategory(CategoryDto categoryDto);

    // update
    CategoryDto updateCategry(CategoryDto categoryDto, Integer categoryId);

    // delete
    void deleteCategory(Integer categoryId);

    // get
    CategoryDto getCategory(Integer categoryId);

    // get all
    List<CategoryDto> getAllCategory();
}

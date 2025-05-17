package com.example.Datilera.service.category;

import java.util.List;

import com.example.Datilera.dto.category.CategoryCreateDto;
import com.example.Datilera.dto.category.CategoryDto;

public interface CategoryService {
    CategoryDto createCategory(CategoryCreateDto categoryCreateDto);
    CategoryDto getCategoryById(Long id);
    List<CategoryDto> getAllCategories();
    void deleteCategory(Long id);
    CategoryDto updateCategory(Long id, CategoryCreateDto categoryCreateDto);
}

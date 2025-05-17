package com.example.datilera.service.category;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.datilera.domain.Category;
import com.example.datilera.dto.category.CategoryCreateDto;
import com.example.datilera.dto.category.CategoryDto;
import com.example.datilera.exceptions.ResourceNotFoundException;
import com.example.datilera.mapper.category.CategoryMapper;
import com.example.datilera.repository.CategoryRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private CategoryMapper categoryMapper;
    private CategoryRepository categoryRepository;

    @Override
    public CategoryDto createCategory(CategoryCreateDto categoryCreateDto) {
        Category categoryCreated = categoryMapper.categoryCreateDtoToCategory(categoryCreateDto);
        return categoryMapper.categoryToCategoryDto(categoryRepository.save(categoryCreated));
    }

    @Override
    public CategoryDto getCategoryById(Long id) {
        return categoryMapper.categoryToCategoryDto(categoryRepository.findById(id).orElseThrow(() 
                    -> new ResourceNotFoundException("Categoría con ID: " + id + " no encontrada.")));
    }

    @Override
    public List<CategoryDto> getAllCategories() {
        return categoryRepository.findAll().stream().map(categoryMapper::categoryToCategoryDto).toList();
    }

    @Override
    public void deleteCategory(Long id) {
        if (categoryRepository.existsById(id)) {
            categoryRepository.deleteById(id);
        }else{
            throw new ResourceNotFoundException("Categoría con ID: " +id+" no encontrada." );
        }
    }

    @Override
    public CategoryDto updateCategory(Long id, CategoryCreateDto categoryCreateDto) {
        Category categoryUpdate=categoryRepository.findById(id).orElseThrow();
        categoryUpdate.setName(categoryCreateDto.name());
        return categoryMapper.categoryToCategoryDto(categoryRepository.save(categoryUpdate));
    }

}
package com.example.datilera.mapper.category;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.example.datilera.domain.Category;
import com.example.datilera.dto.category.CategoryCreateDto;
import com.example.datilera.dto.category.CategoryDto;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    CategoryDto categoryToCategoryDto(Category category);

    @Mapping(target = "id_category", ignore = true)
    @Mapping(target = "products", ignore = true)
    Category categoryCreateDtoToCategory(CategoryCreateDto categoryCreateDto);
}
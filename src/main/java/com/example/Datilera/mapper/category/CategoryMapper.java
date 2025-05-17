package com.example.Datilera.mapper.category;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.example.Datilera.domain.Category;
import com.example.Datilera.dto.category.CategoryCreateDto;
import com.example.Datilera.dto.category.CategoryDto;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    CategoryDto categoryToCategoryDto(Category category);

    @Mapping(target = "id_category", ignore = true)
    @Mapping(target = "products", ignore = true)
    Category categoryCreateDtoToCategory(CategoryCreateDto categoryCreateDto);
}
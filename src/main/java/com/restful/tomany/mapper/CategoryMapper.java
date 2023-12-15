package com.restful.tomany.mapper;

import com.restful.tomany.dto.CategoryDTO;
import com.restful.tomany.entity.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {

    public CategoryDTO toDTO(Category category) {
        return new CategoryDTO(category.getId(), category.getName());
    }

    public Category toEntity(CategoryDTO categoryDTO) {
        return new Category(categoryDTO.getId(), categoryDTO.getName());
    }
}

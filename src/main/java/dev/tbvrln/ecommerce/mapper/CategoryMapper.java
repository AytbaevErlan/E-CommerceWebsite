package dev.tbvrln.ecommerce.mapper;

import dev.tbvrln.ecommerce.dto.CategoryDTO;
import dev.tbvrln.ecommerce.model.Category;
import org.mapstruct.Mapper;

@Mapper
public class CategoryMapper {

    public static CategoryDTO toDTO(Category category) {
        return new CategoryDTO(category.getId(), category.getName());
    }

    public static Category toEntity(CategoryDTO dto) {
        return new Category(dto.getId(), dto.getName());
    }
}
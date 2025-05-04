package dev.tbvrln.ecommerce.service;

import dev.tbvrln.ecommerce.dto.CategoryDTO;
import dev.tbvrln.ecommerce.mapper.CategoryMapper;

import dev.tbvrln.ecommerce.model.Category;

import dev.tbvrln.ecommerce.repository.CategoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    public List<Category> getCategory() {
        return categoryRepository.findAll();
    }

//    public List<Category> getCategoryById(Long id) {
//        return categoryRepository.findById(id).map().orElse(null);
//    }


//    public CategoryDTO getCategoryById(Long id) {
//        return categoryRepository.findById(id).map(CategoryMapper::toDTO).orElse(null);
//    }

    public CategoryDTO createCategory(CategoryDTO dto) {
        Category saved = categoryRepository.save(CategoryMapper.toEntity(dto));
        return CategoryMapper.toDTO(saved);
    }

    public CategoryDTO updateCategory(Long id, CategoryDTO dto) {
        Category existing = categoryRepository.findById(id).orElse(null);
        if (existing == null) return null;
        existing.setName(dto.getName());
        return CategoryMapper.toDTO(categoryRepository.save(existing));

    }

    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }


}

package dev.tbvrln.ecommerce.controller;


import dev.tbvrln.ecommerce.dto.CategoryDTO;
import dev.tbvrln.ecommerce.model.Category;
import dev.tbvrln.ecommerce.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/category")
public class CategoryController {
    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public List<Category> getCategories() {
        return categoryService.getCategory();
    }

//    @GetMapping(path = "{categoryId}")
//    public Optional<Category> getCategory(@PathVariable("categoryId") Long categoryId) {
//        return categoryService.getCategory(categoryId);
//    }


    @PutMapping(path = "{categoryId}")
    public void updateCategory(@PathVariable("categoryId") Long categorytId,
                               @RequestBody CategoryDTO dto) {
        categoryService.updateCategory(categorytId, dto);
    }


    @PostMapping
    public void registerNewCategory(@RequestBody CategoryDTO categoryDTO) {
        categoryService.createCategory(categoryDTO);
    }

    @DeleteMapping(path = "{categoryId}")
    public void deleteCategory(@PathVariable("categoryId") Long id) {
        categoryService.deleteCategory((id));
    }

}

package com.cafe.main.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cafe.main.models.CategoryModel;
import com.cafe.main.services.CategoryService;

@RestController
@RequestMapping(path = "/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/getAll")
    public List<CategoryModel> getAll() {
        return categoryService.getCategories();
    }

    @PostMapping("/save")
    public CategoryModel save(@RequestBody CategoryModel categoryModel) {
        return categoryService.createCategory(categoryModel);
    }

    @PutMapping("/update/{id}")
    public CategoryModel update(@PathVariable int id, @RequestBody CategoryModel categoryModel) {
        return categoryService.updateCategory(id, categoryModel);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable int id) {
        categoryService.deleteCategory(id);
    }

    @GetMapping("/totalCategories")
    public long totalCategories(){
        return categoryService.totalCategories();
    }

}

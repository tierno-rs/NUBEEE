package com.cafe.main.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe.main.models.CategoryModel;
import com.cafe.main.repositories.CategoryRepository;

@Service
public class CategoryService {
    
    @Autowired
    private CategoryRepository categoryRepository;

    public List<CategoryModel> getCategories(){
        return categoryRepository.findAll();
    }

    public CategoryModel getCategoryById(int id){
        return categoryRepository.findById(id).orElse(null);
    }
    
    public CategoryModel createCategory(CategoryModel category){
        return categoryRepository.save(category);
    }

    public CategoryModel updateCategory(int id, CategoryModel category){
        CategoryModel existingCategory = categoryRepository.findById(id).orElse(null);
        if(existingCategory != null){
            existingCategory.setName(category.getName());
            return categoryRepository.save(existingCategory);
        }
        return null;
    }

    public void deleteCategory(int id){
        categoryRepository.deleteById(id);
    }

    public long totalCategories(){
        return categoryRepository.count();
    }

}

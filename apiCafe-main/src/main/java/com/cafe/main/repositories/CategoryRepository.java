package com.cafe.main.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cafe.main.models.CategoryModel;

public interface CategoryRepository extends JpaRepository<CategoryModel, Integer> {}

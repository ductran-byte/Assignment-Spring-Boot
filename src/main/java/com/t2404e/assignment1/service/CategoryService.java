package com.t2404e.assignment1.service;

import com.t2404e.assignment1.entity.Category;
import java.util.List;

public interface CategoryService {
    List<Category> getAllCategories();
    Category createCategory(Category category);
}

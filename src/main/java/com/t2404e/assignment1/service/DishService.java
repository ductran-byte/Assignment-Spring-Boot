package com.t2404e.assignment1.service;

import com.t2404e.assignment1.entity.Dish;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface DishService {

    Page<Dish> getAllDishes(
            int page,
            int limit,
            String sortBy,
            String sortDir,
            String keyword,
            Long categoryId,
            Double minPrice,
            Double maxPrice,
            String status
    );

    Optional<Dish> getDishById(String id);

    Dish createDish(Dish dish, Long categoryId);

    Dish updateDish(String id, Dish updatedDish, Long categoryId);

    void softDeleteDish(String id);
}

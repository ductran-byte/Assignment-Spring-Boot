
package com.t2404e.assignment1.service.impl;

import com.t2404e.assignment1.entity.*;
import com.t2404e.assignment1.repository.CategoryRepository;
import com.t2404e.assignment1.repository.DishRepository;
import com.t2404e.assignment1.service.DishService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DishServiceImpl implements DishService {

    private final DishRepository dishRepository;
    private final CategoryRepository categoryRepository;

    @Override
    public Page<Dish> getAllDishes(
            int page,
            int limit,
            String sortBy,
            String sortDir,
            String keyword,
            Long categoryId,
            Double minPrice,
            Double maxPrice,
            String statusStr
    ) {
        Sort sort = Sort.by(Sort.Direction.fromString(sortDir), sortBy);
        Pageable pageable = PageRequest.of(page - 1, limit, sort);

        DishStatus status = null;
        if (statusStr != null) {
            try {
                status = DishStatus.valueOf(statusStr.toUpperCase());
            } catch (IllegalArgumentException ignored) {}
        }

        Specification<Dish> spec = Specification.where((root, query, cb) ->
                cb.notEqual(root.get("status"), DishStatus.DELETED)
        );

        if (keyword != null && !keyword.trim().isEmpty()) {
            String pattern = "%" + keyword.trim().toLowerCase() + "%";
            spec = spec.and((root, query, cb) ->
                    cb.or(
                            cb.like(cb.lower(root.get("name")), pattern),
                            cb.like(cb.lower(root.get("description")), pattern)
                    )
            );
        }

        if (categoryId != null) {
            spec = spec.and((root, query, cb) ->
                    cb.equal(root.get("category").get("id"), categoryId)
            );
        }

        if (minPrice != null) {
            spec = spec.and((root, query, cb) ->
                    cb.greaterThanOrEqualTo(root.get("price"), minPrice)
            );
        }

        if (maxPrice != null) {
            spec = spec.and((root, query, cb) ->
                    cb.lessThanOrEqualTo(root.get("price"), maxPrice)
            );
        }

        if (status != null) {
            final DishStatus finalStatus = status;
            spec = spec.and((root, query, cb) ->
                    cb.equal(root.get("status"), finalStatus)
            );
        }

        return dishRepository.findAll(spec, pageable);
    }

    @Override
    public Optional<Dish> getDishById(String id) {
        return dishRepository.findById(id)
                .filter(d -> d.getStatus() != DishStatus.DELETED);
    }

    @Override
    public Dish createDish(Dish dish, Long categoryId) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new EntityNotFoundException("Category not found"));

        // Tạo ID tự động (MN001, MN002...)
        String newId = "MN" + String.format("%03d", dishRepository.count() + 1);
        dish.setId(newId);

        dish.setCategory(category);
        dish.setStatus(DishStatus.ON_SALE);
        return dishRepository.save(dish);
    }

    @Override
    public Dish updateDish(String id, Dish updatedDish, Long categoryId) {
        Dish existing = dishRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Dish not found"));

        if (existing.getStatus() == DishStatus.DELETED) {
            throw new IllegalStateException("Cannot edit a deleted dish");
        }

        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new EntityNotFoundException("Category not found"));

        existing.setName(updatedDish.getName());
        existing.setDescription(updatedDish.getDescription());
        existing.setImageUrl(updatedDish.getImageUrl());
        existing.setPrice(updatedDish.getPrice());
        existing.setCategory(category);
        existing.setStatus(updatedDish.getStatus());

        return dishRepository.save(existing);
    }

    @Override
    public void softDeleteDish(String id) {
        Dish dish = dishRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Dish not found"));

        if (dish.getStatus() == DishStatus.DELETED) {
            throw new IllegalStateException("Dish already deleted");
        }

        dish.setStatus(DishStatus.DELETED);
        dishRepository.save(dish);
    }
}

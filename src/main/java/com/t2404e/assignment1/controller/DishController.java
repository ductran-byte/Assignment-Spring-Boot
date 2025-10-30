package com.t2404e.assignment1.controller;

import com.t2404e.assignment1.dto.DishRequest;
import com.t2404e.assignment1.dto.DishResponse;
import com.t2404e.assignment1.entity.Dish;
import com.t2404e.assignment1.entity.DishStatus;
import com.t2404e.assignment1.service.DishService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/dishes")
@RequiredArgsConstructor
@CrossOrigin("*")
public class DishController {

    private final DishService dishService;
    private final ModelMapper modelMapper = new ModelMapper();

    // 3.2 - GET /api/v1/dishes
    @GetMapping
    public ResponseEntity<Map<String, Object>> getAllDishes(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "5") int limit,
            @RequestParam(defaultValue = "startDate") String sortBy,
            @RequestParam(defaultValue = "desc") String sortDir,
            @RequestParam(required = false) String keyword,
            @RequestParam(required = false) Long categoryId,
            @RequestParam(required = false) Double minPrice,
            @RequestParam(required = false) Double maxPrice,
            @RequestParam(defaultValue = "ON_SALE") String status
    ) {
        Page<Dish> dishes = dishService.getAllDishes(page, limit, sortBy, sortDir, keyword, categoryId, minPrice, maxPrice, status);
        Map<String, Object> response = new HashMap<>();
        response.put("content", dishes.getContent());
        response.put("page", page);
        response.put("limit", limit);
        response.put("totalPages", dishes.getTotalPages());
        response.put("totalElements", dishes.getTotalElements());
        return ResponseEntity.ok(response);
    }

    // 3.3 - GET /api/v1/dishes/{id} Lấy chi tiết món ăn
    @GetMapping("/{id}")
    public ResponseEntity<DishResponse> getDishById(@PathVariable String id) {
        Dish dish = dishService.getDishById(id)
                .orElseThrow(() -> new EntityNotFoundException("Dish not found"));
        return ResponseEntity.ok(modelMapper.map(dish, DishResponse.class));
    }

    // 3.4 - POST /api/v1/dishes Thêm món ăn mới
    @PostMapping
    public ResponseEntity<DishResponse> createDish(@Valid @RequestBody DishRequest request) {
        Dish dish = modelMapper.map(request, Dish.class);
        Dish created = dishService.createDish(dish, request.getCategoryId());
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(modelMapper.map(created, DishResponse.class));
    }

    // 3.5 - PUT /api/v1/dishes/{id} Cập nhật món ăn
    @PutMapping("/{id}")
    public ResponseEntity<DishResponse> updateDish(
            @PathVariable String id,
            @Valid @RequestBody DishRequest request
    ) {
        Dish dish = modelMapper.map(request, Dish.class);

        // Nếu client không gửi status thì giữ nguyên trạng thái cũ
        if (request.getStatus() != null) {
            try {
                dish.setStatus(DishStatus.valueOf(request.getStatus().toUpperCase()));
            } catch (IllegalArgumentException ignored) {
                dish.setStatus(DishStatus.ON_SALE);
            }
        }

        Dish updated = dishService.updateDish(id, dish, request.getCategoryId());
        return ResponseEntity.ok(modelMapper.map(updated, DishResponse.class));
    }

    // 3.6 - DELETE /api/v1/dishes/{id} Xoá món ăn
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDish(@PathVariable String id) {
        dishService.softDeleteDish(id);
        return ResponseEntity.noContent().build();
    }
}

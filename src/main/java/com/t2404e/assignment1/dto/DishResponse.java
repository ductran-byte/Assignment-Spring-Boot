package com.t2404e.assignment1.dto;

import com.t2404e.assignment1.entity.Category;
import com.t2404e.assignment1.entity.DishStatus;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class DishResponse {
    private String id;
    private String name;
    private String description;
    private String imageUrl;
    private Double price;
    private LocalDateTime startDate;
    private LocalDateTime lastModifiedDate;
    private DishStatus status;
    private Category category;
}

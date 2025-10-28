package com.t2404e.assignment1.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class DishRequest {

    @NotBlank(message = "Name is required")
    @Size(min = 7, message = "Name must be at least 7 characters")
    private String name;

    @Size(max = 1000, message = "Description cannot exceed 1000 characters")
    private String description;

    @Size(max = 500, message = "Image URL too long")
    private String imageUrl;

    @NotNull(message = "Price is required")
    @Positive(message = "Price must be greater than 0")
    private Double price;

    @NotNull(message = "CategoryId is required")
    private Long categoryId;

    private String status; // Optional, dùng cho update
}

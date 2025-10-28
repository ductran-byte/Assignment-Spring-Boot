package com.t2404e.assignment1.repository;

import com.t2404e.assignment1.entity.Dish;
import com.t2404e.assignment1.entity.DishStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface DishRepository extends JpaRepository<Dish, String>, JpaSpecificationExecutor<Dish> {
    List<Dish> findByStatusNot(DishStatus status);
}

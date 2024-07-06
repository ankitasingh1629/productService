package com.productservice.productservice.repo;

import com.productservice.productservice.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepositary extends JpaRepository<Category,Long> {
}

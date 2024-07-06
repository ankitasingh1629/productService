package com.productservice.productservice.repo;

import com.productservice.productservice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepositary extends JpaRepository<Product,Long> {
}

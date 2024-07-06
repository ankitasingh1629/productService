package com.productservice.productservice.dto;

import com.productservice.productservice.model.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class ProductWrapper {
    private Product product;
    private String message;
}

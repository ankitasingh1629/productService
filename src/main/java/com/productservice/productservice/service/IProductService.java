package com.productservice.productservice.service;

import com.productservice.productservice.dto.Productrequestdto;
import com.productservice.productservice.exception.InvalidProduct;
import com.productservice.productservice.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IProductService {

    Product getProductById(Long id) throws InvalidProduct;

    List<Product> getProducts();

    Product updateProduct(Long id, Productrequestdto productrequestdto);

    Product createProduct(Product product);
}

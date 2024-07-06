package com.productservice.productservice.controller;

import com.productservice.productservice.dto.ProductWrapper;
import com.productservice.productservice.dto.Productrequestdto;
import com.productservice.productservice.exception.InvalidProduct;
import com.productservice.productservice.model.Category;
import com.productservice.productservice.model.Product;
import com.productservice.productservice.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {
    @Autowired
    @Qualifier("selfproductservice")
    IProductService productService;
    /*@Autowired
    public ProductController(@Qualifier("selfproductservice") IProductService productService) {
        this.productService = productService;
    }*/

    @GetMapping("/products/{id}")
    public ResponseEntity<ProductWrapper> getProductById(@PathVariable("id") Long id) throws InvalidProduct {
        ProductWrapper productWrapper = new ProductWrapper(productService.getProductById(id),"successfully retrieved");
            return new ResponseEntity<>(productWrapper, HttpStatus.OK);


    }
    @GetMapping("/products")
    public List<Product> getProducts(){
        return productService.getProducts();
    }
    @PostMapping("/products")
    public Product createProduct(@RequestBody Productrequestdto productrequestdto){
        Product product = new Product();
        product.setName(productrequestdto.getTitle());
        product.setPrice(productrequestdto.getPrice());
        product.setImage(productrequestdto.getImage());
        product.setDescription(productrequestdto.getDescription());
        Category category = new Category();
        category.setName(productrequestdto.getCategory());
        product.setCategory(category);
        return productService.createProduct(product);

    }
    @PutMapping("/products/{id}")
    public Product updateProduct(@PathVariable("id")Long id, @RequestBody Productrequestdto productrequestdto){
        return productService.updateProduct(id,productrequestdto);
    }
    @DeleteMapping("/dproduct/{id}")
    public boolean deleteProduct(Long id){
        return true;
    }
}

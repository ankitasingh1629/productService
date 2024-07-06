package com.productservice.productservice.globalcontroller;

import com.productservice.productservice.dto.ProductWrapper;
import com.productservice.productservice.exception.InvalidProduct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AdviseController {
    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<ProductWrapper> handleProduct(){
        ProductWrapper productWrapper = new ProductWrapper(null,"Invalid product Id");
        return new ResponseEntity<>(productWrapper, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler(InvalidProduct.class)
    public ResponseEntity<ProductWrapper> handleProductException(){
        ProductWrapper productWrapper = new ProductWrapper(null,"Invalid product Id");
        return new ResponseEntity<>(productWrapper,HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

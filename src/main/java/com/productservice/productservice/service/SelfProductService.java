package com.productservice.productservice.service;

import com.productservice.productservice.dto.Productrequestdto;
import com.productservice.productservice.exception.InvalidProduct;
import com.productservice.productservice.model.Product;
import com.productservice.productservice.repo.CategoryRepositary;
import com.productservice.productservice.repo.ProductRepositary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
//@Primary
@Qualifier("selfproductservice")
public class SelfProductService implements IProductService{
    @Autowired
    ProductRepositary productRepositary;
    @Autowired
    CategoryRepositary categoryRepositary;
    @Override
    public Product getProductById(Long id) throws InvalidProduct {
        Optional<Product> product = productRepositary.findById(id);
        if(product.isEmpty()){
            throw new InvalidProduct();
        }
        return product.get();
    }

    @Override
    public List<Product> getProducts() {
        return productRepositary.findAll();
    }

    @Override
    public Product updateProduct(Long id, Productrequestdto productrequestdto) {
        return null;
    }

    @Override
    public Product createProduct(Product product) {
        categoryRepositary.save(product.getCategory());
        return productRepositary.save(product);
    }
}

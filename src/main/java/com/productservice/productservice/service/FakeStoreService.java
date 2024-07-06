package com.productservice.productservice.service;

import com.productservice.productservice.dto.Productrequestdto;
import com.productservice.productservice.dto.Productresponsedto;
import com.productservice.productservice.exception.InvalidProduct;
import com.productservice.productservice.model.Category;
import com.productservice.productservice.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpMessageConverterExtractor;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
@Qualifier("fakestoreservice")
public class FakeStoreService implements IProductService{

    @Autowired
    RestTemplate restTemplate;

    @Override
    public Product getProductById(Long id) throws InvalidProduct {

        if(id > 20) {
            throw new InvalidProduct();
        }
        Productresponsedto productresponsedto = restTemplate.getForObject("https://fakestoreapi.com/products/" + id , Productresponsedto.class);
        return getProduct(productresponsedto);
    }

    @Override
    public List<Product> getProducts() {
        Productresponsedto[] products = restTemplate.getForObject("https://fakestoreapi.com/products", Productresponsedto[].class);
        List<Product> productList = new ArrayList<>();
        for(Productresponsedto productresponsedto : products){
            productList.add(getProduct(productresponsedto));
        }
        return productList;
    }

    @Override
    public Product updateProduct(Long id, Productrequestdto productrequestdto) {
        RequestCallback requestCallback = restTemplate.httpEntityCallback(productrequestdto,Productresponsedto.class);
        HttpMessageConverterExtractor<Productresponsedto> responseExtractor = new HttpMessageConverterExtractor(Productresponsedto.class, restTemplate.getMessageConverters());
        Productresponsedto execute = restTemplate.execute("https://fakestoreapi.com/products/" + id, HttpMethod.PUT, requestCallback, responseExtractor);
        return getProduct(execute);
    }

    @Override
    public Product createProduct(Product product) {
        return null;
    }

    public Product getProduct(Productresponsedto productresponsedto){
        Product product = new Product();
        product.setName(productresponsedto.getTitle());
        product.setDescription(productresponsedto.getDescription());
        product.setPrice(productresponsedto.getPrice());
        product.setImage(productresponsedto.getImage());
        Category category = new Category();
        category.setName(productresponsedto.getCategory());
        product.setCategory(category);
        return product;
    }
}

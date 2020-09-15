package com.geekbrains.krilov.spring.mvc.services;

import com.geekbrains.krilov.spring.mvc.model.Product;
import com.geekbrains.krilov.spring.mvc.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class ProductService {

    private ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.getAllProducts();
    }

    public void addProduct(Product product) {
        productRepository.addNewProduct(product);
    }

    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

}

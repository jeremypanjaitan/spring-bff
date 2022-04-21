package com.domain.services;

import com.domain.models.Product;
import com.domain.repos.ProductRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

    public Product[] getAllProducts() {
        return productRepo.getAllProduct();
    }

    public Product getDetailProduct(Long id) {
        return productRepo.getDetailProduct(id);
    }

    public Product saveProduct(Product product) {
        return productRepo.saveProduct(product);
    }

    public Object deleteProduct(Long id) {
        return productRepo.deleteProduct(id);
    }

}

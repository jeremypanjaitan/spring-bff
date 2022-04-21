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

}

package com.domain.controllers;

import com.domain.dto.JsonResponse;
import com.domain.models.Product;
import com.domain.services.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("bff/products")
public class ProductControllers {

    @Autowired
    private ProductService productService;

    @GetMapping
    public JsonResponse<Product[]> findAll() {
        Product[] products = productService.getAllProducts();
        return new JsonResponse<Product[]>(HttpStatus.OK.value(), "ok", products);
    }

    @GetMapping("/{id}")
    public JsonResponse<Product> findOne(@PathVariable("id") Long id) {
        Product product = productService.getDetailProduct(id);
        return new JsonResponse<Product>(HttpStatus.OK.value(), "ok", product);
    }
}

package com.domain.controllers;

import com.domain.dto.JsonResponse;
import com.domain.models.Product;
import com.domain.services.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @PostMapping
    public JsonResponse<Product> createOne(@RequestBody Product product) {
        Product productSaved = productService.saveProduct(product);
        return new JsonResponse<Product>(HttpStatus.OK.value(), "ok", productSaved);
    }

    @DeleteMapping("/{id}")
    public JsonResponse<Object> removeOne(@PathVariable("id") Long id) {
        Object result = productService.deleteProduct(id);
        if (result == null) {
            return new JsonResponse<>(HttpStatus.BAD_REQUEST.value(), "data not found", null);
        }
        return new JsonResponse<>(HttpStatus.OK.value(), "ok", null);
    }
}

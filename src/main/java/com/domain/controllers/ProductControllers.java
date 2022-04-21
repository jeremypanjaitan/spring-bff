package com.domain.controllers;

import com.domain.dto.JsonResponse;
import com.domain.models.Product;
import com.domain.services.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;

@RestController
@RequestMapping("bff/products")
public class ProductControllers {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<JsonResponse<Product[]>> findAll() {
        Product[] products = productService.getAllProducts();
        JsonResponse<Product[]> response = new JsonResponse<Product[]>(HttpStatus.OK.value(), "ok", products);
        return new ResponseEntity<JsonResponse<Product[]>>(response, null, HttpStatus.OK.value());
    }

    @GetMapping("/{id}")
    public ResponseEntity<JsonResponse<Object>> findOne(@PathVariable("id") Long id) {
        try {
            Object product = productService.getDetailProduct(id);
            JsonResponse<Object> response = new JsonResponse<Object>(HttpStatus.OK.value(), "ok", product);
            return new ResponseEntity<JsonResponse<Object>>(response, null, HttpStatus.OK.value());
        } catch (HttpClientErrorException err) {
            JsonResponse<Object> response = new JsonResponse<Object>(err.getRawStatusCode(), "data not found",
                    null);
            return new ResponseEntity<JsonResponse<Object>>(response, null, err.getRawStatusCode());
        }
    }

    @PostMapping
    public ResponseEntity<JsonResponse<Product>> createOne(@RequestBody Product product) {
        Product productSaved = productService.saveProduct(product);
        JsonResponse<Product> response = new JsonResponse<Product>(HttpStatus.OK.value(), "ok", productSaved);
        return new ResponseEntity<JsonResponse<Product>>(response, null, HttpStatus.OK.value());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<JsonResponse<Object>> removeOne(@PathVariable("id") Long id) {
        Object result = productService.deleteProduct(id);
        if (result == null) {
            JsonResponse<Object> response = new JsonResponse<Object>(HttpStatus.BAD_REQUEST.value(), "data not found",
                    null);
            return new ResponseEntity<JsonResponse<Object>>(response, null, HttpStatus.BAD_REQUEST.value());
        }
        JsonResponse<Object> response = new JsonResponse<Object>(HttpStatus.OK.value(), "ok", null);
        return new ResponseEntity<JsonResponse<Object>>(response, null, HttpStatus.OK.value());
    }

    @PutMapping
    public ResponseEntity<JsonResponse<Product>> update(@RequestBody Product product) {
        try {
            productService.updateProduct(product);
            JsonResponse<Product> response = new JsonResponse<Product>(HttpStatus.OK.value(), "ok", product);
            return new ResponseEntity<JsonResponse<Product>>(response, null, HttpStatus.OK.value());
        } catch (RestClientException err) {
            JsonResponse<Product> response = new JsonResponse<Product>(HttpStatus.BAD_REQUEST.value(),
                    "data not found", null);
            return new ResponseEntity<JsonResponse<Product>>(response, null, HttpStatus.BAD_REQUEST.value());
        }
    }
}

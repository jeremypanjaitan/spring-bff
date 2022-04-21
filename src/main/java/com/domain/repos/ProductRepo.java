package com.domain.repos;

import com.domain.dto.ApiListProductResponse;
import com.domain.models.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class ProductRepo {

    @Autowired
    private RestTemplate restTemplate;

    public Product[] getAllProduct() {
        ApiListProductResponse response = this.restTemplate.getForObject("/products", ApiListProductResponse.class);
        return response.getData();
    }

}

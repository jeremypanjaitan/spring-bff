package com.domain.repos;

import com.domain.dto.ApiDetailProductResponse;
import com.domain.dto.ApiListProductResponse;
import com.domain.dto.ApiSaveProductResponse;
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

    public Product getDetailProduct(Long id) {
        ApiDetailProductResponse response = this.restTemplate.getForObject("/products/{id}",
                ApiDetailProductResponse.class, id);
        return response.getData();
    }

    public Product saveProduct(Product product) {
        ApiSaveProductResponse response = this.restTemplate.postForObject("/products", product,
                ApiSaveProductResponse.class);
        return response.getData();
    }

}

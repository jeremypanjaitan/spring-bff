package com.domain.dto;

import com.domain.models.Product;

public class ApiDetailProductResponse {
    private int statusCode;
    private String status;
    private Product data;

    public ApiDetailProductResponse(int statusCode, String status, Product data) {
        this.statusCode = statusCode;
        this.status = status;
        this.data = data;
    }

    public ApiDetailProductResponse() {
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Product getData() {
        return data;
    }

    public void setData(Product data) {
        this.data = data;
    }

}

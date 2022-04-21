package com.domain.dto;

public class ApiDeleteProductResponse {
    private int statusCode;
    private String status;
    private Object data;

    public ApiDeleteProductResponse(int statusCode, String status, Object data) {
        this.statusCode = statusCode;
        this.status = status;
        this.data = data;
    }

    public ApiDeleteProductResponse() {
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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}

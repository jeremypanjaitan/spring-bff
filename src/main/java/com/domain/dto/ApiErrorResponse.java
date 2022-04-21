package com.domain.dto;

import java.io.Serializable;

public class ApiErrorResponse implements Serializable {
    private int statusCode;
    private String status;
    private Object data;

    public ApiErrorResponse(int statusCode, String status, Object data) {
        this.statusCode = statusCode;
        this.status = status;
        this.data = data;
    }

    public ApiErrorResponse() {
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

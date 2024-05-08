package com.example.cosmetics.dto;

import java.io.Serializable;

public class PaymentDto implements Serializable {
    private String status;
    private String message;
    private String url;

    private Integer paymentStatusId;

    public PaymentDto() {
    }

    public PaymentDto(String status, String message, String url, Integer paymentStatusId) {
        this.status = status;
        this.message = message;
        this.url = url;
        this.paymentStatusId = paymentStatusId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getPaymentStatusId() {
        return paymentStatusId;
    }

    public void setPaymentStatusId(Integer paymentStatusId) {
        this.paymentStatusId = paymentStatusId;
    }
}

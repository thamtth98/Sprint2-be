package com.example.cosmetics.dto;

import com.example.cosmetics.model.Account;
import com.example.cosmetics.model.Bill;
import com.example.cosmetics.model.CosmeticsSize;
import jakarta.persistence.*;

public class OrderDto {
    private Integer id;

    private Integer idBill;

    private Integer idCosmeticsSize;

    private Integer idAccount;

    private Long total;
    private Integer quantity;

    public OrderDto(Integer id, Integer idBill, Integer idCosmeticsSize, Integer idAccount, Long total, Integer quantity) {
        this.id = id;
        this.idBill = idBill;
        this.idCosmeticsSize = idCosmeticsSize;
        this.idAccount = idAccount;
        this.total = total;
        this.quantity = quantity;
    }

    public OrderDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdBill() {
        return idBill;
    }

    public void setIdBill(Integer idBill) {
        this.idBill = idBill;
    }

    public Integer getIdCosmeticsSize() {
        return idCosmeticsSize;
    }

    public void setIdCosmeticsSize(Integer idCosmeticsSize) {
        this.idCosmeticsSize = idCosmeticsSize;
    }

    public Integer getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(Integer idAccount) {
        this.idAccount = idAccount;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}

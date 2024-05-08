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
    private Long quantity;
    private Integer quantityReal;

    public OrderDto(Integer id, Integer idBill, Integer idCosmeticsSize, Integer idAccount, Long total, Long quantity, Integer quantityReal) {
        this.id = id;
        this.idBill = idBill;
        this.idCosmeticsSize = idCosmeticsSize;
        this.idAccount = idAccount;
        this.total = total;
        this.quantity = quantity;
        this.quantityReal = quantityReal;
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

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public Integer getQuantityReal() {
        return quantityReal;
    }

    public void setQuantityReal(Integer quantityReal) {
        this.quantityReal = quantityReal;
    }
}

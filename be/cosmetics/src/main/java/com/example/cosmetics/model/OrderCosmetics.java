package com.example.cosmetics.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class OrderCosmetics {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "id_bill")
    private Bill bill;

    @ManyToOne
    @JoinColumn
    private Product product;
    @ManyToOne
    @JoinColumn(name = "id_account")
    private Account account;

    private Long total;
    private Integer quantity;

    public OrderCosmetics(Integer id, Bill bill, Product product, Account account, Long total, Integer quantity) {
        this.id = id;
        this.bill = bill;
        this.product = product;
        this.account = account;
        this.total = total;
        this.quantity = quantity;
    }

    public OrderCosmetics() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }


    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}

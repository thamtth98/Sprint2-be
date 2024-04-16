package com.example.cosmetics.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String description;
    private LocalDate expiry;
    private Long quantity;
    private Long sold;
    private Long price;
    @Column(columnDefinition = "bit(1) default 0")
    private Boolean isDelete;
    @ManyToOne
    @JoinColumn(name = "id_producer")
    private Producer producer;

    @ManyToOne
    @JoinColumn(name = "id_type")
    private Type type;
    private Integer discount;

    @OneToMany(mappedBy = "product")
    @JsonBackReference
    private List<CosmeticsSize> cosmeticsSizeList;


    public Product(Integer id, String name, String description, LocalDate expiry, Long quantity, Long sold, Long price, Boolean isDelete, Producer producer, Type type, Integer discount, List<CosmeticsSize> cosmeticsSizeList) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.expiry = expiry;
        this.quantity = quantity;
        this.sold = sold;
        this.price = price;
        this.isDelete = isDelete;
        this.producer = producer;
        this.type = type;
        this.discount = discount;
        this.cosmeticsSizeList = cosmeticsSizeList;
    }

    public Product() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public Boolean getDelete() {
        return isDelete;
    }

    public void setDelete(Boolean delete) {
        isDelete = delete;
    }

    public Producer getProducer() {
        return producer;
    }

    public void setProducer(Producer producer) {
        this.producer = producer;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getExpiry() {
        return expiry;
    }

    public void setExpiry(LocalDate expiry) {
        this.expiry = expiry;
    }


    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }


    public List<CosmeticsSize> getCosmeticsSizeList() {
        return cosmeticsSizeList;
    }

    public void setCosmeticsSizeList(List<CosmeticsSize> cosmeticsSizeList) {
        this.cosmeticsSizeList = cosmeticsSizeList;
    }

    public Long getSold() {
        return sold;
    }

    public void setSold(Long sold) {
        this.sold = sold;
    }
}

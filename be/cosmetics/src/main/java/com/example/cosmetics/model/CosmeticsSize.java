package com.example.cosmetics.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class CosmeticsSize {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String imageList;
    private LocalDate expiry;
    private Long quantity;
    private Long sold;
    private Long price;

    @ManyToOne
    @JoinColumn
    private Size size;
    @ManyToOne
    @JoinColumn
    private Product product;
    @ManyToOne
    @JoinColumn(name = "id_type_detail")
    private TypeDetail typeDetail;
    private Integer discount;

    public CosmeticsSize(Integer id, String name, String imageList, LocalDate expiry, Long quantity, Long sold, Long price, Size size, Product product, TypeDetail typeDetail, Integer discount) {
        this.id = id;
        this.name = name;
        this.imageList = imageList;
        this.expiry = expiry;
        this.quantity = quantity;
        this.sold = sold;
        this.price = price;
        this.size = size;
        this.product = product;
        this.typeDetail = typeDetail;
        this.discount = discount;
    }

    public CosmeticsSize() {
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

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getImageList() {
        return imageList;
    }

    public void setImageList(String imageList) {
        this.imageList = imageList;
    }



    public LocalDate getExpiry() {
        return expiry;
    }

    public void setExpiry(LocalDate expiry) {
        this.expiry = expiry;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public Long getSold() {
        return sold;
    }

    public void setSold(Long sold) {
        this.sold = sold;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public TypeDetail getTypeDetail() {
        return typeDetail;
    }

    public void setTypeDetail(TypeDetail typeDetail) {
        this.typeDetail = typeDetail;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }
}

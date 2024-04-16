package com.example.cosmetics.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class CosmeticsSize {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String imageList;

    @ManyToOne
    @JoinColumn
    private Size size;
    @ManyToOne
    @JoinColumn
    private Product product;

    public CosmeticsSize(Integer id, String name, String imageList, Size size, Product product) {
        this.id = id;
        this.name = name;
        this.imageList = imageList;
        this.size = size;
        this.product = product;
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
}

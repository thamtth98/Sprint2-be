package com.example.cosmetics.dto;

import com.example.cosmetics.model.Product;
import com.example.cosmetics.model.Size;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public interface CosmeticsDto {
    Integer getId();
    String getName();
    String getImageList();

    Size getSize();

    Product getProduct();
}

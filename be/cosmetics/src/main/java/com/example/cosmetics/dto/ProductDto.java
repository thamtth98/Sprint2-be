package com.example.cosmetics.dto;

import com.example.cosmetics.model.*;

import java.time.LocalDate;
import java.util.List;

public interface ProductDto {
    Integer getId();
    String getName();
    String getDescription();
    LocalDate getExpiry();
    Long getQuantity();
    Long getPrice();
    Producer getProducer();
    Type getType();
    Integer getDiscount();
    interface Image{
        Integer getId();
        String getLinkImage();
    }
    List<Image> getImageList();
    interface CosmeticsSize{
        Integer getId();
        String getName();

        Size getSize();
    }
    List<CosmeticsSize> getCosmeticsSizeList();
    Boolean getDelete();
}

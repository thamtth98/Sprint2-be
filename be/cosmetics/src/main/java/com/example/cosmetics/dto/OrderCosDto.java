package com.example.cosmetics.dto;

import com.example.cosmetics.model.Account;
import com.example.cosmetics.model.Bill;
import com.example.cosmetics.model.CosmeticsSize;

public interface OrderCosDto {
    Integer getId();

    Bill getBill();

    CosmeticsSize getCosmeticsSize();

    Account getAccount();

    Long getTotal();
    Integer getQuantity();
}

package com.example.cosmetics.service;

import com.example.cosmetics.dto.BillDto;
import com.example.cosmetics.model.Bill;
import com.example.cosmetics.model.CosmeticsSize;
import com.example.cosmetics.model.OrderCosmetics;

import java.util.List;

public interface ICosmeticSizeService {
    Bill addNewBill(BillDto billDto,String username);

    List<OrderCosmetics> detailBill(Integer idAccount, Integer idBill);

    CosmeticsSize findById(int idCosmeticsSize);

    void saveQuantity(CosmeticsSize cosmeticsSize);
}

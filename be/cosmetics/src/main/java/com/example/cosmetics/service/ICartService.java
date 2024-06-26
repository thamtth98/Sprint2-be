package com.example.cosmetics.service;

import com.example.cosmetics.dto.CosmeticsDto;
import com.example.cosmetics.dto.OrderCosDto;
import com.example.cosmetics.dto.OrderDto;
import com.example.cosmetics.model.Bill;
import com.example.cosmetics.model.OrderCosmetics;

import java.util.List;

public interface ICartService {

    List<OrderCosmetics> findAll();

    void save(OrderDto orderDto);

    List<OrderCosmetics> getCartFromData(Integer idAccount);

    void deleteById(Integer id);

    List<Bill> getPayment(String email);
    List<OrderCosmetics> detailBill(Integer idAccount, Integer idBill);
}

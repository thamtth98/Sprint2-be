package com.example.cosmetics.service;

import com.example.cosmetics.model.OrderCosmetics;

import java.util.List;

public interface ICartService {
    void save(OrderCosmetics orderCosmetics);

    List<OrderCosmetics> findAll();
}

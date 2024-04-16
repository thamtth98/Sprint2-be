package com.example.cosmetics.service.impl;

import com.example.cosmetics.model.OrderCosmetics;
import com.example.cosmetics.repository.ICartRepository;
import com.example.cosmetics.service.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService implements ICartService {
    @Autowired
    private ICartRepository cartRepository;
    @Override
    public void save(OrderCosmetics orderCosmetics) {
        cartRepository.save(orderCosmetics);
    }

    @Override
    public List<OrderCosmetics> findAll() {
        return cartRepository.findAll();
    }
}

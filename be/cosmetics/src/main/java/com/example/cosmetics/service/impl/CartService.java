package com.example.cosmetics.service.impl;

import com.example.cosmetics.dto.CosmeticsDto;
import com.example.cosmetics.dto.OrderCosDto;
import com.example.cosmetics.dto.OrderDto;
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
    public List<OrderCosmetics> findAll() {
        return cartRepository.findAll();
    }

    @Override
    public void save(OrderDto orderDto) {
        List<OrderCosmetics> orderCosmeticsList = getCartFromData(orderDto.getIdAccount());
        for(OrderCosmetics orderCosmetics: orderCosmeticsList){
            if(orderCosmetics.getCosmeticsSize().getId() != orderDto.getIdCosmeticsSize()){
                cartRepository.saveOrder(orderDto);
            }else {
                orderDto.setQuantity(orderDto.getQuantity()+orderCosmetics.getQuantity());
                cartRepository.saveOrder(orderDto);
            }
        }
    }



    @Override
    public List<OrderCosmetics> getCartFromData(Integer idAccount) {
        return cartRepository.getCartFromData(idAccount);
    }


}

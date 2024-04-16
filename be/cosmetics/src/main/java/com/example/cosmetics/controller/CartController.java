package com.example.cosmetics.controller;

import com.example.cosmetics.model.OrderCosmetics;
import com.example.cosmetics.service.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private ICartService cartService;
    @GetMapping("")
    public ResponseEntity<List<OrderCosmetics>> getCartItems() {
        List<OrderCosmetics> orderCosmeticsList = cartService.findAll();
        return new ResponseEntity<>(orderCosmeticsList, HttpStatus.OK);
    }
    @PostMapping("/addToCart")
    public void addToCart(@RequestBody OrderCosmetics orderCosmetics) {
        cartService.save(orderCosmetics);
    }
}

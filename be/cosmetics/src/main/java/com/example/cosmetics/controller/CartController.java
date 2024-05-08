package com.example.cosmetics.controller;

import com.example.cosmetics.dto.CosmeticsDto;
import com.example.cosmetics.dto.OrderCosDto;
import com.example.cosmetics.dto.OrderDto;
import com.example.cosmetics.model.OrderCosmetics;
import com.example.cosmetics.service.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
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
    public ResponseEntity<?> addToCart(@RequestBody List<OrderDto> orderDtoList) {
        for (OrderDto orderDto : orderDtoList) {
            cartService.save(orderDto);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/getAllList")
    public ResponseEntity<List<OrderCosmetics>> getCartFromData(@RequestParam Integer id) {
        List<OrderCosmetics> orderCosmeticsList = cartService.getCartFromData(id);
        return new ResponseEntity<>(orderCosmeticsList, HttpStatus.OK);
    }
}

package com.example.cosmetics.controller;

import com.example.cosmetics.dto.CosmeticsDto;
import com.example.cosmetics.dto.OrderCosDto;
import com.example.cosmetics.dto.OrderDto;
import com.example.cosmetics.model.Account;
import com.example.cosmetics.model.Bill;
import com.example.cosmetics.model.OrderCosmetics;
import com.example.cosmetics.service.IBillService;
import com.example.cosmetics.service.ICartService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private ICartService cartService;
    @Autowired
    private IBillService billService;


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
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCart(@PathVariable Integer id) {
        try {
            cartService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping("/getAllPayment")
    public ResponseEntity<List<Bill>> getPayment(@RequestBody Account account) {
        List<Bill> billList = billService.getPayment(account.getEmail());
        return new ResponseEntity<>(billList, HttpStatus.OK);
    }
    @GetMapping("/detailBill/{idAccount}/{idBill}")
    public ResponseEntity<List<OrderCosmetics>> detailBill(@PathVariable Integer idAccount,@PathVariable Integer idBill) {
        List<OrderCosmetics> billList = cartService.detailBill(idAccount,idBill);
        return new ResponseEntity<>(billList, HttpStatus.OK);
    }

}

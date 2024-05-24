package com.example.cosmetics.controller;

import com.example.cosmetics.dto.CosmeticsDto;
import com.example.cosmetics.model.CosmeticsSize;
import com.example.cosmetics.model.OrderCosmetics;
import com.example.cosmetics.service.IBillService;
import com.example.cosmetics.service.ICosmeticSizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/")
public class CosmeticSizeController {
    @Autowired
    private ICosmeticSizeService cosmeticSizeService;
    @GetMapping("/detailBill")
    public ResponseEntity<List<OrderCosmetics>> detailBill(@RequestParam Integer idAccount, @RequestParam Integer idBill) {
        List<OrderCosmetics> billList = cosmeticSizeService.detailBill(idAccount,idBill);
        return new ResponseEntity<>(billList, HttpStatus.OK);
    }
    @PostMapping("/product/{idCosmeticsSize}/{quantity}")
    public  ResponseEntity<?> saveQuantity(@PathVariable int idCosmeticsSize,@PathVariable long quantity){
        CosmeticsSize cosmeticsSize = cosmeticSizeService.findById(idCosmeticsSize);
        cosmeticsSize.setQuantity(quantity);
        cosmeticSizeService.saveQuantity(cosmeticsSize);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

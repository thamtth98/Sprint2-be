package com.example.cosmetics.controller;

import com.example.cosmetics.dto.CosmeticsDto;
import com.example.cosmetics.dto.RequestDto;
import com.example.cosmetics.model.Account;
import com.example.cosmetics.service.IInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@CrossOrigin("*")
@RequestMapping("")
public class InfoController {
    @Autowired
    private IInfoService infoService;
    @PostMapping("/info")
    private ResponseEntity<?> saveInfo(@RequestBody Account account) {
        infoService.saveInfo(account);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

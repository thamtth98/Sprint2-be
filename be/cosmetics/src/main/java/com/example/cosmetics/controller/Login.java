package com.example.cosmetics.controller;

import com.example.cosmetics.model.Account;
import com.example.cosmetics.model.Producer;
import com.example.cosmetics.service.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/login")
public class Login {
    @Autowired
    private ILoginService loginService;
    @GetMapping
    public ResponseEntity<List<Account>> getAllAccount() {
        List<Account> accountList = loginService.findAll();
        return new ResponseEntity<>(accountList, HttpStatus.OK);
    }
}

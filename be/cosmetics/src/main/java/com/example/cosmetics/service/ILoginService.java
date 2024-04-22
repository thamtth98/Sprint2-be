package com.example.cosmetics.service;

import com.example.cosmetics.model.Account;

import java.util.List;

public interface ILoginService {
    List<Account> findAll();
}

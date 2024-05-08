package com.example.cosmetics.service;

import com.example.cosmetics.model.Account;

public interface IAccountService {
    Account findAccountByUsername(String username);

    Account findAccountById(Integer id);
}

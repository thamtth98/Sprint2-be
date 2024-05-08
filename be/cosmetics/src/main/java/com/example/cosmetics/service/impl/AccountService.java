package com.example.cosmetics.service.impl;

import com.example.cosmetics.config.UserPrinciple;
import com.example.cosmetics.model.Account;
import com.example.cosmetics.repository.IAccountRepository;
import com.example.cosmetics.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AccountService implements UserDetailsService, IAccountService {
    @Autowired
    private IAccountRepository accountRepository;
    public Account findByUsername(String name) {
        return accountRepository.findAccountByUsername(name);
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return UserPrinciple.build(accountRepository.findAccountByUsername(username));
    }

    @Override
    public Account findAccountByUsername(String username) {
        return accountRepository.findAccountByUsername(username);
    }

    @Override
    public Account findAccountById(Integer id) {
        return accountRepository.findById(id).orElse(null);
    }
}

package com.example.cosmetics.service.impl;

import com.example.cosmetics.model.Account;
import com.example.cosmetics.repository.ILoginRepository;
import com.example.cosmetics.service.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginService implements ILoginService {
    @Autowired
    private ILoginRepository loginRepository;
    @Override
    public List<Account> findAll() {
        return loginRepository.findAll();
    }
}

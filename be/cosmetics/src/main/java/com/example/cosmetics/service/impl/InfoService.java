package com.example.cosmetics.service.impl;

import com.example.cosmetics.model.Account;
import com.example.cosmetics.repository.InfoRepository;
import com.example.cosmetics.service.IInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InfoService implements IInfoService {
    @Autowired
    private InfoRepository infoRepository;

    @Override
    public void saveInfo(Account account) {
        infoRepository.saveInfo(account);

    }
}

package com.example.cosmetics.service.impl;

import com.example.cosmetics.repository.IBillRepository;
import com.example.cosmetics.service.IBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BillService implements IBillService {
    @Autowired
    private IBillRepository billRepository;
}

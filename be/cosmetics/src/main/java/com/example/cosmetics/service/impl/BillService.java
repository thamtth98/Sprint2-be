package com.example.cosmetics.service.impl;

import com.example.cosmetics.model.Bill;
import com.example.cosmetics.repository.IBillRepository;
import com.example.cosmetics.service.IBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillService implements IBillService {
    @Autowired
    private IBillRepository billRepository;


    @Override
    public List<Bill> getPayment(String email) {
        return billRepository.getBill(email);
    }
}

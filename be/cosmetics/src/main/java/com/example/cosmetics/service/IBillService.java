package com.example.cosmetics.service;

import com.example.cosmetics.model.Bill;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface IBillService {

    List<Bill> getPayment(String email);
}

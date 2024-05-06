package com.example.cosmetics.service.impl;

import com.example.cosmetics.model.Size;
import com.example.cosmetics.repository.ISizeRepository;
import com.example.cosmetics.service.ISizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SizeService implements ISizeService {
    @Autowired
    private ISizeRepository sizeRepository;

    @Override
    public List<Size> findAll() {
        return sizeRepository.findAll();
    }
}

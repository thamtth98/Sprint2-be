package com.example.cosmetics.service.impl;

import com.example.cosmetics.model.Color;
import com.example.cosmetics.repository.IColorRepository;
import com.example.cosmetics.service.IColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ColorService implements IColorService {
    @Autowired
    private IColorRepository colorRepository;
    @Override
    public List<Color> findAll() {
        return colorRepository.findAll();
    }
}

package com.example.cosmetics.service.impl;

import com.example.cosmetics.model.Producer;
import com.example.cosmetics.repository.IProducerRepository;
import com.example.cosmetics.service.IProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProducerService implements IProducerService {
    @Autowired
    private IProducerRepository producerRepository;
    @Override
    public List<Producer> findAll() {
        return producerRepository.findAll();
    }
}

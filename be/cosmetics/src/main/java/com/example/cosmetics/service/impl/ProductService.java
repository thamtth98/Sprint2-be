package com.example.cosmetics.service.impl;

import com.example.cosmetics.dto.CosmeticsDto;
import com.example.cosmetics.dto.ProductDto;
import com.example.cosmetics.dto.RequestDto;
import com.example.cosmetics.model.Bill;
import com.example.cosmetics.model.CosmeticsSize;
import com.example.cosmetics.model.OrderCosmetics;
import com.example.cosmetics.repository.IBillRepository;
import com.example.cosmetics.repository.IProductRepository;
import com.example.cosmetics.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public class ProductService implements IProductService{
    @Autowired
    private IProductRepository productRepository;


    @Override
    public Page<CosmeticsDto> getAllPage(RequestDto requestDto) {
        Pageable pageable = PageRequest.of(requestDto.getPage(), requestDto.getSize());
        return productRepository.getAllPage(requestDto,pageable);
    }

    @Override
    public CosmeticsDto findById(int idProduct) {
        return productRepository.findByIdProduct(idProduct);
    }

    @Override
    public List<CosmeticsDto> findByNameType(CosmeticsDto cosmeticsDto) {
        return productRepository.findByNameType(cosmeticsDto);
    }

    @Override
    public List<CosmeticsDto> getAllList(RequestDto requestDto) {
        return productRepository.findAllList(requestDto);
    }




}

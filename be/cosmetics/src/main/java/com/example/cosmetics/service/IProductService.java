package com.example.cosmetics.service;

import com.example.cosmetics.dto.CosmeticsDto;
import com.example.cosmetics.dto.ProductDto;
import com.example.cosmetics.dto.RequestDto;
import org.springframework.data.domain.Page;

public interface IProductService {


    Page<CosmeticsDto> getAllPage(RequestDto requestDto);

    CosmeticsDto findById(int idProduct);
}

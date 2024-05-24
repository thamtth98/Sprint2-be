package com.example.cosmetics.service;

import com.example.cosmetics.dto.CosmeticsDto;
import com.example.cosmetics.dto.ProductDto;
import com.example.cosmetics.dto.RequestDto;
import com.example.cosmetics.model.CosmeticsSize;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IProductService {


    Page<CosmeticsDto> getAllPage(RequestDto requestDto);

    CosmeticsDto findById(int idProduct);

    List<CosmeticsDto> findByNameType(CosmeticsDto cosmeticsDto);

    List<CosmeticsDto> getAllList(RequestDto requestDto);

}

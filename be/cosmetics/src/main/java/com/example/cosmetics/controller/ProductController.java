package com.example.cosmetics.controller;

import com.example.cosmetics.dto.CosmeticsDto;
import com.example.cosmetics.dto.ProductDto;
import com.example.cosmetics.dto.RequestDto;
import com.example.cosmetics.model.CosmeticsSize;
import com.example.cosmetics.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("")
public class ProductController {
    @Autowired
    private IProductService productService;

    @PostMapping("/home")
    private ResponseEntity<Page<CosmeticsDto>> getPage(@RequestBody RequestDto requestDto) {
        Page<CosmeticsDto> cosmeticsSizeDtoPage = productService.getAllPage(requestDto);
        return new ResponseEntity<>(cosmeticsSizeDtoPage, HttpStatus.OK);
    }
    @PostMapping("/product/list")
    private ResponseEntity<List<CosmeticsDto>> getList(@RequestBody RequestDto requestDto) {
        List<CosmeticsDto> cosmeticsDtoList = productService.getAllList(requestDto);
        return new ResponseEntity<>(cosmeticsDtoList, HttpStatus.OK);
    }
    @GetMapping("/product/{idProduct}")
    public ResponseEntity<?> getProductById(@PathVariable int idProduct){
        CosmeticsDto cosmeticsDto = productService.findById(idProduct);
        return new ResponseEntity<>(cosmeticsDto,HttpStatus.OK);
    }

    @GetMapping("/product/type/{idProduct}")
    public  ResponseEntity<?> getProductSameType(@PathVariable int idProduct){
        CosmeticsDto cosmeticsDto = productService.findById(idProduct);
        List<CosmeticsDto> cosmeticsDtoList = productService.findByNameType(cosmeticsDto);
        return new ResponseEntity<>(cosmeticsDtoList,HttpStatus.OK);
    }



}

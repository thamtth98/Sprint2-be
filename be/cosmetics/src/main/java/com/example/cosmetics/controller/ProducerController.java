package com.example.cosmetics.controller;

import com.example.cosmetics.model.Color;
import com.example.cosmetics.model.Producer;
import com.example.cosmetics.model.Size;
import com.example.cosmetics.service.IColorService;
import com.example.cosmetics.service.IProducerService;
import com.example.cosmetics.service.ISizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/")
public class ProducerController {

    @Autowired
    private IProducerService producerService;
    @Autowired
    private IColorService colorService;
    @Autowired
    private ISizeService sizeService;

    @GetMapping("/producer")
    public ResponseEntity<List<Producer>> showProducer() {
        List<Producer> producerList = producerService.findAll();
        return new ResponseEntity<>(producerList, HttpStatus.OK);
    }
    //lấy color
    @GetMapping("/color")
    public ResponseEntity<List<Color>> showColor() {
        List<Color> colorList = colorService.findAll();
        return new ResponseEntity<>(colorList, HttpStatus.OK);
    }

    //lấy size
    @GetMapping("/size")
    public ResponseEntity<List<Size>> showSize() {
        List<Size> sizeList = sizeService.findAll();
        return new ResponseEntity<>(sizeList, HttpStatus.OK);
    }



}

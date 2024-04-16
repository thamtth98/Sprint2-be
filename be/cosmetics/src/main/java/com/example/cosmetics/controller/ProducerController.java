package com.example.cosmetics.controller;

import com.example.cosmetics.model.Producer;
import com.example.cosmetics.service.IProducerService;
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
@RequestMapping("/producer")
public class ProducerController {

    @Autowired
    private IProducerService producerService;

    @GetMapping
    public ResponseEntity<List<Producer>> showContractStatus() {
        List<Producer> producerList = producerService.findAll();
        return new ResponseEntity<>(producerList, HttpStatus.OK);
    }


}

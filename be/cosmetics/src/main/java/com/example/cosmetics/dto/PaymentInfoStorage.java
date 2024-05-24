package com.example.cosmetics.dto;

import org.springframework.stereotype.Component;

@Component
public class PaymentInfoStorage {
    private BillDto billDto;

    public BillDto getBillDto() {
        return billDto;
    }

    public void setBillDto(BillDto billDto) {
        this.billDto = billDto;
    }
}

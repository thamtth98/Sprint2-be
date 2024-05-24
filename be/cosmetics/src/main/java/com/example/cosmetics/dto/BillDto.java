package com.example.cosmetics.dto;

import java.time.LocalDate;

public class BillDto {
    private String fullname;
    private String phoneNumber;
    private String address;
    private String note;

    public BillDto(String fullname, String phoneNumber, String address, String note) {
        this.fullname = fullname;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.note = note;
    }

    public BillDto() {
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}

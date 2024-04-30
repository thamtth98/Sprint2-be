package com.example.cosmetics.dto;

public class RequestDto {
    private Integer page;
    private Integer size;
    private Integer idProducer;
    private Integer idType;
    private Integer idSize;
    private String nameSearch;
    private String color;

    public RequestDto(Integer page, Integer size, Integer idProducer, Integer idType, Integer idSize, String nameSearch, String color) {
        this.page = page;
        this.size = size;
        this.idProducer = idProducer;
        this.idType = idType;
        this.idSize = idSize;
        this.nameSearch = nameSearch;
        this.color = color;
    }

    public RequestDto() {
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getIdProducer() {
        return idProducer;
    }

    public void setIdProducer(Integer idProducer) {
        this.idProducer = idProducer;
    }

    public Integer getIdType() {
        return idType;
    }

    public void setIdType(Integer idType) {
        this.idType = idType;
    }

    public Integer getIdSize() {
        return idSize;
    }

    public void setIdSize(Integer idSize) {
        this.idSize = idSize;
    }

    public String getNameSearch() {
        return nameSearch;
    }

    public void setNameSearch(String nameSearch) {
        this.nameSearch = nameSearch;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}

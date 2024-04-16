package com.example.cosmetics.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.List;
@Entity
public class Size {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @OneToMany(mappedBy = "size")
    @JsonBackReference
    private List<CosmeticsSize> cosmeticsSizeList;

    public Size(Integer id, String name, List<CosmeticsSize> cosmeticsSizeList) {
        this.id = id;
        this.name = name;
        this.cosmeticsSizeList = cosmeticsSizeList;
    }

    public Size() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<CosmeticsSize> getCosmeticsSizeList() {
        return cosmeticsSizeList;
    }

    public void setCosmeticsSizeList(List<CosmeticsSize> cosmeticsSizeList) {
        this.cosmeticsSizeList = cosmeticsSizeList;
    }
}

package com.example.cosmetics.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String description;
    private String ingredient;

    @Column(columnDefinition = "bit(1) default 0")
    private Boolean isDelete;
    @ManyToOne
    @JoinColumn(name = "id_producer")
    private Producer producer;

    @OneToMany(mappedBy = "product")
    @JsonBackReference
    private List<CosmeticsSize> cosmeticsSizeList;
    @ManyToOne
    @JoinColumn(name = "id_color")
    private Color color;
    @ManyToOne
    @JoinColumn(name = "id_incense")
    private Incense incense;
    @ManyToOne
    @JoinColumn(name = "id_skin")
    private Skin skin;

    public Product(Integer id, String name, String description, String ingredient, Boolean isDelete, Producer producer, List<CosmeticsSize> cosmeticsSizeList, Color color, Incense incense, Skin skin) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.ingredient = ingredient;
        this.isDelete = isDelete;
        this.producer = producer;
        this.cosmeticsSizeList = cosmeticsSizeList;
        this.color = color;
        this.incense = incense;
        this.skin = skin;
    }

    public Product() {
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



    public Boolean getDelete() {
        return isDelete;
    }

    public void setDelete(Boolean delete) {
        isDelete = delete;
    }

    public Producer getProducer() {
        return producer;
    }

    public void setProducer(Producer producer) {
        this.producer = producer;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public List<CosmeticsSize> getCosmeticsSizeList() {
        return cosmeticsSizeList;
    }

    public void setCosmeticsSizeList(List<CosmeticsSize> cosmeticsSizeList) {
        this.cosmeticsSizeList = cosmeticsSizeList;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Incense getIncense() {
        return incense;
    }

    public void setIncense(Incense incense) {
        this.incense = incense;
    }

    public Skin getSkin() {
        return skin;
    }

    public void setSkin(Skin skin) {
        this.skin = skin;
    }

    public String getIngredient() {
        return ingredient;
    }

    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }
}

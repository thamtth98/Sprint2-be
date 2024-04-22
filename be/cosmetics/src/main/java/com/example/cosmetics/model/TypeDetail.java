package com.example.cosmetics.model;

import jakarta.persistence.*;

@Entity
public class TypeDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "id_type")
    private Type type;

    public TypeDetail(Integer id, String name, Type type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }

    public TypeDetail() {
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

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}

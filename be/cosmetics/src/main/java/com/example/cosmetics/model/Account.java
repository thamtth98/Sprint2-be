package com.example.cosmetics.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Set;

@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String username;
    private String fullname;
    private String email;
    private String phoneNumber;
    private String address;
    private String password;
    private LocalDate createAt;
    @Column(columnDefinition = "bit(1) default 0")
    private Boolean isDelete;
    @ManyToOne
    @JoinColumn(name = "id_role")
    private Role roles;

    public Account(Integer id, String username, String fullname, String email, String phoneNumber, String address, String password, LocalDate createAt, Boolean isDelete, Role roles) {
        this.id = id;
        this.username = username;
        this.fullname = fullname;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.password = password;
        this.createAt = createAt;
        this.isDelete = isDelete;
        this.roles = roles;
    }

    public Account() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Role getRoles() {
        return roles;
    }

    public void setRoles(Role roles) {
        this.roles = roles;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDate createAt) {
        this.createAt = createAt;
    }

    public Boolean getDelete() {
        return isDelete;
    }

    public void setDelete(Boolean delete) {
        isDelete = delete;
    }
}

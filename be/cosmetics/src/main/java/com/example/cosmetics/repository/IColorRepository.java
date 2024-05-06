package com.example.cosmetics.repository;

import com.example.cosmetics.model.Color;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IColorRepository extends JpaRepository<Color,Integer> {

}

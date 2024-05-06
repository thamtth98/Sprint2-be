package com.example.cosmetics.repository;

import com.example.cosmetics.model.Size;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISizeRepository extends JpaRepository<Size,Integer> {
}

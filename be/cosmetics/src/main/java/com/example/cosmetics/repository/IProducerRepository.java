package com.example.cosmetics.repository;

import com.example.cosmetics.model.Producer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProducerRepository extends JpaRepository<Producer, Integer> {
}

package com.example.cosmetics.repository;

import com.example.cosmetics.model.OrderCosmetics;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICartRepository extends JpaRepository<OrderCosmetics,Integer> {

}

package com.example.cosmetics.repository;

import com.example.cosmetics.model.CosmeticsSize;
import com.example.cosmetics.model.OrderCosmetics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ICosmeticSizeRepository extends JpaRepository<CosmeticsSize,Integer> {
    @Query(value = "SELECT or FROM OrderCosmetics or where or.account.username = :#{#username}")
    List<OrderCosmetics> getAllProductOrderOfUser(@Param("username") String username);
}

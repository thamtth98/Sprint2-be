package com.example.cosmetics.repository;

import com.example.cosmetics.dto.CosmeticsDto;
import com.example.cosmetics.dto.OrderCosDto;
import com.example.cosmetics.dto.OrderDto;
import com.example.cosmetics.model.OrderCosmetics;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ICartRepository extends JpaRepository<OrderCosmetics,Integer> {

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO order_cosmetics (id, total, id_account, id_bill, quantity, id_cosmetics_size) " +
            "VALUES (:#{#orderDto.id}, :#{#orderDto.total}, :#{#orderDto.idAccount}, :#{#orderDto.idBill}, :#{#orderDto.quantity}, :#{#orderDto.idCosmeticsSize})", nativeQuery = true)
    void saveOrder(@Param("orderDto") OrderDto orderDto);


    @Query(value = "SELECT * FROM order_cosmetics where :#{#idAccount}",nativeQuery = true)
    List<OrderCosmetics> getCartFromData(@Param("idAccount") Integer idAccount);
}

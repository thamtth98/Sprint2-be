package com.example.cosmetics.repository;

import com.example.cosmetics.dto.OrderDto;
import com.example.cosmetics.model.CosmeticsSize;
import com.example.cosmetics.model.OrderCosmetics;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ICosmeticSizeRepository extends JpaRepository<CosmeticsSize,Integer> {
    @Query(value = "SELECT or FROM OrderCosmetics or where or.account.username = :#{#username}")
    List<OrderCosmetics> getAllProductOrderOfUser(@Param("username") String username);

    @Query(value = "SELECT * FROM order_cosmetics as ord where ord.id_account = :#{#idAccount} and ord.id_bill = :#{#idBill}",nativeQuery = true)
    List<OrderCosmetics> detailBill(Integer idAccount, Integer idBill);

    @Modifying
    @Transactional
    @Query(value = "UPDATE order_cosmetics as oc SET oc.quantity = :#{#cosmeticsSize.quantity} WHERE (id_cosmetics_size = :#{#cosmeticsSize.id})", nativeQuery = true)
    void saveQuantity(@Param("cosmeticsSize") CosmeticsSize cosmeticsSize);
}

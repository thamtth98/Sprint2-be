package com.example.cosmetics.repository;

import com.example.cosmetics.dto.OrderDto;
import com.example.cosmetics.model.Bill;
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


    @Query(value = "SELECT * FROM order_cosmetics where :#{#idAccount} and order_cosmetics.id_bill is null",nativeQuery = true)
    List<OrderCosmetics> getCartFromData(@Param("idAccount") Integer idAccount);

    @Modifying
    @Transactional
    @Query(value = "UPDATE order_cosmetics as oc SET oc.quantity = :#{#orderDto.quantity} WHERE (id_cosmetics_size = :#{#orderDto.idCosmeticsSize})", nativeQuery = true)
    void saveDto(@Param("orderDto") OrderDto orderDto);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM order_cosmetics WHERE id_cosmetics_size = :id", nativeQuery = true)
    void deleteByUser(@Param("id") Integer id);

    @Query(value = "SELECT * FROM bill where bill.email = LIKE CONCAT('%', :email, '%') ",nativeQuery = true)
    List<Bill> getBill(@Param("email") String email);

    @Query(value = "SELECT * FROM order_cosmetics as ord where ord.id_account = :#{#idAccount} and ord.id_bill = :#{#idBill}",nativeQuery = true)
    List<OrderCosmetics> detailBill(@Param("idAccount") Integer idAccount, @Param("idBill") Integer idBill);
}

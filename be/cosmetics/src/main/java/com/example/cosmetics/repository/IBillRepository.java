package com.example.cosmetics.repository;

import com.example.cosmetics.model.Bill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IBillRepository extends JpaRepository<Bill,Integer> {

    @Query(value = "SELECT * FROM bill where bill.email = :#{#email}",nativeQuery = true)
    List<Bill> getBill(@Param("email") String email);
}

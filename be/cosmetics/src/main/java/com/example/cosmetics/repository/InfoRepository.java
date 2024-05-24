package com.example.cosmetics.repository;

import com.example.cosmetics.model.Account;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface InfoRepository extends JpaRepository<Account,Integer> {

    @Modifying
    @Transactional
    @Query(value = "UPDATE account as ac SET ac.address = :#{#account.address}, ac.email = :#{#account.email}," +
            "ac.fullname = :#{#account.fullname},ac.phone_number = :#{#account.phoneNumber}  WHERE (id = :#{#account.id})", nativeQuery = true)
    void saveInfo(Account account);
}

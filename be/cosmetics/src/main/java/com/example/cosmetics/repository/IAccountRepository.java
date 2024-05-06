package com.example.cosmetics.repository;

import com.example.cosmetics.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAccountRepository extends JpaRepository<Account,Integer> {
    Account findAccountByUsername(String username);
}

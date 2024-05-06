package com.example.cosmetics.repository;

import com.example.cosmetics.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ILoginRepository extends JpaRepository<Account,Integer> {
}

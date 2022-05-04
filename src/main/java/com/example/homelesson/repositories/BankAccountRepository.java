package com.example.homelesson.repositories;

import com.example.homelesson.entity.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankAccountRepository extends JpaRepository<BankAccount, Long> {

BankAccount findByAccountHolderName(String name);
}

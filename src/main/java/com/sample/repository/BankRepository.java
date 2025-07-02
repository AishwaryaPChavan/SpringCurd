package com.sample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sample.Entity.Bank;

@Repository
public interface BankRepository extends JpaRepository<Bank, Integer>{

}

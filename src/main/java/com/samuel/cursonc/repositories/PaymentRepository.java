package com.samuel.cursonc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.samuel.cursonc.domain.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer>{
	
}

package com.samuel.cursonc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.samuel.cursonc.domain.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer>{
	
}

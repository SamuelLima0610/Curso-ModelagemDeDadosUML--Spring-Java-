package com.samuel.cursonc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.samuel.cursonc.domain.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{
	
}

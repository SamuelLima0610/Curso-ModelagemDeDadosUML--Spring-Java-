package com.samuel.cursonc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.samuel.cursonc.domain.City;

@Repository
public interface CityRepository extends JpaRepository<City, Integer>{
	
}

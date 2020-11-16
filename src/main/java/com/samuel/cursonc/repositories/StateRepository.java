package com.samuel.cursonc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.samuel.cursonc.domain.State;

@Repository
public interface StateRepository extends JpaRepository<State, Integer>{
	
}

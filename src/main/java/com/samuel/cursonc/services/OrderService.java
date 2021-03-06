package com.samuel.cursonc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.samuel.cursonc.domain.Order;
import com.samuel.cursonc.repositories.OrderRepository;
import com.samuel.cursonc.services.exceptions.ObjectNotFoundException;

@Service
public class OrderService {

	@Autowired
	private OrderRepository repo;
	
	public Order get(Integer id) {
		Optional<Order> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found, id: " + id + " type: "+  Order.class.getName()));
	}
	
}

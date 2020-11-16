package com.samuel.cursonc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.samuel.cursonc.domain.Client;
import com.samuel.cursonc.repositories.ClientRepository;
import com.samuel.cursonc.services.exceptions.ObjectNotFoundException;

@Service
public class ClientService {

	@Autowired
	private ClientRepository repo;
	
	public Client get(Integer id) {
		Optional<Client> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found, id: " + id + " type: "+  Client.class.getName()));
	}
	
}

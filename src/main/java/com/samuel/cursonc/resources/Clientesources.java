package com.samuel.cursonc.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.samuel.cursonc.domain.Client;
import com.samuel.cursonc.services.ClientService;

@RestController
@RequestMapping(value="/clients")
public class Clientesources {
	
	@Autowired
	private ClientService service;
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public ResponseEntity<?> findById(@PathVariable Integer id) {
		Client send = service.get(id);
		return ResponseEntity.ok().body(send);
	}
}

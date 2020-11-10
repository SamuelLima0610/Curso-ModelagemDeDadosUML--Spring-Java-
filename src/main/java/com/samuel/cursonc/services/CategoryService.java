package com.samuel.cursonc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.samuel.cursonc.domain.Category;
import com.samuel.cursonc.repositories.CategoryRepository;
import com.samuel.cursonc.services.exceptions.ObjectNotFoundException;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository repo;
	
	public Category get(Integer id) {
		Optional<Category> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found, id: " + id + " type: "+  Category.class.getName()));
	}
	
}

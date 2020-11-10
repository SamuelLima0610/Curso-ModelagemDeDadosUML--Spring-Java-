package com.samuel.cursonc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.samuel.cursonc.domain.Category;
import com.samuel.cursonc.domain.Product;
import com.samuel.cursonc.repositories.CategoryRepository;
import com.samuel.cursonc.repositories.ProductRepository;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner{

	@Autowired
	private CategoryRepository categoryRepo;
	@Autowired
	private ProductRepository productRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Category cat1 = new Category(null,"Informática");
		Category cat2 = new Category(null,"Escritório");
		Product p1 = new Product(null,"Computador",2000.00);
		Product p2 = new Product(null,"Impressora",800.00);
		Product p3 = new Product(null,"Mouse",80.00);
		cat1.getProducts().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProducts().add(p2);
		p1.getCategories().addAll(Arrays.asList(cat1));
		p2.getCategories().addAll(Arrays.asList(cat1,cat2));
		p3.getCategories().addAll(Arrays.asList(cat1));
		categoryRepo.saveAll(Arrays.asList(cat1,cat2));
		productRepo.saveAll(Arrays.asList(p1,p2,p3));
	}

}

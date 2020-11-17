package com.samuel.cursonc;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.samuel.cursonc.domain.Address;
import com.samuel.cursonc.domain.BankSlip;
import com.samuel.cursonc.domain.Card;
import com.samuel.cursonc.domain.Category;
import com.samuel.cursonc.domain.City;
import com.samuel.cursonc.domain.Client;
import com.samuel.cursonc.domain.Order;
import com.samuel.cursonc.domain.Payment;
import com.samuel.cursonc.domain.Product;
import com.samuel.cursonc.domain.State;
import com.samuel.cursonc.domain.enums.ClientType;
import com.samuel.cursonc.domain.enums.PaymentState;
import com.samuel.cursonc.repositories.AddressRepository;
import com.samuel.cursonc.repositories.CategoryRepository;
import com.samuel.cursonc.repositories.CityRepository;
import com.samuel.cursonc.repositories.ClientRepository;
import com.samuel.cursonc.repositories.OrderRepository;
import com.samuel.cursonc.repositories.PaymentRepository;
import com.samuel.cursonc.repositories.ProductRepository;
import com.samuel.cursonc.repositories.StateRepository;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner{

	@Autowired
	private CategoryRepository categoryRepo;
	@Autowired
	private ProductRepository productRepo;
	@Autowired
	private StateRepository stateRepo;
	@Autowired
	private CityRepository cityRepo;
	@Autowired
	private ClientRepository clientRepo;
	@Autowired
	private AddressRepository addressRepo;
	@Autowired
	private OrderRepository orderRepo;
	@Autowired
	private PaymentRepository paymentRepo;
	
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
		
		State st1 = new State(null, "Minas Gerais");
		State st2 = new State(null, "São Paulo");
		
		City c1 = new City(null,"Uberlândia",st1);
		City c2 = new City(null,"São Paulo",st2);
		City c3 = new City(null,"Campinas",st2);
		
		cat1.getProducts().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProducts().add(p2);
		
		p1.getCategories().addAll(Arrays.asList(cat1));
		p2.getCategories().addAll(Arrays.asList(cat1,cat2));
		p3.getCategories().addAll(Arrays.asList(cat1));
		
		st1.getCities().addAll(Arrays.asList(c1));
		st2.getCities().addAll(Arrays.asList(c2,c3));
		
		categoryRepo.saveAll(Arrays.asList(cat1,cat2));
		productRepo.saveAll(Arrays.asList(p1,p2,p3));
		stateRepo.saveAll(Arrays.asList(st1,st2));
		cityRepo.saveAll(Arrays.asList(c1,c2,c3));
		
		Client cli1 = new Client(null, "Maria Silva","maria@mail.com","36378912377",ClientType.PESSOAFISICA);
		
		Address ad1 = new Address(null,"Rua Flores", "300", "Jardim", "Apto 203", "38220834", c1,cli1);
		Address ad2 = new Address(null,"Avenida Matos", "105", "Centro", "Sala 800", "38777012", c2, cli1);
		
		cli1.getCellphones().addAll(Arrays.asList("12345678", "11110000"));
		cli1.getAdrresses().addAll(Arrays.asList(ad1,ad2));
		
		clientRepo.save(cli1);
		addressRepo.saveAll(Arrays.asList(ad1,ad2));
		
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm");
		
		Order od1 = new Order(null, sdf.parse("30/09/2017 10:32"), cli1, ad1);
		Order od2 = new Order(null, sdf.parse("10/10/2017 19:35"), cli1, ad2);
		
		cli1.getOrders().addAll(Arrays.asList(od1, od2));
		
		Payment pagto1 = new Card(null, PaymentState.QUITATO, od1, 6);
		od1.setPayment(pagto1);
		
		Payment pagto2 = new BankSlip(null, PaymentState.PENDENTE, od2, sdf.parse("20/10/2017 00:00"), null);
		od2.setPayment(pagto2);
		
		orderRepo.saveAll(Arrays.asList(od1, od2));
		paymentRepo.saveAll(Arrays.asList(pagto1, pagto2));
		
	}

}

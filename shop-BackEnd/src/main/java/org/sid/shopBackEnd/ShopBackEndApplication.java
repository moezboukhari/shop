package org.sid.shopBackEnd;

import java.util.Optional;

import org.sid.shopBackEnd.dao.CategoryDao;
import org.sid.shopBackEnd.dto.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ShopBackEndApplication implements CommandLineRunner{
	@Autowired
	CategoryDao categoryDao;
	public static void main(String[] args) {
		SpringApplication.run(ShopBackEndApplication.class, args);
		
	}
 
@Override
public void run(String... args) throws Exception {
	// TODO Auto-generated method stub
	

	
}	
		
	
}

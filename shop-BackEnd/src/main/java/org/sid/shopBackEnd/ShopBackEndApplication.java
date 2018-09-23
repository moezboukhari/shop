package org.sid.shopBackEnd;

import java.util.Optional;

import org.sid.shopBackEnd.dao.CategoryDao;
import org.sid.shopBackEnd.dao.ProductRepository;
import org.sid.shopBackEnd.dto.Category;
import org.sid.shopBackEnd.dto.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ShopBackEndApplication implements CommandLineRunner{
	@Autowired
	CategoryDao categoryDao;
	@Autowired
	ProductRepository productRepository;
	public static void main(String[] args) {
		SpringApplication.run(ShopBackEndApplication.class, args);
		
	}
 
@Override
public void run(String... args) throws Exception {
	    
//     categoryDao.save(new Category(null,"Television","this is some description for television","CAT_1.png",true));
//     categoryDao.save(new Category(null,"Laptop","this is some description for Laptop","CAT_2.png",true));
//     categoryDao.save(new Category(null,"Telephone","this is some description for telephone","CAT_3.png",true));
//	productRepository.save(new Product());
     System.out.println(productRepository.findByIs_active(true));
    
	

	
}	
		
	
}

package org.sid.shopFrontEnd;

import org.apache.catalina.core.ApplicationContext;
import org.sid.shopBackEnd.dao.CategoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

//@ComponentScan({"org.sid.shopBackEnd.dao","org.sid.shopBackEnd"})

@SpringBootApplication
public class ShopFrontEndApplication {
	
	
	
	public static void main(String[] args) {
		 SpringApplication.run(ShopFrontEndApplication.class, args);
	    //System.out.println(ctx.getBean(CategoryDao.class).findAll());
	    
	    
	    
	}

	
//		System.out.println("1111111111111111111111111111");
//		//categoryDao.save(new Category(null,"Television","this is some description for television","CAT_1.png",true));
//		
//		System.out.println(categoryDao.findAll());
	
}

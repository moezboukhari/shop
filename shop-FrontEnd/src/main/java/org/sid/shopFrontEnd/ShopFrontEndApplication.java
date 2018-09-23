package org.sid.shopFrontEnd;

import org.sid.shopBackEnd.dao.CategoryDao;
import org.sid.shopBackEnd.dto.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

//@ComponentScan({"org.sid.shopBackEnd.dao","org.sid.shopBackEnd"})

@SpringBootApplication
public class ShopFrontEndApplication {
	
	@Autowired
	public static  CategoryDao categoryDao;
	
	public static void main(String[] args) {
		 ConfigurableApplicationContext ctx =  SpringApplication.run(ShopFrontEndApplication.class, args);
		 categoryDao = ctx.getBean(CategoryDao.class);
	    
//         categoryDao.save(new Category(null,"Television","this is some description for television","CAT_1.png",true));
//         categoryDao.save(new Category(null,"Laptop","this is some description for Laptop","CAT_2.png",true));
//         categoryDao.save(new Category(null,"Telephone","this is some description for telephone","CAT_3.png",true));

         System.out.println(categoryDao.findAll());
	    
	}

	
//		System.out.println("1111111111111111111111111111");
//		
		
	
}

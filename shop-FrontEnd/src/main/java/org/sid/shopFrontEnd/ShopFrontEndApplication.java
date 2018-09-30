package org.sid.shopFrontEnd;

import java.lang.annotation.Annotation;

import javax.servlet.annotation.MultipartConfig;

import org.sid.shopBackEnd.dao.CategoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.multipart.MultipartResolver;
//import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;

//@ComponentScan({"org.sid.shopBackEnd.dao","org.sid.shopBackEnd"})

@SpringBootApplication
public class ShopFrontEndApplication {
	
	@Bean
	public MultipartResolver multipartResolver() {
	    StandardServletMultipartResolver multipartResolver = new StandardServletMultipartResolver();
	    //multipartResolver.setMaxUploadSize(500000000);
	    return multipartResolver;
	}
	@Bean
	public MultipartConfig multipartConfig() {
		MultipartConfig mp = new MultipartConfig() {
			
			@Override
			public Class<? extends Annotation> annotationType() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public long maxRequestSize() {
				
				return 4194301;//4MB
			}
			
			@Override
			public long maxFileSize() {
				return 2097152;//2MB
			}
			
			@Override
			public String location() {
				
				return null;
			}
			
			@Override
			public int fileSizeThreshold() {
				
				return 1048576;//1MB
			}
		};
		return mp;
	}
	
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

package org.sid.shopBackEnd;



import static org.junit.Assert.assertArrayEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.sid.shopBackEnd.dao.CategoryDao;
import org.sid.shopBackEnd.dto.Category;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CategoryTestCase {
private static AnnotationConfigApplicationContext context;
private static CategoryDao categoryDao;
private  Category category;
@BeforeClass
public static void init() {
	
	context = new AnnotationConfigApplicationContext();
	context.scan("org.sid.shopBackEnd");
	context.refresh();
	categoryDao = (CategoryDao) context.getBean("categoryDao");
	
}
	@Test
	public void testSave() {
		category = new Category();
		category.setName("test");
		
//assertArrayEquals("message", true,categoryDao.save(category).getClass());		//fail("Not yet implemented");
	}

}

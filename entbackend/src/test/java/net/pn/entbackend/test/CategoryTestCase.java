package net.pn.entbackend.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.pn.entbackend.dao.CategoryDAO;
import net.pn.entbackend.dto.Category;

public class CategoryTestCase {

	private static AnnotationConfigApplicationContext context;
	
	private static CategoryDAO categoryDAO;
	
	private Category category;
	
	@BeforeClass
	public static void init()
	
	{
		
		context =  new AnnotationConfigApplicationContext();
	   context.scan("net.pn.entbackend");
	   context.refresh();
	   
	   categoryDAO = (CategoryDAO)context.getBean("categoryDAO");
		
	}
	
/*	@Test
	public void testAddCategory()
	{
		category = new Category();
		category.setName("pateries");
		category.setActive(true);
		
		assertEquals("succesfully added a categoey",true,categoryDAO.add(category));
		
		
	}*/
	
	@Test
	public void testGetCategory()
	{
		category = categoryDAO.get(5);
		assertEquals("succesfully fatched a categoey","pasteries",category.getName());
		
	}
	
}
									
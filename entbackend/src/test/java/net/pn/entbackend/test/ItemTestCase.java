package net.pn.entbackend.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.pn.entbackend.dao.ItemDAO;
import net.pn.entbackend.dto.Item;

public class ItemTestCase {
	
private static AnnotationConfigApplicationContext context;
	
	
	private static ItemDAO itemDAO;
	
	
	private Item item;
	
	
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("net.pn.entbackend");
		context.refresh();
		itemDAO = (ItemDAO)context.getBean("itemDAO");
	}
	
/*	@Test
	public void testCRUDItem() {
		
		// create operation
		item = new Item();
				
		item.setName("butterscotch cake");
		item.setDescription("butterscotch");
		item.setCategoryId(1);
	
		assertEquals("Something went wrong while inserting a new item!",
				true,itemDAO.add(item));		
		
		
		// reading and updating the category
		item = itemDAO.get(1);
		item.setName("chocolate truffle");
		assertEquals("Something went wrong while updating the existing record!",
				true,itemDAO.update(item));		
				
		assertEquals("Something went wrong while deleting the existing record!",
				true,itemDAO.delete(item));		
		
		// list
		assertEquals("Something went wrong while fetching the list of items!",
				5,itemDAO.list().size());		
				
	}
*/
	
	@Test
	public void testListActiveItems() {
		assertEquals("Something went wrong while fetching the list of items!",
				8,itemDAO.listActiveItems().size());				
	} 
	
	
	/*@Test
	public void testListActiveItemsByCategory() {
		assertEquals("Something went wrong while fetching the list of items!",
				3,itemDAO.listActiveItemsByCategory(3).size());
		assertEquals("Something went wrong while fetching the list of items!",
				2,itemDAO.listActiveItemsByCategory(1).size());
	} 
	*/
	
	
	


}

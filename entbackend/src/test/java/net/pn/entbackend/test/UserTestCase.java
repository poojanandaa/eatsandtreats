package net.pn.entbackend.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.pn.entbackend.dao.UserDAO;
import net.pn.entbackend.dto.Cart;
import net.pn.entbackend.dto.User;

public class UserTestCase {

	private static AnnotationConfigApplicationContext context;
	private static UserDAO userDAO;
	private User user = null;
	/* private Cart cart = null; */

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("net.pn.entbackend");
		context.refresh();

		userDAO = (UserDAO) context.getBean("userDAO");
	}

	@Test
	public void testAddUser() {

		user = new User();
		user.setFirstName("pooja");
		user.setLastName("nanda");
		user.setEmail("nanda.pooja52@gmail.com");
		user.setContactNumber("1234512345");
		user.setRole("ADMIN");
		user.setEnabled(true);
		user.setPassword("12345");

		Cart cart = new Cart();

		//linked the cart with the user
		cart.setUser(user);
		//link the user with the cart
		 user.setCart(cart);

		// add the user
		assertEquals("Failed to add the user!", true, userDAO.add(user));

	}

	
	  @Test 
	  public void testUpdateCart() {
		  
	  user = userDAO.getByEmail("nanda.pooja52@gmail.com"); 
	  Cart cart = user.getCart();
	  cart.setGrandTotal(100); 
	  cart.setCartLines(1);
	  assertEquals("Failed to update the cart!", true,userDAO.update(cart)); 
	  
	  }
	  
	
	/* @Test 
	  public void email() {
		  
	  user = userDAO.getByEmail("nanda.pooja52@gmail.com"); 
	 
	  assertEquals("Failed to update the cart!",1,userDAO.getByEmail("nanda.pooja52@gmail.com")); 
	  
	  }*/
	 

}

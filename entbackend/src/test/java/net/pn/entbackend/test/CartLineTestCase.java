package net.pn.entbackend.test;
import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.pn.entbackend.dao.CartLineDAO;
import net.pn.entbackend.dao.ItemDAO;
import net.pn.entbackend.dao.UserDAO;
import net.pn.entbackend.dto.Cart;
import net.pn.entbackend.dto.CartLine;
import net.pn.entbackend.dto.Item;
import net.pn.entbackend.dto.User;

public class CartLineTestCase {

	

	private static AnnotationConfigApplicationContext context;
	
	
	private static CartLineDAO cartLineDAO;
	private static ItemDAO itemDAO;
	private static UserDAO userDAO;
	
	
	private CartLine cartLine = null;
	
	
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("net.pn.entbackend");
		context.refresh();
		cartLineDAO = (CartLineDAO)context.getBean("cartLineDAO");
		itemDAO = (ItemDAO)context.getBean("itemDAO");
		userDAO = (UserDAO)context.getBean("userDAO");
	}
	

	@Test
	public void testAddCartLine() {
		
		// fetch the user and then cart of that user
		User user = userDAO.getByEmail("nanda.pooja52@gmail.com");		
		Cart cart = user.getCart();
		
		// fetch the item 
		Item item = itemDAO.get(1);
		
		// Create a new CartLine
		cartLine = new CartLine();
		cartLine.setCartId(cart.getId());
		cartLine.setItem(item);
		cartLine.setItemCount(1);
		
		double oldTotal = cartLine.getTotal();		
		
		cartLine.setTotal(item.getUnitPrice() * cartLine.getItemCount());
		
		cart.setCartLines(cart.getCartLines() + 1);
		cart.setGrandTotal(cart.getGrandTotal() + (cartLine.getTotal() - oldTotal));
		
		assertEquals("Failed to add the CartLine!",true, cartLineDAO.add(cartLine));
		assertEquals("Failed to update the cart!",true, userDAO.update(cart));
		
	}
	
	
	
	@Test
	public void testUpdateCartLine() {

		// fetch the user and then cart of that user
		User user = userDAO.getByEmail("nanda.pooja52@gmail.com");		
		Cart cart = user.getCart();
				
		cartLine = cartLineDAO.getByCartAndItem(cart.getId(), 1);
		
		cartLine.setItemCount(cartLine.getItemCount() + 1);
				
		double oldTotal = cartLine.getTotal();
				
		cartLine.setTotal(cartLine.getItem().getUnitPrice() * cartLine.getItemCount());
		
		cart.setGrandTotal(cart.getGrandTotal() + (cartLine.getTotal() - oldTotal));
		
		assertEquals("Failed to update the CartLine!",true, cartLineDAO.update(cartLine));	

		
	}
	
	
	
}

package net.pn.eatsandtreats.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.pn.eatsandtreats.model.UserModel;
import net.pn.entbackend.dao.CartLineDAO;
import net.pn.entbackend.dao.ItemDAO;
import net.pn.entbackend.dto.Cart;
import net.pn.entbackend.dto.CartLine;
import net.pn.entbackend.dto.Item;

@Service("cartService")
public class CartService {

	@Autowired
	private CartLineDAO cartLineDAO;
	
	@Autowired
	private ItemDAO itemDAO;
		
	@Autowired
	private HttpSession session;
	
	public List<CartLine> getCartLines() {

		return cartLineDAO.list(getCart().getId());

	}
	
	/* to update the cart count */
	public String manageCartLine(int cartLineId, int count) {
		
		CartLine cartLine = cartLineDAO.get(cartLineId);		

		double oldTotal = cartLine.getTotal();

		
		Item item = cartLine.getItem();
		
		// check if that much quantity is available or not
		if(item.getQuantity() < count) {
			return "result=unavailable";		
		}	
		
		// update the cart line
		cartLine.setItemCount(count);
		cartLine.setBuyingPrice(item.getUnitPrice());
		cartLine.setTotal(item.getUnitPrice() * count);
		cartLineDAO.update(cartLine);

	
		// update the cart
		Cart cart = this.getCart();
		cart.setGrandTotal(cart.getGrandTotal() - oldTotal + cartLine.getTotal());
		cartLineDAO.updateCart(cart);
		
		return "result=updated";
	}



	public String addCartLine(int itemId) {		
		Cart cart = this.getCart();
		String response = null;
		CartLine cartLine = cartLineDAO.getByCartAndItem(cart.getId(), itemId);
		if(cartLine==null) {
			// add a new cartLine if a new item is getting added
			cartLine = new CartLine();
			Item item = itemDAO.get(itemId);
			// transfer the item details to cartLine
			cartLine.setCartId(cart.getId());
			cartLine.setItem(item);
			cartLine.setItemCount(1);
			cartLine.setBuyingPrice(item.getUnitPrice());
			cartLine.setTotal(item.getUnitPrice());
			
			// insert a new cartLine
			cartLineDAO.add(cartLine);
			
			// update the cart
			cart.setGrandTotal(cart.getGrandTotal() + cartLine.getTotal());
			cart.setCartLines(cart.getCartLines() + 1);
			cartLineDAO.updateCart(cart);

			response = "result=added";						
		} 
		else {
			// check if the cartLine has been already reached to maximum count
			if(cartLine.getItemCount() < 3) {
				// call the manageCartLine method to increase the count
				response = this.manageCartLine(cartLine.getId(), cartLine.getItemCount() + 1);				
			}			
			else {				
				response = "result=maximum";				
			}						
		}		
		return response;
	}
	
	private Cart getCart() {
		return ((UserModel)session.getAttribute("userModel")).getCart();
	}


	public String removeCartLine(int cartLineId) {
		
		CartLine cartLine = cartLineDAO.get(cartLineId);
		// deduct the cart
		// update the cart
		Cart cart = this.getCart();	
		cart.setGrandTotal(cart.getGrandTotal() - cartLine.getTotal());
		cart.setCartLines(cart.getCartLines() - 1);		
		cartLineDAO.updateCart(cart);
		
		// remove the cartLine
		cartLineDAO.remove(cartLine);
				
		return "result=deleted";
	}


	public String validateCartLine() {
		Cart cart = this.getCart();
		List<CartLine> cartLines = cartLineDAO.list(cart.getId());
		double grandTotal = 0.0;
		int lineCount = 0;
		String response = "result=success";
		boolean changed = false;
		Item item = null;
		for(CartLine cartLine : cartLines) {					
			item = cartLine.getItem();
			changed = false;
			// check if the item is active or not
			// if it is not active make the availability of cartLine as false
			if((!item.isActive() && item.getQuantity() == 0) && cartLine.isAvailable()) {
				cartLine.setAvailable(false);
				changed = true;
			}			
			// check if the cartLine is not available
			// check whether the item is active and has at least one quantity available
			if((item.isActive() && item.getQuantity() > 0) && !(cartLine.isAvailable())) {
					cartLine.setAvailable(true);
					changed = true;
			}
			
			// check if the buying price of item has been changed
			if(cartLine.getBuyingPrice() != item.getUnitPrice()) {
				// set the buying price to the new price
				cartLine.setBuyingPrice(item.getUnitPrice());
				// calculate and set the new total
				cartLine.setTotal(cartLine.getItemCount() * item.getUnitPrice());
				changed = true;				
			}
			
			// check if that much quantity of item is available or not
			if(cartLine.getItemCount() > item.getQuantity()) {
				cartLine.setItemCount(item.getQuantity());										
				cartLine.setTotal(cartLine.getItemCount() * item.getUnitPrice());
				changed = true;
				
			}
			
			// changes has happened
			if(changed) {				
				//update the cartLine
				cartLineDAO.update(cartLine);
				// set the result as modified
				response = "result=modified";
			}
			
			grandTotal += cartLine.getTotal();
			lineCount++;
		}
		
		cart.setCartLines(lineCount++);
		cart.setGrandTotal(grandTotal);
		cartLineDAO.updateCart(cart);

		return response;
	}	
}

package net.pn.entbackend.dao;

import java.util.List;

import net.pn.entbackend.dto.Cart;
import net.pn.entbackend.dto.CartLine;

public interface CartLineDAO {

	public List<CartLine> list(int cartId);
	public CartLine get(int id);	
	public boolean add(CartLine cartLine);
	public boolean update(CartLine cartLine);
	public boolean remove(CartLine cartLine);
	
	// fetch the CartLine based on cartId and itemId
	public CartLine getByCartAndItem(int cartId, int itemId);		
		
	// updating the cart
	boolean updateCart(Cart cart);
	
	// list of available cartLine
	public List<CartLine> listAvailable(int cartId);
	
	
	
}

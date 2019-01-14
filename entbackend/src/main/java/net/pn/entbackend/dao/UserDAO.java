package net.pn.entbackend.dao;

import net.pn.entbackend.dto.Cart;
import net.pn.entbackend.dto.User;

public interface UserDAO {

	User getByEmail(String email);
	User get(int id);

	boolean add(User user);
	
	boolean update(Cart cart);
	

}

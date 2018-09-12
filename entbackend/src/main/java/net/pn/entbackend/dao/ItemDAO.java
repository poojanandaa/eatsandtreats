package net.pn.entbackend.dao;

import java.util.List;

import net.pn.entbackend.dto.Item;

public interface ItemDAO {
	
		public Item get(int id);
		boolean add(Item item);
		List <Item> list();
		public boolean update(Item item);
		public boolean delete(Item item);
		
		
		
		List <Item> listActiveItems();
		List <Item> listActiveItemsByCategory(int categoryId);
		

	

}

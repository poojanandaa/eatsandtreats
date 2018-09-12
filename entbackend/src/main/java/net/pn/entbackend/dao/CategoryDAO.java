package net.pn.entbackend.dao;

import java.util.List;

import net.pn.entbackend.dto.Category;


public interface CategoryDAO {
	
	boolean add(Category category);
	List <Category> list();
	public Category get(int id);
	public boolean updateCategory(Category category);
	public boolean deleteCategory(Category category);
	

}

package net.pn.entbackend.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import net.pn.entbackend.dao.CategoryDAO;
import net.pn.entbackend.dto.Category;


@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {

	private static List<Category> categories = new ArrayList<>();
	
	static
	{
		Category category = new Category();
		category.setId(1);
		category.setName("cakes");
		category.setActive(true);
		
		categories.add(category);
		
	}

	public List<Category> list() {

		return categories;
	}

}

package net.pn.entbackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.pn.entbackend.dao.CategoryDAO;
import net.pn.entbackend.dto.Category;

@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	private SessionFactory sessionFactory;

	private static List<Category> categories = new ArrayList<>();

	public List<Category> list() 
	{
		return categories;
	}
	


	@Override
	@Transactional
	public boolean add(Category category) {
		
		try {
			sessionFactory.getCurrentSession().persist(category);
			
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}



	@Override
	@Transactional
	public Category get(int id) {
			return sessionFactory.getCurrentSession().get(Category.class, Integer.valueOf(id));
	}



	@Override
	public boolean updateCategory(Category category) {
		// TODO Auto-generated method stub
		return false;
	}

}

package net.pn.entbackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.pn.entbackend.dao.ItemDAO;
import net.pn.entbackend.dto.Item;

@Transactional
@Repository("itemDAO")
public class ItemDAOImpl implements ItemDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	public Item get(int id) {
		return sessionFactory.getCurrentSession().get(Item.class, Integer.valueOf(id));
	}

	
	public boolean add(Item item) {
		try {
			sessionFactory.getCurrentSession().persist(item);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	
	public List<Item> list() {
		return sessionFactory.getCurrentSession().createQuery("FROM Item", Item.class).getResultList();
	}
	
	
	public boolean update(Item item) {
		try {
			sessionFactory.getCurrentSession().update(item);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	
	public boolean delete(Item item) {
		item.setActive(false);

		try {
			sessionFactory.getCurrentSession().update(item);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	
	public List<Item> listActiveItems() {
		String selectActiveItems = "FROM Item WHERE active = :active ";
		return sessionFactory.getCurrentSession()
								.createQuery(selectActiveItems, Item.class)
									.setParameter("active", true)
										.getResultList();
											
		
	}

	
	public List<Item> listActiveItemsByCategory(int categoryId) {
		String selectActiveItemsByCategory = "FROM Item WHERE active = :active and categoryId = :categoryId ";
		return sessionFactory.getCurrentSession()
								.createQuery(selectActiveItemsByCategory, Item.class)
									.setParameter("active", true)
										.setParameter("categoryId", categoryId)
											.getResultList();
	}

	
}

package com.java.jsf.Dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import com.java.jsf.model.Menu;
import com.java.jsf.model.Restaurant;
import com.java.jsf.util.SessionHelper;

public class CanteenDaoImpl implements CanteenDao {

	Session session;

	@Override
	public List<Restaurant> showRestaurant() {
		session = SessionHelper.getSessionFactory().openSession();
		Query query = session.getNamedQuery("showRestaurant");
		List<Restaurant> reslist = query.list();
		return reslist;
	}

//	@Override
//	public List<Menu> showMenubyId(int restaurantId) {
//		session = SessionHelper.getSessionFactory().openSession();
//		Query query = session.getNamedQuery("searchMenu");
//		query.setParameter("restaurantId", restaurantId);
//		List<Menu> menuList = query.list(); 
//		session.close();
//		return menuList;
//	}
//	
	
	@Override
	public List<Menu> showMenubyId(int restId) {
		session = SessionHelper.getSessionFactory().openSession();
		Query query = session.getNamedQuery("showMenuById");
		query.setParameter("restaurantId", restId);
		List<Menu> menuList = query.list();
		session.close();
		return menuList;
	}

}

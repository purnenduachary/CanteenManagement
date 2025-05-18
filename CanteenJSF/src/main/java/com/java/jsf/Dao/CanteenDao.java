package com.java.jsf.Dao;

import java.util.List;

import com.java.jsf.model.Menu;
import com.java.jsf.model.Restaurant;

public interface CanteenDao {

	List<Restaurant> showRestaurant();
	
	List<Menu> showMenubyId(int restId);

	
	
}

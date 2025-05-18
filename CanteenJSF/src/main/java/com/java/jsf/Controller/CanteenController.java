package com.java.jsf.Controller;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.faces.context.FacesContext;

import com.java.jsf.Dao.CanteenDaoImpl;
import com.java.jsf.model.Menu;
import com.java.jsf.model.Restaurant;

public class CanteenController {

	private CanteenDaoImpl dao;
	private Menu menu;
	private Restaurant res;

	private List<Menu> menuList;
	private List<Menu> paginatedMenuList;

	private int restaurantId;
	private int page = 0;
	private int pageSize = 5;
	
	private String sortField;
	private boolean ascending  = true;
	private List<Restaurant> resList;
	private List<Menu> menList;
	
	
	
	
	
	public List<Menu> getMenList() {
		return menList;
	}


	public void setMenList(List<Menu> menList) {
		this.menList = menList;
	}


	public CanteenController() {
		dao = new CanteenDaoImpl();
	}
	
	
	public void sortBy(String field) {
		if(field.equals(sortField)) {
			ascending = !ascending;
		}
		else {
			sortField = field;
			ascending = true;
		}
	}
	
   public void sortList() {
	   if(sortField ==null || resList == null) {
		   return;
	   }
	   
	   Collections.sort(resList, (e1, e2) -> {
           try {
               Field f = Restaurant.class.getDeclaredField(sortField);
               f.setAccessible(true);
               Comparable v1 = (Comparable) f.get(e1);
               Comparable v2 = (Comparable) f.get(e2);
               return ascending ? v1.compareTo(v2) : v2.compareTo(v1);
           } catch (Exception ex) {
               return 0;
           }
       });
   }
	
	
	public String getSortField() {
		return sortField;
	}

	public void setSortField(String sortField) {
		this.sortField = sortField;
	}

	public boolean isAscending() {
		return ascending;
	}

	public void setAscending(boolean ascending) {
		this.ascending = ascending;
	}

	public List<Restaurant> getResList() {
		return resList;
	}

	public void setResList(List<Restaurant> resList) {
		this.resList = resList;
	}

	

	public List<Menu> getPaginatedMenuList() {
		if (menuList == null) {
			String restIdParam = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap()
					.get("restaurantid");

			if (restIdParam != null && restIdParam.trim().matches("\\d+")) {
				restaurantId = Integer.parseInt(restIdParam.trim());
				menuList = dao.showMenubyId(restaurantId);
			} else {
				menuList = new ArrayList<>();
			}
		}

		int fromIndex = page * pageSize;
		int toIndex = Math.min(fromIndex + pageSize, menuList.size());

		paginatedMenuList = menuList.subList(fromIndex, toIndex);
		return paginatedMenuList;
	}

	public void nextPage() {
		if ((page + 1) * pageSize < menuList.size()) {
			page++;
		}
	}

	public void previousPage() {
		if (page > 0) {
			page--;
		}
	}

	public boolean isHasNextPage() {
		return (page + 1) * pageSize < menuList.size();
	}

	public boolean isHasPreviousPage() {
		return page > 0;
	}

	
	
	public List<Restaurant> getRestaurantList() {
		resList =  dao.showRestaurant();
		sortList();
		return resList;
	}

	public List<Menu> showMenubyId(int restId) {
		menList = dao.showMenubyId(restId);
		sortList();
		return menList;
		
	}


	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public Restaurant getRes() {
		return res;
	}

	public void setRes(Restaurant res) {
		this.res = res;
	}

	public int getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}

	public List<Menu> getMenuList() {
		return menuList;
	}

	public void setMenuList(List<Menu> menuList) {
		this.menuList = menuList;
	}

	public List<Menu> getPaginatedList() {
		return paginatedMenuList;
	}

	public void setPaginatedMenuList(List<Menu> paginatedMenuList) {
		this.paginatedMenuList = paginatedMenuList;
	}

	public CanteenDaoImpl getDao() {
		return dao;
	}

	public void setDao(CanteenDaoImpl dao) {
		this.dao = dao;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
}

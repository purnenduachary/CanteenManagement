package com.java.jsf.Controller;

import java.util.ArrayList;
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

	// ✅ Constructor to initialize DAO
	public CanteenController() {
		dao = new CanteenDaoImpl();
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
		return dao.showRestaurant();
	}

	public List<Menu> showMenubyId(int restId) {
		return dao.showMenubyId(restId);
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

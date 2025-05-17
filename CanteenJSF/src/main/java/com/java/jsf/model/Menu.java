package com.java.jsf.model;

public class Menu {

	private int menuId;
	private String itemName;
	private double price;
	private int restaurantId;
	private double rating;

	public Menu(int menuId, String itemName, double price, int restaurantId, double rating) {
		super();
		this.menuId = menuId;
		this.itemName = itemName;
		this.price = price;
		this.restaurantId = restaurantId;
		this.rating = rating;
	}

	public Menu() {
		super();
	}

	public int getMenuId() {
		return menuId;
	}

	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "Menu [menuId=" + menuId + ", itemName=" + itemName + ", price=" + price + ", restaurantId="
				+ restaurantId + ", rating=" + rating + "]";
	}

//	CREATE TABLE Menu (
//		    MenuId INT PRIMARY KEY AUTO_INCREMENT,
//		    ItemName VARCHAR(30),
//		    Price NUMERIC(9,2),
//		    RestaurantId INT,
//		    Rating NUMERIC(9,2),
//		    FOREIGN KEY (RestaurantId) REFERENCES Restaurant(RestaurantId)
//		);

}

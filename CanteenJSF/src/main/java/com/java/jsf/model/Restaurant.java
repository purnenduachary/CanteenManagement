package com.java.jsf.model;


public class Restaurant {

	private int restaurantId;
	private String restaurantName;
	private String city;
	private double rating;
	private Flag flag;

	public Restaurant(int restaurantId, String restaurantName, String city, double rating, Flag flag) {
		this.restaurantId = restaurantId;
		this.restaurantName = restaurantName;
		this.city = city;
		this.rating = rating;
		this.flag = flag;
	}

	public Restaurant() {
	}

	public int getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}

	public String getRestaurantName() {
		return restaurantName;
	}

	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public Flag getFlag() {
		return flag;
	}

	public void setFlag(Flag flag) {
		this.flag = flag;
	}

	@Override
	public String toString() {
		return "Restaurant [restaurantId=" + restaurantId + ", restaurantName=" + restaurantName + ", city=" + city
				+ ", rating=" + rating + ", flag=" + flag + "]";
	}

}

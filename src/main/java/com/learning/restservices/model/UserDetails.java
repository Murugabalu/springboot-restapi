package com.learning.restservices.model;

public class UserDetails {
	
	private String first_name;
	private String last_name;
	private String city;
	
	public UserDetails(String first_name, String last_name, String city) {
		this.first_name = first_name;
		this.last_name = last_name;
		this.city = city;
	}
	
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Override
	public String toString() {
		return "UserDetails [first_name=" + first_name + ", last_name=" + last_name + ", city=" + city + "]";
	}

}
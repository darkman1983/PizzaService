/**
 *
 */
package com.pizzacontrol.model;

/**
 * @author Der_B
 *
 */
public class Customer {
	private String id;
	private String name;
	private String firstname;
	private String username;
	private String password;
	private String street;
	private String housenumber;
	private String zip;
	private String city;
	private String phone;
	private String mobile;
	private String email;

	/**
	 * @param id
	 * @param name
	 * @param firstname
	 * @param username
	 * @param password
	 * @param street
	 * @param housenumber
	 * @param zip
	 * @param city
	 * @param phone
	 * @param mobile
	 * @param email
	 */
	public Customer(String id, String name, String firstname, String username, String password, String street, String housenumber, String zip, String city, String phone, String mobile, String email) {
		this.id = id;
		this.name = name;
		this.firstname = firstname;
		this.username = username;
		this.password = password;
		this.street = street;
		this.housenumber = housenumber;
		this.zip = zip;
		this.city = city;
		this.phone = phone;
		this.mobile = mobile;
		this.email = email;
	}

	/**
	 * @param id
	 * @param name
	 * @param firstname
	 */
	public Customer(String id, String name, String firstname) {
		this.id = id;
		this.name = name;
		this.firstname = firstname;
	}
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the firstname
	 */
	public String getFirstname() {
		return firstname;
	}
	/**
	 * @param firstname the firstname to set
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the street
	 */
	public String getStreet() {
		return street;
	}
	/**
	 * @param street the street to set
	 */
	public void setStreet(String street) {
		this.street = street;
	}
	/**
	 * @return the housenumber
	 */
	public String getHousenumber() {
		return housenumber;
	}
	/**
	 * @param housenumber the housenumber to set
	 */
	public void setHousenumber(String housenumber) {
		this.housenumber = housenumber;
	}
	/**
	 * @return the zip
	 */
	public String getZip() {
		return zip;
	}
	/**
	 * @param zip the zip to set
	 */
	public void setZip(String zip) {
		this.zip = zip;
	}
	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * @return the mobile
	 */
	public String getMobile() {
		return mobile;
	}
	/**
	 * @param mobile the mobile to set
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
}

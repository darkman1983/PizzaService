/**
 *
 */
package com.pizzacontrol.dao;

import java.util.ArrayList;

import com.pizzacontrol.model.Customer;

/**
 * @author Der_B
 *
 */
public interface CustomerDAO {
	public int insertCustomer(String name, String firstname, String street);

	public boolean updateCustomer(Customer customer);

	public boolean deleteCustomer(int id);
	public Customer findCustomer(int id);
	public ArrayList<Customer> findCustomer(String name);
	public ArrayList<Customer> selectAllCustomers();
}

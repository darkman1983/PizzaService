/**
 *
 */
package com.pizzacontrol.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Connection;

import com.pizzacontrol.model.Customer;

/**
 * @author Der_B
 *
 */
public class MySQLCustomerDAO implements CustomerDAO {


private Connection dbConnect;

public MySQLCustomerDAO (){
	this.dbConnect = (Connection) MySQLDAOFactory.createConnection();
}

	/* (non-Javadoc)
	 * @see com.pizzacontrol.dao.CustomerDAO#insertCustomer(java.lang.String, java.lang.String)
	 */
	@Override
	public int insertCustomer(String name, String firstname, String street) {
		String sql = "INSERT INTO customers (`name`, `firstname`, `street`) VALUES(?, ?, ?)";
		int id = -1;

		if(this.dbConnect != null) {
			try {
				PreparedStatement preStm = this.dbConnect.prepareStatement(sql);
				preStm.setString(1, name);
				preStm.setString(2, firstname);
				preStm.setString(3, street);

				Statement stmt = this.dbConnect.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT @@IDENTITY");

				if(rs != null && rs.next()) {
					id = rs.getInt(1);
				}

				stmt.close();
				preStm.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}

		return id;
	}

	/* (non-Javadoc)
	 * @see com.pizzacontrol.dao.CustomerDAO#updateCustomer(com.pizzacontrol.model.Customer)
	 */
	@Override
	public boolean updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see com.pizzacontrol.dao.CustomerDAO#deleteCustomer(int)
	 */
	@Override
	public boolean deleteCustomer(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see com.pizzacontrol.dao.CustomerDAO#findCustomer(int)
	 */
	@Override
	public Customer findCustomer(String id) {
		String sql = "SELECT * FROM custWithCity WHERE id=" + id;
		Customer customer = null;

		if(this.dbConnect != null){
			Statement stmt;
			try {

				stmt = this.dbConnect.createStatement();
				ResultSet rs = stmt.executeQuery(sql);

				while(rs.next()){
					String uid = rs.getString(1);
					String name = rs.getString(2);
					String firstname = rs.getString(3);
					String username = rs.getString(4);
					String password = rs.getString(5);
					String street = rs.getString(6);
					String housenumber = rs.getString(7);
					String zip = rs.getString(8);
					String phone = rs.getString(9);
					String mobile = rs.getString(10);
					String email = rs.getString(11);
					String city = rs.getString(12);

					customer = new Customer(uid, name, firstname, username, password, street, housenumber, zip, city, phone, mobile, email);
				}
				stmt.close();
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return customer;
	}

	/* (non-Javadoc)
	 * @see com.pizzacontrol.dao.CustomerDAO#findCustomer(java.lang.String)
	 */
	//@Override
	/*public ArrayList<Customer> findCustomer(String name) {
		// TODO Auto-generated method stub
		return null;
	}*/

	/* (non-Javadoc)
	 * @see com.pizzacontrol.dao.CustomerDAO#selectAllCustomers()
	 */
	@Override
	public ArrayList<Customer> selectAllCustomers() {
		String sql = "SELECT * FROM custWithCity";
		ArrayList<Customer> customerList = new ArrayList<Customer>();

		Statement stmt;
		if(this.dbConnect != null){
			try {
				stmt = this.dbConnect.createStatement();
				ResultSet rs = stmt.executeQuery(sql);

				while(rs.next()){
					String id = rs.getString(1);
					String name = rs.getString(2);
					String firstname = rs.getString(3);
					String username = rs.getString(4);
					String password = rs.getString(5);
					String street = rs.getString(6);
					String housenumber = rs.getString(7);
					String zip = rs.getString(8);
					String phone = rs.getString(9);
					String mobile = rs.getString(10);
					String email = rs.getString(11);
					String city = rs.getString(12);

					customerList.add(new Customer(id, name, firstname, username, password, street, housenumber, zip, city, phone, mobile, email));
				}
				stmt.close();

			}
			catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return customerList;
	}

}

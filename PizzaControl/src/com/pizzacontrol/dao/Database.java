package com.pizzacontrol.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 */

/**
 * @author tstepputtis
 *
 */
public class Database {

	private static Database dbIsntance;
	private static Connection con;
	@SuppressWarnings("unused")
	private static Statement stmt;

	private Database() {
		// private constructor //
	}

	public static Database getInstance() {
		if (dbIsntance == null) {
			dbIsntance = new Database();
		}
		return dbIsntance;
	}

	public Connection getConnection() {

		if (con == null) {
			try {
				String host = "jdbc:mysql://localhost:1527/pizzaservice";
				String username = "pizzaservice";
				String password = "0815Pizza";
				con = DriverManager.getConnection(host, username, password);
			} catch (SQLException ex) {
				Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
			}
		}

		return con;
	}
}

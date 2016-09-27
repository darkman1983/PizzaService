package com.pizzacontrol.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLDAOFactory extends DAOFactory {
	private static String className = "com.mysql.jdbc.Driver";
	//Hier müssen Ihre Daten für name und kennwort eingetragen werden, bitte nicht root benutzen
	private static String dbString = "jdbc:mysql://localhost:3306/pizzacontrol?user=pizzaservice&password=HCB5aErfXTGJu8pW";
	private static Connection connection;

	public static Connection createConnection(){
		//geändert, um das Registeren der Klasse des DB-Treibers nicht 100 mal zu machen
		try {
			if(connection == null || connection.isClosed()){
				try{
					Class.forName(className);
					connection = DriverManager.getConnection(dbString);
					System.out.println("SQL Connection active...");
					return connection;
				}
				catch(ClassNotFoundException e){
					e.printStackTrace();
				}

				catch(SQLException  e){
					e.printStackTrace();
				}
			}
			else{
				System.out.println("SQL Connection active...");
				return connection;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		System.out.println("No SQL Connection...");
		return null;

	}

	@Override
	public CustomerDAO getCustomerDAO() {
		CustomerDAO customerDAO = new MySQLCustomerDAO();

		return customerDAO;
	}

	/*public AbteilungDAO getAbteilungDAO() {
		AbteilungDAO abteilungsDAO = new MySQLAbteilungDAO();
		return abteilungsDAO;
	}

	public GruppeDAO getGruppeDAO() {
		GruppeDAO gruppeDAO = new MySQLGruppeDAO();
		return gruppeDAO;
	}*/
}

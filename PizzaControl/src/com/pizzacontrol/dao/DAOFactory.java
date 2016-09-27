package com.pizzacontrol.dao;

public abstract class DAOFactory {
	public static final int MYSQL = 1;
	public static final int ORACLE = 2;

	public abstract CustomerDAO getCustomerDAO();
	/*public abstract AbteilungDAO getAbteilungDAO();
	public abstract GruppeDAO getGruppeDAO();*/

	public static DAOFactory getDAOFactory(int whichFactory){
		switch(whichFactory){
		case MYSQL:
			System.out.println("MYSQL DAO selected...");
			return new MySQLDAOFactory();
		case ORACLE:
			//liefert nur null zurück, da nicht implementiert!
			return new OracleLDAOFactory();
		}

		return null;
	}
}

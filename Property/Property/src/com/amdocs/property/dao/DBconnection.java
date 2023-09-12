package com.amdocs.property.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnection {
	private static Connection connection;
	private static final String dbURL = "jdbc:Oracle:thin:@localhost:1521:orcl";
	private static final String user = "SYSTEM";
	private static final String pass = "Amdocs123";
	
	public static Connection getConnection() throws SQLException{
	    	connection = DriverManager.getConnection(dbURL, user, pass);
//	    	System.out.println("Connection Established");
	    	return connection;
	}
	
	public static void close() throws SQLException {
		connection.close();
		System.out.println("Connection closed");
	}
	
//	public static void main(String[] args) throws SQLException {
//		getConnection();
//		close();
//	}
}

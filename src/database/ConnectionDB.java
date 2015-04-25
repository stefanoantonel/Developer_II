package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionDB {
	
	public static Connection connection = null;
	public static String dbName;
	public static Statement statement;
	public static ResultSet resultSet;
	
//	public static Statement getStatement() {
//		return statement;
//	}
//	public static ResultSet getResultSet() {
//		return resultSet;
//	}
//	public static Connection getC() {
//		return c;
//	}
//	public static String getDbName() {
//		return dbName;
//	}
	
	public static void setup() {
		openConnection();
		generateStatement();
	}
	public static void openConnection() {
		try {
			Class.forName("org.sqlite.JDBC");
			dbName = "src/database/test.db";
			connection = DriverManager.getConnection("jdbc:sqlite:" + dbName);
			
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("error openConnection");
		}
		
	}
	public static void closeConnection() {
		try {
			statement.close(); // close the Statement object
			connection.close(); // close the Connection object
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("error closingConnection");
		} 
	}
	public static void generateStatement() {
		try {
			statement = connection.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

public class DBUtility {
	
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
		openConnection("test");
	}
	public static void openConnection(String databaseName) {
		try {
			Class.forName("org.sqlite.JDBC");
			dbName = "src/database/"+databaseName+".db";
			connection = DriverManager.getConnection("jdbc:sqlite:" + dbName);
			statement = connection.createStatement();
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
	public static void dropTable(String tableName) {
		try {
//			connection = openConnection("");
			statement = connection.createStatement();
			String drop = "DROP TABLE IF EXISTS " + tableName;
			statement.execute(drop);		
			resultSet = statement.getGeneratedKeys();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("error dropTable");
		}
	}	
	public static int getRandom() {
		double d = Math.random()*1000;
		return (int) d;
	}
}

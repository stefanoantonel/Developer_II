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
	public static void dropTable(String tableName) {
		try {
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
//	public static void createTable(String tableName, HashMap<String, String> fields) {
//		try {
//			statement = connection.createStatement();
//			StringBuilder create = new StringBuilder();
//			create.append("CREATE TABLE ");
//			create.append(tableName + "(");
//			create.append("ID INTEGER PRIMARY KEY AUTOINCREMENT,");
//			create.append("Name CHAR(20),");
//			create.append("Quantity INTEGER");
//			create.append(")");
//			statement.execute(create.toString());
//			resultSet = statement.getResultSet();	
//		} catch (Exception e) {
//			e.printStackTrace();
//			System.out.println("error createTable");
//		}
//	}
}

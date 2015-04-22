package database;

import java.sql.*;

public class A {

	private static Connection c = null;
	private static String dbName;
	private static Statement stmt;
	private static ResultSet rs;

	public static void main(String args[]) {
		openConnection();
		dropTable("MyTable");		
		createTable();
		closeConnection();
	}
	private static void dropTable(String tableName) {
		try {
			stmt = c.createStatement();
			String drop = "DROP TABLE IF EXISTS " + tableName;
			stmt.execute(drop);		
			rs = stmt.getGeneratedKeys();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}	
	private static void closeConnection() {
		try {
			stmt.close(); // close the Statement object
			c.close(); // close the Connection object
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	private static void openConnection() {
		try {
			Class.forName("org.sqlite.JDBC");
			dbName = "src/database/test.db";
			c = DriverManager.getConnection("jdbc:sqlite:" + dbName);
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	private static void createTable() {
		try {
			stmt = c.createStatement();
			StringBuilder create = new StringBuilder();
			create.append("CREATE TABLE MyTable(");
			create.append("ID INTEGER,");
			create.append("Name CHAR(20),");
			create.append("Quantity INTEGER");
			create.append(")");
			stmt.execute(create.toString());
			rs = stmt.getResultSet();	
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
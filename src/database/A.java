package database;

import java.sql.*;

public class A {

	private static Connection c = null;
	private static String dbName;
	private static Statement stmt;
	private static ResultSet rs;

	public static void main(String args[]) {

		try {
			Class.forName("org.sqlite.JDBC");
			dbName = "src/database/test.db";
			c = DriverManager.getConnection("jdbc:sqlite:" + dbName);

			dropTable("MyTable");
			stmt = c.createStatement();
			
			String create = "CREATE TABLE MyTable(firstCol INTEGER)";
			stmt.execute(create);
			rs = stmt.getResultSet();
//			System.out.println(rs.toString());
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		System.out.println("Opened database successfully");
	}

//	private static void createTable (String tableName) {
////		String dropIf = "DROP TABLE IF EXISTS " + tableName;
////		String createIf = "CREATE TABLE IF NOT EXISTS " + tableName ; 
//		
//		try {
//			String createIf = "CREATE TABLE IF NOT EXISTS " + tableName + "AS " + tableName; 
//			stmt.execute(createIf);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		
//	}
	private static void dropTable(String tableName) {
		try {
			stmt = c.createStatement();
			String drop = "DROP TABLE IF EXISTS " + tableName;
			
			stmt.execute(drop);
						
			rs = stmt.getGeneratedKeys();
//			System.out.println(rs.toString());
						
//			stmt.close(); // close the Statement object
//			c.close(); // close the Connection object
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
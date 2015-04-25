package database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class A {
	private static Statement stmt = null;
	private static Connection c = null;
	private static ResultSet rs = null;
	
	private static int pupulateNumber = 15;
	private static int fieldsRandom = 3;
	private static String tableName = "MyTable2";

	public static void main(String args[]) {
		ConnectionDB.setup();
		stmt = ConnectionDB.statement;
		c = ConnectionDB.connection;
		rs = ConnectionDB.resultSet;
		
//		ConnectionDB.openConnection();
//		dropTable(tableName);		
//		createTable();
		populateTable();
		selects();
		updates();
		ConnectionDB.closeConnection();
	}
	
	private static void dropTable(String tableName) {
		try {
			
			stmt = c.createStatement();
			String drop = "DROP TABLE IF EXISTS " + tableName;
			stmt.execute(drop);		
			rs = stmt.getGeneratedKeys();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("error dropTable");
		}
	}	
	private static void createTable() {
		try {
			stmt = c.createStatement();
			StringBuilder create = new StringBuilder();
			create.append("CREATE TABLE ");
			create.append(tableName + "(");
			create.append("ID INTEGER PRIMARY KEY AUTOINCREMENT,");
			create.append("Name CHAR(20),");
			create.append("Quantity INTEGER");
			create.append(")");
			stmt.execute(create.toString());
			rs = stmt.getResultSet();	
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("error createTable");
		}
	}
	private static void populateTable() {
		StringBuilder complete = new StringBuilder();
		int i = pupulateNumber;
		StringBuilder sb = new StringBuilder();
		complete.append("INSERT INTO ");
		complete.append(tableName + "(Name, Quantity) ");
		complete.append("VALUES ");
		do {
			sb = new StringBuilder();
			sb.append("(");
			sb.append("'Student " + getRandom() + "',");
			sb.append(getRandom());
			sb.append("),");
			complete.append(sb.toString());
			i--;
		} while (i>0);
		complete.setLength(complete.length() - 1);
		complete.append(";");
		
		try {
			stmt = c.createStatement();
			stmt.execute(complete.toString());
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("error populateTable");
		}
	}
	private static void selects() {
		
		try {
			rs = stmt.executeQuery("SELECT * FROM " + tableName + " LIMIT 5");
//			rs = stmt.getResultSet();
			while(rs.next()) {
				StringBuilder sb = new StringBuilder();
				sb.append("[");
				sb.append("ID: ");
				sb.append(rs.getString("ID"));
				sb.append(" Name: ");
				sb.append(rs.getString("Name"));
				sb.append(" Quantity: ");
				sb.append(rs.getString("Quantity"));
				sb.append("]");
				System.out.println(sb.toString());	
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	private static void updates() {
		try {
			stmt.executeUpdate("UPDATE " + tableName +  " SET Quantity = 40 WHERE ID like 4");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	private static int getRandom() {
		double d = Math.random()*1000;
		return (int) d;
	}
}
package database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;

public class A {
	private static Statement stmt = null;
	private static Connection c = null;
	private static ResultSet rs = null;
	
	private static int pupulateNumber = 15;
	private static int fieldsRandom = 3;
	private static String tableName = "MyTable2";

	public static void main(String args[]) {
		DBUtility.setup();
		stmt = DBUtility.statement;
		c = DBUtility.connection;
		rs = DBUtility.resultSet;
		
		DBUtility.openConnection();
		DBUtility.dropTable(tableName);		
		createTable(tableName);
		populateTable();
		selects();
		updates();
		DBUtility.closeConnection();
	}
	
	
	private static void createTable(String tableName) {
		
//		HashMap<String, String> fields = new HashMap<>();
//		
//		fields.put("ID", "INTEGER PRIMARY KEY AUTOINCREMENT, ");
//		fields.put("Name", "STRING,");
//		fields.put("Quantity", "INTEGER");
//		
//		for(String sw: s.keySet()) {
//			System.out.println(sw);
//			System.out.println(s.get(sw));
//		}
//		DBUtility.createTable(tableName, fields);
		try {
			stmt = c.createStatement();
			StringBuilder create = new StringBuilder();
			create.append("CREATE TABLE ");
			create.append(tableName + "(");
			create.append("ID INTEGER PRIMARY KEY AUTOINCREMENT,");
			create.append("Name TEXT,");
			create.append("Quantity INTEGER");
			create.append(")");
//			 Data Types: NULL, INTEGER, REAL, TEXT, BLOB
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
			sb.append("'Student " + DBUtility.getRandom() + "',");
			sb.append(DBUtility.getRandom());
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
			
			ArrayList<String> results = new ArrayList<>();
			while(rs.next()) {
				StringBuilder sb = new StringBuilder();
//				sb.append("[");
				sb.append("ID: ");
				sb.append(rs.getString("ID"));
				sb.append(" Name: ");
				sb.append(rs.getString("Name"));
				sb.append(" Quantity: ");
				sb.append(rs.getString("Quantity"));
//				sb.append("]");
//				sb.append("/n");
				results.add(sb.toString());
			}
			Collections.shuffle(results);
			System.out.println(results.toString());
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
	
}
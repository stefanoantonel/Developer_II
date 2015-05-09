package exampleFinal;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;

import database.DBUtility;

public class CreateDbTable {

	public static void main(String[] args) 
			throws SQLException, ClassNotFoundException {

		Connection con = null;
		Statement stmt = null;
		String DBName = StaticVariables.DBNAME;
		String tableName = StaticVariables.TABLENAME;
		String sql;
		String dbFileName = StaticVariables.DBURI;

		try {
			Class.forName("org.sqlite.JDBC");
			con = DriverManager.getConnection("jdbc:sqlite:" + dbFileName);
			stmt = con.createStatement();
			sql = "CREATE TABLE " + tableName
					+ "(vin		    TEXT		PRIMARY KEY		NOT NULL,"
					+ " make		TEXT   						NOT NULL,"
					+ " year	   	INTEGER     				NOT NULL,"
					+ " mpg		    REAL )";
			stmt.execute(sql); // execute the SQL statement
			System.out.println("DB created successfully");
			System.out.println("Table created successfully");
		} catch (Exception err) {
			try {
				stmt = con.createStatement();
				sql = "DROP TABLE IF EXISTS " + tableName;
				stmt.execute(sql);
				System.out.println("Table already exist. Deleting...");
				System.out.println("Table deleted successfully");
				main(null);
			} catch (Exception e) {
				System.err.println(err.getClass().getName() + ": "
						+ err.getMessage());
			}
		} finally {
			stmt.close();
			con.close();
		}
	}
} // end class
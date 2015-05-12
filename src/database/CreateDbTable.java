package database;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;

public class CreateDbTable
{
  public static void main( String [] args ) throws Exception
  {
    Connection con = null;
    Statement stmt = null;
    String dbFileName = "src/database/studentDB.db", sql;
    try {
      Class.forName( "org.sqlite.JDBC" );
      con = DriverManager.getConnection( "jdbc:sqlite:" + dbFileName );
      System.out.println( "DB created successfully" );

	  stmt = con.createStatement();
      sql = "CREATE TABLE student " +
            "(studentId		CHAR(10)	PRIMARY KEY		NOT NULL," +
            " studentName	CHAR(50)   	NOT NULL," +
            " studentGpa    REAL );";
      stmt.execute( sql ); // execute the SQL statement
      System.out.println( "Table created successfully" );
    }
    catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      System.exit( 0 );
    }
    finally{
	  stmt.close(); // close Statement object
      con.close(); // close Connection object
	}
  }
}
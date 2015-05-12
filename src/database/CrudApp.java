package database;

/* CrudApp.java
 * 11/26/13
 * Richard Johnson
 * This is a sample database application
 */

import javax.swing.JFrame;

public class CrudApp
{
   public static void main(String[] args) throws Exception
   {
	  JFrame frame = new CrudAppGui();
	  frame.setLocationRelativeTo(null);
      frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
      frame.setTitle( "CRUD" );
      frame.setVisible( true );
   }
}


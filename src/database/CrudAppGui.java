package database;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class CrudAppGui extends JFrame
{
	// instance fields
	private JLabel			ssnLabel;
	private JLabel			nameLabel;
	private JLabel			gpaLabel;
	private JTextField		ssnTextField;
	private JTextField		nameTextField;
	private JTextField		gpaTextField;
	private JButton			createButton;
	private JButton			readButton;
	private JButton			updateButton;
	private JButton			deleteButton;
	private JPanel			buttonPanel;
	private JPanel			textFieldPanel;
	private ActionListener 	createListener;
	private ActionListener 	readListener;
	private ActionListener 	updateListener;
	private ActionListener 	deleteListener;

	private static final int FRAME_WIDTH  = 500;
	private static final int FRAME_HEIGHT = 150;

   // constructor for the frame.
   public CrudAppGui()
   {
		ssnLabel			= new JLabel( "SSN"  );
		nameLabel			= new JLabel( "Name" );
		gpaLabel			= new JLabel( "GPA"  );
		ssnTextField		= new JTextField( 15 );
		nameTextField		= new JTextField( 30 );
		gpaTextField		= new JTextField( 5  );
		createButton 		= new JButton( "Create" );
		readButton 			= new JButton( "Read"   );
		updateButton 		= new JButton( "Update" );
		deleteButton 		= new JButton( "Delete" );

		textFieldPanel		= new JPanel();
		textFieldPanel.setLayout( new GridLayout(3, 2) );
		textFieldPanel.add( ssnLabel );
		textFieldPanel.add( ssnTextField );
		textFieldPanel.add( nameLabel );
		textFieldPanel.add( nameTextField );
		textFieldPanel.add( gpaLabel );
		textFieldPanel.add( gpaTextField );

		buttonPanel 		= new JPanel();
		buttonPanel.setLayout( new GridLayout(1, 4) );
		buttonPanel.add( createButton );
		buttonPanel.add( readButton );
		buttonPanel.add( updateButton );
		buttonPanel.add( deleteButton );

		// Add panels to content pane
		add( textFieldPanel, BorderLayout.NORTH );
		add( buttonPanel, BorderLayout.SOUTH );

	  // inner listener classes for the four buttons
      class CreateListener implements ActionListener
      {
         public void actionPerformed( ActionEvent event )
         {
            create();
         }
      }

      class ReadListener implements ActionListener
      {
         public void actionPerformed( ActionEvent event )
         {
            read();
         }
      }

      class UpdateListener implements ActionListener
      {
         public void actionPerformed( ActionEvent event )
         {
            update();
         }
      }

      class DeleteListener implements ActionListener
      {
         public void actionPerformed( ActionEvent event )
         {
            delete();
         }
      }

	  // create the listener objects
      createListener = new CreateListener();
      readListener   = new ReadListener();
      updateListener = new UpdateListener();
      deleteListener = new DeleteListener();

      // register the listener objects with the buttons
      createButton.addActionListener( createListener );
      readButton.addActionListener( readListener );
      updateButton.addActionListener( updateListener );
      deleteButton.addActionListener( deleteListener );

      setSize( FRAME_WIDTH, FRAME_HEIGHT );

   } // end constructor

   private Connection makeConnection() throws Exception{
	   Class.forName( "org.sqlite.JDBC" );
	   String dbFileName = "studentDB.db";
	   Connection con = DriverManager.getConnection( "jdbc:sqlite:" + dbFileName );
	   return con;
   }

   private void create()
   {
       try
       {
		   	String ssn, name;
		   	double gpa;
			Statement sqlStatement;
			Connection con = makeConnection();

			ssn = ssnTextField.getText();
			name = nameTextField.getText();
			gpa = Double.parseDouble( gpaTextField.getText() );

			// INSERT INTO student VALUES ( 'M111', 'Doe, John', 3.5 )
			String queryString = "INSERT INTO student VALUES ( '"
				+ ssn + "', '" + name + "', " + gpa + ")";

	       	// create a java.sql.Statement to run queries
	       	sqlStatement = con.createStatement();

	       	sqlStatement.execute( queryString );

	       	sqlStatement.close(); // close the Statement
	       	con.close(); 	      // close the Connection
   		} // end try

       catch ( Exception err )
       {
	       	JOptionPane.showMessageDialog( null, "ERROR: " + err );
       } // end catch

   } // end create


   private void read()
   {
       try
       {
			String ssn, name = "";
			double gpa = 0;

			Connection con = makeConnection();

			Statement sqlStatement;
			ResultSet resultSet;

			ssn = ssnTextField.getText();

			String queryString =
				"SELECT * FROM Student WHERE studentId = '"	+ ssn + "'";

	       	// create a java.sql.Statement to run queries
	       	sqlStatement = con.createStatement();

	       	sqlStatement.execute( queryString );

			resultSet = sqlStatement.getResultSet();
			resultSet.next();
        	if ( resultSet != null )
        	{
        		ssn  = resultSet.getString( 1 );
        		name = resultSet.getString( 2 );
        		gpa  = resultSet.getDouble( 3 );
        	}

			nameTextField.setText( name );
			gpaTextField.setText( "" + gpa );

	       	sqlStatement.close(); // close the Statement
	       	con.close(); 	      // close the Connection
   		} // end try

       catch ( Exception err )
       {
	       	JOptionPane.showMessageDialog( null, "ERROR: " + err );
       } // end catch
   } // end read


   private void update()
   {
       try
       {
			String ssn, name = "";
			double gpa = 0;
			Connection con = makeConnection();

			Statement sqlStatement;
			ResultSet resultSet;

			ssn = ssnTextField.getText();
			name = nameTextField.getText();
			gpa = Double.parseDouble( gpaTextField.getText() );

			String queryString = "UPDATE Student " +
				"SET studentId = '" + ssn + "', studentName = '" +
				 name + "' , studentGpa = " + gpa + " " +
				"WHERE studentId = '" + ssn + "'";

	       	// create a java.sql.Statement to run queries
	       	sqlStatement = con.createStatement();

	       	sqlStatement.execute( queryString );

			JOptionPane.showMessageDialog( null,
				"Record for " + ssn + " updated." );

	       	sqlStatement.close(); // close the Statement
	       	con.close(); 	      // close the Connection

   		} // end try
       catch ( Exception err )
       {
	       	JOptionPane.showMessageDialog( null, "ERROR: " + err );
       } // end catch
   } // end update()


   private void delete()
   {
       try
       {
			String ssn;

			Connection con = makeConnection();

			Statement sqlStatement;
			ResultSet resultSet;

			ssn = ssnTextField.getText();

			String queryString = "DELETE FROM Student " +
				"WHERE studentId = '" + ssn + "'";

	       	// create a java.sql.Statement to run queries
	       	sqlStatement = con.createStatement();

	       	sqlStatement.execute( queryString );

			JOptionPane.showMessageDialog( null,
				"Record for " + ssn + " deleted." );

	       	sqlStatement.close(); // close the Statement
	       	con.close(); 	      // close the Connection

   		} // end try
       catch ( Exception err )
       {
	       	JOptionPane.showMessageDialog( null, "ERROR: " + err );
       } // end catch

   } // end delete


} // end class
package finalTest;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JTextArea;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

public class BookGui extends JFrame {
	
	/**
	 * Author: Stefano Antonel.
	 * This class will provide the GUI for a program that allows the user to  
	 * 		Create, Update and Display all the books.
	 */

	// instance fields for GUI object
	private JLabel idLabel;
	private JLabel titleLabel;
	private JLabel yearLabel;
	private JLabel eBookLabel;
	private JTextField idTextField;
	private JTextField titleTextField;
	private JTextField yearTextField;
	private JTextField eBookTextField;
	private JTextArea outputTextArea;
	private JButton createButton;
	private JButton updateButton;
	private JButton displayAllButton;
	private JPanel buttonPanel;
	private JPanel textFieldPanel;

	private ActionListener createListener;
	private ActionListener updateListener;
	private ActionListener displayListener;

	private Statement sqlStatement;
	private Connection con;
	private ResultSet resultSet;

	private String queryString;
	private String outputString;
	private String id;
	private String title;
	private int year;
	private int eBook;


	public BookGui() {
		buildGui();
		addListeners();
	} 

	// constructor methods

	private void buildGui() { // build the GUI
		idLabel = new JLabel("ID");
		titleLabel = new JLabel("Title");
		yearLabel = new JLabel("Year");
		eBookLabel = new JLabel("eBook");
		idTextField = new JTextField(30);
		titleTextField = new JTextField(15);
		yearTextField = new JTextField(10);
		eBookTextField = new JTextField(10);
		
		outputTextArea = new JTextArea();
		createButton = new JButton("Add ");
		updateButton = new JButton("Update ");
		displayAllButton = new JButton("Display");

		textFieldPanel = new JPanel();
		// use GridLayout, 4 rows, 2 columns
		textFieldPanel.setLayout(new GridLayout(4, 2));
		textFieldPanel.add(idLabel);
		textFieldPanel.add(idTextField);
		textFieldPanel.add(titleLabel);
		textFieldPanel.add(titleTextField);
		textFieldPanel.add(yearLabel);
		textFieldPanel.add(yearTextField);
		textFieldPanel.add(eBookLabel);
		textFieldPanel.add(eBookTextField);

		buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(1, 3));
		buttonPanel.add(createButton);
		buttonPanel.add(updateButton);
		buttonPanel.add(displayAllButton);

		// Add panels to frame using BorderLayout
		add(textFieldPanel, BorderLayout.NORTH);
		add(outputTextArea, BorderLayout.CENTER);
		add(buttonPanel, BorderLayout.SOUTH);
	} // end buildGui()

	private void addListeners() { // add listener objects for GUI
		class CreateListener implements ActionListener {
			public void actionPerformed(ActionEvent event) {
				create();
			}
		} 
		class UpdateListener implements ActionListener {
			public void actionPerformed(ActionEvent event) {
				update();
			}
		} 
		class DisplayListener implements ActionListener {
			public void actionPerformed(ActionEvent event) {
				displayAll();
			}
		} 
	
		// create the listener objects using listener classs
		createListener = new CreateListener();
		updateListener = new UpdateListener();
		displayListener = new DisplayListener();

		// register the listener objects with the appropriate buttons
		createButton.addActionListener(createListener);
		updateButton.addActionListener(updateListener);
		displayAllButton.addActionListener(displayListener);
	} 

	

	private void create() { // method for creating a record in the db
		try {
			con = makeConnection();

			// get user values from GUI
			
			id = idTextField.getText();
			title = titleTextField.getText();
			String yearString = yearTextField.getText();
			String eBookString = eBookTextField.getText();
			
			// if every field is filled
			if(	!id.equals("") && !title.equals("") && 
				!yearString.equals("") && !eBookString.equals("") ) {
				
				year = Integer.parseInt(yearTextField.getText());
				eBook = Integer.parseInt(eBookTextField.getText());

				StringBuilder sb = new StringBuilder();
				sb.append("INSERT INTO ");
				sb.append(StaticVariables.TABLENAME + " ");
				sb.append("VALUES ('"+id+"', '"+title+"', "+year+", "+eBook+");");
				
				queryString = sb.toString();
				sqlStatement = executeSQL(con, queryString);
				JOptionPane.showMessageDialog(null, "Book added! ID: " + id);
			}
			else {
				JOptionPane.showMessageDialog(null, 
						"Complete each field", 
						"ERROR", JOptionPane.ERROR_MESSAGE);
			}
			
			
		}
		catch (NumberFormatException nf) {
			JOptionPane.showMessageDialog(null, 
					"Wrong year or eBook. Both have to be a numeric input ", 
					"ERROR", JOptionPane.ERROR_MESSAGE);
		}
		catch (Exception err) {
			// there were an error, try to create database if it doesn't exist. 
			try {
				CreateDbTable.main(null);
				// call again to the create method in this class
				create();
			}
			catch(Exception e) {
				JOptionPane.showMessageDialog(null, e.getClass().getName() + ": "
						+ e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
			}
		} 
		finally {
			closeObjects();
		} 
	} 
	private void update() {
		try {
			con = makeConnection();

			// get user values from GUI
			id = idTextField.getText();
			if(id.equals("")) {
				JOptionPane.showMessageDialog(null, 
						"ID is required",
						"ERROR", JOptionPane.ERROR_MESSAGE);
			}
			else {
				title = titleTextField.getText();
				year = Integer.parseInt(yearTextField.getText());
				eBook = Integer.parseInt(eBookTextField.getText());

				StringBuilder sb = new StringBuilder();
				sb.append("UPDATE ");
				sb.append(StaticVariables.TABLENAME + " ");
				sb.append("SET title = '"+title+"', year = "+year+","
						+ " eBook = "+eBook+" ");
				sb.append("WHERE id = '"+id+"'");
				
				queryString = sb.toString();

				sqlStatement = executeSQL(con, queryString);

				JOptionPane.showMessageDialog(null, "Book Updated! ID: " + id);
			}
			
		}
		catch (NumberFormatException err) {
			// there were an error parsing the fields 
			JOptionPane.showMessageDialog(null, 
				"Fill the fields with proper information",
				"ERROR", JOptionPane.ERROR_MESSAGE);
		} 
		catch(Exception err) {
			JOptionPane.showMessageDialog(null, err.getClass().getName() + ": "
					+ err.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
		}
		finally {
			closeObjects();
		} 
		
	}
	
	private void displayAll() {
		/**
		 * ORDER BY YEAR
		 */
		try {
			con = makeConnection();
			
			StringBuilder sb = new StringBuilder();
			sb.append("SELECT * FROM ");
			sb.append(StaticVariables.TABLENAME + " ");
			sb.append("ORDER BY year ASC");
			queryString = sb.toString();
			
			sqlStatement = executeSQL(con, queryString);

			resultSet = sqlStatement.getResultSet();
			boolean areBooks = false;
			StringBuilder results = new StringBuilder();
			while(resultSet.next()) {
				areBooks = true;
				results.append(resultSet.getString(1));
				results.append("\t");
				results.append(resultSet.getString(2));
				results.append("\t");
				results.append(resultSet.getString(3));
				results.append("\n");
			}
			if(!areBooks) {
				results.append("There are no books saved");
			}
			else {
				String a = "ID \tTitle \tYear \n";
				results.insert(0,a);
			}
			outputString = results.toString();
			outputTextArea.setText(outputString);
			
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, e.getClass().getName() + ": "
					+ e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
		}
		
		
	}


	// database interaction methods

	// create Connection object for database
	private Connection makeConnection() throws SQLException,
			ClassNotFoundException {
		Class.forName("org.sqlite.JDBC"); // get the DB driver object
		
		// get the connection object
		con = DriverManager.getConnection("jdbc:sqlite:" + StaticVariables.DBURI);
		return con;
	} 

	// create Statement object
	private Statement executeSQL(Connection con, String queryString)
			throws SQLException {
		// create a Statement object and execute query
		sqlStatement = con.createStatement();
		sqlStatement.execute(queryString);
		return sqlStatement;
	} 

	// close Connection and Statement objects
	private void closeObjects() {
		try {
			if (!con.isClosed()) {
				if (sqlStatement != null)
					sqlStatement.close(); // close the Statement object
				if (con != null)
					con.close(); // close the Connection object
			}
		} catch (Exception err) {
			JOptionPane.showMessageDialog(null, err.getClass().getName() + ": "
					+ err.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
		} 
	} // end closeObjects()

}
package exampleFinal;

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

public class CarAppGui extends JFrame {

	// instance fields for GUI object
	private JLabel vinLabel;
	private JLabel makeLabel;
	private JLabel yearLabel;
	private JLabel mpgLabel;
	private JTextField vinTextField;
	private JTextField makeTextField;
	private JTextField yearTextField;
	private JTextField mpgTextField;
	private JTextArea outputTextArea;
	private JCheckBox minCheckBox;
	private JCheckBox maxCheckBox;
	private JCheckBox avgCheckBox;
	private JRadioButton yearRadioButton;
	private JRadioButton mpgRadioButton;
	private ButtonGroup buttonGroup;
	private JButton createButton;
	private JButton readButton;
	private JButton calcButton;
	private JButton resetButton;
	private JPanel buttonPanel;
	private JPanel textFieldPanel;
	private JPanel choicePanel;

	private ActionListener createListener;
	private ActionListener readListener;
	private ActionListener calcListener;
	private ActionListener resetListener;

	private Statement sqlStatement;
	private Connection con;
	private ResultSet resultSet;

	private String queryString;
	private String outputString;
	private String vin;
	private String make;
	private int year;
	private double mpg;

	// constructor
	public CarAppGui() {
		buildGui();
		addListeners();
	} // end constructor

	// constructor methods

	private void buildGui() { // build the GUI
		vinLabel = new JLabel("VIN");
		makeLabel = new JLabel("Make");
		yearLabel = new JLabel("Year");
		mpgLabel = new JLabel("MPG");
		vinTextField = new JTextField(30);
		makeTextField = new JTextField(15);
		yearTextField = new JTextField(10);
		mpgTextField = new JTextField(10);
		minCheckBox = new JCheckBox("Min");
		maxCheckBox = new JCheckBox("Max");
		avgCheckBox = new JCheckBox("Avg");
		yearRadioButton = new JRadioButton("Year");
		buttonGroup = new ButtonGroup();
		mpgRadioButton = new JRadioButton("MPG");
		outputTextArea = new JTextArea();
		createButton = new JButton("Add Record");
		readButton = new JButton("Read Record");
		calcButton = new JButton("Calculate");
		resetButton = new JButton("Reset");

		// add two radio buttons to the button group
		buttonGroup.add(yearRadioButton);
		buttonGroup.add(mpgRadioButton);

		textFieldPanel = new JPanel();
		// use GridLayout, 4 rows, 2 columns
		textFieldPanel.setLayout(new GridLayout(4, 2));
		textFieldPanel.add(vinLabel);
		textFieldPanel.add(vinTextField);
		textFieldPanel.add(makeLabel);
		textFieldPanel.add(makeTextField);
		textFieldPanel.add(yearLabel);
		textFieldPanel.add(yearTextField);
		textFieldPanel.add(mpgLabel);
		textFieldPanel.add(mpgTextField);

		buttonPanel = new JPanel();
		// use GridLayout, 1 row, 5 columns
		buttonPanel.setLayout(new GridLayout(1, 4));
		buttonPanel.add(createButton);
		buttonPanel.add(readButton);
		buttonPanel.add(calcButton);
		buttonPanel.add(resetButton);

		choicePanel = new JPanel();
		choicePanel.setLayout(new GridLayout(3, 2));
		choicePanel.add(minCheckBox);
		choicePanel.add(yearRadioButton);
		choicePanel.add(maxCheckBox);
		choicePanel.add(mpgRadioButton);
		choicePanel.add(avgCheckBox);

		// Add panels to frame using BorderLayout
		add(textFieldPanel, BorderLayout.NORTH);
		add(outputTextArea, BorderLayout.CENTER);
		add(choicePanel, BorderLayout.EAST);
		add(buttonPanel, BorderLayout.SOUTH);
	} // end buildGui()

	private void addListeners() { // add listener objects for GUI
		// inner listener classes for the four buttons
		class CreateListener implements ActionListener {
			public void actionPerformed(ActionEvent event) {
				create();
			}
		} // end class

		class ReadListener implements ActionListener {
			public void actionPerformed(ActionEvent event) {
				read();
			}
		} // end class

		class CalcListener implements ActionListener {
			public void actionPerformed(ActionEvent event) {
				calculate();
			}
		} // end class

		class ResetListener implements ActionListener {
			public void actionPerformed(ActionEvent event) {
				reset();
			} // end actionPerformed()
		} // end class

		// create the listener objects using listener classse
		createListener = new CreateListener();
		readListener = new ReadListener();
		calcListener = new CalcListener();
		resetListener = new ResetListener();

		// register the listener objects with the appropriate buttons
		createButton.addActionListener(createListener);
		readButton.addActionListener(readListener);
		calcButton.addActionListener(calcListener);
		resetButton.addActionListener(resetListener);
	} // end addListeners()

	// business logic methods for create, read, calc avg, find top 3, reset

	private void create() { // method for creating a record in the db
		try {
			con = makeConnection();

			// get user values from GUI
			vin = vinTextField.getText();
			make = makeTextField.getText();
			year = Integer.parseInt(yearTextField.getText());
			mpg = Double.parseDouble(mpgTextField.getText());

			// SQL example: INSERT INTO car VALUES ( '111', 'Ford', 2014, 30.5 )
			queryString = "INSERT INTO car VALUES ( '" + vin + "', '" + make
					+ "', " + year + ", " + mpg + " )";

			sqlStatement = executeSQL(con, queryString);

			// confirm execution
			JOptionPane.showMessageDialog(null, "Record added for car " + vin);
		} // end try
		catch (Exception err) {
			JOptionPane.showMessageDialog(null, err.getClass().getName() + ": "
					+ err.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
		} // end catch
		finally {
			closeObjects();
		} // end finally
	} // end create()

	private void read() { // method for reading a record in the db
		try {
			con = makeConnection();

			vin = vinTextField.getText();

			// SQL example: SELECT * FROM car WHERE vin = '111'
			queryString = "SELECT * FROM car WHERE vin = '" + vin + "'";
			sqlStatement = executeSQL(con, queryString);

			resultSet = sqlStatement.getResultSet();
			resultSet.next();
			if (resultSet != null) {
				make = resultSet.getString(2); // get column 2 data
				year = resultSet.getInt(3); // get column 3 data
				mpg = resultSet.getDouble(4); // get column 4 data
			}
			// put data into appropriate text fields
			makeTextField.setText(make);
			yearTextField.setText("" + year);
			mpgTextField.setText("" + mpg);
		} // end try
		catch (Exception err) {
			JOptionPane.showMessageDialog(null, err.getClass().getName() + ": "
					+ err.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
		} // end catch
		finally {
			closeObjects();
		} // end finally
	} // end read()

	private void calculate() { // method to calculate average MPG for all cars
		try {
			double minMPG = 0, maxMPG = 0, avgMPG = 0, avgYear = 0;
			int minYear = 0, maxYear = 0;
			queryString = "";
			outputString = "";
			resultSet = null;
			sqlStatement = null;

			// clear text fields
			vinTextField.setText("");
			makeTextField.setText("");
			yearTextField.setText("");
			mpgTextField.setText("");

			con = makeConnection();

			if (!minCheckBox.isSelected() && !maxCheckBox.isSelected()
					&& !avgCheckBox.isSelected())
				outputString += "No selections made for MIN, MAX, or AVG.\n";
			else if (!yearRadioButton.isSelected()
					&& !mpgRadioButton.isSelected())
				outputString = "No selections made for Year or MPG.\n";
			else if (mpgRadioButton.isSelected()) {
				if (minCheckBox.isSelected()) {
					queryString = "SELECT MIN( mpg ) FROM car";
					sqlStatement = executeSQL(con, queryString);
					resultSet = sqlStatement.getResultSet();
					resultSet.next(); // point to result
					if (resultSet != null)
						minMPG = resultSet.getDouble(1);
					outputString += "The minimum MPG is " + minMPG + "\n";
				}
				if (maxCheckBox.isSelected()) {
					queryString = "SELECT MAX( mpg ) FROM car";
					sqlStatement = executeSQL(con, queryString);
					resultSet = sqlStatement.getResultSet();
					resultSet.next(); // point to result
					if (resultSet != null)
						maxMPG = resultSet.getDouble(1);
					outputString += "The maximum MPG is " + maxMPG + "\n";
				}
				if (avgCheckBox.isSelected()) {
					queryString = "SELECT AVG( mpg ) FROM car";
					sqlStatement = executeSQL(con, queryString);
					resultSet = sqlStatement.getResultSet();
					resultSet.next(); // point to result
					if (resultSet != null)
						avgMPG = resultSet.getDouble(1);
					outputString += "The average MPG is " + avgMPG + "\n";
				}
			} else if (yearRadioButton.isSelected()) {
				if (minCheckBox.isSelected()) {
					queryString = "SELECT MIN( year ) FROM car";
					sqlStatement = executeSQL(con, queryString);
					resultSet = sqlStatement.getResultSet();
					resultSet.next(); // point to result
					if (resultSet != null)
						minYear = resultSet.getInt(1);
					outputString += "The minimum year is " + minYear + "\n";
				}
				if (maxCheckBox.isSelected()) {
					queryString = "SELECT MAX( year ) FROM car";
					sqlStatement = executeSQL(con, queryString);
					resultSet = sqlStatement.getResultSet();
					resultSet.next(); // point to result
					if (resultSet != null)
						maxYear = resultSet.getInt(1);
					outputString += "The maximum year is " + maxYear + "\n";
				}
				if (avgCheckBox.isSelected()) {
					queryString = "SELECT AVG( year ) FROM car";
					sqlStatement = executeSQL(con, queryString);
					resultSet = sqlStatement.getResultSet();
					resultSet.next(); // point to result
					if (resultSet != null)
						avgYear = resultSet.getDouble(1);
					outputString += "The average year is " + avgYear + "\n";
				}
			} // end if...else

			outputTextArea.setText(outputString);

		} // end try
		catch (Exception err) {
			JOptionPane.showMessageDialog(null, err.getClass().getName() + ": "
					+ err.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
		} // end catch
		finally {
			// if( sqlStatement != null )
			closeObjects();
		} // end finally
	} // end calculate()

	private void reset() { // method to reset all fields to empty strings
		vinTextField.setText("");
		makeTextField.setText("");
		yearTextField.setText("");
		mpgTextField.setText("");
		outputTextArea.setText("");
		minCheckBox.setSelected(false);
		maxCheckBox.setSelected(false);
		avgCheckBox.setSelected(false);
		yearRadioButton.setSelected(false);
		mpgRadioButton.setSelected(false);

	} // end reset()

	// database interaction methods

	// create Connection object for database
	private Connection makeConnection() throws SQLException,
			ClassNotFoundException {
		Class.forName("org.sqlite.JDBC"); // get the DB driver object
		String dbFileName = "carDB.db"; // name the database file
		// get the connection object
		con = DriverManager.getConnection("jdbc:sqlite:" + dbFileName);
		return con;
	} // end makeConnection()

	// create Statement object
	private Statement executeSQL(Connection con, String queryString)
			throws SQLException {
		// create a Statement object and execute query
		sqlStatement = con.createStatement();
		sqlStatement.execute(queryString);
		return sqlStatement;
	} // end executeSQL()

	// close Connection and Statement objects
	private void closeObjects() {
		try {
			if (sqlStatement != null)
				sqlStatement.close(); // close the Statement object
			if (con != null)
				con.close(); // close the Connection object
		} catch (Exception err) {
			JOptionPane.showMessageDialog(null, err.getClass().getName() + ": "
					+ err.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
		} // end catch
	} // end closeObjects()

} // end class
package chapter13.challenge8;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javafx.scene.control.SelectionMode;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


public class CostCalculator extends JFrame {

	private JList<Object> admitionList;
	private JList<Object> conferenceList;
	JTextField JFieldTotal = new JTextField(10);
	JButton btCalculate = new JButton("Calculate");
	
	public CostCalculator() {
		generateAdmitions();
		generateConferences();
		createWindow();
		refreshTotal();
	}
	
		public static void main(String[] args) {
		// TODO Auto-generated method stub
		new CostCalculator();
	}

	private void generateAdmitions() {
		
		String[] admitionsName = {"General", "Student"};
		float[] prices = {895, 	495};
		
		Object[] array = Controller.createAdmitionsByArray(admitionsName, prices);
		admitionList = new JList<>(array);
//		admitionList.setSize(getWidth(), getHeight());
		
		admitionList.setSelectedIndex(0);
	}
	
	private void generateConferences() {
				
		String[] conferencesNames = {
				"Dinner Keynote",	
				"Introduction to E-commerce", 
				"The future of the web", 
				"Advance Java Programming", 
				"Network Security"};
		float[] conferencesPrices = {
				30, 	
				295, 	
				295,		
				395, 	
				395 };
		
		Object[] arrayAux = Controller.createConferenceByArray(conferencesNames, conferencesPrices);
		conferenceList = new JList<>(arrayAux);
		conferenceList.setSelectedIndex(0);
	}
	
	private void createWindow() {
//		this.setLayout(new GridLayout(2	,1));
		this.setTitle("Calculator");
		JPanel panel1 = new JPanel();
//		JLabel totalSalesLabel = new JLabel("Total Sale");
//		totalSalesLabel.setLabelFor(totalSales);
		admitionList.addListSelectionListener(new ListChangeListener());
		admitionList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		conferenceList.addListSelectionListener(new ListChangeListener());
		
		JScrollPane scrollAdmition = new JScrollPane(admitionList);
		scrollAdmition.setViewportView(admitionList);
		panel1.add(scrollAdmition);
		
		JScrollPane scrollConference = new JScrollPane(conferenceList);
		scrollConference.setVerticalScrollBar(new JScrollBar());
		scrollConference.setViewportView(conferenceList);
		panel1.add(scrollConference);
		
		btCalculate.addActionListener(new BtCalculateListener());
		panel1.add(btCalculate);
		
		this.add(panel1);
		
//		JPanel panel2 = new JPanel();
//		panel2.setLayout(new GridLayout(1,2));
		JLabel labelTotal = new JLabel("Total Amount: $");
		panel1.add(labelTotal);
		
		JFieldTotal.setEditable(false);
		JFieldTotal.setFocusable(false);
		panel1.add(JFieldTotal);
		
		this.add(panel1);
		
//		pack();
		this.setSize(380, 250);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	private class ListChangeListener implements ListSelectionListener {

		@Override
		public void valueChanged(ListSelectionEvent arg0) {
			refreshTotal();	
		}
	}
	
	private void refreshTotal() {
		new BtCalculateListener().actionPerformed(null);
	}
	
	private class BtCalculateListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String result = String.valueOf(calculateResult());
			JFieldTotal.setText(result);
		}
	}

	private double calculateResult() {
		try {
			double totalPrice = 0;
			int[] admitionSelected = admitionList.getSelectedIndices();
			for (int a : admitionSelected) {
				String nameSelected = Controller.getAdmitionArray().get(a).getName();
				Admition admition = Controller.findAdmition(nameSelected);
				totalPrice+=admition.getPrice();
			}
			
			int[] conferenceSelected = conferenceList.getSelectedIndices();
			for (int c : conferenceSelected) {
				String nameSelected = Controller.getConferenceArray().get(c).getName();
				Conference conference = Controller.findConference(nameSelected);
				totalPrice+=conference.getPrice();
			}
			
			return totalPrice;
		}
		catch (Exception ex) {
			System.out.println(ex.getMessage());
//			return "ERROR: Select dorm and meal";
			return -1;
		}
	}
}

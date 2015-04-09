package chapter13.challenge8;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;




public class CostCalculator extends JFrame {

	private JList<Object> admitionList;
	private JList<Object> conferenceList;
	JTextField JFieldTotal = new JTextField(10);
	JButton btCalculate = new JButton("Calculate");
	
	public CostCalculator() {
		generateAdmitions();
		generateConferences();
		createWindow();
	}
	
		public static void main(String[] args) {
		// TODO Auto-generated method stub
		new CostCalculator();
	}

	private void generateAdmitions() {
		Admition a = new Admition("General",895);
		ArrayList<String> array = new ArrayList<>(); 
		array.add(a.getName());
		Controller.addAdmition(a);
		
		a = new Admition("Student", 495);
		array.add(a.getName());
		Controller.addAdmition(a);
		
		admitionList = new JList<>(array.toArray());
		admitionList.setSize(getWidth(), getHeight());
		
		admitionList.setSelectedIndex(0);
	}
	
	private void generateConferences() {
		ArrayList<String> array = new ArrayList<>();
		
		Conference c = new Conference ("Dinner Keynote", 30);
		array.add(c.getName());
		Controller.addConference(c);
		
		c = new Conference ("Introduction to E-commerce", 295);
		array.add(c.getName());
		Controller.addConference(c);
		
		c = new Conference ("The future of the web", 295);
		array.add(c.getName());
		Controller.addConference(c);
		
		c = new Conference ("Advance Java Programming", 395);
		array.add(c.getName());
		Controller.addConference(c);
		
		c = new Conference ("Network Security", 395);
		array.add(c.getName());
		Controller.addConference(c);
		
		conferenceList = new JList<>(array.toArray());
		conferenceList.setSelectedIndex(0);
	}
	
	private void createWindow() {
		this.setLayout(new GridLayout(2	,1));
		this.setTitle("Calculator");
		JPanel panel1 = new JPanel();
//		JLabel totalSalesLabel = new JLabel("Total Sale");
//		totalSalesLabel.setLabelFor(totalSales);
		JScrollPane scrollAdmition = new JScrollPane(admitionList);
		panel1.add(scrollAdmition);
		JScrollPane scrollConference = new JScrollPane(conferenceList);
		scrollConference.setVerticalScrollBar(new JScrollBar());
		panel1.add(scrollConference);
		
		btCalculate.addActionListener(new BtCalculateListener());
		panel1.add(btCalculate);
		
		this.add(panel1);
		
		JPanel panel2 = new JPanel();
		JLabel labelTotal = new JLabel("Total Amount: $");
		panel2.add(labelTotal);
		
		JFieldTotal.setEditable(false);
		JFieldTotal.setFocusable(false);
		panel2.add(JFieldTotal);
		
		this.add(panel2);
		
		pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
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

package chapter13.challenge3;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

public class DormCalculator extends JFrame{

	private static JComboBox<String> JComboDorms = new JComboBox<>();
	private static JComboBox<String> JComboMeal = new JComboBox<>();
	JTextField JFieldTotal = new JTextField(10);
	JButton btCalculate = new JButton("Calculate");
	
	public DormCalculator() {
		generateDorms();
		generateMeals();
		createWindow();
	}
	
	
	public void generateDorms() {
		Dorm d = new Dorm ("Allen Hall", 1500);
		JComboDorms.addItem(d.getName());
		Controller.addDorm(d);
		
		d = new Dorm ("Pike Hall", 1600);
		JComboDorms.addItem(d.getName());
		Controller.addDorm(d);
		
		d= new Dorm ("Farthing Hall", 1200);
		JComboDorms.addItem(d.getName());
		Controller.addDorm(d);
		
		d= new Dorm ("University Suites", 1800);
		JComboDorms.addItem(d.getName());
		Controller.addDorm(d);
	}
	
	public void generateMeals() {
		MealPlan m = new MealPlan("7 Meals/Week",560);
		JComboMeal.addItem(m.getName());
		Controller.addMeal(m);
		
		m = new MealPlan("14 Meals/Week",1095);
		JComboMeal.addItem(m.getName());
		Controller.addMeal(m);
		
		m = new MealPlan("Unlimited/Week",1500);
		JComboMeal.addItem(m.getName());
		Controller.addMeal(m);
	}
	
	public static void main(String[] args) {
		new DormCalculator();
	}

	private void createWindow() {
//		this.setLayout(new BoxLayout(null, null);
		this.setLayout(new GridLayout(2	,1));
		this.setTitle("Calculator");
		JPanel panel1 = new JPanel();
//		JLabel totalSalesLabel = new JLabel("Total Sale");
//		totalSalesLabel.setLabelFor(totalSales);
		JComboDorms.addItemListener(new ItemSelectedListener());
		panel1.add(JComboDorms);
		JComboMeal.addItemListener(new ItemSelectedListener());
		panel1.add(JComboMeal);
		
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
		refreshResult();
		this.setVisible(true);
	}
	
	private class BtCalculateListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String result = calculateResult();
			JFieldTotal.setText(result);
		}
	}

	private void refreshResult() {
		new BtCalculateListener().actionPerformed(null);
	}
	
	private class ItemSelectedListener implements ItemListener {
		@Override
		public void itemStateChanged(ItemEvent arg0) {
			refreshResult();
		}
	} 
	
	private String calculateResult() {
		try {
//			Dorm dorm = Controller.findDorms(JComboDorms.getSelectedItem().toString());
//			MealPlan meal = Controller.findMealPlan(JComboMeal.getSelectedItem().toString());
			int indexDormSelected = JComboDorms.getSelectedIndex();
			int indexMealSelected = JComboMeal.getSelectedIndex();
			Dorm dorm = Controller.getDormsArray().get(indexDormSelected);
			MealPlan meal = Controller.getMealArray().get(indexMealSelected);
			
			if(dorm != null && meal != null) {
				double total = dorm.getPrice() + meal.getPrice();
				return String.format("%.2f",total);
			}
			return "Select dorm and meal";
		}
		catch (Exception ex) {
			System.out.println(ex.getMessage());
			return "ERROR: Select dorm and meal";
		}
	}

}



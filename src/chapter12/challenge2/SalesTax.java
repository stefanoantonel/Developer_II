package chapter12.challenge2;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class SalesTax extends JFrame {

	private static double STATETAX = 0.04;
	private static double COUNTRYTAX = 0.02;
	private JTextField totalSales = new JTextField(10);
	private JTextField stateTax = new JTextField(10);
	private JTextField countryTax = new JTextField(10);
	private JTextField totalTax = new JTextField(10);
	private JButton btCalculate = new JButton();
	
	public SalesTax() {
		createWindow();
		totalSales.addFocusListener(new FocusListenerErase(totalSales));
		disableFields();
	}
	
	public static void main(String[] args) {
		new SalesTax();
	}
	
	private void disableFields() {
		stateTax.setEditable(false);
		stateTax.setFocusable(false);
		countryTax.setEditable(false);
		countryTax.setFocusable(false);
		totalTax.setEditable(false);
		totalTax.setFocusable(false);
	}
	
	private void createWindow() {
		this.setLayout(new GridLayout(5,1));
		
		JPanel panel1 = new JPanel();
		JLabel totalSalesLabel = new JLabel("Total Sale");
		totalSalesLabel.setLabelFor(totalSales);
		panel1.add(totalSalesLabel);
		panel1.add(totalSales);
		this.add(panel1);

		JPanel panel2 = new JPanel();
		JLabel stateTaxLabel = new JLabel("State Tax");
		stateTaxLabel.setLabelFor(stateTax);
		panel2.add(stateTaxLabel);
		panel2.add(stateTax);
		this.add(panel2);
		
		JPanel panel3 = new JPanel();
		JLabel countryTaxLabel = new JLabel("Country Tax");
		countryTaxLabel.setLabelFor(countryTax);
		panel3.add(countryTaxLabel);
		panel3.add(countryTax);
		this.add(panel3);
		
		JPanel panel4 = new JPanel();
		JLabel totalTaxLabel = new JLabel("Total Tax");
		countryTaxLabel.setLabelFor(totalTax);
		panel4.add(totalTaxLabel);
		panel4.add(totalTax);
		this.add(panel4);
				
		btCalculate = new JButton("Calculate");
		btCalculate.addActionListener(new BtCalculateListener());
		
		JPanel panel5 = new JPanel();
		panel5.add(btCalculate);
		this.add(panel5);
			
		this.setLocationRelativeTo(null);
		pack();
		this.setVisible(true);
	}
	
	private class FocusListenerErase implements FocusListener {

		private JTextField fieldFocused; 
		
		public FocusListenerErase(JTextField field) {
			this.fieldFocused = field;
		}

		@Override
		public void focusGained(FocusEvent arg0) {
			fieldFocused.selectAll();
		}

		@Override
		public void focusLost(FocusEvent arg0) {
			
		}
		
	}
	
	private class BtCalculateListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			calculateResult();
		}
	}
	
	private void calculateResult() {
		try {
			float totalTaxF = Float.parseFloat(totalSales.getText());
			countryTax.setText(String.valueOf(totalTaxF*COUNTRYTAX));
			stateTax.setText(String.valueOf(totalTaxF*STATETAX));
			double totalTaxD= totalTaxF*(COUNTRYTAX+STATETAX);
			totalTax.setText(String.format("%.2f", totalTaxD));
			
		}
		catch (Exception ex) {
//			textResult.setText("Numbers ERROR");
			System.out.println(ex.getMessage());
		}
	}
	

}

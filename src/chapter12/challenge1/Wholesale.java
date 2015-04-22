package chapter12.challenge1;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Wholesale extends JFrame{

	private JTextField wholesalePrice;
	private JTextField markupPercentage;
	private JTextField textResult;
	private JButton btCalculate;
	
	public Wholesale() {
		createWindow();
	}
	
	private void createWindow() {
		
		wholesalePrice = new JTextField(10);
		wholesalePrice.addFocusListener(new FocusListenerErase(wholesalePrice));
		JLabel whole = new JLabel("Wholesale");
		whole.setLabelFor(wholesalePrice);
		

		markupPercentage = new JTextField(10);
		markupPercentage.addFocusListener(new FocusListenerErase(markupPercentage));
		JLabel markup = new JLabel("Markup %");
		markup.setLabelFor(markupPercentage);
		
		this.setLayout(new GridLayout(4,1));
		
		JPanel panel1 = new JPanel();
		panel1.add(whole);
		panel1.add(wholesalePrice);
		this.add(panel1);

		JPanel panel2 = new JPanel();
		panel2.add(markup);
		panel2.add(markupPercentage);
		this.add(panel2);
		
		btCalculate = new JButton("Calculate");
		
		btCalculate.addActionListener(new BtCalculateListener());
		btCalculate.addKeyListener(new KeyListenerImp());

		textResult = new JTextField(10);
		textResult.setEditable(false);
		textResult.setFocusable(false);
		JLabel resultLabel = new JLabel("Result");
		resultLabel.setLabelFor(textResult);

		JPanel panel4 = new JPanel();
		panel4.add(resultLabel);
		panel4.add(textResult);
		this.add(panel4);
		
		JPanel panel3 = new JPanel();
		panel3.add(btCalculate);
		this.add(panel3);
		
		this.setLocationRelativeTo(null);
		pack();
		this.setVisible(true);
	}
	
	
	private class BtCalculateListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			calculateResult();
		}
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
	
	private class KeyListenerImp implements KeyListener {

		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			calculateResult();
			
		}

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	private void calculateResult() {
		try {
			float wholeF = Float.parseFloat(wholesalePrice.getText());
			float markupF = Float.parseFloat(markupPercentage.getText());
			float result = wholeF + (wholeF * markupF)/100;
			textResult.setText(String.valueOf(result));
		}
		catch (Exception ex) {
			textResult.setText("Numbers ERROR");
			System.out.println(ex.getMessage());
		}
	}
	
	public static void main(String[] args) {
		new Wholesale();
	}

	
}

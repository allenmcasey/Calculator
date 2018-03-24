package calculator;

import javax.swing.*;
import javax.swing.border.Border;
import java.io.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.*;

public class Calculator extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel numberPanel;					//the panel of numbers on GUI
	private JPanel operationPanel;					//the panel of operators on GUI
	private JPanel trigPanel;					//the panel of trig buttons on GUI
	JTextArea console = new JTextArea(2, 10);			//The console on the calculator
	private String[] expression = new String[20];			//the array in which the expression is stored
	private int counter = 0;					//counter that places each term of the expression in the array
	
	public Calculator() {
		
		//The code below constructs the calculator from objects created elsewhere in the code
		setTitle("Calculator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
		buildNumberPanel();
		buildOperationPanel();
		buildTrigPanel();
		
		
		//Styles calculator console with a border
		Border border = BorderFactory.createLineBorder(Color.blue);
		console.setBorder(border);
		console.setFont(new Font(Font.MONOSPACED, Font.BOLD, 14));
		
		//Creates an output stream and redirects all output to the GUI JTextArea
		PrintStream outStream = new PrintStream(new TextAreaOutputStream(console));
        	System.setOut(outStream);
        	System.setErr(outStream);
		
        	add(console, BorderLayout.SOUTH);
		add(numberPanel, BorderLayout.CENTER);
		add(operationPanel, BorderLayout.EAST);
		add(trigPanel, BorderLayout.WEST);
		
		pack();
		setVisible(true);
	}
	
	//This is the class that writes to the console on the GUI
	private class TextAreaOutputStream extends OutputStream {
        private javax.swing.JTextArea textArea1;
        
        public TextAreaOutputStream(JTextArea textArea) {
            this.textArea1 = textArea;
        }

        public void write( int b ) throws IOException {
            textArea1.append(String.valueOf((char)b));
            textArea1.setCaretPosition(textArea1.getDocument().getLength());
        }
    }
	
	//Creates number buttons
	private void buildNumberPanel() {

		numberPanel = new JPanel();
		numberPanel.setLayout(new GridLayout(3, 3));
		JButton one = new JButton("1");
		one.setActionCommand("1");
		one.addActionListener(new NumberListener());
		numberPanel.add(one);
		
		JButton two = new JButton("2");
		two.setActionCommand("2");
		two.addActionListener(new NumberListener());
		numberPanel.add(two);
		
		JButton three = new JButton("3");
		three.setActionCommand("3");
		three.addActionListener(new NumberListener());
		numberPanel.add(three);
		
		JButton four = new JButton("4");
		four.setActionCommand("4");
		four.addActionListener(new NumberListener());
		numberPanel.add(four);
		
		JButton five = new JButton("5");
		five.setActionCommand("5");
		five.addActionListener(new NumberListener());
		numberPanel.add(five);
		
		JButton six = new JButton("6");
		six.setActionCommand("6");
		six.addActionListener(new NumberListener());
		numberPanel.add(six);
		
		JButton seven = new JButton("7");
		seven.setActionCommand("7");
		seven.addActionListener(new NumberListener());
		numberPanel.add(seven);
		
		JButton eight = new JButton("8");
		eight.setActionCommand("8");
		eight.addActionListener(new NumberListener());
		numberPanel.add(eight);
		
		JButton nine = new JButton("9");
		nine.setActionCommand("9");
		nine.addActionListener(new NumberListener());
		numberPanel.add(nine);
		
		JButton zero = new JButton("0");
		zero.setActionCommand("0");
		zero.addActionListener(new NumberListener());
		numberPanel.add(zero);
		
		JButton decimal = new JButton(".");
		decimal.setActionCommand(".");
		decimal.addActionListener(new NumberListener());
		numberPanel.add(decimal);
		
		JButton negative = new JButton("(-)");
		negative.setActionCommand("-");
		negative.addActionListener(new NumberListener());
		numberPanel.add(negative);
	}
	
	//Creates operator buttons
	private void buildOperationPanel() {
		
		operationPanel = new JPanel();
		operationPanel.setLayout(new GridLayout(4, 2));
		
		JButton add = new JButton("+");
		add.setActionCommand("1");
		add.addActionListener(new OperationListener());
		operationPanel.add(add);
		
		JButton squareRoot = new JButton("sqrt(x)");
		squareRoot.setActionCommand("14");
		squareRoot.addActionListener(new OperationListener());
		operationPanel.add(squareRoot); 
		
		JButton subtract = new JButton("-");
		subtract.setActionCommand("2");
		subtract.addActionListener(new OperationListener());
		operationPanel.add(subtract);
		
		JButton clearLast = new JButton("C");
		clearLast.setActionCommand("13");
		clearLast.addActionListener(new OperationListener());
		operationPanel.add(clearLast);
		
		JButton multiply = new JButton("*");
		multiply.setActionCommand("3");
		multiply.addActionListener(new OperationListener());
		operationPanel.add(multiply);
		
		JButton clear = new JButton("CE");
		clear.setActionCommand("11");
		clear.addActionListener(new OperationListener());
		operationPanel.add(clear);
		
		JButton divide = new JButton("/");
		divide.setActionCommand("4");
		divide.addActionListener(new OperationListener());
		operationPanel.add(divide);
		
		JButton equals = new JButton("=");
		equals.setActionCommand("10");
		equals.addActionListener(new OperationListener());
		operationPanel.add(equals); 
		
	}
	
	private void buildTrigPanel() {
		
		trigPanel = new JPanel();
		trigPanel.setLayout(new GridLayout(3, 1));
		
		JButton sin = new JButton("sin(x)");
		sin.setActionCommand("15");
		sin.addActionListener(new OperationListener());
		trigPanel.add(sin); 
		
		JButton cos = new JButton("cos(x)");
		cos.setActionCommand("16");
		cos.addActionListener(new OperationListener());
		trigPanel.add(cos); 
		
		JButton tan = new JButton("tan(x)");
		tan.setActionCommand("17");
		tan.addActionListener(new OperationListener());
		trigPanel.add(tan); 
	}

	//Creates listeners for number buttons
		private class NumberListener implements ActionListener {
			
			public void actionPerformed(ActionEvent e) {
				System.out.print(e.getActionCommand());
				if (expression[counter] == null)
					expression[counter] = e.getActionCommand();
				else
					expression[counter] += (e.getActionCommand());
			}
		}
		
	//Creates listeners for operator buttons
	private class OperationListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (Integer.parseInt(e.getActionCommand()) == 1) {
				expression[++counter] = "+";
				System.out.print(" + ");
				counter++;
			}
			
			if (Integer.parseInt(e.getActionCommand()) == 2) {
				expression[++counter] = "-";
				System.out.print(" - ");
				counter++;
			}
			if (Integer.parseInt(e.getActionCommand()) == 3) {
				expression[++counter] = "*";
				System.out.print(" * ");
				counter++;			
			}
			if (Integer.parseInt(e.getActionCommand()) == 4) {
				expression[++counter] = "/";
				System.out.print(" / ");
				counter++;
			}
			if (Integer.parseInt(e.getActionCommand()) == 14) {
				expression[counter] = "s";
				System.out.print("sqrt ");
				counter++;
			}
			if (Integer.parseInt(e.getActionCommand()) == 15) {
				expression[counter] = "sin";
				System.out.print("sin ");
				counter++;
			}
			if (Integer.parseInt(e.getActionCommand()) == 16) {
				expression[counter] = "cos";
				System.out.print("cos ");
				counter++;
			}
			if (Integer.parseInt(e.getActionCommand()) == 17) {
				expression[counter] = "tan";
				System.out.print("tan ");
				counter++;
			}
			
			//This is the "equals" button
			if (Integer.parseInt(e.getActionCommand()) == 10){
		
				int dex = 0;  		//index that steps through expression array
				double result = 0;	//the current result of the expression   
				int length = 0;		//the length of the expression
				
				//gets length of expression
				while (expression[dex] != null && dex < expression.length) {
					length++;
					dex++;
				}
	
				dex = 0;	//begin stepping through at beginning of expression
				
				//checks for square roots, then multiplication and division, and evaluates
				//stores each result in the index of the leftmost term, 
				//then resizes array to account for fewer terms (because terms are simplified)
				while(dex < length - 1) {
					//Finds sqrts first
					if (expression[dex].equals("s")) {
						length -= 1;
						expression[dex] = Double.toString(Math.sqrt(Double.parseDouble(expression[dex + 1])));
						int i = dex + 2;
						while (expression[i] != null && i < expression.length - 1) {
							expression[i - 1] = expression[i];
							i++;
						}
					}
					else if (expression[dex].equals("sin")) {
						length -= 1;
						expression[dex] = Double.toString(Math.sin(Math.toRadians(Double.parseDouble(expression[dex + 1]))));
						int i = dex + 2;
						while (expression[i] != null && i < expression.length - 1) {
							expression[i - 1] = expression[i];
							i++;
						}
					}
					else if (expression[dex].equals("cos")) {
						length -= 1;
						expression[dex] = Double.toString(Math.cos(Math.toRadians(Double.parseDouble(expression[dex + 1]))));
						int i = dex + 2;
						while (expression[i] != null && i < expression.length - 1) {
							expression[i - 1] = expression[i];
							i++;
						}
					}
					else if (expression[dex].equals("tan")) {
						length -= 1;
						expression[dex] = Double.toString(Math.tan(Math.toRadians(Double.parseDouble(expression[dex + 1]))));
						int i = dex + 2;
						while (expression[i] != null && i < expression.length - 1) {
							expression[i - 1] = expression[i];
							i++;
						}
					}
					dex++;
				}
				
				dex = 0;
					
				while(dex < length - 1) {
					//if multiplication
					if (expression[dex].equals("*")) {	
						length -= 2;
						//find product of values to the left and right of the operator and
						//store it in the place of left term
						expression[dex - 1] = Double.toString(Double.parseDouble(expression[dex - 1]) 
												* Double.parseDouble(expression[dex + 1]));
						//move the rest of the equation to the left 
						int i = dex + 2;
						while (expression[i] != null && i < expression.length) {
							expression[i - 2] = expression[i];
							i++;
						}
					}
					
					//if division
					else if (expression[dex].equals("/")) {
						length -= 2;
						//find quotient of values to the left and right of the operator and
						//store it in the place of left term
						expression[dex - 1] = Double.toString(Double.parseDouble(expression[dex - 1]) 
												/ Double.parseDouble(expression[dex + 1]));
						
						//move the rest of the equation to the left 
						int i = dex + 2;
						while (expression[i] != null && i < expression.length) {
							expression[i - 2] = expression[i];
							i++;
						}
					}
					else
						dex++;
				}
				
				result = Double.parseDouble(expression[0]);
				dex = 0;
				
				//Steps through expression array and evaluates remaining addition and subtraction
				while(dex < length) {
					if(expression[dex].equals("+")) {
						if (dex == 1)
							result = Double.parseDouble(expression[dex - 1]) + Double.parseDouble(expression[dex + 1]);
						else
							result += Double.parseDouble(expression[dex + 1]);
						dex ++;
					}
					else if(expression[dex].equals("-")) {
						if (dex == 1)
							result = Double.parseDouble(expression[dex - 1]) - Double.parseDouble(expression[dex + 1]);
						else
							result -= Double.parseDouble(expression[dex + 1]);
						dex ++;
					}
					else
						dex ++;
				}
				//If there are no decimals print result. Else, format result before printing.
				if (result % 1 == 0)
					System.out.println(" = " + (int)result);
				else
					System.out.printf(" = %.4f" , result);
				
				//Expression is done being evaluated. Clear array for next use
				for (int i = 0; i < expression.length; i++) {
					expression[i] = null;
				}
				counter = 0;
			}
			
			//The clear button. Clears array for next use
			if (Integer.parseInt(e.getActionCommand()) == 11) {
				for (int i = 0; i < expression.length; i++) {
					expression[i] = null;
				}
				console.setText(null);
			}
			
			//The single-term-clear button. Only erases the last entered element
			if (Integer.parseInt(e.getActionCommand()) == 13 && counter >= 0) {
				console.setText(null);
				expression[counter] = null;
				int i = 0;
				while (i < counter) {
					System.out.print(expression[i++] + " ");
				}
				if (counter != 0)
					counter--;
			}
			
		}
	}
	
	public static void main(String[] args) { 
		new Calculator();
	}
}

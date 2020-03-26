/*COP 3330 Spring 2019. FT Quiz 2
 This Code is Written By: Jayden Sipe*/


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;


import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class GUICalc extends JFrame {

	private JPanel contentPane;
	double num1;
	double num2;
	Calculator calc = new Calculator(num1, num2);
	private JTextField operand1TextField;
	private JTextField operand2TextField;
	JComboBox comboBox = new JComboBox();
	private JTextField resultButton;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	JRadioButton popupButton = new JRadioButton("Show result in Pop-Up");
	JRadioButton textFieldButton = new JRadioButton("Show result only in TextField");
	private JTextField plusetcTextField;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUICalc frame = new GUICalc();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	public void operatorFunction(String name)
	{
		try 
		{
		
			double operand1 = Double.parseDouble(operand1TextField.getText());
			double operand2 = Double.parseDouble(operand2TextField.getText());
			
			if (popupButton.isSelected() == true)
			{
				JOptionPane.showMessageDialog(null, calc.operatorFunction(operand1, operand2, name), "Output", 1);
				resultButton.setText(Double.toString(calc.operatorFunction(operand1, operand2, name)));
				resultButton.setCaretPosition(0);
			} else
			{
				resultButton.setText(Double.toString(calc.operatorFunction(operand1, operand2, name)));
				resultButton.setCaretPosition(0);
			}
			
			if (name == "Add")
			{
				plusetcTextField.setText("+");
			}
			else if (name == "Sub")
			{
				plusetcTextField.setText("-");
			}
			else if (name == "Mul")
			{
				plusetcTextField.setText("*");
			}
			else if (name == "Div")
			{
				plusetcTextField.setText("/");
			}
			else if (name == "Power")
			{
				plusetcTextField.setText("^");
			}
			else if (name == "Mod")
			{
				plusetcTextField.setText("%");
			}
		
			
		}
		
		catch(NumberFormatException exception)
		{
			System.out.println("Error occured!");
			
			if (operand1TextField.getText().equals("") || operand2TextField.getText().equals(""))
			{
				JOptionPane.showMessageDialog(null, "Please Enter Two Values!", "Error", 2);
			} else
			{
				JOptionPane.showMessageDialog(null, "Please Enter Only Numerical Values!", "Error", 2);
			}
			
		}
		
	}

	/**
	 * Create the frame.
	 */
	public GUICalc() {
		setTitle("Simple Calculator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 453, 407);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 204));
		contentPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "Operators: ", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setBounds(6, 22, 211, 180);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 153));
		panel.setBounds(6, 16, 199, 157);
		panel_3.add(panel);
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		JButton plusButton = new JButton("+");
		plusButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				operatorFunction("Add");
				
			}
		});
		plusButton.setBounds(10, 48, 70, 23);
		panel.setLayout(null);
		panel.add(plusButton);
		
		JButton subtractButton = new JButton("-");
		subtractButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				operatorFunction("Sub");
				
			}
		});
		subtractButton.setBounds(119, 48, 70, 23);
		panel.add(subtractButton);
		
		JButton multiplyButton = new JButton("*");
		multiplyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				operatorFunction("Mul");
				
			}
		});
		multiplyButton.setBounds(10, 82, 70, 23);
		panel.add(multiplyButton);
		
		JButton divsionButton = new JButton("/");
		divsionButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				operatorFunction("Div");
				
			}
		});
		divsionButton.setBounds(119, 82, 70, 23);
		panel.add(divsionButton);
		
		JButton btnMod = new JButton("%");
		btnMod.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				operatorFunction("Mod");
				
			}
		});
		btnMod.setBounds(10, 117, 70, 23);
		panel.add(btnMod);
		
		JButton exponentButton = new JButton("^");
		exponentButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				operatorFunction("Power");
				
				}
		});
		exponentButton.setBounds(119, 116, 70, 23);
		panel.add(exponentButton);
		
		JLabel lblOperators = new JLabel("Operators:");
		lblOperators.setBounds(10, 11, 70, 14);
		panel.add(lblOperators);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Operation: ", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(227, 22, 200, 202);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 153));
		panel_1.setBounds(6, 16, 188, 180);
		panel_2.add(panel_1);
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1.setLayout(null);
		
		JLabel lblOperand = new JLabel("Operand 1:");
		lblOperand.setBounds(10, 11, 62, 14);
		panel_1.add(lblOperand);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(82, 11, 86, 20);
		panel_1.add(panel_5);
		panel_5.setLayout(null);
		
		operand1TextField = new JTextField();
		operand1TextField.setBounds(0, 0, 86, 20);
		panel_5.add(operand1TextField);
		operand1TextField.setColumns(10);
		
		JLabel lblOperand_1 = new JLabel("Operand 2:");
		lblOperand_1.setBounds(10, 72, 62, 14);
		panel_1.add(lblOperand_1);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(82, 72, 86, 20);
		panel_1.add(panel_4);
		panel_4.setLayout(null);
		
		operand2TextField = new JTextField();
		operand2TextField.setBounds(0, 0, 86, 20);
		panel_4.add(operand2TextField);
		operand2TextField.setColumns(10);
		
		resultButton = new JTextField();
		resultButton.setHorizontalAlignment(SwingConstants.TRAILING);
		resultButton.setEditable(false);
		resultButton.setBounds(66, 137, 102, 20);
		panel_1.add(resultButton);
		resultButton.setColumns(10);
		resultButton.setCaretPosition(0);
		
		JLabel lblResult = new JLabel("Result:");
		lblResult.setBounds(10, 140, 46, 14);
		panel_1.add(lblResult);
		
		plusetcTextField = new JTextField();
		plusetcTextField.setHorizontalAlignment(SwingConstants.CENTER);
		plusetcTextField.setEditable(false);
		plusetcTextField.setBounds(102, 41, 43, 20);
		panel_1.add(plusetcTextField);
		plusetcTextField.setColumns(10);
		
		JButton exitButton = new JButton("Exit");
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.exit(0);
			}
		});
		exitButton.setBounds(128, 292, 89, 31);
		contentPane.add(exitButton);
		
		JButton clearButton = new JButton("Clear");
		clearButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				operand1TextField.setText("");
				operand2TextField.setText("");
				resultButton.setText("");
				comboBox.setSelectedIndex(0);
				plusetcTextField.setText("");
			}
		});
		

		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					if(comboBox.getSelectedItem() == "+")
					{
						
						operatorFunction("Add");
						
					} else if (comboBox.getSelectedItem() == "-")
					{
						
						operatorFunction("Sub");
						
					} else if (comboBox.getSelectedItem() == "*")
					{
						operatorFunction("Mul");
					} else if (comboBox.getSelectedItem() == "/")
					{
						operatorFunction("Div");
					} else if(comboBox.getSelectedItem() == "%")
					{
						operatorFunction("Mod");
						
					} else if (comboBox.getSelectedItem() == "^")
					{
						operatorFunction("Power");
					}
				}
					
				
		});
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"--Select Operator--", "+", "-", "*", "/", "%", "^"}));
		comboBox.setBounds(10, 213, 205, 20);
		contentPane.add(comboBox);
		
		
		clearButton.setBounds(10, 292, 89, 31);
		contentPane.add(clearButton);
		
		
		buttonGroup.add(popupButton);
		popupButton.setBounds(227, 239, 200, 23);
		contentPane.add(popupButton);
		
		buttonGroup.add(textFieldButton);
		textFieldButton.setBounds(227, 265, 200, 23);
		contentPane.add(textFieldButton);
	}
}

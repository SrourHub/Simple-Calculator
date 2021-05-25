import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Calculator extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	private double result;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculator frame = new Calculator();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public String getTextField() { 
		return textField.getText();
	}
	
	public Calculator() {
		setTitle("Calculator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 270, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(5, 5, 259, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton MCButton = new JButton("MC");
		MCButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				result = 0;
			}
		});
		MCButton.setBounds(6, 40, 38, 29);
		contentPane.add(MCButton);
		
		JButton MRButton = new JButton("MR");
		MRButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s = String.valueOf(result) ;
				textField.setText(s);
			}
		});
		MRButton.setBounds(56, 40, 38, 29);
		contentPane.add(MRButton);
		
		JButton MSButton = new JButton("MS");
		MSButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s = textField.getText();
				result = Double.parseDouble(s);
			}
		});
		MSButton.setBounds(106, 40, 38, 29);
		contentPane.add(MSButton);
		
		JButton MPlusButton = new JButton("M+");
		MPlusButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s = textField.getText();
				double temp = Double.parseDouble(s);
				result = result + temp;
			}
		});
		MPlusButton.setBounds(156, 40, 38, 29);
		contentPane.add(MPlusButton);
		
		JButton MminusButton = new JButton("M-"); 
		MminusButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s = textField.getText();
				double temp = Double.parseDouble(s);
				result = result - temp; 
			}
		});
		MminusButton.setBounds(206, 40, 38, 29);
		contentPane.add(MminusButton);
		
		JButton FirstHalfParanthesis = new JButton("(");
		FirstHalfParanthesis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String t = textField.getText();
				t = t + "(";
				textField.setText(t);
			}
		});
		FirstHalfParanthesis.setBounds(156, 81, 38, 29);
		contentPane.add(FirstHalfParanthesis);
		
		JButton DELButton = new JButton("DEL");
		DELButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String t = textField.getText();
				if (t.length() > 1) {
					t = t.substring(0, t.length() - 1);
					textField.setText(t);
				}
				else if (t.length() == 1) {
					textField.setText("");
				}
			}
		});
		DELButton.setBounds(0, 81, 94, 26);
		contentPane.add(DELButton);
		
		JButton CButton = new JButton("C");
		CButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
			}
		});
		CButton.setBounds(106, 81, 38, 29);
		contentPane.add(CButton);
		
		JButton SecondHalfParanthesis = new JButton(")");
		SecondHalfParanthesis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String t = textField.getText();
				t = t + ")";
				textField.setText(t);
			}
		});
		SecondHalfParanthesis.setBounds(206, 81, 38, 29);
		contentPane.add(SecondHalfParanthesis);
		
		JButton SevenButton = new JButton("7");
		SevenButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String t = textField.getText();
				t = t + "7";
				textField.setText(t);
			}
		});
		SevenButton.setBounds(6, 119, 38, 29);
		contentPane.add(SevenButton);
		
		JButton EightButton = new JButton("8");
		EightButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String t = textField.getText();
				t = t + "8";
				textField.setText(t);
			}
		});
		EightButton.setBounds(56, 119, 38, 29);
		contentPane.add(EightButton);
		
		JButton NinthButton = new JButton("9");
		NinthButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String t = textField.getText();
				t = t + "9";
				textField.setText(t);
			}
		});
		NinthButton.setBounds(106, 119, 38, 29);
		contentPane.add(NinthButton);
		
		JButton DivideButton = new JButton("/");
		DivideButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String t = textField.getText();
				t = t + "/";
				textField.setText(t);
			}
		});
		DivideButton.setBounds(156, 119, 38, 29);
		contentPane.add(DivideButton);
		
		JButton EqualButton = new JButton("=");
		EqualButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String s = ToPostfix.changeFromInfixToPostfix(textField.getText());
				String result = Evaluate.computePostfix(s);
				textField.setText(result);
			}
		});
		EqualButton.setBounds(206, 119, 38, 153);
		contentPane.add(EqualButton);
		
		JButton FourthButton = new JButton("4");
		FourthButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String t = textField.getText();
				t = t + "4";
				textField.setText(t);
			}
		});
		FourthButton.setBounds(6, 160, 38, 29);
		contentPane.add(FourthButton);
		
		JButton FifthButton = new JButton("5");
		FifthButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String t = textField.getText();
				t = t + "5";
				textField.setText(t);
			}
		});
		FifthButton.setBounds(56, 160, 38, 29);
		contentPane.add(FifthButton);
		
		JButton SixthButton = new JButton("6");
		SixthButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String t = textField.getText();
				t = t + "6";
				textField.setText(t);
			}
		});
		SixthButton.setBounds(106, 160, 38, 29);
		contentPane.add(SixthButton);
		
		JButton TimesButton = new JButton("*");
		TimesButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String t = textField.getText();
				t = t + "*";
				textField.setText(t);
			}
		});
		TimesButton.setBounds(156, 160, 38, 29);
		contentPane.add(TimesButton);
		
		JButton OneButton = new JButton("1");
		OneButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String l = textField.getText();
				l = l + "1";
				textField.setText(l);
			}
		});
		OneButton.setBounds(5, 201, 38, 29);
		contentPane.add(OneButton);
		
		JButton SecondButton = new JButton("2");
		SecondButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String t = textField.getText();
				t = t + "2";
				textField.setText(t);
		}
		});
		SecondButton.setBounds(56, 201, 38, 29);
		contentPane.add(SecondButton);
		
		JButton ThirdButton = new JButton("3");
		ThirdButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String t = textField.getText();
				t = t + "3";
				textField.setText(t);
			}
		});
		ThirdButton.setBounds(106, 201, 38, 29);
		contentPane.add(ThirdButton);
		
		JButton MinusButton = new JButton("-");
		MinusButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String t = textField.getText();
				t = t + "-";
				textField.setText(t);
			}
		});
		MinusButton.setBounds(156, 201, 38, 29);
		contentPane.add(MinusButton);
		
		JButton ZeroButton = new JButton("0");
		ZeroButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String t = textField.getText();
				t = t + "0";
				textField.setText(t);
			}
		});
		ZeroButton.setBounds(5, 242, 94, 29);
		contentPane.add(ZeroButton);
		
		JButton DotButton = new JButton(".");
		DotButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String t = textField.getText();
				t = t + ".";
				textField.setText(t);
			}
		});
		DotButton.setBounds(106, 242, 38, 29);
		contentPane.add(DotButton);
		
		JButton PlusButton = new JButton("+"); 
		PlusButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String t = textField.getText();
				t = t + "+";
				textField.setText(t);
			}
		});
		PlusButton.setBounds(156, 242, 38, 29);
		contentPane.add(PlusButton);
	}
}

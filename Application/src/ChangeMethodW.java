/*
 * @projectDescription The pop-up window for the " Change Method " button
 * 
 * @authors	John Shenk
 * 
 * @dateLastModified September 26, 2022
 */


import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JSeparator;

public class ChangeMethodW {

	Controller controller;
	private static JTextField textField;
	public ChangeMethodW(Controller newController) {
		controller = newController;
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void initialize() {
		JFrame frmJamblAdd = new JFrame("JAMBL - Change Method Type");
		frmJamblAdd.setTitle("JAMBL - Change Method");
		frmJamblAdd.setBounds(100, 100, 447, 321);
		frmJamblAdd.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frmJamblAdd.getContentPane().setLayout(null);
		frmJamblAdd.setVisible(true);
		
		JLabel lblAddClass = new JLabel("Choose a class and choose the method name.");
		lblAddClass.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAddClass.setBounds(10, 10, 338, 13);
		frmJamblAdd.getContentPane().add(lblAddClass);
		
		JLabel lblChooseM = new JLabel("* Choose a Method name");
		lblChooseM.setForeground(new Color(255, 0, 0));
		lblChooseM.setBounds(181, 140, 167, 13);
		frmJamblAdd.getContentPane().add(lblChooseM);
		lblChooseM.setVisible(false);
		
		JLabel lblClassName = new JLabel("Choose a class name:");
		lblClassName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblClassName.setBounds(10, 33, 219, 51);
		frmJamblAdd.getContentPane().add(lblClassName);
		
		JLabel lblNewLabel = new JLabel("New Method Type:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(10, 202, 146, 13);
		frmJamblAdd.getContentPane().add(lblNewLabel);
		lblNewLabel.setVisible(false);
		
		JLabel lblMethod= new JLabel("Method Name:");
		lblMethod.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMethod.setBounds(10, 113, 161, 13);
		frmJamblAdd.getContentPane().add(lblMethod);
		lblMethod.setVisible(false);
		
		//////////////////////////////
		//******* Text Field *******//
		//////////////////////////////
		
		textField = new JTextField();
		textField.setBounds(142, 201, 265, 19);
		frmJamblAdd.getContentPane().add(textField);
		textField.setColumns(10);
		textField.setVisible(false);
		
		///////////////////////////
		//******* Buttons *******//
		///////////////////////////
		
		////////////////////////////////////////////////////////////// Change Method Button
		JButton btnChangeMethod = new JButton("Change Method");
		btnChangeMethod.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnChangeMethod.setBounds(10, 253, 190, 21);
		frmJamblAdd.getContentPane().add(btnChangeMethod);
		btnChangeMethod.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		////////////////////////////////////////////////////////////// Cancel Button
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCancel.setBounds(233, 253, 190, 21);
		frmJamblAdd.getContentPane().add(btnCancel);
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmJamblAdd.dispose();
			}
		});
		
		//////////////////////////////
		//******* Combo Boxes*******//
		//////////////////////////////
		
		JComboBox Methods = new JComboBox();
		Methods.setModel(new DefaultComboBoxModel(new String[] {"Choose a method:", "Method1"}));
		Methods.setBounds(10, 136, 161, 21);
		frmJamblAdd.getContentPane().add(Methods);
		Methods.setVisible(false);
		Methods.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				textField.setVisible(true);
				lblNewLabel.setVisible(true);
			}
		});
		
		@SuppressWarnings("rawtypes")
		JComboBox Classes = new JComboBox();
		Classes.setModel(new DefaultComboBoxModel(new String[] {"Choose a class:", "Class1", "Class2"}));
		Classes.setBounds(10, 74, 161, 21);
		frmJamblAdd.getContentPane().add(Classes);
		Classes.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				Methods.setVisible(true);
				lblMethod.setVisible(true);
			}
		});
		
		

	}
}
/*
 * @projectDescription The pup-up window for the " Add Class " button
 * 
 * @authors	John Shenk
 * 
 * @dateLastModified September 26, 2022
 */



import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

import javax.swing.JComboBox;
public class AddFieldW {
	
	
	private static JTextField fieldNameBox;
	private static JTextField fieldTypeBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public static void initialize() {
		JFrame frame = new JFrame("JAMBL - Add Field");
		frame.setBounds(100, 100, 496, 285);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblAddClass = new JLabel("Select a class to add a field to.");
		lblAddClass.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAddClass.setBounds(10, 10, 338, 13);
		frame.getContentPane().add(lblAddClass);
		
		JLabel lblClassName = new JLabel("Class Name: ");
		lblClassName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblClassName.setBounds(10, 43, 87, 13);
		frame.getContentPane().add(lblClassName);
		
		fieldNameBox = new JTextField();
		lblClassName.setLabelFor(fieldNameBox);
		fieldNameBox.setBounds(121, 107, 227, 19);
		frame.getContentPane().add(fieldNameBox);
		fieldNameBox.setColumns(10);
		frame.setVisible(true);
		
		///////////////////////////
		//******* Buttons *******//
		///////////////////////////
		
		////////////////////////////////////////////////////////////// Add Class Button
		JButton btnAddField = new JButton("Add Field");
		btnAddField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAddField.setBounds(85, 227, 132, 21);
		frame.getContentPane().add(btnAddField);
		btnAddField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		
		////////////////////////////////////////////////////////////// Cancel Button
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCancel.setBounds(227, 227, 132, 21);
		frame.getContentPane().add(btnCancel);
		
		JComboBox comboBoxClasses = new JComboBox();
		comboBoxClasses.setBounds(10, 66, 124, 21);
		frame.getContentPane().add(comboBoxClasses);
		
		JLabel lblField = new JLabel("Field Name:");
		lblField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblField.setBounds(10, 108, 108, 13);
		frame.getContentPane().add(lblField);
		
		JLabel lblFieldType = new JLabel("Field Type:");
		lblFieldType.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblFieldType.setBounds(10, 148, 108, 18);
		frame.getContentPane().add(lblFieldType);
		
		fieldTypeBox = new JTextField();
		fieldTypeBox.setColumns(10);
		fieldTypeBox.setBounds(121, 147, 227, 19);
		frame.getContentPane().add(fieldTypeBox);
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
	}
}
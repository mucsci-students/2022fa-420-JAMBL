/*
 * @projectDescription The pup-up window for the " Delete Class " button
 * 
 * @authors	John Shenk
 * 
 * @dateLastModified September 26, 2022
 */


import java.awt.EventQueue;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.Color;


public class DeleteMethodW {

	Controller controller;
	public DeleteMethodW(Controller newController) {
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
	public static void initialize() {
		JFrame frame = new JFrame("JAMBL - Delete Method");
		frame.setBounds(100, 100, 450, 289);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		////////////////////////////
		///******* Labels *******///
		////////////////////////////
		
		JLabel lblDeleteClass = new JLabel("Select the name of a class and method");
		lblDeleteClass.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDeleteClass.setBounds(10, 10, 338, 13);
		frame.getContentPane().add(lblDeleteClass);
		
		JLabel lblSelectClass = new JLabel("Select Class Name: ");
		lblSelectClass.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSelectClass.setBounds(10, 54, 137, 13);
		frame.getContentPane().add(lblSelectClass);
		
		JLabel lblSelectMethodName = new JLabel("Select Method Name: ");
		lblSelectMethodName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSelectMethodName.setBounds(10, 108, 137, 13);
		frame.getContentPane().add(lblSelectMethodName);
		
		///////////////////////////
		//******* Buttons *******//
		///////////////////////////
		
		////////////////////////////////////////////////////////////// Add Class Button
		JButton btnDeleteMethod = new JButton("Delete Method");
		btnDeleteMethod.setForeground(new Color(255, 0, 0));
		btnDeleteMethod.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnDeleteMethod.setBounds(85, 221, 132, 21);
		frame.getContentPane().add(btnDeleteMethod);
		btnDeleteMethod.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		
		////////////////////////////////////////////////////////////// Cancel Button
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCancel.setBounds(227, 221, 132, 21);
		frame.getContentPane().add(btnCancel);
		
	
		//////////////////////////////
		//******* Combo Boxes*******//
		//////////////////////////////
		
		@SuppressWarnings("rawtypes")
		JComboBox comboBoxClasses = new JComboBox();
		comboBoxClasses.setBounds(10, 77, 207, 21);
		frame.getContentPane().add(comboBoxClasses);
		
		JComboBox comboBoxMethods = new JComboBox();
		comboBoxMethods.setBounds(10, 130, 207, 21);
		frame.getContentPane().add(comboBoxMethods);
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		
	
	
	}
}

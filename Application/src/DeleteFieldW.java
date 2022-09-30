/*
 * @projectDescription The pup-up window for the " Delete Field " button
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

public class DeleteFieldW {

	Controller GUIcontroller = new Controller(null, null);
	public DeleteFieldW(Controller newController) {
		GUIcontroller = newController;
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
		JFrame frmJamblAdd = new JFrame("JAMBL - Change Field Name");
		frmJamblAdd.setTitle("JAMBL - Change Method");
		frmJamblAdd.setBounds(100, 100, 447, 258);
		frmJamblAdd.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frmJamblAdd.getContentPane().setLayout(null);
		frmJamblAdd.setVisible(true);
		
		////////////////////////////
		///******* Labels *******///
		////////////////////////////
		
		JLabel lblAddClass = new JLabel("Choose a class and choose the field.");
		lblAddClass.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAddClass.setBounds(10, 10, 338, 13);
		frmJamblAdd.getContentPane().add(lblAddClass);
		
		JLabel lblClassName = new JLabel("Choose a class name:");
		lblClassName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblClassName.setBounds(10, 33, 219, 51);
		frmJamblAdd.getContentPane().add(lblClassName);
		
		JLabel lblField= new JLabel("Field Name:");
		lblField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblField.setBounds(10, 113, 161, 13);
		frmJamblAdd.getContentPane().add(lblField);
		lblField.setVisible(false);
		
		///////////////////////////
		//******* Buttons *******//
		///////////////////////////
		
		////////////////////////////////////////////////////////////// Change Field Name Button
		JButton btnDeleteField = new JButton("Delete Field");
		btnDeleteField.setForeground(new Color(255, 0, 0));
		btnDeleteField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnDeleteField.setBounds(10, 189, 190, 21);
		frmJamblAdd.getContentPane().add(btnDeleteField);
		btnDeleteField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		
			}
		});
		
		////////////////////////////////////////////////////////////// Cancel Button
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCancel.setBounds(233, 189, 190, 21);
		frmJamblAdd.getContentPane().add(btnCancel);
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmJamblAdd.dispose();
			}
		});
		
		//////////////////////////////
		//******* Combo Boxes*******//
		//////////////////////////////
		
		JComboBox cbMethods = new JComboBox();
		cbMethods.setModel(new DefaultComboBoxModel(new String[] {"Choose a field:"}));
		cbMethods.setBounds(10, 136, 161, 21);
		frmJamblAdd.getContentPane().add(cbMethods);
		cbMethods.setVisible(false);
		cbMethods.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				
			}
		});
		@SuppressWarnings("rawtypes")
		JComboBox Classes = new JComboBox();
		Classes.setModel(new DefaultComboBoxModel(new String[] {"Choose a class:", "Class1", "Class2"}));
		Classes.setBounds(10, 74, 161, 21);
		frmJamblAdd.getContentPane().add(Classes);
		Classes.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				cbMethods.setVisible(true);
				lblField.setVisible(true);
			}
		});
		
		

	}
}
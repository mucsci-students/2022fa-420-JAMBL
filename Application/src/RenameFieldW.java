/*
 * @projectDescription The pup-up window for the " Add Relationship " button
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

public class RenameFieldW {

	Controller GUIcontroller = new Controller(null, null);
	
	private static JTextField textField;
	public RenameFieldW(Controller newController) {
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
		frmJamblAdd.setTitle("JAMBL - Rename Field");
		frmJamblAdd.setBounds(100, 100, 447, 321);
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
		
		JLabel lblChooseM = new JLabel("* Choose a Field name");
		lblChooseM.setForeground(new Color(255, 0, 0));
		lblChooseM.setBounds(181, 140, 167, 13);
		frmJamblAdd.getContentPane().add(lblChooseM);
		lblChooseM.setVisible(false);
		
		JLabel lblClassName = new JLabel("Choose a class name:");
		lblClassName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblClassName.setBounds(10, 33, 219, 51);
		frmJamblAdd.getContentPane().add(lblClassName);
		
		JLabel lblNewField = new JLabel("New Field Name:");
		lblNewField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewField.setBounds(10, 202, 146, 13);
		frmJamblAdd.getContentPane().add(lblNewField);
		lblNewField.setVisible(false);
		
		JLabel lblMethod= new JLabel("Field Name:");
		lblMethod.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMethod.setBounds(10, 113, 161, 13);
		frmJamblAdd.getContentPane().add(lblMethod);
		lblMethod.setVisible(false);
		
		//////////////////////////////
		///******* Text Box *******///
		//////////////////////////////
		
		textField = new JTextField();
		textField.setBounds(142, 201, 265, 19);
		frmJamblAdd.getContentPane().add(textField);
		textField.setColumns(10);
		textField.setVisible(false);
	
		///////////////////////////
		//******* Buttons *******//
		///////////////////////////
		
		////////////////////////////////////////////////////////////// Change Field Name Button
		JButton btnChangeMethod = new JButton("Change Field Name");
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
		
		
		JComboBox Methods = new JComboBox();
		Methods.setModel(new DefaultComboBoxModel(new String[] {"Choose a field:"}));
		Methods.setBounds(10, 136, 161, 21);
		frmJamblAdd.getContentPane().add(Methods);
		Methods.setVisible(false);
		Methods.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				textField.setVisible(true);
				lblNewField.setVisible(true);
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
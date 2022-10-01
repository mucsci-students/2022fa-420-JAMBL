/*
 * @projectDescription The pop-up window for the " Edit Field " button
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

public class EditFieldWindow {

	Controller controller;
	private static JTextField textFieldType;
	public EditFieldWindow(Controller newController) {
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
		JFrame frmJamblAdd = new JFrame("JAMBL - Change Field Type");
		frmJamblAdd.setTitle("JAMBL - Change Method");
		frmJamblAdd.setBounds(100, 100, 447, 321);
		frmJamblAdd.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frmJamblAdd.getContentPane().setLayout(null);
		frmJamblAdd.setVisible(true);
		

		////////////////////////////
		///******* Labels *******///
		////////////////////////////
		
		JLabel lblAddClass = new JLabel("Choose a class and choose the field name.");
		lblAddClass.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAddClass.setBounds(10, 10, 371, 13);
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
		
		JLabel lblNewFType = new JLabel("New Field Type:");
		lblNewFType.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewFType.setBounds(10, 202, 146, 13);
		frmJamblAdd.getContentPane().add(lblNewFType);
		lblNewFType.setVisible(false);
		
		JLabel lblField= new JLabel("Field Name:");
		lblField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblField.setBounds(10, 113, 161, 13);
		frmJamblAdd.getContentPane().add(lblField);
		lblField.setVisible(false);
		
		////////////////////////////
		//******* Text Box *******//
		////////////////////////////
		
		textFieldType = new JTextField();
		textFieldType.setBounds(142, 201, 265, 19);
		frmJamblAdd.getContentPane().add(textFieldType);
		textFieldType.setColumns(10);
		textFieldType.setVisible(false);
		
		///////////////////////////
		//******* Buttons *******//
		///////////////////////////
		
		////////////////////////////////////////////////////////////// Change Method Button
		JButton btnChangeField = new JButton("Change Field");
		btnChangeField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnChangeField.setBounds(10, 253, 190, 21);
		frmJamblAdd.getContentPane().add(btnChangeField);
		btnChangeField.addActionListener(new ActionListener() {
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
		
		JComboBox Fields = new JComboBox();
		Fields.setModel(new DefaultComboBoxModel(new String[] {"Choose a field:", "Field1"}));
		Fields.setBounds(10, 136, 161, 21);
		frmJamblAdd.getContentPane().add(Fields);
		Fields.setVisible(false);
		Fields.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				textFieldType.setVisible(true);
				lblNewFType.setVisible(true);
			}
		});
		
		@SuppressWarnings("rawtypes")
		JComboBox Classes = new JComboBox();
		Classes.setModel(new DefaultComboBoxModel(new String[] {"Choose a class:", "Class1", "Class2"}));
		Classes.setBounds(10, 74, 161, 21);
		frmJamblAdd.getContentPane().add(Classes);
		Classes.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				Fields.setVisible(true);
				lblField.setVisible(true);
			}
		});
	}
}
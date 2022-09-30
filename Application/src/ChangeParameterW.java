/*
 * @projectDescription The pup-up window for the " Add Parameter " button
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

public class ChangeParameterW {

	Controller controller;
	private static JTextField textParameter;
	public ChangeParameterW(Controller newController) {
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
		JFrame frmJamblAdd = new JFrame("JAMBL - Add Parameter");
		frmJamblAdd.setTitle("JAMBL - Change Parameter");
		frmJamblAdd.setBounds(100, 100, 447, 373);
		frmJamblAdd.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frmJamblAdd.getContentPane().setLayout(null);
		frmJamblAdd.setVisible(true);
		
		////////////////////////////
		///******* Labels *******///
		////////////////////////////
		
		
		JLabel lblAddClass = new JLabel("Choose a class to get started");
		lblAddClass.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAddClass.setBounds(10, 10, 398, 33);
		frmJamblAdd.getContentPane().add(lblAddClass);
		
		JLabel lblClassName = new JLabel("Choose a class name:");
		lblClassName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblClassName.setBounds(10, 33, 219, 51);
		frmJamblAdd.getContentPane().add(lblClassName);
		
		JLabel lblMethod = new JLabel("Method:");
		lblMethod.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMethod.setBounds(10, 113, 136, 13);
		frmJamblAdd.getContentPane().add(lblMethod);
		lblMethod.setVisible(false);
		
		JLabel lblParameter = new JLabel("Parameter Name:");
		lblParameter.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblParameter.setBounds(10, 177, 136, 13);
		frmJamblAdd.getContentPane().add(lblParameter);
		lblParameter.setVisible(false);
		
		JLabel lblNewParameterName = new JLabel("New Parameter Name:");
		lblNewParameterName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewParameterName.setBounds(9, 237, 158, 13);
		frmJamblAdd.getContentPane().add(lblNewParameterName);
		lblNewParameterName.setVisible(false);
		
		////////////////////////////
		//******* Text Box *******//
		////////////////////////////

		textParameter = new JTextField();
		textParameter.setBounds(8, 258, 161, 19);
		frmJamblAdd.getContentPane().add(textParameter);
		textParameter.setColumns(10);
		textParameter.setVisible(false);
		
		
		///////////////////////////
		//******* Buttons *******//
		///////////////////////////
		
		////////////////////////////////////////////////////////////// Add Class Button
		JButton btnChangeParameter = new JButton("Change Parameter");
		btnChangeParameter.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnChangeParameter.setBounds(11, 299, 190, 21);
		frmJamblAdd.getContentPane().add(btnChangeParameter);
		btnChangeParameter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		////////////////////////////////////////////////////////////// Cancel Button
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCancel.setBounds(224, 298, 190, 21);
		frmJamblAdd.getContentPane().add(btnCancel);
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmJamblAdd.dispose();
			}
		});
		
		//////////////////////////////
		//******* Combo Boxes*******//
		//////////////////////////////
		
		JComboBox cbParameters = new JComboBox();
		cbParameters.setModel(new DefaultComboBoxModel(new String[] {"Choose a parameter", "Parameter1"}));
		cbParameters.setBounds(10, 200, 161, 21);
		frmJamblAdd.getContentPane().add(cbParameters);
		cbParameters.setVisible(false);
		cbParameters.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				textParameter.setVisible(true);
				lblNewParameterName.setVisible(true);
			}
		});	
		
		JComboBox cbMethods = new JComboBox();
		cbMethods.setBounds(10, 136, 161, 21);
		frmJamblAdd.getContentPane().add(cbMethods);
		cbMethods.setModel(new DefaultComboBoxModel(new String[] {"Choose a method:", "Method1"})); 
		cbMethods.setVisible(false);
		cbMethods.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				cbParameters.setVisible(true);
				lblParameter.setVisible(true);
			}
		});

		@SuppressWarnings("rawtypes")
		JComboBox cbClasses = new JComboBox();
		cbClasses.setModel(new DefaultComboBoxModel(new String[] {"Choose a class:", "Class1"}));
		cbClasses.setBounds(10, 74, 161, 21);
		frmJamblAdd.getContentPane().add(cbClasses);
		cbClasses.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				cbMethods.setVisible(true);
				lblMethod.setVisible(true);
			}
		});
	}
}
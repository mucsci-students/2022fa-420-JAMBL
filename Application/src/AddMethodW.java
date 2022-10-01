/*
 * @projectDescription The pop-up window for the " Add Method " button
 * 
 * @authors	John Shenk
 * 
 * @dateLastModified September 26, 2022
 */

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
import javax.swing.SwingConstants;
import javax.swing.DefaultComboBoxModel;

public class AddMethodW {
	
	Controller controller;
	public AddMethodW(Controller newController) {
		controller = newController;
	}
	
	private static JTextField methodNameBox;
	private static JTextField methodTypeBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings("rawtypes")
	public static void initialize() {
		JFrame frmJamblAdd = new JFrame("JAMBL - Add Class");
		frmJamblAdd.setTitle("JAMBL - Add Method");
		frmJamblAdd.setBounds(100, 100, 576, 225);
		frmJamblAdd.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frmJamblAdd.getContentPane().setLayout(null);
		
		////////////////////////////
		///******* Labels *******///
		////////////////////////////
		
		JLabel lblAddMethod = new JLabel("Enter the name and type for a method to add and select a class");
		lblAddMethod.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddMethod.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAddMethod.setBounds(10, 10, 542, 29);
		frmJamblAdd.getContentPane().add(lblAddMethod);
		
		JLabel lblMethodName = new JLabel("Method Name");
		lblMethodName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMethodName.setBounds(27, 78, 106, 18);
		frmJamblAdd.getContentPane().add(lblMethodName);
		lblMethodName.setVisible(false);
		
		JLabel lblClass = new JLabel("Class:");
		lblClass.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblClass.setBounds(30, 49, 45, 13);
		frmJamblAdd.getContentPane().add(lblClass);
		
		JLabel lblMethodType = new JLabel("Method Type:");
		lblMethodType.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMethodType.setBounds(27, 101, 106, 19);
		frmJamblAdd.getContentPane().add(lblMethodType);
		lblMethodType.setVisible(false);
		
		////////////////////////////////
		///******* Text Boxes *******///
		////////////////////////////////
		
		methodNameBox = new JTextField();
		methodNameBox.setBounds(132, 80, 227, 19);
		frmJamblAdd.getContentPane().add(methodNameBox);
		methodNameBox.setColumns(10);
		frmJamblAdd.setVisible(true);
		methodNameBox.setVisible(false);
		
		methodTypeBox = new JTextField();
		methodTypeBox.setColumns(10);
		methodTypeBox.setBounds(132, 103, 227, 19);
		frmJamblAdd.getContentPane().add(methodTypeBox);
		methodTypeBox.setVisible(false);
		
		///////////////////////////
		//******* Buttons *******//
		///////////////////////////
		
		////////////////////////////////////////////////////////////// Add Method Button
		JButton btnAddMethod = new JButton("Add Method");
		btnAddMethod.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAddMethod.setBounds(85, 136, 132, 21);
		frmJamblAdd.getContentPane().add(btnAddMethod);
		btnAddMethod.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmJamblAdd.dispose();
			}
		});
		
		////////////////////////////////////////////////////////////// Cancel Button
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCancel.setBounds(227, 136, 132, 21);
		frmJamblAdd.getContentPane().add(btnCancel);
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmJamblAdd.dispose();
			}
		});

		//////////////////////////////
		//******* Combo Boxes*******//
		//////////////////////////////

		JComboBox comboBoxClasses = new JComboBox();
		comboBoxClasses.setModel(new DefaultComboBoxModel(new String[] {"Choose a class: ", "Class1"}));
		comboBoxClasses.setBounds(85, 47, 132, 21);
		frmJamblAdd.getContentPane().add(comboBoxClasses);
		comboBoxClasses.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				lblMethodName.setVisible(true);
				lblMethodType.setVisible(true);
				methodNameBox.setVisible(true);
				methodTypeBox.setVisible(true);
			}
		});
		
		
	}
}

/*
 * @projectDescription The pup-up window for the " Remove Parameter " button
 * 
 * @authors	John Shenk
 * 
 * @dateLastModified September 29, 2022
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

public class RemoveParameterW {

	Controller controller;
	public RemoveParameterW(Controller newController) {
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
	@SuppressWarnings({ "unchecked", "rawtypes", "deprecation" })
	public static void initialize() {
		JFrame frmJamblAdd = new JFrame("JAMBL - Remove Parameter");
		frmJamblAdd.setBounds(100, 100, 447, 393);
		frmJamblAdd.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frmJamblAdd.getContentPane().setLayout(null);
		frmJamblAdd.setVisible(true);
		
		////////////////////////////
		///******* Labels *******///
		////////////////////////////

		JLabel lblClassName = new JLabel("Choose a class name:");
		lblClassName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblClassName.setBounds(10, 33, 219, 51);
		frmJamblAdd.getContentPane().add(lblClassName);
		
		JLabel lblParameter = new JLabel("Parameter:");
		lblParameter.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblParameter.setBounds(10, 193, 82, 13);
		frmJamblAdd.getContentPane().add(lblParameter);
		lblParameter.setVisible(false);
		
		JLabel lblMethod = new JLabel("Method:");
		lblMethod.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMethod.setBounds(10, 113, 136, 13);
		frmJamblAdd.getContentPane().add(lblMethod);
		lblMethod.setVisible(false);
		
		///////////////////////////
		//******* Buttons *******//
		///////////////////////////
		
		////////////////////////////////////////////////////////////// Remove Parameter Button
		JButton btnRemoveParameter = new JButton("Delete Parameter");
		btnRemoveParameter.setForeground(new Color(255, 0, 0));
		btnRemoveParameter.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnRemoveParameter.setBounds(10, 296, 190, 21);
		frmJamblAdd.getContentPane().add(btnRemoveParameter);
		btnRemoveParameter.disable();
		btnRemoveParameter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		////////////////////////////////////////////////////////////// Cancel Button
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCancel.setBounds(233, 296, 190, 21);
		frmJamblAdd.getContentPane().add(btnCancel);
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmJamblAdd.dispose();
			}
		});
		
		//////////////////////////////
		//******* Combo Boxes*******//
		//////////////////////////////
		
		JComboBox cbParameter = new JComboBox();
		cbParameter.setModel(new DefaultComboBoxModel(new String[] {"Choose a Parameter:"}));
		cbParameter.setBounds(10, 216, 161, 21);
		frmJamblAdd.getContentPane().add(cbParameter);
		cbParameter.setVisible(false);
		
		JComboBox cdMethods = new JComboBox();
		cdMethods.setBounds(10, 136, 161, 21);
		frmJamblAdd.getContentPane().add(cdMethods);
		cdMethods.setModel(new DefaultComboBoxModel(new String[] {"Choose a Method:"}));
		cdMethods.setVisible(false);
		cdMethods.addItemListener(new ItemListener() {
		public void itemStateChanged(ItemEvent arg0) {
				cbParameter.setVisible(true);
				lblParameter.setVisible(true);
		}
		});
		
		JComboBox cbClasses = new JComboBox();
		cbClasses.setModel(new DefaultComboBoxModel(new String[] {"Choose a class:"}));
		cbClasses.setBounds(10, 74, 161, 21);
		frmJamblAdd.getContentPane().add(cbClasses);
		cbClasses.addItemListener(new ItemListener() {
		public void itemStateChanged(ItemEvent arg0) {
				cdMethods.setVisible(true);
				lblMethod.setVisible(true);
		}
		});
		
		
		
		
		

	}
}
/*
 * @projectDescription The pup-up window for the " Delete Relationship " button
 * 
 * @authors	John Shenk
 * 
 * @dateLastModified September 26, 2022
 */

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

public class DeleteRelationshipW {

	Controller controller;
	public DeleteRelationshipW(Controller newController) {
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
		JFrame frame = new JFrame("JAMBL - Delete Relationship");
		frame.setBounds(100, 100, 450, 243);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		////////////////////////////
		///******* Labels *******///
		////////////////////////////
		
		JLabel lblClassChoose = new JLabel("Select a class and the class in relationship to delete.");
		lblClassChoose.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblClassChoose.setBounds(10, 20, 416, 13);
		frame.getContentPane().add(lblClassChoose);
		
		JLabel lblClass1 = new JLabel("Class Name:");
		lblClass1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblClass1.setBounds(10, 54, 134, 13);
		frame.getContentPane().add(lblClass1);
		
		JLabel lblClass2 = new JLabel("Class with relationship to delete:");
		lblClass2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblClass2.setBounds(10, 108, 255, 13);
		frame.getContentPane().add(lblClass2);
		lblClass2.setVisible(false);

		///////////////////////////
		//******* Buttons *******//
		///////////////////////////

		JButton btnDeleteRelationship = new JButton("Delete Relationship");
		btnDeleteRelationship.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnDeleteRelationship.setBounds(10, 172, 186, 21);
		frame.getContentPane().add(btnDeleteRelationship);
		btnDeleteRelationship.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
					}
				});

		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCancel.setBounds(240, 172, 186, 21);
		frame.getContentPane().add(btnCancel);
		frame.setVisible(true);
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});

		
		///////////////////////////////
		//******* Combo Boxes *******//
		///////////////////////////////

		JComboBox cdClass2 = new JComboBox();
		cdClass2.setModel(new DefaultComboBoxModel(new String[] {"Choose a class:"}));
		cdClass2.setBounds(10, 131, 134, 21);
		frame.getContentPane().add(cdClass2);
		cdClass2.setVisible(false);
		
		JComboBox cbClass1 = new JComboBox();
		cbClass1.setModel(new DefaultComboBoxModel(new String[] {"Choose a class:"}));
		cbClass1.setBounds(10, 77, 134, 21);
		frame.getContentPane().add(cbClass1);
		cbClass1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				cdClass2.setVisible(true);
				lblClass2.setVisible(true);
			}
		});

		
	}
}
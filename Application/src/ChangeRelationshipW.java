/*
 * @projectDescription The pup-up window for the " Change Relationship " button
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
import javax.swing.JTextField;
import javax.swing.JButton;

public class ChangeRelationshipW {

	Controller controller;
	public ChangeRelationshipW(Controller newController) {
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
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void initialize() {
		JFrame frmJamblChange = new JFrame("JAMBL - Rename Class");
		frmJamblChange.setTitle("JAMBL - Change Relationship Type");
		frmJamblChange.setBounds(100, 100, 450, 332);
		frmJamblChange.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frmJamblChange.getContentPane().setLayout(null);
		
		////////////////////////////
		///******* Labels *******///
		////////////////////////////
		
		JLabel lblNewLabel = new JLabel("Select Class to Rename.");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(10, 10, 235, 23);
		frmJamblChange.getContentPane().add(lblNewLabel);
		
		JLabel lblClass1 = new JLabel("Class 1:");
		lblClass1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblClass1.setBounds(10, 55, 63, 13);
		frmJamblChange.getContentPane().add(lblClass1);
		
		JLabel lblRelationship = new JLabel("New Relationship Type: ");
		lblRelationship.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblRelationship.setBounds(10, 171, 168, 13);
		frmJamblChange.getContentPane().add(lblRelationship);
		
		JLabel lblClass2 = new JLabel("Class 2:");
		lblClass2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblClass2.setBounds(10, 109, 63, 13);
		frmJamblChange.getContentPane().add(lblClass2);
		lblClass2.setVisible(false);
		
		/////////////////////////////
		///******* Buttons *******///
		/////////////////////////////
		
		JButton btnRenameClass = new JButton("Change Type");
		btnRenameClass.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnRenameClass.setBounds(10, 249, 178, 21);
		frmJamblChange.getContentPane().add(btnRenameClass);
		btnRenameClass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmJamblChange.dispose();
			}
		});
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCancel.setBounds(248, 249, 178, 21);
		frmJamblChange.getContentPane().add(btnCancel);
		frmJamblChange.setVisible(true);
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmJamblChange.dispose();
			}
		});
		
		//////////////////////////////
		//******* Combo Boxes*******//
		//////////////////////////////
	
		JComboBox cbRelationships = new JComboBox();
		cbRelationships.setModel(new DefaultComboBoxModel(new String[] {"Choose a relationship type:", "Aggr", "Real", "Inhe", "Comp"}));
		cbRelationships.setBounds(10, 194, 111, 21);
		frmJamblChange.getContentPane().add(cbRelationships);
		
		JComboBox cbClass2 = new JComboBox();
		cbClass2.setModel(new DefaultComboBoxModel(new String[] {"Choose a class:", "Class1"}));
		cbClass2.setBounds(10, 131, 111, 21);
		frmJamblChange.getContentPane().add(cbClass2);
		cbClass2.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				cbRelationships.setVisible(true);
				lblRelationship.setVisible(true);
			}
		});

		JComboBox cbClass1 = new JComboBox();
		cbClass1.setModel(new DefaultComboBoxModel(new String[] {"Choose a class:", "Class1"}));
		cbClass1.setBounds(10, 78, 111, 21);
		frmJamblChange.getContentPane().add(cbClass1);
		cbClass1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				cbClass2.setVisible(true);
				lblClass2.setVisible(true);
			}
		});

	}
}
/*
 * @projectDescription The pup-up window for the " Add Relationship " button
 * 
 * @authors	John Shenk
 * 
 * @dateLastModified September 26, 2022
 */

package PopUps;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JSeparator;
import source.*;
public class AddRelationshipW {

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
		JFrame frame = new JFrame("JAMBL - Add Relationship");
		frame.setBounds(100, 100, 447, 300);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		JLabel lblAddClass = new JLabel("Enter the name for a new class to add.");
		lblAddClass.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAddClass.setBounds(10, 10, 338, 13);
		frame.getContentPane().add(lblAddClass);
		
		JLabel lblClassName = new JLabel("Choose a relationship type:");
		lblClassName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblClassName.setBounds(10, 33, 219, 51);
		frame.getContentPane().add(lblClassName);
		
		@SuppressWarnings("rawtypes")
		JComboBox relationships = new JComboBox();
		relationships.setModel(new DefaultComboBoxModel(new String[] {"Choose a relationship type:", "Aggregation", "Composition", "Ineritance", "Realization"}));
		relationships.setBounds(10, 74, 161, 21);
		frame.getContentPane().add(relationships);
		
		JLabel lblChoose = new JLabel("* Choose a relationship type.");
		lblChoose.setForeground(new Color(255, 0, 0));
		lblChoose.setBounds(181, 78, 167, 13);
		frame.getContentPane().add(lblChoose);
		lblChoose.setVisible(false);
		

		JLabel lblClass1 = new JLabel("Class 1:");
		lblClass1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblClass1.setBounds(10, 113, 73, 13);
		frame.getContentPane().add(lblClass1);
		
		JLabel lblClass2 = new JLabel("Class 2:");
		lblClass2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblClass2.setBounds(239, 114, 45, 13);
		frame.getContentPane().add(lblClass2);
		
		JComboBox comboBoxClass1 = new JComboBox();
		comboBoxClass1.setBounds(10, 137, 90, 21);
		frame.getContentPane().add(comboBoxClass1);
		comboBoxClass1.setModel(new DefaultComboBoxModel(new String[] {"Classes to be added!"}));
		
		JComboBox comboBoxClass2 = new JComboBox();
		comboBoxClass2.setBounds(239, 137, 90, 21);
		frame.getContentPane().add(comboBoxClass2);
		comboBoxClass2.setModel(new DefaultComboBoxModel(new String[] {"Classes to be added!"}));
		///////////////////////////
		//******* Buttons *******//
		///////////////////////////
		
		////////////////////////////////////////////////////////////// Add Class Button
		JButton btnAddRelationship = new JButton("Add Relationship");
		btnAddRelationship.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAddRelationship.setBounds(10, 217, 190, 21);
		frame.getContentPane().add(btnAddRelationship);
		btnAddRelationship.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(relationships.getSelectedItem().toString().equals("Choose a relationship type:"))
				{
					lblChoose.setVisible(true);
				}
				else
				{
					frame.dispose();
				}
			}
		});
		
		////////////////////////////////////////////////////////////// Cancel Button
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCancel.setBounds(233, 217, 190, 21);
		frame.getContentPane().add(btnCancel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(110, 147, 119, 2);
		frame.getContentPane().add(separator);
		
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		
		
		

	}
}
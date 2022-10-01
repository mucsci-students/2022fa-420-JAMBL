/*
 * @projectDescription The pup-up window for the " List Class " button
 * 
 * @authors	John Shenk
 * 
 * @dateLastModified September 26, 2022
 */

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ListAClassWindow {

	Controller controller;
	public ListAClassWindow(Controller newController) {
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
		JFrame frame = new JFrame("JAMBL - List a Class");
		frame.setBounds(100, 100, 450, 213);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);

		////////////////////////////
		///******* Labels *******///
		////////////////////////////
		
		JLabel lblListClass = new JLabel("Select the name of a class to list");
		lblListClass.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblListClass.setBounds(10, 10, 338, 13);
		frame.getContentPane().add(lblListClass);
	
		JLabel lblSelectClass = new JLabel("Select Class Name: ");
		lblSelectClass.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSelectClass.setBounds(10, 54, 137, 13);
		frame.getContentPane().add(lblSelectClass);

		///////////////////////////
		//******* Buttons *******//
		///////////////////////////
	
		////////////////////////////////////////////////////////////// List Class Button
		JButton btnListClass = new JButton("List Class");
		btnListClass.setForeground(new Color(0, 0, 0));
		btnListClass.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnListClass.setBounds(85, 136, 132, 21);
		frame.getContentPane().add(btnListClass);
		btnListClass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
	
		////////////////////////////////////////////////////////////// Cancel Button
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCancel.setBounds(227, 136, 132, 21);
		frame.getContentPane().add(btnCancel);
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		
		//////////////////////////////
		//******* Combo Boxes*******//
		//////////////////////////////
		
		@SuppressWarnings("rawtypes")
		JComboBox cbClasses = new JComboBox();
		cbClasses.setBounds(10, 77, 207, 21);
		frame.getContentPane().add(cbClasses);
	}
	
}

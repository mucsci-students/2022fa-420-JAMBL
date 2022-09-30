/*
 * @projectDescription The pup-up window for the " Rename Class " button
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

public class RenameClassW {

	Controller controller;
	private static JTextField textFieldClassName;
	public RenameClassW(Controller newController) {
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
		JFrame frame = new JFrame("JAMBL - Rename Class");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		////////////////////////////
		///******* Labels *******///
		////////////////////////////
		
		JLabel lblNewLabel = new JLabel("Select Class to Rename.");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(10, 10, 235, 23);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblClass = new JLabel("Class:");
		lblClass.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblClass.setBounds(10, 55, 45, 13);
		frame.getContentPane().add(lblClass);
		
		JLabel lblNewName = new JLabel("New Class Name:");
		lblNewName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewName.setBounds(10, 123, 133, 13);
		frame.getContentPane().add(lblNewName);
		lblNewName.setVisible(false);
		
		//////////////////////////////
		///******* Text Box *******///
		//////////////////////////////
		
		textFieldClassName = new JTextField();
		textFieldClassName.setBounds(10, 146, 178, 19);
		frame.getContentPane().add(textFieldClassName);
		textFieldClassName.setColumns(10);
		textFieldClassName.setVisible(false);
		
		/////////////////////////////
		///******* Buttons *******///
		/////////////////////////////
		
		JButton btnRenameClass = new JButton("Rename Class");
		btnRenameClass.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnRenameClass.setBounds(10, 206, 178, 21);
		frame.getContentPane().add(btnRenameClass);
		btnRenameClass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCancel.setBounds(248, 206, 178, 21);
		frame.getContentPane().add(btnCancel);
		frame.setVisible(true);
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		
		//////////////////////////////
		//******* Combo Boxes*******//
		//////////////////////////////
		
		JComboBox cbClasses = new JComboBox();
		cbClasses.setModel(new DefaultComboBoxModel(new String[] {"Choose a class:", "Class1"}));
		cbClasses.setBounds(10, 78, 111, 21);
		frame.getContentPane().add(cbClasses);
		cbClasses.addItemListener(new ItemListener() {
					public void itemStateChanged(ItemEvent arg0) {
						textFieldClassName.setVisible(true);
						lblNewName.setVisible(true);
					}
				});

		
	}
}
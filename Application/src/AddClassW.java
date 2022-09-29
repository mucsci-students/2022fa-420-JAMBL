/*
 * @projectDescription The pup-up window for the " Add Class " button
 * 
 * @authors	John Shenk
 * 
 * @dateLastModified September 26, 2022
 */





import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class AddClassW {
	
	public AddClassW() {
		
	}
	
	private static JTextField classNameBox;

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
		JFrame frame = new JFrame("JAMBL - Add Class");
		frame.setBounds(100, 100, 496, 225);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblAddClass = new JLabel("Enter the name for a new class to add.");
		lblAddClass.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAddClass.setBounds(10, 10, 338, 13);
		frame.getContentPane().add(lblAddClass);
		
		JLabel lblClassName = new JLabel("Class Name: ");
		lblClassName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblClassName.setBounds(27, 78, 87, 13);
		frame.getContentPane().add(lblClassName);
		
		classNameBox = new JTextField();
		lblClassName.setLabelFor(classNameBox);
		classNameBox.setBounds(121, 77, 227, 19);
		frame.getContentPane().add(classNameBox);
		classNameBox.setColumns(10);
		frame.setVisible(true);
		
		///////////////////////////
		//******* Buttons *******//
		///////////////////////////
		
		////////////////////////////////////////////////////////////// Add Class Button
		JButton btnAddClass = new JButton("Add Class");
		btnAddClass.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAddClass.setBounds(85, 136, 132, 21);
		frame.getContentPane().add(btnAddClass);
		btnAddClass.addActionListener(new ActionListener() {
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
		
		
	}
}

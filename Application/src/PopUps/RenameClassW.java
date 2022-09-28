/*
 * @projectDescription The pup-up window for the " Rename Class " button
 * 
 * @authors	John Shenk
 * 
 * @dateLastModified September 26, 2022
 */
package PopUps;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import source.*;
public class RenameClassW {
	private static JTextField textField;

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
		frame.setBounds(100, 100, 358, 300);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		JLabel lblAddClass = new JLabel("Select a class to rename.");
		lblAddClass.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAddClass.setBounds(10, 10, 338, 13);
		frame.getContentPane().add(lblAddClass);
		
		JLabel lblClassName = new JLabel("Class Name: ");
		lblClassName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblClassName.setBounds(27, 78, 87, 13);
		frame.getContentPane().add(lblClassName);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(27, 101, 114, 21);
		frame.getContentPane().add(comboBox);
		
		textField = new JTextField();
		textField.setBounds(151, 131, 178, 19);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("New Class Name:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(27, 132, 150, 13);
		frame.getContentPane().add(lblNewLabel);
		
		///////////////////////////
		//******* Buttons *******//
		///////////////////////////
		
		////////////////////////////////////////////////////////////// Rename Class Button
		JButton btnRenameClass = new JButton("Rename Class");
		btnRenameClass.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnRenameClass.setBounds(27, 212, 140, 21);
		frame.getContentPane().add(btnRenameClass);
		
		////////////////////////////////////////////////////////////// Cancel Button
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCancel.setBounds(177, 212, 140, 21);
		frame.getContentPane().add(btnCancel);
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		
		
	}

}
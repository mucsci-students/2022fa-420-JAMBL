/*
 * @projectDescription The pup-up window for the " Save " button
 * 
 * @authors	John Shenk
 * 
 * @dateLastModified September 26, 2022
 */

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class SaveWindow{

	Controller controller;
	private static JTextField txtDefaulttxt;
	public SaveWindow(Controller newController) {
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
		JFrame frame = new JFrame("JAMBL - Save");
		frame.setBounds(100, 100, 450, 243);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		////////////////////////////
		///******* Labels *******///
		////////////////////////////
		
		JLabel lblNewLabel = new JLabel("Enter a filename.");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(10, 10, 387, 19);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblFileName = new JLabel("File Name:");
		lblFileName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblFileName.setBounds(10, 95, 72, 13);
		frame.getContentPane().add(lblFileName);
		
		//////////////////////////////
		///******* Text Box *******///
		//////////////////////////////
		
		txtDefaulttxt = new JTextField();
		txtDefaulttxt.setText("DEFAULT.txt");
		txtDefaulttxt.setBounds(92, 94, 235, 19);
		frame.getContentPane().add(txtDefaulttxt);
		txtDefaulttxt.setColumns(10);

		///////////////////////////
		//******* Buttons *******//
		///////////////////////////
		
		JButton btnSave = new JButton("Save");
		btnSave.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSave.setBounds(92, 158, 85, 21);
		frame.getContentPane().add(btnSave);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCancel.setBounds(242, 158, 85, 21);
		frame.getContentPane().add(btnCancel);
		frame.setVisible(true);
	}

}
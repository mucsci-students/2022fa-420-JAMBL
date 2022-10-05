/*
 * @projectDescription The pup-up window for the " Load " button
 * 
 * @authors	John Shenk
 * 
 * @dateLastModified September 26, 2022
 */

import java.awt.Desktop;
import java.awt.Desktop.Action;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFileChooser;

public class LoadWindow {

	Controller controller;
	private static JTextField textField;
	public LoadWindow(Controller newController) {
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
		JFrame frame = new JFrame("JAMBL - Load");
		frame.setBounds(100, 100, 486, 182);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		

		////////////////////////////
		///******* Labels *******///
		////////////////////////////
		
		JLabel lblNewLabel = new JLabel("Select a File to Load:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(10, 31, 162, 13);
		frame.getContentPane().add(lblNewLabel);
		

		//////////////////////////////
		///******* Text Box *******///
		//////////////////////////////
		
		textField = new JTextField();
		textField.setBounds(10, 56, 318, 19);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		

		/////////////////////////////
		///******* Buttons *******///
		/////////////////////////////
		JButton btnBrowse = new JButton("Browse...");
		btnBrowse.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnBrowse.setBounds(341, 55, 104, 21);
		frame.getContentPane().add(btnBrowse);
		//Create a file chooser
		final JFileChooser fc = new JFileChooser();
		btnBrowse.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						//In response to a button click:
						int returnVal = fc.showOpenDialog(null);
						
						if (returnVal == JFileChooser.APPROVE_OPTION) {
				            File file = fc.getSelectedFile();
				            textField.setText(file.getAbsolutePath()); 
						}
					}
			});
				
		JButton btnLoad = new JButton("Load");
		btnLoad.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnLoad.setBounds(113, 114, 85, 21);
		frame.getContentPane().add(btnLoad);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCancel.setBounds(243, 114, 85, 21);
		frame.getContentPane().add(btnCancel);
		

	}

}

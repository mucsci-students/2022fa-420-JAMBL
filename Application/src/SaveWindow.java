/*
 * @projectDescription The pup-up window for the " Save " button
 * 
 * @authors	John Shenk
 * 
 * @dateLastModified September 26, 2022
 */

import java.awt.EventQueue;

import javax.swing.JFrame;

public class SaveWindow{

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
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
	}

}
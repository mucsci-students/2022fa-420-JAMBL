import java.awt.EventQueue;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class GUIMain {

	private JFrame frmJambl;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIMain window = new GUIMain();
					window.frmJambl.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUIMain() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		//******** MAIN PAGE ********//
		frmJambl = new JFrame();
		frmJambl.setTitle("JAMBL");
		frmJambl.setBounds(100, 100, 935, 752);
		frmJambl.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmJambl.getContentPane().setLayout(null);
		
		JTextArea textAreaMain = new JTextArea();
		textAreaMain.setEditable(false);
		textAreaMain.setBounds(234, 10, 675, 693);
		frmJambl.getContentPane().add(textAreaMain);
		
		JLabel ClassLabel = new JLabel("Class");
		ClassLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		ClassLabel.setBounds(10, 68, 214, 13);
		frmJambl.getContentPane().add(ClassLabel);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 91, 187, 2);
		frmJambl.getContentPane().add(separator_1);
		
		JLabel lblRelationships = new JLabel("Relationships");
		lblRelationships.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblRelationships.setBounds(10, 196, 214, 13);
		frmJambl.getContentPane().add(lblRelationships);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(10, 219, 187, 2);
		frmJambl.getContentPane().add(separator_2);
		
		JLabel lblNewLabel = new JLabel("Under Construction!");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(10, 16, 187, 13);
		frmJambl.getContentPane().add(lblNewLabel);
		
		JLabel lblSaveload = new JLabel("Save/Load");
		lblSaveload.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSaveload.setBounds(10, 295, 214, 13);
		frmJambl.getContentPane().add(lblSaveload);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(10, 358, 187, 2);
		frmJambl.getContentPane().add(separator_4);
		
		JButton btnAddClass = new JButton("Add Class");
		btnAddClass.setBounds(10, 103, 97, 21);
		frmJambl.getContentPane().add(btnAddClass);
		
		btnAddClass.addActionListener(new ActionListener() {
			@SuppressWarnings("static-access")
			@Override
			public void actionPerformed(ActionEvent e) {
				addClass addCl = new addClass();
				addCl.initialize();
			}
		});
		
		JButton btnRenameClass = new JButton("Rename Class");
		btnRenameClass.setBounds(10, 134, 97, 21);
		frmJambl.getContentPane().add(btnRenameClass);
		
		JButton btnDeleteClass = new JButton("Delete Class");
		btnDeleteClass.setBounds(10, 165, 97, 21);
		frmJambl.getContentPane().add(btnDeleteClass);
		
		JButton btnAddRelationship = new JButton("Add Relationship");
		btnAddRelationship.setBounds(10, 231, 187, 21);
		frmJambl.getContentPane().add(btnAddRelationship);
		
		JButton btnNewButton_4 = new JButton("Delete Relationship");
		btnNewButton_4.setBounds(10, 262, 187, 21);
		frmJambl.getContentPane().add(btnNewButton_4);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSave.setBounds(10, 372, 85, 21);
		frmJambl.getContentPane().add(btnSave);
		
		JButton btnLoad = new JButton("Load");
		btnLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLoad.setBounds(10, 405, 85, 21);
		frmJambl.getContentPane().add(btnLoad);
		
		JButton btnListAll = new JButton("List All");
		btnListAll.setBounds(10, 486, 137, 21);
		frmJambl.getContentPane().add(btnListAll);
		
		JButton btnListRelationships = new JButton("List Relationships");
		btnListRelationships.setBounds(10, 519, 137, 21);
		frmJambl.getContentPane().add(btnListRelationships);
		
		JButton btnListClass = new JButton("List a Class");
		btnListClass.setBounds(10, 453, 137, 21);
		frmJambl.getContentPane().add(btnListClass);
	
		
		//******** MAIN PAGE ********//
		
		
	}
	

}

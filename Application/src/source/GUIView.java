package source;
/*
 * @projectDescription The main "page" for the JAMBL application
 * 
 * @authors	John Shenk
 * 
 * @dateLastModified September 26, 2022
 */

import java.awt.EventQueue;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

// Custom java package containing the pop-up windows
import PopUps.*;

public class GUIView extends View {

	Model model = new Model();
	private Controller GUICntrlr = new Controller(model, this);

	private JFrame frmJambl;
	// A boolean signifying if the recent UML diagram has been saved.
	// If not, a pop-up message will appear upon clicking the x button
	// asking the user if they would like to save before closing
	private boolean saved = false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIView window = new GUIView();
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
	public GUIView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		// ******** MAIN PAGE ********//
		frmJambl = new JFrame();
		frmJambl.setTitle("JAMBL");
		frmJambl.setBounds(100, 100, 1063, 752);
		frmJambl.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmJambl.getContentPane().setLayout(null);

		/////////////////////////////////////////// textAreaMain - where the UML diagram
		/////////////////////////////////////////// will be able displayed and updated
		/////////////////////////////////////////// in real time
		/////////////////////////////////////////// as classes, field, methods, and
		/////////////////////////////////////////// relationships are added
		JTextArea textAreaMain = new JTextArea();
		textAreaMain.setEditable(false);
		textAreaMain.setBounds(359, 67, 678, 635);
		frmJambl.getContentPane().add(textAreaMain);

		JLabel ClassLabel = new JLabel("Class");
		ClassLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		ClassLabel.setBounds(10, 68, 214, 13);
		frmJambl.getContentPane().add(ClassLabel);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 91, 106, 2);
		frmJambl.getContentPane().add(separator_1);

		JLabel lblRelationships = new JLabel("Relationships");
		lblRelationships.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblRelationships.setBounds(220, 68, 214, 13);
		frmJambl.getContentPane().add(lblRelationships);

		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(220, 93, 97, 2);
		frmJambl.getContentPane().add(separator_2);

		/****** TEMPORARY WHILE WHILE WE FIGURE OUT WHAT TO PUT HERE *******/
		JLabel lblNewLabel = new JLabel("Under Construction!");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(10, 16, 187, 13);
		frmJambl.getContentPane().add(lblNewLabel);

		JLabel lblSaveload = new JLabel("Save/Load");
		lblSaveload.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSaveload.setBounds(10, 373, 214, 13);
		frmJambl.getContentPane().add(lblSaveload);

		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(10, 398, 106, 2);
		frmJambl.getContentPane().add(separator_4);

		JLabel lblNewLabel_1 = new JLabel("Parameters");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(10, 217, 90, 16);
		frmJambl.getContentPane().add(lblNewLabel_1);

		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBounds(10, 245, 106, 2);
		frmJambl.getContentPane().add(separator_1_1);

		JLabel lblMethods = new JLabel("Methods");
		lblMethods.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMethods.setBounds(220, 218, 214, 13);
		frmJambl.getContentPane().add(lblMethods);

		JSeparator separator_1_1_1 = new JSeparator();
		separator_1_1_1.setBounds(220, 245, 106, 2);
		frmJambl.getContentPane().add(separator_1_1_1);

		JLabel lblFields = new JLabel("Fields");
		lblFields.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblFields.setBounds(220, 398, 214, 13);
		frmJambl.getContentPane().add(lblFields);

		JSeparator separator_4_1 = new JSeparator();
		separator_4_1.setBounds(220, 423, 106, 2);
		frmJambl.getContentPane().add(separator_4_1);

		///////////////////////////
		// ******* Buttons *******//
		///////////////////////////

		////////////////////////////////////////////////////////////// Add Class Button
		JButton btnAddClass = new JButton("Add");
		btnAddClass.setBounds(10, 103, 97, 21);
		frmJambl.getContentPane().add(btnAddClass);
		btnAddClass.addActionListener(new ActionListener() {
			@SuppressWarnings("static-access")
			@Override
			public void actionPerformed(ActionEvent e) {
				AddClassW addCl = new AddClassW();
				addCl.initialize();
				saved = false;
			}
		});

		////////////////////////////////////////////////////////////// Rename Class
		////////////////////////////////////////////////////////////// Button
		JButton btnRenameClass = new JButton("Rename");
		btnRenameClass.setBounds(10, 134, 97, 21);
		frmJambl.getContentPane().add(btnRenameClass);
		btnRenameClass.addActionListener(new ActionListener() {
			@SuppressWarnings("static-access")
			@Override
			public void actionPerformed(ActionEvent e) {
				RenameClassW renameCl = new RenameClassW();
				renameCl.initialize();
				saved = false;
			}
		});

		////////////////////////////////////////////////////////////// Delete Class
		////////////////////////////////////////////////////////////// Button
		JButton btnDeleteClass = new JButton("Delete");
		btnDeleteClass.setBounds(10, 165, 97, 21);
		frmJambl.getContentPane().add(btnDeleteClass);
		btnDeleteClass.addActionListener(new ActionListener() {
			@SuppressWarnings("static-access")
			@Override
			public void actionPerformed(ActionEvent e) {
				DeleteClassW deleteCl = new DeleteClassW();
				deleteCl.initialize();
				saved = false;
			}
		});

		////////////////////////////////////////////////////////////// Add Relationship
		////////////////////////////////////////////////////////////// Button
		JButton btnAddRelationship = new JButton("Add");
		btnAddRelationship.setBounds(220, 105, 97, 21);
		frmJambl.getContentPane().add(btnAddRelationship);
		btnAddRelationship.addActionListener(new ActionListener() {
			@SuppressWarnings("static-access")
			@Override
			public void actionPerformed(ActionEvent e) {
				AddRelationshipW addRel = new AddRelationshipW();
				addRel.initialize();
				saved = false;
			}
		});

		////////////////////////////////////////////////////////////// Delete
		////////////////////////////////////////////////////////////// Relationship
		////////////////////////////////////////////////////////////// Button
		JButton btnDeleteRel = new JButton("Delete");
		btnDeleteRel.setBounds(220, 136, 97, 21);
		frmJambl.getContentPane().add(btnDeleteRel);
		btnDeleteRel.addActionListener(new ActionListener() {
			@SuppressWarnings("static-access")
			@Override
			public void actionPerformed(ActionEvent e) {
				DeleteRelationshipW deleteRel = new DeleteRelationshipW();
				deleteRel.initialize();
				saved = false;
			}
		});

		////////////////////////////////////////////////////////////// Save Button
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			@SuppressWarnings("static-access")
			@Override
			public void actionPerformed(ActionEvent e) {
				SaveWindow saveW = new SaveWindow();
				saveW.initialize();
				saved = true;
			}
		});
		btnSave.setBounds(10, 412, 85, 21);
		frmJambl.getContentPane().add(btnSave);

		////////////////////////////////////////////////////////////// Load Button
		JButton btnLoad = new JButton("Load");
		btnLoad.setBounds(10, 445, 85, 21);
		frmJambl.getContentPane().add(btnLoad);
		btnLoad.addActionListener(new ActionListener() {
			@SuppressWarnings("static-access")
			@Override
			public void actionPerformed(ActionEvent e) {
				LoadWindow loadW = new LoadWindow();
				loadW.initialize();
			}
		});

		////////////////////////////////////////////////////////////// List All Button -
		////////////////////////////////////////////////////////////// displays entire
		////////////////////////////////////////////////////////////// UML diagram
		JButton btnListAll = new JButton("List All");
		btnListAll.setBounds(10, 649, 137, 21);
		frmJambl.getContentPane().add(btnListAll);
		btnListAll.addActionListener(new ActionListener() {
			@SuppressWarnings("static-access")
			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});

		////////////////////////////////////////////////////////////// List
		////////////////////////////////////////////////////////////// Relationships
		////////////////////////////////////////////////////////////// Button - displays
		////////////////////////////////////////////////////////////// list of
		////////////////////////////////////////////////////////////// relationships
		JButton btnListRelationships = new JButton("List Relationships");
		btnListRelationships.setBounds(10, 682, 137, 21);
		frmJambl.getContentPane().add(btnListRelationships);
		btnListRelationships.addActionListener(new ActionListener() {
			@SuppressWarnings("static-access")
			@Override
			public void actionPerformed(ActionEvent e) {
				textAreaMain.insert("Test", 0);
			}
		});

		////////////////////////////////////////////////////////////// List a class
		////////////////////////////////////////////////////////////// button - displays
		////////////////////////////////////////////////////////////// a singular class
		////////////////////////////////////////////////////////////// of a specified
		////////////////////////////////////////////////////////////// name
		JButton btnListClass = new JButton("List a Class");
		btnListClass.setBounds(10, 616, 137, 21);
		frmJambl.getContentPane().add(btnListClass);
		btnListClass.addActionListener(new ActionListener() {
			@SuppressWarnings("static-access")
			@Override
			public void actionPerformed(ActionEvent e) {
				ListAClassWindow listCl = new ListAClassWindow();
				listCl.initialize();
			}
		});

		////////////////////////////////////////////////////////////// Add Parameter
		////////////////////////////////////////////////////////////// Button
		JButton btnAddParameter = new JButton("Add");
		btnAddParameter.setBounds(10, 259, 97, 21);
		frmJambl.getContentPane().add(btnAddParameter);

		////////////////////////////////////////////////////////////// Remove Parameter
		////////////////////////////////////////////////////////////// Button
		JButton btnDeleteParameter = new JButton("Remove");
		btnDeleteParameter.setBounds(10, 292, 97, 21);
		frmJambl.getContentPane().add(btnDeleteParameter);

		////////////////////////////////////////////////////////////// Change Parameter
		////////////////////////////////////////////////////////////// Button
		JButton btnChangeParameter = new JButton("Change");
		btnChangeParameter.setBounds(10, 325, 97, 21);
		frmJambl.getContentPane().add(btnChangeParameter);

		////////////////////////////////////////////////////////////// Add Method Button
		JButton btnAddMethod = new JButton("Add");
		btnAddMethod.setBounds(220, 256, 97, 21);
		frmJambl.getContentPane().add(btnAddMethod);
		btnAddMethod.addActionListener(new ActionListener() {
			@SuppressWarnings("static-access")
			public void actionPerformed(ActionEvent e) {
				AddMethodW addMethodWindow = new AddMethodW();
				addMethodWindow.initialize();
			}
		});

		////////////////////////////////////////////////////////////// Change Method
		////////////////////////////////////////////////////////////// Button
		JButton btnRefactor = new JButton("Change");
		btnRefactor.setBounds(220, 289, 97, 21);
		frmJambl.getContentPane().add(btnRefactor);

		////////////////////////////////////////////////////////////// Delete Method
		////////////////////////////////////////////////////////////// Button
		JButton btnDeleteMethod = new JButton("Delete");
		btnDeleteMethod.setBounds(220, 355, 97, 21);
		frmJambl.getContentPane().add(btnDeleteMethod);
		btnDeleteMethod.addActionListener(new ActionListener() {
			@SuppressWarnings("static-access")
			public void actionPerformed(ActionEvent e) {
				DeleteMethodW deleteMethodWindow = new DeleteMethodW();
				deleteMethodWindow.initialize();
			}
		});

		////////////////////////////////////////////////////////////// Rename Method
		////////////////////////////////////////////////////////////// Button
		JButton btnRenameMethod = new JButton("Rename");
		btnRenameMethod.setBounds(220, 322, 97, 21);
		frmJambl.getContentPane().add(btnRenameMethod);
		btnRenameMethod.addActionListener(new ActionListener() {
			@SuppressWarnings("static-access")
			public void actionPerformed(ActionEvent e) {
				RenameMethodW rnmMthd = new RenameMethodW();
				rnmMthd.initialize();
			}
		});

		////////////////////////////////////////////////////////////// Add Field Button
		JButton btnAddField = new JButton("Add");
		btnAddField.setBounds(220, 437, 97, 21);
		frmJambl.getContentPane().add(btnAddField);
		btnAddField.addActionListener(new ActionListener() {
			@SuppressWarnings("static-access")
			public void actionPerformed(ActionEvent e) {
				AddFieldW addFld = new AddFieldW();
				addFld.initialize();
			}
		});

		////////////////////////////////////////////////////////////// Change Field Type
		////////////////////////////////////////////////////////////// Button
		JButton btnChangeFieldType = new JButton("Edit Type");
		btnChangeFieldType.setBounds(220, 470, 97, 21);
		frmJambl.getContentPane().add(btnChangeFieldType);

		////////////////////////////////////////////////////////////// Delete Field
		////////////////////////////////////////////////////////////// Button
		JButton btnDeleteField = new JButton("Delete");
		btnDeleteField.setBounds(220, 536, 97, 21);
		frmJambl.getContentPane().add(btnDeleteField);

		////////////////////////////////////////////////////////////// Rename Field
		////////////////////////////////////////////////////////////// Button
		JButton btnRenameField = new JButton("Rename");
		btnRenameField.setBounds(220, 503, 97, 21);
		frmJambl.getContentPane().add(btnRenameField);
		btnRenameField.addActionListener(new ActionListener() {
			@SuppressWarnings("static-access")
			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});

		frmJambl.addWindowListener(new WindowAdapter() {
			@SuppressWarnings("static-access")
			@Override
			public void windowClosing(WindowEvent windowEvent) {
				SaveAssuranceW savedCheck = new SaveAssuranceW();
				savedCheck.initialize();
			}
		});
	}

	public void updateTextAreaMain() {

	}
}

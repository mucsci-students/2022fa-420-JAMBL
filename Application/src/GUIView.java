/*
 * @projectDescription The main "page" for the JAMBL application
 * 
 * @authors	John Shenk
 * 
 * @dateLastModified September 26, 2022
 */


import java.awt.EventQueue;

import javax.swing.*;
//import java.awt.BorderLayout;
import java.awt.Color;
//import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
//import java.awt.event.WindowListener;
import java.io.File;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class GUIView extends View  {
	
	// Basic frame for small pop-ups
	JFrame f=new JFrame(); 
	
	private JFrame frmJambl;
	// A boolean signifying if the recent UML diagram has been saved. 
	// If not, a pop-up message will appear upon clicking the x button
	//     asking the user if they would like to save before closing
	boolean saved = false;
	String cls;

	// main window buttons
	
	JButton btnAddClass = new JButton("Add");
	JButton btnRenameClass = new JButton("Rename"); 
	JButton btnDeleteClass = new JButton("Delete");
	JButton btnAddRelationship = new JButton("Add");
	JButton btnDeleteRel = new JButton("Delete");
	JButton btnChangeType = new JButton("Change Type");
	JButton btnSave = new JButton("Save");
	JButton btnLoad = new JButton("Load");
	JButton btnListAll = new JButton("List All");
	JButton btnListRelationships = new JButton("List Relationships");
	JButton btnListClass = new JButton("List a Class");
	JButton btnAddParameter = new JButton("Add");
	JButton btnDeleteParameter = new JButton("Remove");
	JButton btnChangeParameter = new JButton("Change");
	JButton btnAddMethod = new JButton("Add");
	JButton btnRefactor = new JButton("Change Type");
	JButton btnDeleteMethod = new JButton("Delete");
	JButton btnRenameMethod = new JButton("Rename");
	JButton btnAddField = new JButton("Add");
	JButton btnChangeFieldType = new JButton("Edit Type");
	JButton btnDeleteField = new JButton("Delete");
	JButton btnRenameField = new JButton("Rename");

	// Secondary Window buttons
	JButton btnCancel;
	JComboBox<Object> cbClasses;
	JTextField textFieldClassName;
	JTextField classNameBox;
	JTextArea textAreaMain;



	/**
	 * Launch the application.
	 */
		

	public GUIView() {
		initialize();
	}

	public void setVisible(){
		frmJambl.setVisible(true);
	}

	public JTextArea getMainArea(){
		return textAreaMain;
	}

	// how controller access buttons
	
	public JButton loadButton(){
		return btnLoad;
	}

	public JButton addClassBtn(){
		return btnAddClass;
	}

	public JButton delClassBtn(){
		return btnDeleteClass;
	}

	public JButton renClassBtn(){
		return btnRenameClass;
	}

	public JButton addRelBtn(){
		return btnAddRelationship;
	}

	public JButton delRelBtn(){
		return btnDeleteRel;
	}

	public JButton chgRelBtn(){
		return btnChangeType;
	}

	public JButton listAllBtn(){
		return btnListAll;
	}

	// how controller access textbox
	public JTextField  getTextBox(){
		return classNameBox;
	}


	// Windows of actions

	public JFrame addingClassWindow(){
		JFrame frame = new JFrame("JAMBL - Add Class");
				frame.setBounds(100, 100, 496, 225);
				frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				frame.getContentPane().setLayout(null);
				frame.setVisible(true);
				

				////////////////////////////
				///******* Labels *******///
				////////////////////////////

				JLabel lblAddClass = new JLabel("Enter the name for a new class to add.");
				lblAddClass.setFont(new Font("Tahoma", Font.PLAIN, 18));
				lblAddClass.setBounds(10, 10, 338, 13);
				frame.getContentPane().add(lblAddClass);
				
				JLabel lblClassName = new JLabel("Class Name: ");
				lblClassName.setFont(new Font("Tahoma", Font.PLAIN, 15));
				lblClassName.setBounds(27, 78, 87, 13);
				frame.getContentPane().add(lblClassName);
				
				/////////////////////////////
				///******* TextBox *******///
				/////////////////////////////
				
				classNameBox = new JTextField();
				lblClassName.setLabelFor(classNameBox);
				classNameBox.setBounds(121, 77, 227, 19);
				frame.getContentPane().add(classNameBox);
				classNameBox.setColumns(10);
				
				
				///////////////////////////
				//******* Buttons *******//
				///////////////////////////
				
				//// Add Class Button
			    btnAddClass = new JButton("Add Class");
				btnAddClass.setFont(new Font("Tahoma", Font.PLAIN, 15));
				btnAddClass.setBounds(85, 136, 132, 21);
				frame.getContentPane().add(btnAddClass);
				btnAddClass.setName("AddClass");

				
				//// Cancel Button
				btnCancel = new JButton("Cancel");
				btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 15));
				btnCancel.setBounds(227, 136, 132, 21);
				frame.getContentPane().add(btnCancel);
				
				saved = false;
				return frame;
	}




	JLabel lblNewLabel = new JLabel("Select Class to Rename.");
	JLabel lblClass = new JLabel("Class:");
	JLabel lblNewName = new JLabel("New Class Name:");


	// Window for renaming
	public JFrame renamingClassWindow(){
		JFrame frame = new JFrame("JAMBL - Rename Class");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		////////////////////////////
		///******* Labels *******///
		////////////////////////////
		
		
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(10, 10, 235, 23);
		frame.getContentPane().add(lblNewLabel);
		
		
		lblClass.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblClass.setBounds(10, 55, 45, 13);
		frame.getContentPane().add(lblClass);
		
		
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
		
		//////////////////////////////
		//******* Combo Boxes*******//
		//////////////////////////////
		cbClasses = new JComboBox<Object>();
		cbClasses.setModel(new DefaultComboBoxModel<Object>());
		cbClasses.setBounds(10, 78, 111, 21);
		frame.getContentPane().add(cbClasses);
	
		
		/////////////////////////////
		///******* Buttons *******///
		/////////////////////////////
		
		btnRenameClass = new JButton("Rename Class");
		btnRenameClass.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnRenameClass.setBounds(10, 206, 178, 21);
		frame.getContentPane().add(btnRenameClass);
		
		btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCancel.setBounds(248, 206, 178, 21);
		frame.getContentPane().add(btnCancel);
		frame.setVisible(true);

		return frame;
	}

	

	JFrame frame;
	JLabel lblDeleteClass;
	JLabel lblSelectClass;
	JComboBox<Object> comboBoxClasses;
	
	public JFrame deletingClassWindow(){
		frame = new JFrame("JAMBL - Delete Class");
		frame.setBounds(100, 100, 450, 203);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
	

		lblDeleteClass = new JLabel("Select the name of a class to delete");
		lblDeleteClass.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDeleteClass.setBounds(10, 10, 338, 13);
		frame.getContentPane().add(lblDeleteClass);
		
		lblSelectClass = new JLabel("Select Class Name: ");
		lblSelectClass.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSelectClass.setBounds(10, 54, 137, 13);
		frame.getContentPane().add(lblSelectClass);
	
		//////////////////////////////
		//******* Combo Boxes*******//
		//////////////////////////////
		
		
		comboBoxClasses = new JComboBox<Object>();
		comboBoxClasses.setBounds(10, 77, 207, 21);
		frame.getContentPane().add(comboBoxClasses);
		
		
		///////////////////////////
		//******* Buttons *******//
		///////////////////////////
		
		////////////////////////////////////////////////////////////// Delete Class Button
		btnDeleteClass = new JButton("Delete Class");
		btnDeleteClass.setForeground(new Color(255, 0, 0));
		btnDeleteClass.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnDeleteClass.setBounds(85, 136, 132, 21);
		frame.getContentPane().add(btnDeleteClass);

		////////////////////////////////////////////////////////////// Cancel Button
		btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCancel.setBounds(227, 136, 132, 21);
		frame.getContentPane().add(btnCancel);
					
							
				
		
		return frame;
	}


	JComboBox<Object> comboBoxClass1;
	JComboBox<Object> comboBoxClass2;
	JComboBox<Object> cbRelationships;
	JLabel lblClass1;
	JLabel lblClass2;
	
	public JFrame addingRelsWindow(){
		JFrame frame = new JFrame("JAMBL - Add Relationship");
		frame.setBounds(100, 100, 447, 300);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(110, 147, 119, 2);
		frame.getContentPane().add(separator);
		
		JLabel lblAddClass = new JLabel("Choose a relationship type and classes");
		lblAddClass.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAddClass.setBounds(10, 10, 338, 13);
		frame.getContentPane().add(lblAddClass);
		
		JLabel lblRelationshipType = new JLabel("Choose a relationship type:");
		lblRelationshipType.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblRelationshipType.setBounds(10, 33, 219, 51);
		frame.getContentPane().add(lblRelationshipType);
		
		JLabel lblChoose = new JLabel("* Choose a relationship type.");
		lblChoose.setForeground(new Color(255, 0, 0));
		lblChoose.setBounds(181, 78, 167, 13);
		frame.getContentPane().add(lblChoose);
		lblChoose.setVisible(false);
		
		lblClass1 = new JLabel("Class 1:");
		lblClass1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblClass1.setBounds(10, 113, 73, 13);
		frame.getContentPane().add(lblClass1);
		lblClass1.setVisible(false);
		
		lblClass2 = new JLabel("Class 2:");
		lblClass2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblClass2.setBounds(239, 114, 45, 13);
		frame.getContentPane().add(lblClass2);
		lblClass2.setVisible(false);

		//////////////////////////////
		//******* Combo Boxes*******//
		//////////////////////////////
		
		comboBoxClass1 = new JComboBox<Object>();
		comboBoxClass1.setBounds(10, 137, 90, 21);
		frame.getContentPane().add(comboBoxClass1);
		comboBoxClass1.setVisible(false);
		
		comboBoxClass2 = new JComboBox<Object>();
		comboBoxClass2.setBounds(239, 137, 90, 21);
		frame.getContentPane().add(comboBoxClass2);
		comboBoxClass2.setVisible(false);
		
		
		cbRelationships = new JComboBox<Object>();
		cbRelationships.setModel(new DefaultComboBoxModel<Object>(new String[] {"Choose a relationship type:", "Aggregation", "Composition", "Inheritance", "Realization"}));
		cbRelationships.setBounds(10, 74, 161, 21);
		frame.getContentPane().add(cbRelationships);

		///////////////////////////
		//******* Buttons *******//
		///////////////////////////
		
		// Add Relationship Button
		btnAddRelationship = new JButton("Add Relationship");
		btnAddRelationship.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAddRelationship.setBounds(10, 217, 190, 21);
		frame.getContentPane().add(btnAddRelationship);

		// Cancel Button
		btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCancel.setBounds(233, 217, 190, 21);
		frame.getContentPane().add(btnCancel);
		return frame;

	}


	JComboBox<Object> cdClass2;
	JComboBox<Object> cbClass1;
	JButton btnDeleteRelationship;

	public JFrame deletingRelsWindow(){
		JFrame frame = new JFrame("JAMBL - Delete Relationship");
				frame.setBounds(100, 100, 450, 243);
				frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				frame.getContentPane().setLayout(null);
				
				////////////////////////////
				///******* Labels *******///
				////////////////////////////
				
				JLabel lblClassChoose = new JLabel("Select a class and the class in relationship to delete.");
				lblClassChoose.setFont(new Font("Tahoma", Font.PLAIN, 14));
				lblClassChoose.setBounds(10, 20, 416, 13);
				frame.getContentPane().add(lblClassChoose);
				
				lblClass1 = new JLabel("Class Name:");
				lblClass1.setFont(new Font("Tahoma", Font.PLAIN, 15));
				lblClass1.setBounds(10, 54, 134, 13);
				frame.getContentPane().add(lblClass1);
				
				lblClass2 = new JLabel("Class with relationship to delete:");
				lblClass2.setFont(new Font("Tahoma", Font.PLAIN, 15));
				lblClass2.setBounds(10, 108, 255, 13);
				frame.getContentPane().add(lblClass2);
				lblClass2.setVisible(false);

				///////////////////////////////
				//******* Combo Boxes *******//
				///////////////////////////////

				cdClass2 = new JComboBox<Object>();
				cdClass2.setBounds(10, 131, 134, 21);
				frame.getContentPane().add(cdClass2);
				cdClass2.setVisible(false);
				
				cbClass1 = new JComboBox<Object>();
				cbClass1.setBounds(10, 77, 134, 21);
				frame.getContentPane().add(cbClass1);

				///////////////////////////
				//******* Buttons *******//
				///////////////////////////

				btnDeleteRelationship = new JButton("Delete Relationship");
				btnDeleteRelationship.setFont(new Font("Tahoma", Font.PLAIN, 15));
				btnDeleteRelationship.setBounds(10, 172, 186, 21);
				frame.getContentPane().add(btnDeleteRelationship);

				btnCancel = new JButton("Cancel");
				btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 15));
				btnCancel.setBounds(240, 172, 186, 21);
				frame.getContentPane().add(btnCancel);
				frame.setVisible(true);
				return frame;
	}

	JLabel lblRelationship;
	JComboBox<Object> cbClass2;
	JButton bteditRelType;
	JFrame frmJamblChange;

	public JFrame changingRelsWindow(){
		frmJamblChange = new JFrame("JAMBL - Change Relationship Type");
		frmJamblChange.setTitle("JAMBL - Change Relationship Type");
		frmJamblChange.setBounds(100, 100, 450, 332);
		frmJamblChange.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frmJamblChange.getContentPane().setLayout(null);
		
		////////////////////////////
		///******* Labels *******///
		////////////////////////////
		
		JLabel lblNewLabel = new JLabel("Select Classes to change relationship type of.");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(10, 10, 235, 23);
		frmJamblChange.getContentPane().add(lblNewLabel);
		
		lblClass1 = new JLabel("Class 1:");
		lblClass1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblClass1.setBounds(10, 55, 63, 13);
		frmJamblChange.getContentPane().add(lblClass1);
		
		lblRelationship = new JLabel("New Relationship Type:");
		lblRelationship.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblRelationship.setBounds(10, 171, 168, 13);
		frmJamblChange.getContentPane().add(lblRelationship);
		lblRelationship.setVisible(false);
		
		lblClass2 = new JLabel("Class 2:");
		lblClass2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblClass2.setBounds(10, 109, 63, 13);
		frmJamblChange.getContentPane().add(lblClass2);
		lblClass2.setVisible(false);

		//////////////////////////////
		//******* Combo Boxes*******//
		//////////////////////////////
			
		cbRelationships = new JComboBox<Object>();
		cbRelationships.setModel(new DefaultComboBoxModel<Object>(new String[] {"Choose a relationship type:", "Aggregation", 
				"Realization", "Inheritance", "Composition"}));
		cbRelationships.setBounds(10, 194, 111, 21);
		frmJamblChange.getContentPane().add(cbRelationships);
		cbRelationships.setVisible(false);
		
		cbClass2 = new JComboBox<Object>();
		cbClass2.setBounds(10, 131, 111, 21);
		frmJamblChange.getContentPane().add(cbClass2);
		cbClass2.setVisible(false);
		cbClass2.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				cbRelationships.setVisible(true);
				lblRelationship.setVisible(true);
			}
		});
		cbClass1 = new JComboBox<Object>();
		cbClass1.setBounds(10, 78, 111, 21);
		frmJamblChange.getContentPane().add(cbClass1);

		/////////////////////////////
		///******* Buttons *******///
		/////////////////////////////
		

		bteditRelType = new JButton("Change Type");
		bteditRelType.setFont(new Font("Tahoma", Font.PLAIN, 15));
		bteditRelType.setBounds(10, 249, 178, 21);
		frmJamblChange.getContentPane().add(bteditRelType);

		btnCancel = new JButton("Cancel");
				btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 15));
				btnCancel.setBounds(248, 249, 178, 21);
				frmJamblChange.getContentPane().add(btnCancel);
				frmJamblChange.setVisible(true);



		return frmJamblChange;
	}


	JTextField methodNameBox;
	JTextField methodTypeBox;
	JLabel lblMethodName;
	JLabel lblMethodType;
	JFrame frmJamblAdd;
	public JFrame addingMethodWindow(){
		frmJamblAdd = new JFrame("JAMBL - Add Class");
		frmJamblAdd.setTitle("JAMBL - Add Method");
		frmJamblAdd.setBounds(100, 100, 576, 225);
		frmJamblAdd.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frmJamblAdd.getContentPane().setLayout(null);
		
		////////////////////////////
		///******* Labels *******///
		////////////////////////////
		
		JLabel lblAddMethod = new JLabel("Enter the name and type for a method to add and select a class");
		lblAddMethod.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddMethod.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAddMethod.setBounds(10, 10, 542, 29);
		frmJamblAdd.getContentPane().add(lblAddMethod);
		
		lblMethodName = new JLabel("Method Name");
		lblMethodName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMethodName.setBounds(27, 78, 106, 18);
		frmJamblAdd.getContentPane().add(lblMethodName);
		lblMethodName.setVisible(false);
		
		JLabel lblClass = new JLabel("Class:");
		lblClass.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblClass.setBounds(30, 49, 45, 13);
		frmJamblAdd.getContentPane().add(lblClass);
		
		lblMethodType = new JLabel("Method Type:");
		lblMethodType.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMethodType.setBounds(27, 101, 106, 19);
		frmJamblAdd.getContentPane().add(lblMethodType);
		lblMethodType.setVisible(false);
		
		////////////////////////////////
		///******* Text Boxes *******///
		////////////////////////////////
		
		methodNameBox = new JTextField();
		methodNameBox.setBounds(132, 80, 227, 19);
		frmJamblAdd.getContentPane().add(methodNameBox);
		methodNameBox.setColumns(10);
		frmJamblAdd.setVisible(true);
		methodNameBox.setVisible(false);
		
		methodTypeBox = new JTextField();
		methodTypeBox.setColumns(10);
		methodTypeBox.setBounds(132, 103, 227, 19);
		frmJamblAdd.getContentPane().add(methodTypeBox);
		methodTypeBox.setVisible(false);  

		//////////////////////////////
		//******* Combo Boxes*******//
		//////////////////////////////

		comboBoxClasses = new JComboBox<Object>();
		comboBoxClasses.setBounds(85, 47, 132, 21);
		frmJamblAdd.getContentPane().add(comboBoxClasses);

		
		///////////////////////////
		//******* Buttons *******//
		///////////////////////////
		
		// Add Method Button
		btnAddMethod = new JButton("Add Method");
		btnAddMethod.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAddMethod.setBounds(85, 136, 132, 21);
		frmJamblAdd.getContentPane().add(btnAddMethod);

		// Cancel Button
		btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCancel.setBounds(227, 136, 132, 21);
		frmJamblAdd.getContentPane().add(btnCancel);

		return frmJamblAdd;
	}

	JButton btnChangeMethod;
	JComboBox<Object> Methods;
	JComboBox<Object> Classes;
	JLabel lblMethod = new JLabel("Method Name:");

	public JFrame changingMethodWindow(){
		frmJamblAdd = new JFrame("JAMBL - Change Method Return Type");
		frmJamblAdd.setTitle("JAMBL - Change Method Return Type");
		frmJamblAdd.setBounds(100, 100, 447, 321);
		frmJamblAdd.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frmJamblAdd.getContentPane().setLayout(null);
		frmJamblAdd.setVisible(true);
		
		JLabel lblAddClass = new JLabel("Choose a class and choose the method name.");
		lblAddClass.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAddClass.setBounds(10, 10, 338, 13);
		frmJamblAdd.getContentPane().add(lblAddClass);
		
		JLabel lblChooseM = new JLabel("* Choose a Method name");
		lblChooseM.setForeground(new Color(255, 0, 0));
		lblChooseM.setBounds(181, 140, 167, 13);
		frmJamblAdd.getContentPane().add(lblChooseM);
		lblChooseM.setVisible(false);
		
		JLabel lblClassName = new JLabel("Choose a class name:");
		lblClassName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblClassName.setBounds(10, 33, 219, 51);
		frmJamblAdd.getContentPane().add(lblClassName);
		
		JLabel lblNewLabel = new JLabel("New Return Type:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(10, 202, 146, 13);
		frmJamblAdd.getContentPane().add(lblNewLabel);
		lblNewLabel.setVisible(false);
		
		lblMethod= new JLabel("Method Name:");
		lblMethod.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMethod.setBounds(10, 113, 161, 13);
		frmJamblAdd.getContentPane().add(lblMethod);
		lblMethod.setVisible(false);

		//////////////////////////////
		//******* Text Field *******//
		//////////////////////////////
		
		textField = new JTextField();
		textField.setBounds(142, 201, 265, 19);
		frmJamblAdd.getContentPane().add(textField);
		textField.setColumns(10);
		textField.setVisible(false);

		//////////////////////////////
		//******* Combo Boxes*******//
		//////////////////////////////
		
		Methods = new JComboBox<Object>();
		Methods.setModel(new DefaultComboBoxModel<Object>());
		Methods.setBounds(10, 136, 161, 21);
		frmJamblAdd.getContentPane().add(Methods);
		Methods.setVisible(false);
		
		Classes = new JComboBox<Object>();
		Classes.setBounds(10, 74, 161, 21);
		frmJamblAdd.getContentPane().add(Classes);

		///////////////////////////
		//******* Buttons *******//
		///////////////////////////
		
		// Change Method Button
		btnChangeMethod = new JButton("Change Type");
		btnChangeMethod.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnChangeMethod.setBounds(10, 253, 190, 21);
		frmJamblAdd.getContentPane().add(btnChangeMethod);	
		
		// Cancel Button
		btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCancel.setBounds(233, 253, 190, 21);
		frmJamblAdd.getContentPane().add(btnCancel);

		return frmJamblAdd;
	}

	JLabel lblNewMethod;
	JFrame frmJamblAdd2;
	public JFrame renamingMethodWindow(){
		frmJamblAdd2 = new JFrame("JAMBL - Change Field Name");
		frmJamblAdd2.setTitle("JAMBL - Rename Method");
		frmJamblAdd2.setBounds(100, 100, 447, 321);
		frmJamblAdd2.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frmJamblAdd2.getContentPane().setLayout(null);
		frmJamblAdd2.setVisible(true);
		
		////////////////////////////
		///******* Labels *******///
		////////////////////////////
		
		JLabel lblAddClass = new JLabel("Choose a class and choose the method");
		lblAddClass.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAddClass.setBounds(10, 10, 338, 13);
		frmJamblAdd2.getContentPane().add(lblAddClass);
		
		JLabel lblChooseM = new JLabel("* Choose a Field name");
		lblChooseM.setForeground(new Color(255, 0, 0));
		lblChooseM.setBounds(181, 140, 167, 13);
		frmJamblAdd2.getContentPane().add(lblChooseM);
		lblChooseM.setVisible(false);
		
		JLabel lblClassName = new JLabel("Choose a class name:");
		lblClassName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblClassName.setBounds(10, 33, 219, 51);
		frmJamblAdd2.getContentPane().add(lblClassName);
		
		lblNewMethod = new JLabel("New Method Name:");
		lblNewMethod.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewMethod.setBounds(10, 202, 146, 13);
		frmJamblAdd2.getContentPane().add(lblNewMethod);
		lblNewMethod.setVisible(false);
		
		JLabel lblMethod= new JLabel("Method Name:");
		lblMethod.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMethod.setBounds(10, 113, 161, 13);
		frmJamblAdd2.getContentPane().add(lblMethod);
		lblMethod.setVisible(false);
		
		//////////////////////////////
		///******* Text Box *******///
		//////////////////////////////
		
		textField = new JTextField();
		textField.setBounds(142, 201, 265, 19);
		frmJamblAdd2.getContentPane().add(textField);
		textField.setColumns(10);
		textField.setVisible(false);
	
		///////////////////////////
		//******* ComboBoxes *******//
		///////////////////////////

		Methods = new JComboBox<Object>();
		Methods.setModel(new DefaultComboBoxModel<Object>());
		Methods.setBounds(10, 136, 161, 21);
		frmJamblAdd2.getContentPane().add(Methods);
		Methods.setVisible(false);

		Classes = new JComboBox<Object>();
		Classes.setBounds(10, 74, 161, 21);
		frmJamblAdd2.getContentPane().add(Classes);

		///////////////////////////
		//******* Buttons *******//
		///////////////////////////
		
		/// Change Method Name Button
		btnChangeMethod = new JButton("Change Method Name");
		btnChangeMethod.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnChangeMethod.setBounds(10, 253, 190, 21);
		frmJamblAdd2.getContentPane().add(btnChangeMethod);

		// Cancel Button
		btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCancel.setBounds(233, 253, 190, 21);
		frmJamblAdd2.getContentPane().add(btnCancel);
		return frmJamblAdd2;
	}


	JLabel lblMethods;

	public JFrame deletingMethodWindow(){
		JFrame frame = new JFrame("JAMBL - Delete Method");
		frame.setBounds(100, 100, 450, 289);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		////////////////////////////
		///******* Labels *******///
		////////////////////////////
		
		JLabel lblDeleteClass = new JLabel("Select the name of a class and method");
		lblDeleteClass.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDeleteClass.setBounds(10, 10, 338, 13);
		frame.getContentPane().add(lblDeleteClass);
		
		JLabel lblSelectClass = new JLabel("Select Class Name: ");
		lblSelectClass.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSelectClass.setBounds(10, 54, 137, 13);
		frame.getContentPane().add(lblSelectClass);
		
		JLabel lblSelectMethodName = new JLabel("Select Method Name: ");
		lblSelectMethodName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSelectMethodName.setBounds(10, 108, 137, 13);
		frame.getContentPane().add(lblSelectMethodName);
		
		//////////////////////////////
		//******* Combo Boxes*******//
		//////////////////////////////
		
		Methods = new JComboBox<Object>();
		
		Methods.setBounds(10, 136, 161, 21);
		frame.getContentPane().add(Methods);
		Methods.setVisible(false);

		Classes = new JComboBox<Object>();
		Classes.setBounds(10, 74, 161, 21);
		frame.getContentPane().add(Classes);

		///////////////////////////
		//******* Buttons *******//
		///////////////////////////
		
		// Delete Method Button
		btnDeleteMethod = new JButton("Delete Method");
		btnDeleteMethod.setForeground(new Color(255, 0, 0));
		btnDeleteMethod.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnDeleteMethod.setBounds(85, 221, 132, 21);
		frame.getContentPane().add(btnDeleteMethod);

		// Cancel Button
		btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCancel.setBounds(227, 221, 132, 21);
		frame.getContentPane().add(btnCancel);	
		return frame;
	}

	JComboBox<Object> cbMethods;
	JTextField textParameter;
	JTextField textParamType;
	public JFrame addingParamWindow(){
		frmJamblAdd = new JFrame("JAMBL - Add Parameter");
		frmJamblAdd.setTitle("JAMBL - Add Parameter");
		frmJamblAdd.setBounds(100, 100, 447, 348);
		frmJamblAdd.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frmJamblAdd.getContentPane().setLayout(null);
		frmJamblAdd.setVisible(true);
		
		////////////////////////////
		///******* Labels *******///
		////////////////////////////
		
		
		JLabel lblAddClass = new JLabel("Choose a class to get started");
		lblAddClass.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAddClass.setBounds(10, 10, 398, 33);
		frmJamblAdd.getContentPane().add(lblAddClass);
		
		JLabel lblClassName = new JLabel("Choose a class name:");
		lblClassName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblClassName.setBounds(10, 33, 219, 51);
		frmJamblAdd.getContentPane().add(lblClassName);
		
		JLabel lblMethod = new JLabel("Method:");
		lblMethod.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMethod.setBounds(10, 113, 136, 13);
		frmJamblAdd.getContentPane().add(lblMethod);
		
		JLabel lblParameter = new JLabel("Parameter Name:");
		lblParameter.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblParameter.setBounds(10, 177, 136, 13);
		frmJamblAdd.getContentPane().add(lblParameter);
		
		JLabel lblParameterType = new JLabel("Parameter Type:");
		lblParameterType.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblParameterType.setBounds(233, 179, 136, 13);
		frmJamblAdd.getContentPane().add(lblParameterType);
		
		////////////////////////////
		//******* Text Box *******//
		////////////////////////////

		textParameter = new JTextField();
		textParameter.setBounds(10, 200, 161, 19);
		frmJamblAdd.getContentPane().add(textParameter);
		textParameter.setColumns(10);
		
		textParamType = new JTextField();
		textParamType.setBounds(233, 200, 161, 19);
		frmJamblAdd.getContentPane().add(textParamType);
		textParamType.setColumns(10);
		

		//////////////////////////////
		//******* Combo Boxes*******//
		//////////////////////////////
		
		cbMethods = new JComboBox<Object>();
		cbMethods.setBounds(10, 136, 161, 21);
		frmJamblAdd.getContentPane().add(cbMethods);
		cbMethods.setModel(new DefaultComboBoxModel<Object>());

		cbClasses = new JComboBox<Object>();
		cbClasses.setBounds(10, 74, 161, 21);
		frmJamblAdd.getContentPane().add(cbClasses);

		///////////////////////////
		//******* Buttons *******//
		///////////////////////////
		
		// Add Class Button
		btnAddParameter = new JButton("Add Parameter");
		btnAddParameter.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAddParameter.setBounds(10, 260, 190, 21);
		frmJamblAdd.getContentPane().add(btnAddParameter);

		/// Cancel Button
		btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCancel.setBounds(233, 260, 190, 21);
		frmJamblAdd.getContentPane().add(btnCancel);
		
		return frmJamblAdd;
	}

	JButton btnRemoveParameter;
	JButton btnDeleteAll;
	JComboBox<Object> cbParameter;
	JComboBox<Object> cdMethods;
	public JFrame deletingParamWindow(){
		JFrame frmJamblAdd = new JFrame("JAMBL - Remove Parameter");
		frmJamblAdd.setBounds(100, 100, 447, 393);
		frmJamblAdd.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frmJamblAdd.getContentPane().setLayout(null);
		frmJamblAdd.setVisible(true);
		
		////////////////////////////
		///******* Labels *******///
		////////////////////////////

		JLabel lblClassName = new JLabel("Choose a class name:");
		lblClassName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblClassName.setBounds(10, 33, 219, 51);
		frmJamblAdd.getContentPane().add(lblClassName);
		
		lblParameter = new JLabel("Parameter:");
		lblParameter.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblParameter.setBounds(10, 193, 82, 13);
		frmJamblAdd.getContentPane().add(lblParameter);
		lblParameter.setVisible(false);
		
		lblMethod = new JLabel("Method:");
		lblMethod.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMethod.setBounds(10, 113, 136, 13);
		frmJamblAdd.getContentPane().add(lblMethod);
		lblMethod.setVisible(false);


		//////////////////////////////
		//******* Combo Boxes*******//
		//////////////////////////////
		
		cbParameter = new JComboBox<Object>();
		cbParameter.setModel(new DefaultComboBoxModel<Object>(new String[] {"Choose a Parameter:"}));
		cbParameter.setBounds(10, 216, 161, 21);
		frmJamblAdd.getContentPane().add(cbParameter);
		cbParameter.setVisible(false);
		
		cdMethods = new JComboBox<Object>();
		cdMethods.setBounds(10, 136, 161, 21);
		frmJamblAdd.getContentPane().add(cdMethods);
		cdMethods.setModel(new DefaultComboBoxModel<Object>());
		cdMethods.setVisible(false);	
		cbClasses = new JComboBox<Object>();
		cbClasses.setBounds(10, 74, 161, 21);
		frmJamblAdd.getContentPane().add(cbClasses);

		///////////////////////////
		//******* Buttons *******//
		///////////////////////////
		
		/// Remove Parameter Button
		btnRemoveParameter = new JButton("Delete Parameter");
		btnRemoveParameter.setForeground(new Color(255, 0, 0));
		btnRemoveParameter.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnRemoveParameter.setBounds(10, 296, 190, 21);
		frmJamblAdd.getContentPane().add(btnRemoveParameter);

		/// Cancel Button
		btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCancel.setBounds(233, 296, 190, 21);
		frmJamblAdd.getContentPane().add(btnCancel);

		//// DeleteAllButton
		btnDeleteAll = new JButton("DELETE ALL PARAMETERS");
		btnDeleteAll.setForeground(new Color(255, 0, 0));
		btnDeleteAll.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnDeleteAll.setBounds(103, 327, 222, 21);
		frmJamblAdd.getContentPane().add(btnDeleteAll);
		return frmJamblAdd;
	}


	
	JComboBox<Object> cbParameters;
	JLabel lblParameter;
	JLabel lblNewParameterName;
	JLabel lblNewParameterType;
	
	public JFrame changingParamWindow(){
		JFrame frmJamblAdd = new JFrame("JAMBL - Add Parameter");
		frmJamblAdd.setTitle("JAMBL - Change Parameter");
		frmJamblAdd.setBounds(100, 100, 447, 373);
		frmJamblAdd.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frmJamblAdd.getContentPane().setLayout(null);
		frmJamblAdd.setVisible(true);
		
		////////////////////////////
		///******* Labels *******///
		////////////////////////////
		
		
		JLabel lblAddClass = new JLabel("Choose a class to get started");
		lblAddClass.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAddClass.setBounds(10, 10, 398, 33);
		frmJamblAdd.getContentPane().add(lblAddClass);
		
		JLabel lblClassName = new JLabel("Choose a class name:");
		lblClassName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblClassName.setBounds(10, 33, 219, 51);
		frmJamblAdd.getContentPane().add(lblClassName);
		
		JLabel lblMethod = new JLabel("Method:");
		lblMethod.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMethod.setBounds(10, 113, 136, 13);
		frmJamblAdd.getContentPane().add(lblMethod);
		lblMethod.setVisible(false);
		
		lblParameter = new JLabel("Parameter Name:");
		lblParameter.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblParameter.setBounds(10, 177, 136, 13);
		frmJamblAdd.getContentPane().add(lblParameter);
		lblParameter.setVisible(false);
		
		lblNewParameterName = new JLabel("New Parameter Name:");
		lblNewParameterName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewParameterName.setBounds(9, 237, 158, 13);
		frmJamblAdd.getContentPane().add(lblNewParameterName);
		lblNewParameterName.setVisible(false);
		
		lblNewParameterType = new JLabel("New Parameter Type:");
		lblNewParameterType.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewParameterType.setBounds(233, 237, 158, 13);
		frmJamblAdd.getContentPane().add(lblNewParameterType);
		lblNewParameterType.setVisible(false);
		
		////////////////////////////
		//******* Text Box *******//
		////////////////////////////

		textParameter = new JTextField();
		textParameter.setBounds(8, 258, 161, 19);
		frmJamblAdd.getContentPane().add(textParameter);
		textParameter.setColumns(10);
		textParameter.setVisible(false);
		
		textParamType = new JTextField();
		textParamType.setBounds(233, 258, 161, 19);
		frmJamblAdd.getContentPane().add(textParamType);
		textParamType.setColumns(10);
		textParamType.setVisible(false);

		//////////////////////////////
		//******* Combo Boxes*******//
		//////////////////////////////
		
		cbParameters = new JComboBox<Object>();
		cbParameters.setModel(new DefaultComboBoxModel<Object>());
		cbParameters.setBounds(10, 200, 161, 21);
		frmJamblAdd.getContentPane().add(cbParameters);
		cbParameters.setVisible(false);

		cbMethods = new JComboBox<Object>();
		cbMethods.setBounds(10, 136, 161, 21);
		frmJamblAdd.getContentPane().add(cbMethods);
		cbMethods.setModel(new DefaultComboBoxModel<Object>()); 
		cbMethods.setVisible(false);

		cbClasses = new JComboBox<Object>();
		cbClasses.setBounds(10, 74, 161, 21);
		frmJamblAdd.getContentPane().add(cbClasses);

		///////////////////////////
		//******* Buttons *******//
		///////////////////////////
		
		// Change Parameter Button
		btnChangeParameter = new JButton("Change Parameter");
		btnChangeParameter.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnChangeParameter.setBounds(11, 299, 190, 21);
		frmJamblAdd.getContentPane().add(btnChangeParameter);

		// Cancel Button
		btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCancel.setBounds(224, 298, 190, 21);
		frmJamblAdd.getContentPane().add(btnCancel);
		return frmJamblAdd;
	}


	JTextField fieldTypeBox;
	JTextField fieldNameBox;
	JLabel lblField;
	JLabel lblFieldType;
	public JFrame addingFieldWindow(){
		JFrame frame = new JFrame("JAMBL - Add Field");
		frame.setBounds(100, 100, 496, 285);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		////////////////////////////
		///******* Labels *******///
		////////////////////////////
		
		JLabel lblAddClass = new JLabel("Select a class to add a field to.");
		lblAddClass.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAddClass.setBounds(10, 10, 338, 13);
		frame.getContentPane().add(lblAddClass);
		
		JLabel lblClassName = new JLabel("Class Name: ");
		lblClassName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblClassName.setBounds(10, 43, 87, 13);
		frame.getContentPane().add(lblClassName);
		
		lblField = new JLabel("Field Name:");
		lblField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblField.setBounds(10, 108, 108, 13);
		frame.getContentPane().add(lblField);
		lblField.setVisible(false);
		
		lblFieldType = new JLabel("Field Type:");
		lblFieldType.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblFieldType.setBounds(10, 148, 108, 18);
		frame.getContentPane().add(lblFieldType);
		lblFieldType.setVisible(false);

		//////////////////////////////
		//******* Text Boxes *******//
		//////////////////////////////
		
		fieldNameBox = new JTextField();
		fieldNameBox.setBounds(121, 107, 227, 19);
		fieldNameBox.setColumns(10);
		frame.getContentPane().add(fieldNameBox);
		fieldNameBox.setVisible(false);
		
		fieldTypeBox = new JTextField();
		fieldTypeBox.setColumns(10);
		fieldTypeBox.setBounds(121, 147, 227, 19);
		frame.getContentPane().add(fieldTypeBox);
		fieldTypeBox.setVisible(false);

		//////////////////////////////
		//******* Combo Boxes*******//
		//////////////////////////////
		comboBoxClasses = new JComboBox<Object>();
		comboBoxClasses.setBounds(10, 66, 124, 21);
		frame.getContentPane().add(comboBoxClasses);

		///////////////////////////
		//******* Buttons *******//
		///////////////////////////
		
		// Add Field Button
		btnAddField = new JButton("Add Field");
		btnAddField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAddField.setBounds(85, 204, 132, 21);
		frame.getContentPane().add(btnAddField);

		/// Cancel Button
		btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCancel.setBounds(227, 204, 132, 21);
		frame.getContentPane().add(btnCancel);
		return frame;
	}


	JComboBox<Object> cbFields;
	JFrame frmJamblAdd3;
	//JLabel lblField;
	public JFrame deletingFieldWindow(){
		frmJamblAdd3 = new JFrame("JAMBL - Delete Field Name");
		frmJamblAdd3.setBounds(100, 100, 447, 258);
		frmJamblAdd3.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frmJamblAdd3.getContentPane().setLayout(null);
		frmJamblAdd3.setVisible(true);
		
		////////////////////////////
		///******* Labels *******///
		////////////////////////////
		
		JLabel lblAddClass = new JLabel("Choose a class and choose the field.");
		lblAddClass.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAddClass.setBounds(10, 10, 338, 13);
		frmJamblAdd3.getContentPane().add(lblAddClass);
		
		JLabel lblClassName = new JLabel("Choose a class name:");
		lblClassName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblClassName.setBounds(10, 33, 219, 51);
		frmJamblAdd3.getContentPane().add(lblClassName);
		
		lblField= new JLabel("Field Name:");
		lblField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblField.setBounds(10, 113, 161, 13);
		frmJamblAdd3.getContentPane().add(lblField);
		lblField.setVisible(false);
		
		//////////////////////////////
		//******* Combo Boxes*******//
		//////////////////////////////
		
		cbFields = new JComboBox<Object>();
		
		cbFields.setBounds(10, 136, 161, 21);
		frmJamblAdd3.getContentPane().add(cbFields);
		cbFields.setVisible(false);

		Classes = new JComboBox<Object>();
		Classes.setBounds(10, 74, 161, 21);
		frmJamblAdd3.getContentPane().add(Classes);

		///////////////////////////
		//******* Buttons *******//
		///////////////////////////
		
		//  Delete Field
		btnDeleteField = new JButton("Delete Field");
		btnDeleteField.setForeground(new Color(255, 0, 0));
		btnDeleteField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnDeleteField.setBounds(10, 189, 190, 21);
		frmJamblAdd3.getContentPane().add(btnDeleteField);

		 // Cancel Button
		 btnCancel = new JButton("Cancel");
		 btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		 btnCancel.setBounds(233, 189, 190, 21);
		 frmJamblAdd3.getContentPane().add(btnCancel);

		return frmJamblAdd3;
	}

	JFrame frmJamblAdd4;
	JLabel lblNewField;
	//JLabel lblMethod;
	public JFrame renamingFieldWindow(){
		frmJamblAdd4 = new JFrame("JAMBL - Change Field Name");
		frmJamblAdd4.setTitle("JAMBL - Rename Field");
		frmJamblAdd4.setBounds(100, 100, 447, 321);
		frmJamblAdd4.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frmJamblAdd4.getContentPane().setLayout(null);
		frmJamblAdd4.setVisible(true);
		
		////////////////////////////
		///******* Labels *******///
		////////////////////////////
		
		JLabel lblAddClass = new JLabel("Choose a class and choose the field.");
		lblAddClass.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAddClass.setBounds(10, 10, 338, 13);
		frmJamblAdd4.getContentPane().add(lblAddClass);
		
		JLabel lblChooseM = new JLabel("* Choose a Field name");
		lblChooseM.setForeground(new Color(255, 0, 0));
		lblChooseM.setBounds(181, 140, 167, 13);
		frmJamblAdd4.getContentPane().add(lblChooseM);
		lblChooseM.setVisible(false);
		
		JLabel lblClassName = new JLabel("Choose a class name:");
		lblClassName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblClassName.setBounds(10, 33, 219, 51);
		frmJamblAdd4.getContentPane().add(lblClassName);
		
		lblNewField = new JLabel("New Field Name:");
		lblNewField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewField.setBounds(10, 202, 146, 13);
		frmJamblAdd4.getContentPane().add(lblNewField);
		lblNewField.setVisible(false);
		
		lblMethod= new JLabel("Field Name:");
		lblMethod.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMethod.setBounds(10, 113, 161, 13);
		frmJamblAdd4.getContentPane().add(lblMethod);
		lblMethod.setVisible(false);
		
		//////////////////////////////
		///******* Text Box *******///
		//////////////////////////////
		
		textField = new JTextField();
		textField.setBounds(142, 201, 265, 19);
		frmJamblAdd4.getContentPane().add(textField);
		textField.setColumns(10);
		textField.setVisible(false);
	
		Fields = new JComboBox<Object>();
		Fields.setBounds(10, 136, 161, 21);
		frmJamblAdd4.getContentPane().add(Fields);
		Fields.setVisible(false);

		Classes = new JComboBox<Object>();
		Classes.setBounds(10, 74, 161, 21);
		frmJamblAdd4.getContentPane().add(Classes);

		///////////////////////////
		//******* Buttons *******//
		///////////////////////////
		
		// Change Field Name Button
		btnChangeMethod = new JButton("Change Field Name");
		btnChangeMethod.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnChangeMethod.setBounds(10, 253, 190, 21);
		frmJamblAdd4.getContentPane().add(btnChangeMethod);

		// Cancel Button
		btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCancel.setBounds(233, 253, 190, 21);
		frmJamblAdd4.getContentPane().add(btnCancel);
		return frame;
	}



	JButton btnChangeField;
	JLabel lblChooseM;
	JLabel lblNewFType;
	//JLabel lblField;
	JTextField textFieldType;
	JComboBox<Object> Fields;
	JFrame frmJamblAdd5;
	public JFrame editingFieldWindow(){
		frmJamblAdd5 = new JFrame("JAMBL - Change Field Type");
		frmJamblAdd5.setTitle("JAMBL - Change Field Type");
		frmJamblAdd5.setBounds(100, 100, 447, 321);
		frmJamblAdd5.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frmJamblAdd5.getContentPane().setLayout(null);
		frmJamblAdd5.setVisible(true);

		////////////////////////////
		///******* Labels *******///
		////////////////////////////
		
		JLabel lblAddClass = new JLabel("Choose a class and choose the field name.");
		lblAddClass.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAddClass.setBounds(10, 10, 371, 13);
		frmJamblAdd5.getContentPane().add(lblAddClass);
		
		lblChooseM = new JLabel("* Choose a Field name");
		lblChooseM.setForeground(new Color(255, 0, 0));
		lblChooseM.setBounds(181, 140, 167, 13);
		frmJamblAdd5.getContentPane().add(lblChooseM);
		lblChooseM.setVisible(false);
		
		JLabel lblClassName = new JLabel("Choose a class name:");
		lblClassName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblClassName.setBounds(10, 33, 219, 51);
		frmJamblAdd5.getContentPane().add(lblClassName);
		
		lblNewFType = new JLabel("New Field Type:");
		lblNewFType.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewFType.setBounds(10, 202, 146, 13);
		frmJamblAdd5.getContentPane().add(lblNewFType);
		lblNewFType.setVisible(false);
		
		lblField= new JLabel("Field Name:");
		lblField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblField.setBounds(10, 113, 161, 13);
		frmJamblAdd5.getContentPane().add(lblField);
		lblField.setVisible(false);
		
		////////////////////////////
		//******* Text Box *******//
		////////////////////////////
		
		textFieldType = new JTextField();
		textFieldType.setBounds(142, 201, 265, 19);
		frmJamblAdd5.getContentPane().add(textFieldType);
		textFieldType.setColumns(10);
		textFieldType.setVisible(false);
		
		//////////////////////////////
		//******* Combo Boxes*******//
		//////////////////////////////
		
		Fields = new JComboBox<Object>();
		Fields.setBounds(10, 136, 161, 21);
		frmJamblAdd5.getContentPane().add(Fields);
		Fields.setVisible(false);

		Classes = new JComboBox<Object>();
		Classes.setBounds(10, 74, 161, 21);
		frmJamblAdd5.getContentPane().add(Classes);

		///////////////////////////
		//******* Buttons *******//
		///////////////////////////
		
		// Change Field Button
		btnChangeField = new JButton("Change Field");
		btnChangeField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnChangeField.setBounds(10, 253, 190, 21);
		frmJamblAdd5.getContentPane().add(btnChangeField);

		// Cancel Button
		btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCancel.setBounds(233, 253, 190, 21);
		frmJamblAdd5.getContentPane().add(btnCancel);
		return frmJamblAdd5;


	}

	
	JTextField textField;
	JButton btnBrowse;
	JButton btnDefault;
	
	public JFrame loadWindow(){
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
		btnBrowse = new JButton("Browse...");
		btnBrowse.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnBrowse.setBounds(341, 55, 104, 21);
		frame.getContentPane().add(btnBrowse);
		//Create a file chooser

		btnDefault = new JButton("Default");
		btnDefault.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnDefault.setBounds(176, 85, 85, 21);
		frame.getContentPane().add(btnDefault);
		frame.setVisible(true);

		btnLoad = new JButton("Load");
		btnLoad.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnLoad.setBounds(113, 114, 85, 21);
		frame.getContentPane().add(btnLoad);

		
		btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCancel.setBounds(243, 114, 85, 21);
		frame.getContentPane().add(btnCancel);
		frame.setVisible(true);

		
		return frame;
	}

	JTextField txtDefaulttxt;
	public JFrame saveWindow(){
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
		txtDefaulttxt.setText("JAMBL.json");
		txtDefaulttxt.setBounds(92, 94, 235, 19);
		frame.getContentPane().add(txtDefaulttxt);
		txtDefaulttxt.setColumns(10);

		///////////////////////////
		//******* Buttons *******//
		///////////////////////////
		
		btnSave = new JButton("Save");
		//JTextField textField = new JTextField();
		btnSave.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSave.setBounds(92, 158, 85, 21);
		frame.getContentPane().add(btnSave);

		btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCancel.setBounds(242, 158, 85, 21);
		frame.getContentPane().add(btnCancel);
		frame.setVisible(true);
		return frame;	
	}

	public JFrame listAClassWindow(){
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

		//////////////////////////////
		//******* Combo Boxes*******//
		//////////////////////////////
		
		cbClasses = new JComboBox<Object>();
		cbClasses.setBounds(10, 77, 207, 21);
		frame.getContentPane().add(cbClasses);
		

		///////////////////////////
		//******* Buttons *******//
		///////////////////////////
	
		/// List Class Button
		btnListClass = new JButton("List Class");
		btnListClass.setForeground(new Color(0, 0, 0));
		btnListClass.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnListClass.setBounds(85, 136, 132, 21);
		frame.getContentPane().add(btnListClass);

		/// Cancel Button
		btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCancel.setBounds(227, 136, 132, 21);
		frame.getContentPane().add(btnCancel);



		return frame;
	}
	

	


	/* Sets up the buttons of the main page */
	private void initialize(){
		
		//******** MAIN PAGE ********//
		frmJambl = new JFrame();
		frmJambl.setTitle("JAMBL");
		frmJambl.setBounds(100, 100, 1063, 639);
		frmJambl.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmJambl.getContentPane().setLayout(null);
		
		/*
		 * Scroll Pane for text area for large output
		 */
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(359, 67, 678, 524);
		frmJambl.getContentPane().add(scrollPane_1);
		
		/////////////////////////////////////////// textAreaMain - where the UML diagram will be able displayed and updated in real time
		///////////////////////////////////////////			as classes, field, methods, and relationships are added
		textAreaMain = new JTextArea();
		scrollPane_1.setViewportView(textAreaMain);
		textAreaMain.setLineWrap(true);
		textAreaMain.setEditable(false);
		
		
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
		
		lblMethods = new JLabel("Methods");
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


		// Main page Buttons Style

		btnAddClass.setBounds(10, 103, 97, 21);
		frmJambl.getContentPane().add(btnAddClass);

		btnRenameClass.setBounds(10, 134, 97, 21);
		frmJambl.getContentPane().add(btnRenameClass);

		btnDeleteClass.setBounds(10, 165, 97, 21);
		frmJambl.getContentPane().add(btnDeleteClass);

		btnListAll.setBounds(10, 534, 137, 21);
		frmJambl.getContentPane().add(btnListAll);

		btnAddRelationship.setBounds(220, 105, 97, 21);
		frmJambl.getContentPane().add(btnAddRelationship);

		btnDeleteRel.setBounds(220, 136, 97, 21);
		frmJambl.getContentPane().add(btnDeleteRel);
		btnDeleteRel.setName("DeleteRelM");

		btnChangeType.setBounds(220, 165, 97, 21);
		frmJambl.getContentPane().add(btnChangeType);

		btnAddMethod.setBounds(220, 256, 97, 21);
		frmJambl.getContentPane().add(btnAddMethod);

		// method return type
		btnRefactor.setBounds(220, 289, 97, 21);
		frmJambl.getContentPane().add(btnRefactor);

		btnDeleteMethod.setBounds(220, 355, 97, 21);
		frmJambl.getContentPane().add(btnDeleteMethod);

		btnRenameMethod.setBounds(220, 322, 97, 21);
		frmJambl.getContentPane().add(btnRenameMethod);

		btnAddField.setBounds(220, 437, 97, 21);
		frmJambl.getContentPane().add(btnAddField);

		btnChangeFieldType.setBounds(220, 470, 97, 21);
		frmJambl.getContentPane().add(btnChangeFieldType);

		btnDeleteField.setBounds(220, 536, 97, 21);
		frmJambl.getContentPane().add(btnDeleteField);

		btnRenameField.setBounds(220, 503, 97, 21);
		frmJambl.getContentPane().add(btnRenameField);

		btnAddParameter.setBounds(10, 259, 97, 21);
		frmJambl.getContentPane().add(btnAddParameter);

		btnDeleteParameter.setBounds(10, 292, 97, 21);
		frmJambl.getContentPane().add(btnDeleteParameter);

		btnChangeParameter.setBounds(10, 325, 97, 21);
		frmJambl.getContentPane().add(btnChangeParameter);

		btnSave.setBounds(10, 412, 85, 21);
		frmJambl.getContentPane().add(btnSave);

		btnLoad.setBounds(10, 445, 85, 21);
		frmJambl.getContentPane().add(btnLoad);

		btnListAll.setBounds(10, 534, 137, 21);
		frmJambl.getContentPane().add(btnListAll);

		btnListClass.setBounds(10, 503, 137, 21);
		frmJambl.getContentPane().add(btnListClass);

		btnListRelationships.setBounds(10, 565, 137, 21);
		frmJambl.getContentPane().add(btnListRelationships);
	}

///////////////////////////////////
	//// *****POP-UP WINDOWS***** ////
	//////////////////////////////////
	
	/*
	 * A window letting one know if a class exists when attempting to add or rename a class
	 */
	public void classExist(){
		JOptionPane.showMessageDialog(f, "Class Already Exists","Alert",JOptionPane.WARNING_MESSAGE);
   }
   
   /*
	*  A window letting one know a class has been created
	*/
   public void classCreate(String name) {
	   JOptionPane.showMessageDialog(f, "Class '" + name +  "' created.","Info",JOptionPane.INFORMATION_MESSAGE);
   }
   
	
   /*
	*  A window letting one know a class has been created
	*/
   public void classDelete(String name) {
	   JOptionPane.showMessageDialog(f, "Class '" + name + "' deleted.","Info",JOptionPane.INFORMATION_MESSAGE);
   }
   
   /*
	* A window letting one know a class has been renamed
	*/
   public void classRename(String name1, String name2) {
	   JOptionPane.showMessageDialog(f, "Class '" + name1 + "' renamed to ' " + name2 + "'." ,"Info",JOptionPane.INFORMATION_MESSAGE);
   }
   
   /*
	* A window informing user to select a class 
	*/
   public void classSelect() {
	   JOptionPane.showMessageDialog(f, "Please select a class.", "SELECT",JOptionPane.WARNING_MESSAGE);
   }
   
   /*
	* A window informing the user that a relationship already exists on creation attempt 
	*/
   public void relationshipExist() {
	   JOptionPane.showMessageDialog(f, "Relationship already exists!", "Alert",JOptionPane.WARNING_MESSAGE);
   }
   
   /*
	* A window informing the user that a relationship does not exist on deletion attempt
	*/
   public void relationshipNotExist() {
	   JOptionPane.showMessageDialog(f, "Relationship does not exists!", "Alert",JOptionPane.WARNING_MESSAGE);
   }
   
   /*
	* A window for informing the user that a field has been added
	* 
	*/
   public void fieldAdd(String fieldName, String className) {
	   JOptionPane.showMessageDialog(f, "Field " + fieldName + " added to class " + className + "!", "Info",JOptionPane.INFORMATION_MESSAGE);
   }
   
   /*
	* A window informing the user that a field has been renamed
	*/
   public void fieldRename(String oldFieldName, String newFieldName, String className) {
	   JOptionPane.showMessageDialog(f, "Field " + oldFieldName + " renamed to " + newFieldName 
			   + " in class " + className + "!", "Info",JOptionPane.INFORMATION_MESSAGE);
   }
   
   /*
	* A window informing the user a field has had their type changed
	*/
   public void fieldTypeChange(String className, String fieldNAme, String newType) {
	   JOptionPane.showMessageDialog(f, "Field " + fieldNAme + " in class " + className 
			   + " has new type " + newType + "!", "Info",JOptionPane.INFORMATION_MESSAGE);
   }
   
   /*
	* A window informing a user to enter a field name and field type
	*/
   public void fieldText() {
	   JOptionPane.showMessageDialog(f, "Please enter a field name and a field type", "Info",JOptionPane.INFORMATION_MESSAGE);
   }
   
   /*
	* A window for informing the user that a field has been deleted
	* 

	*/
   public void fieldDelete(String fieldName, String className) {
	   JOptionPane.showMessageDialog(f, "Field " + fieldName + " deleted from class " + className + "!", "Alert",JOptionPane.WARNING_MESSAGE);
   }
   
   /*
	* A window informing the user that a class cannot have a relationship with itself
	*/
   public void relationshipNoDouble() {
	   JOptionPane.showMessageDialog(f, "Class cannot have relationship with itself!", "Alert",JOptionPane.WARNING_MESSAGE);
   }
		   
   /*
	* A window informing the user that a field already exists on insertion or rename attempt
	*/
   public void fieldExist() {
	   JOptionPane.showMessageDialog(f, "Field already exists!", "Alert",JOptionPane.WARNING_MESSAGE);
   }
   
   /*
	* A window informing user of an error deleting field
	*/
   public void deleteFieldFailure() {
	   JOptionPane.showMessageDialog(f, "Failed to delete field...", "Error",JOptionPane.ERROR_MESSAGE);
   }
   
   /*
	* A window informing user of an error adding field
	*/

   public void addFieldFailure() {
	   JOptionPane.showMessageDialog(f, "Failed to add field...", "Error",JOptionPane.ERROR_MESSAGE);
   }
   
   /*
	* A window informing user to select a field
	*/
   public void fieldSelect() {
	   JOptionPane.showMessageDialog(f, "Please select a field.", "SELECT",JOptionPane.WARNING_MESSAGE);
   }
   
   /*
	* A window informing user to select a method
	*/
   public void loadSelect() {
	   JOptionPane.showMessageDialog(f, "Please select a file to load.", "SELECT", JOptionPane.WARNING_MESSAGE);
   }
   
   /*
	* A window informing user to enter a file name for saving
	*/
   public void saveSelect() {
	   JOptionPane.showMessageDialog(f, "Please enter a file name.", "SELECT",JOptionPane.WARNING_MESSAGE);
   }
   
   /*
	* A window informing user to enter a file name for saving
	*/
   public void saveSuccess() {
	   JOptionPane.showMessageDialog(f, "Save successful!", "Info",JOptionPane.INFORMATION_MESSAGE);
   }
   
   /*
	* A window informing user to enter a file name for saving
	*/
   public void saveFailure() {
	   JOptionPane.showMessageDialog(f, "Save failed...", "Error",JOptionPane.ERROR_MESSAGE);
   }
   
   /*
	* A window for informing the user that a method has been added
	* 
	*/
   public void methodAdd(String className, String methodName) {
	   JOptionPane.showMessageDialog(f, "Method " + methodName + " added to class " + className + "!", "Info",JOptionPane.INFORMATION_MESSAGE);
   }

   /*
	* A window informing user of an error on an action involving a Method
	*/
   public void methodActionFailure(String action) {
	   JOptionPane.showMessageDialog(f, "Failed to " + action + " method...", "Error",JOptionPane.ERROR_MESSAGE);
   }

   /*
	* A window for informing the user that a method has been deleted
	* 
	*/
   public void methodDelete(String className, String methodName) {
	   JOptionPane.showMessageDialog(f, "Method " + methodName + " deleted from class " + className + "!", "Info",JOptionPane.INFORMATION_MESSAGE);
   }
   
   /*
	* A window for informing the user that a method has been renamed
	* 
	*/
   public void methodRename(String className, String oldName, String newName) {
	   JOptionPane.showMessageDialog(f, "Method " + oldName + " was renamed to " + newName + " in class " + className + "!", "Info",JOptionPane.INFORMATION_MESSAGE);
   }

   /*
	* A window informing the user that a method already exists on insertion or rename attempt
	*/
   public void methodExist() {
	   JOptionPane.showMessageDialog(f, "Method already exists!", "Alert",JOptionPane.WARNING_MESSAGE);
   }


   /*
   * A window for informing the user that a parameter has been added
   * 
   */
   public void paramAdd(String method, String name, String type){
	   JOptionPane.showMessageDialog(f, "Parameter " + type + " " + name + " added to method " + method + "!", "Info",JOptionPane.INFORMATION_MESSAGE);
   }


   /*
   * A window for informing the user that a parameter has been deleted
   * 
   */
   public void paramDelete(String method, String name) {
	   JOptionPane.showMessageDialog(f, "Parameter " + name + " deleted from method " + method + "!", "Alert",JOptionPane.WARNING_MESSAGE);
   }


   /*
   * A window informing the user that a parameter has been renamed and retyped
   */
   public void paramChange(String method, String oldName, String newName, String newType) {
	   JOptionPane.showMessageDialog(f, "Parameter " + oldName + " changed to " + newType + " " + newName 
	   + " in method " + method + "!", "Info",JOptionPane.INFORMATION_MESSAGE);
   }

   /*
   * A window for informing the user that all parameters have been deleted from a method
   * 
   */
   public void paramDeleteAll(String method) {
	   JOptionPane.showMessageDialog(f, "All parameters deleted from method " + method + "!", "Alert",JOptionPane.WARNING_MESSAGE);
   }


   /*
   * A window informing user of an error adding parameter
   */
   public void addParamFailure() {
	   JOptionPane.showMessageDialog(f, "Failed to add parameter...", "Error",JOptionPane.ERROR_MESSAGE);
   }


   /*
   * A window informing user of an error deleting parameter
   */
   public void deleteParamFailure() {
	   JOptionPane.showMessageDialog(f, "Failed to delete parameter...", "Error",JOptionPane.ERROR_MESSAGE);
   }


   /*
   * A window informing user of an error changing parameter
   */
   public void changeParamFailure() {
	   JOptionPane.showMessageDialog(f, "Failed to change parameter...", "Error",JOptionPane.ERROR_MESSAGE);
   }


   /*
   * A window informing user of an error deleting all parameters from a method
   */
   public void deleteAllParamFailure() {
	   JOptionPane.showMessageDialog(f, "Failed to delete all parameters...", "Error",JOptionPane.ERROR_MESSAGE);
   }
   /*
	* A window for informing the user that a method has been renamed
	* 
	*/
   public void methodRetype(String className, String methodName, String returnType) {
	   JOptionPane.showMessageDialog(f, "Method " + methodName + " now has a return type of " + returnType + " in class " + className + "!", "Info",JOptionPane.INFORMATION_MESSAGE);
   }

   // add relationship parameter origin class doesnt exist
   public void originNotExist() {
	   JOptionPane.showMessageDialog(f, "Origin Class does not exists!", "Alert",JOptionPane.WARNING_MESSAGE);
   }

   public void destinationNotExist() {
	   JOptionPane.showMessageDialog(f, "destination Class does not exists!", "Alert",JOptionPane.WARNING_MESSAGE);
   }

   public void relExists(){
	   JOptionPane.showMessageDialog(f, "Relationship already exist! Action Failed!", "Alert",JOptionPane.WARNING_MESSAGE);
   }

   public void addedRel(String origin, String destination) {
	   JOptionPane.showMessageDialog(f, "Relationship added successfully!", "Info",JOptionPane.INFORMATION_MESSAGE);

   }

   public void relTypeEdited(String newType){
	   JOptionPane.showMessageDialog(f,"Relationship type changed to " + newType + "!", "Alert", JOptionPane.WARNING_MESSAGE);
   }
   public void relDeleted() {
	   JOptionPane.showMessageDialog(f, "Relationship deleted successfully", "Info",JOptionPane.INFORMATION_MESSAGE);

   }
}

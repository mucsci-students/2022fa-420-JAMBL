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
	
	Model model = new Model();
	private GUIController controller = new GUIController(model, this);
	
	// Basic frame for small pop-ups
	JFrame f=new JFrame(); 
	
	private JFrame frmJambl;
	// A boolean signifying if the recent UML diagram has been saved. 
	// If not, a pop-up message will appear upon clicking the x button
	//     asking the user if they would like to save before closing
	boolean saved = false;

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

	public GUIView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		
		//******** MAIN PAGE ********//
		frmJambl = new JFrame();
		frmJambl.setTitle("JAMBL");
		frmJambl.setBounds(100, 100, 1063, 752);
		frmJambl.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmJambl.getContentPane().setLayout(null);
		
		/////////////////////////////////////////// textAreaMain - where the UML diagram will be able displayed and updated in real time
		///////////////////////////////////////////			as classes, field, methods, and relationships are added
		JTextArea textAreaMain = new JTextArea();
		textAreaMain.setLineWrap(true);
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
		//******* Buttons *******//
		///////////////////////////
		
		//////////////////////////////////////////////////////////////////////// Add Class Button
		JButton btnAddClass = new JButton("Add");
		btnAddClass.setBounds(10, 103, 97, 21);
		frmJambl.getContentPane().add(btnAddClass);
		btnAddClass.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				JFrame frame = new JFrame("JAMBL - Add Class");
				frame.setBounds(100, 100, 496, 225);
				frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				frame.getContentPane().setLayout(null);
				

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
				
				JTextField classNameBox = new JTextField();
				lblClassName.setLabelFor(classNameBox);
				classNameBox.setBounds(121, 77, 227, 19);
				frame.getContentPane().add(classNameBox);
				classNameBox.setColumns(10);
				frame.setVisible(true);
				
				///////////////////////////
				//******* Buttons *******//
				///////////////////////////
				
				//// Add Class Button
				JButton btnAddClass = new JButton("Add Class");
				btnAddClass.setFont(new Font("Tahoma", Font.PLAIN, 15));
				btnAddClass.setBounds(85, 136, 132, 21);
				frame.getContentPane().add(btnAddClass);
				btnAddClass.setName("AddClass");
				btnAddClass.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(!classNameBox.getText().equals(""))
						{
							controller.addClass(classNameBox.getText());
							frame.dispose();
						}
					}
				});
				
				//// Cancel Button
				JButton btnCancel = new JButton("Cancel");
				btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 15));
				btnCancel.setBounds(227, 136, 132, 21);
				frame.getContentPane().add(btnCancel);
				btnCancel.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						frame.dispose();
					}
				});
				
				saved = false;
			}
		});
		
		//////////////////////////////////////////////////////////////////////// Rename Class Button
		JButton btnRenameClass = new JButton("Rename");
		btnRenameClass.setBounds(10, 134, 97, 21);
		frmJambl.getContentPane().add(btnRenameClass);
		btnRenameClass.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
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
				
				JTextField textFieldClassName = new JTextField();
				textFieldClassName.setBounds(10, 146, 178, 19);
				frame.getContentPane().add(textFieldClassName);
				textFieldClassName.setColumns(10);
				textFieldClassName.setVisible(false);
				
				//////////////////////////////
				//******* Combo Boxes*******//
				//////////////////////////////
				JComboBox<Object> cbClasses = new JComboBox<Object>();
				cbClasses.setModel(new DefaultComboBoxModel<Object>());
				cbClasses.setBounds(10, 78, 111, 21);
				frame.getContentPane().add(cbClasses);
				cbClasses.setModel(new DefaultComboBoxModel<Object>(getList("Class", null, null)));
				cbClasses.addItemListener(new ItemListener() {
							public void itemStateChanged(ItemEvent arg0) {
								textFieldClassName.setVisible(true);
								lblNewName.setVisible(true);
							}
				});
				
				/////////////////////////////
				///******* Buttons *******///
				/////////////////////////////
				
				JButton btnRenameClass = new JButton("Rename Class");
				btnRenameClass.setFont(new Font("Tahoma", Font.PLAIN, 15));
				btnRenameClass.setBounds(10, 206, 178, 21);
				frame.getContentPane().add(btnRenameClass);
				btnRenameClass.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(!cbClasses.getSelectedItem().toString().equals("Choose a class:")) {
							if(!textFieldClassName.getText().equals("")) {
								controller.renameClass(cbClasses.getSelectedItem().toString(), textFieldClassName.getText() );
								frame.dispose();
							}

						}
						else
						{
							classSelect();
						}
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
			}
		});
		
		//////////////////////////////////////////////////////////////////////// Delete Class Button 
		JButton btnDeleteClass = new JButton("Delete");
		btnDeleteClass.setBounds(10, 165, 97, 21);
		frmJambl.getContentPane().add(btnDeleteClass);
		btnDeleteClass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame frame = new JFrame("JAMBL - Delete Class");
				frame.setBounds(100, 100, 450, 203);
				frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				frame.getContentPane().setLayout(null);
				frame.setVisible(true);
			

				JLabel lblDeleteClass = new JLabel("Select the name of a class to delete");
				lblDeleteClass.setFont(new Font("Tahoma", Font.PLAIN, 18));
				lblDeleteClass.setBounds(10, 10, 338, 13);
				frame.getContentPane().add(lblDeleteClass);
				
				JLabel lblSelectClass = new JLabel("Select Class Name: ");
				lblSelectClass.setFont(new Font("Tahoma", Font.PLAIN, 15));
				lblSelectClass.setBounds(10, 54, 137, 13);
				frame.getContentPane().add(lblSelectClass);
			
			    //////////////////////////////
				//******* Combo Boxes*******//
				//////////////////////////////
				
				
				JComboBox<Object> comboBoxClasses = new JComboBox<Object>();
				comboBoxClasses.setBounds(10, 77, 207, 21);
				frame.getContentPane().add(comboBoxClasses);
				comboBoxClasses.setModel(new DefaultComboBoxModel<Object>(getList("Class", null, null)));
				
				///////////////////////////
				//******* Buttons *******//
				///////////////////////////
				
				////////////////////////////////////////////////////////////// Delete Class Button
				JButton btnDeleteClass = new JButton("Delete Class");
				btnDeleteClass.setForeground(new Color(255, 0, 0));
				btnDeleteClass.setFont(new Font("Tahoma", Font.PLAIN, 15));
				btnDeleteClass.setBounds(85, 136, 132, 21);
				frame.getContentPane().add(btnDeleteClass);
				btnDeleteClass.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(!comboBoxClasses.getSelectedItem().equals("Choose a class:")) {
							controller.deleteClass(comboBoxClasses.getSelectedItem().toString());
							frame.dispose();
						}
						else
						{
							classSelect();
						}
							
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
				
				saved = false;
			}
		});
		
		
		//////////////////////////////////////////////////////////////////////// Add Relationship Button 
		JButton btnAddRelationship = new JButton("Add");
		btnAddRelationship.setBounds(220, 105, 97, 21);
		frmJambl.getContentPane().add(btnAddRelationship);
		btnAddRelationship.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
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
				
				JLabel lblClass1 = new JLabel("Class 1:");
				lblClass1.setFont(new Font("Tahoma", Font.PLAIN, 12));
				lblClass1.setBounds(10, 113, 73, 13);
				frame.getContentPane().add(lblClass1);
				lblClass1.setVisible(false);
				
				JLabel lblClass2 = new JLabel("Class 2:");
				lblClass2.setFont(new Font("Tahoma", Font.PLAIN, 12));
				lblClass2.setBounds(239, 114, 45, 13);
				frame.getContentPane().add(lblClass2);
				lblClass2.setVisible(false);
				
				//////////////////////////////
				//******* Combo Boxes*******//
				//////////////////////////////
				
				JComboBox<Object> comboBoxClass1 = new JComboBox<Object>();
				comboBoxClass1.setBounds(10, 137, 90, 21);
				frame.getContentPane().add(comboBoxClass1);
				comboBoxClass1.setModel(new DefaultComboBoxModel<Object>(getList("Class", null, null)));
				comboBoxClass1.setVisible(false);
				
				JComboBox<Object> comboBoxClass2 = new JComboBox<Object>();
				comboBoxClass2.setBounds(239, 137, 90, 21);
				frame.getContentPane().add(comboBoxClass2);
				comboBoxClass2.setModel(new DefaultComboBoxModel<Object>(getList("Class", null, null)));
				comboBoxClass2.setVisible(false);
				
				
				JComboBox<Object> cbRelationships = new JComboBox<Object>();
				cbRelationships.setModel(new DefaultComboBoxModel<Object>(new String[] {"Choose a relationship type:", "Aggregation", "Composition", "Inheritance", "Realization"}));
				cbRelationships.setBounds(10, 74, 161, 21);
				frame.getContentPane().add(cbRelationships);
				cbRelationships.addItemListener(new ItemListener() {
					public void itemStateChanged(ItemEvent arg0) {
						comboBoxClass1.setVisible(true);
						comboBoxClass2.setVisible(true);
						lblClass1.setVisible(true);
						lblClass2.setVisible(true);
					}
				});
				
				///////////////////////////
				//******* Buttons *******//
				///////////////////////////
				
			    // Add Relationship Button
				JButton btnAddRelationship = new JButton("Add Relationship");
				btnAddRelationship.setFont(new Font("Tahoma", Font.PLAIN, 15));
				btnAddRelationship.setBounds(10, 217, 190, 21);
				frame.getContentPane().add(btnAddRelationship);
				btnAddRelationship.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(!comboBoxClass1.getSelectedItem().equals("Choose a class:") || !comboBoxClass2.getSelectedItem().equals("Choose a class:") ) {

							////////////////////////////////////////////////////////
							controller.addRelationship(comboBoxClass1.getSelectedItem().toString(), 
							comboBoxClass2.getSelectedItem().toString(), cbRelationships.getSelectedItem().toString());
							/////////////////////////////////////////////////////////////

							frame.dispose();
						}
						else
						{
							classSelect();
						}
					}
				});
				
				// Cancel Button
				JButton btnCancel = new JButton("Cancel");
				btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 15));
				btnCancel.setBounds(233, 217, 190, 21);
				frame.getContentPane().add(btnCancel);
				btnCancel.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						frame.dispose();
					}
				});

				saved = false;
			}
		});
		
		////////////////////////////////////////////////////////////////////////	Delete Relationship Button 
		JButton btnDeleteRel = new JButton("Delete");
		btnDeleteRel.setBounds(220, 136, 97, 21);
		frmJambl.getContentPane().add(btnDeleteRel);
		btnDeleteRel.setName("DeleteRelM");
		btnDeleteRel.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
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
				
				JLabel lblClass1 = new JLabel("Class Name:");
				lblClass1.setFont(new Font("Tahoma", Font.PLAIN, 15));
				lblClass1.setBounds(10, 54, 134, 13);
				frame.getContentPane().add(lblClass1);
				
				JLabel lblClass2 = new JLabel("Class with relationship to delete:");
				lblClass2.setFont(new Font("Tahoma", Font.PLAIN, 15));
				lblClass2.setBounds(10, 108, 255, 13);
				frame.getContentPane().add(lblClass2);
				lblClass2.setVisible(false);
				
				///////////////////////////////
				//******* Combo Boxes *******//
				///////////////////////////////

				JComboBox<Object> cdClass2 = new JComboBox<Object>();
				cdClass2.setModel(new DefaultComboBoxModel<Object>(getList("Class", null, null)));
				cdClass2.setBounds(10, 131, 134, 21);
				frame.getContentPane().add(cdClass2);
				cdClass2.setVisible(false);
				
				JComboBox<Object> cbClass1 = new JComboBox<Object>();
				cbClass1.setModel(new DefaultComboBoxModel<Object>(getList("Class", null, null)));
				cbClass1.setBounds(10, 77, 134, 21);
				frame.getContentPane().add(cbClass1);
				cbClass1.addItemListener(new ItemListener() {
					public void itemStateChanged(ItemEvent arg0) {
						cdClass2.setVisible(true);
						lblClass2.setVisible(true);
					}
				});
				
				///////////////////////////
				//******* Buttons *******//
				///////////////////////////

				JButton btnDeleteRelationship = new JButton("Delete Relationship");
				btnDeleteRelationship.setFont(new Font("Tahoma", Font.PLAIN, 15));
				btnDeleteRelationship.setBounds(10, 172, 186, 21);
				frame.getContentPane().add(btnDeleteRelationship);
				btnDeleteRelationship.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								if(!cbClass1.getSelectedItem().equals("Choose a class:") || !cdClass2.getSelectedItem().equals("Choose a class:") ) {

									////////////////////////////////////////////////////////
									controller.deleteRelationship(cbClass1.getSelectedItem().toString(), 
									cdClass2.getSelectedItem().toString());
									/////////////////////////////////////////////////////////////

									frame.dispose();
								}
								else
								{
									classSelect();
								}

							}
						});

				
				JButton btnCancel = new JButton("Cancel");
				btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 15));
				btnCancel.setBounds(240, 172, 186, 21);
				frame.getContentPane().add(btnCancel);
				frame.setVisible(true);
				btnCancel.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						frame.dispose();
					}
				});

				saved = false;
				
			}
		});
		
		////////////////////////////////////////////////////////////////////////	Change Relationship Type Button 
		JButton btnChangeType = new JButton("Change Type");
		btnChangeType.setBounds(220, 165, 97, 21);
		frmJambl.getContentPane().add(btnChangeType);
		btnChangeType.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame frmJamblChange = new JFrame("JAMBL - Change Relationship Type");
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
				
				JLabel lblClass1 = new JLabel("Class 1:");
				lblClass1.setFont(new Font("Tahoma", Font.PLAIN, 15));
				lblClass1.setBounds(10, 55, 63, 13);
				frmJamblChange.getContentPane().add(lblClass1);
				
				JLabel lblRelationship = new JLabel("New Relationship Type:");
				lblRelationship.setFont(new Font("Tahoma", Font.PLAIN, 15));
				lblRelationship.setBounds(10, 171, 168, 13);
				frmJamblChange.getContentPane().add(lblRelationship);
				lblRelationship.setVisible(false);
				
				JLabel lblClass2 = new JLabel("Class 2:");
				lblClass2.setFont(new Font("Tahoma", Font.PLAIN, 15));
				lblClass2.setBounds(10, 109, 63, 13);
				frmJamblChange.getContentPane().add(lblClass2);
				lblClass2.setVisible(false);
				//////////////////////////////
				//******* Combo Boxes*******//
				//////////////////////////////
			
				JComboBox<Object> cbRelationships = new JComboBox<Object>();
				cbRelationships.setModel(new DefaultComboBoxModel<Object>(new String[] {"Choose a relationship type:", "Aggregation", 
						"Realization", "Inheritance", "Composition"}));
				cbRelationships.setBounds(10, 194, 111, 21);
				frmJamblChange.getContentPane().add(cbRelationships);
				cbRelationships.setVisible(false);
				
				JComboBox<Object> cbClass2 = new JComboBox<Object>();
				cbClass2.setModel(new DefaultComboBoxModel<Object>(getList("Class", null, null)));
				cbClass2.setBounds(10, 131, 111, 21);
				frmJamblChange.getContentPane().add(cbClass2);
				cbClass2.setVisible(false);
				cbClass2.addItemListener(new ItemListener() {
					public void itemStateChanged(ItemEvent arg0) {
						cbRelationships.setVisible(true);
						lblRelationship.setVisible(true);
					}
				});
				JComboBox<Object> cbClass1 = new JComboBox<Object>();
				cbClass1.setModel(new DefaultComboBoxModel<Object>(getList("Class", null, null)));
				cbClass1.setBounds(10, 78, 111, 21);
				frmJamblChange.getContentPane().add(cbClass1);
				cbClass1.addItemListener(new ItemListener() {
					public void itemStateChanged(ItemEvent arg0) {
						cbClass2.setVisible(true);
						lblClass2.setVisible(true);
					}
				});
				/////////////////////////////
				///******* Buttons *******///
				/////////////////////////////
				

				JButton bteditRelType = new JButton("Change Type");
				bteditRelType.setFont(new Font("Tahoma", Font.PLAIN, 15));
				bteditRelType.setBounds(10, 249, 178, 21);
				frmJamblChange.getContentPane().add(bteditRelType);
				bteditRelType.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						if(!cbClass1.getSelectedItem().equals("Choose a class:") || !cbClass2.getSelectedItem().equals("Choose a class:") ) {
							////////////////////////////////////////////////////////
							controller.editRelationshipType(cbClass1.getSelectedItem().toString(), 
							cbClass2.getSelectedItem().toString(), cbRelationships.getSelectedItem().toString());
							/////////////////////////////////////////////////////////////
							frmJamblChange.dispose();
						}
						else
						{
							classSelect();
						}


						frmJamblChange.dispose();
					}
				});
				
				JButton btnCancel = new JButton("Cancel");
				btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 15));
				btnCancel.setBounds(248, 249, 178, 21);
				frmJamblChange.getContentPane().add(btnCancel);
				frmJamblChange.setVisible(true);
				btnCancel.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						frmJamblChange.dispose();
					}
				});
				

				saved = false;
			}
		});
		
		////////////////////////////////////////////////////////////////////////	Save Button 
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
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
				
				JTextField txtDefaulttxt = new JTextField();
				txtDefaulttxt.setText("DEFAULT.json");
				txtDefaulttxt.setBounds(92, 94, 235, 19);
				frame.getContentPane().add(txtDefaulttxt);
				txtDefaulttxt.setColumns(10);

				///////////////////////////
				//******* Buttons *******//
				///////////////////////////
				
				JButton btnSave = new JButton("Save");
				//JTextField textField = new JTextField();
				btnSave.setFont(new Font("Tahoma", Font.PLAIN, 15));
				btnSave.setBounds(92, 158, 85, 21);
				frame.getContentPane().add(btnSave);
				btnSave.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String text = txtDefaulttxt.getText();
						if(!text.equals("")){
							controller.save(text);
							frame.dispose();
						}
						else
						{
							System.out.println("Outside if statement");
						}
					}
				});
				
				JButton btnCancel = new JButton("Cancel");
				btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 15));
				btnCancel.setBounds(242, 158, 85, 21);
				frame.getContentPane().add(btnCancel);
				frame.setVisible(true);
				saved = true;
			}
		});
		btnSave.setBounds(10, 412, 85, 21);
		frmJambl.getContentPane().add(btnSave);
		
		//////////////////////////////////////////////////////////////////////// Load Button
		JButton btnLoad = new JButton("Load");
		btnLoad.setBounds(10, 445, 85, 21);
		frmJambl.getContentPane().add(btnLoad);
		btnLoad.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
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
				
				JTextField textField = new JTextField();
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
						
				JButton btnDefault = new JButton("Default");
				btnDefault.setFont(new Font("Tahoma", Font.PLAIN, 15));
				btnDefault.setBounds(176, 85, 85, 21);
				frame.getContentPane().add(btnDefault);
				frame.setVisible(true);
				btnDefault.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						textField.setText("DEFAULT.json");
					}
				});
				
				JButton btnLoad = new JButton("Load");
				btnLoad.setFont(new Font("Tahoma", Font.PLAIN, 15));
				btnLoad.setBounds(113, 114, 85, 21);
				frame.getContentPane().add(btnLoad);
				btnLoad.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String text = textField.getText();
						if(!text.equals("")){
							
							controller.load(text);
							frame.dispose();
						}
						else
						{
							
						}
					}
				});

				JButton btnCancel = new JButton("Cancel");
				btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 15));
				btnCancel.setBounds(243, 114, 85, 21);
				frame.getContentPane().add(btnCancel);
				frame.setVisible(true);
				btnCancel.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								frame.dispose();
							}
				});

				saved = false;
			}
		});
		
		
		////////////////////////////////////////////////////////////// List All Button - displays entire UML diagram
		JButton btnListAll = new JButton("List All");
		btnListAll.setBounds(10, 649, 137, 21);
		frmJambl.getContentPane().add(btnListAll);
		btnListAll.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
		
			}
		});
		
		////////////////////////////////////////////////////////////// List Relationships Button - displays list of relationships
		JButton btnListRelationships = new JButton("List Relationships");
		btnListRelationships.setBounds(10, 682, 137, 21);
		frmJambl.getContentPane().add(btnListRelationships);
		btnListRelationships.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				textAreaMain.insert("Test", 0);
			}
		});
		
		//////////////////////////////////////////////////////////////////////// List a class button - displays a singular class of a specified name
		JButton btnListClass = new JButton("List a Class");
		btnListClass.setBounds(10, 616, 137, 21);
		frmJambl.getContentPane().add(btnListClass);
		btnListClass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
			
				/// List Class Button
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
			
				/// Cancel Button
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
				
				JComboBox<Object> cbClasses = new JComboBox<Object>();
				cbClasses.setBounds(10, 77, 207, 21);
				frame.getContentPane().add(cbClasses);

			}
		});
		
		
		////////////////////////////////////////////////////////////////////////////////// Add Parameter Button
		JButton btnAddParameter = new JButton("Add");
		btnAddParameter.setBounds(10, 259, 97, 21);
		frmJambl.getContentPane().add(btnAddParameter);
		btnAddParameter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame frmJamblAdd = new JFrame("JAMBL - Add Parameter");
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
				
				////////////////////////////
				//******* Text Box *******//
				////////////////////////////

				JTextField textParameter = new JTextField();
				textParameter.setBounds(10, 200, 161, 19);
				frmJamblAdd.getContentPane().add(textParameter);
				textParameter.setColumns(10);
				
				
				///////////////////////////
				//******* Buttons *******//
				///////////////////////////
				
				// Add Class Button
				JButton btnAddParameter = new JButton("Add Parameter");
				btnAddParameter.setFont(new Font("Tahoma", Font.PLAIN, 15));
				btnAddParameter.setBounds(10, 260, 190, 21);
				frmJamblAdd.getContentPane().add(btnAddParameter);
				btnAddParameter.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
					}
				});
				
				/// Cancel Button
				JButton btnCancel = new JButton("Cancel");
				btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 15));
				btnCancel.setBounds(233, 260, 190, 21);
				frmJamblAdd.getContentPane().add(btnCancel);
				btnCancel.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						frmJamblAdd.dispose();
					}
				});
				
				//////////////////////////////
				//******* Combo Boxes*******//
				//////////////////////////////
				
				JComboBox<Object> cbMethods = new JComboBox<Object>();
				cbMethods.setBounds(10, 136, 161, 21);
				frmJamblAdd.getContentPane().add(cbMethods);
				cbMethods.setModel(new DefaultComboBoxModel<Object>(new String[] {"Choose a method:"}));
				
				
				
				JComboBox<Object> cbClasses = new JComboBox<Object>();
				cbClasses.setModel(new DefaultComboBoxModel<Object>(new String[] {"Choose a class:"}));
				cbClasses.setBounds(10, 74, 161, 21);
				frmJamblAdd.getContentPane().add(cbClasses);
				cbClasses.addItemListener(new ItemListener() {
							public void itemStateChanged(ItemEvent arg0) {
								cbMethods.setVisible(true);
								lblMethod.setVisible(true);
							}
				});
				saved = false;
			}
		});
		
		////////////////////////////////////////////////////////////////////////	Remove Parameter Button
		JButton btnDeleteParameter = new JButton("Remove");
		btnDeleteParameter.setBounds(10, 292, 97, 21);
		frmJambl.getContentPane().add(btnDeleteParameter);
		btnDeleteParameter.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
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
				
				JLabel lblParameter = new JLabel("Parameter:");
				lblParameter.setFont(new Font("Tahoma", Font.PLAIN, 15));
				lblParameter.setBounds(10, 193, 82, 13);
				frmJamblAdd.getContentPane().add(lblParameter);
				lblParameter.setVisible(false);
				
				JLabel lblMethod = new JLabel("Method:");
				lblMethod.setFont(new Font("Tahoma", Font.PLAIN, 15));
				lblMethod.setBounds(10, 113, 136, 13);
				frmJamblAdd.getContentPane().add(lblMethod);
				lblMethod.setVisible(false);
				
				///////////////////////////
				//******* Buttons *******//
				///////////////////////////
				
				////////////////////////////////////////////////////////////// Remove Parameter Button
				JButton btnRemoveParameter = new JButton("Delete Parameter");
				btnRemoveParameter.setForeground(new Color(255, 0, 0));
				btnRemoveParameter.setFont(new Font("Tahoma", Font.PLAIN, 15));
				btnRemoveParameter.setBounds(10, 296, 190, 21);
				frmJamblAdd.getContentPane().add(btnRemoveParameter);
				btnRemoveParameter.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
					}
				});
				
				////////////////////////////////////////////////////////////// Cancel Button
				JButton btnCancel = new JButton("Cancel");
				btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 15));
				btnCancel.setBounds(233, 296, 190, 21);
				frmJamblAdd.getContentPane().add(btnCancel);
				btnCancel.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						frmJamblAdd.dispose();
					}
				});
				
				//// DeleteAllButton
				JButton btnDeleteAll = new JButton("DELETE ALL PARAMETERS");
				btnDeleteAll.setForeground(new Color(255, 0, 0));
				btnDeleteAll.setFont(new Font("Tahoma", Font.PLAIN, 15));
				btnDeleteAll.setBounds(103, 327, 222, 21);
				frmJamblAdd.getContentPane().add(btnDeleteAll);
				btnDeleteAll.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
					}
				});
				
				//////////////////////////////
				//******* Combo Boxes*******//
				//////////////////////////////
				
				JComboBox<Object> cbParameter = new JComboBox<Object>();
				cbParameter.setModel(new DefaultComboBoxModel<Object>(new String[] {"Choose a Parameter:"}));
				cbParameter.setBounds(10, 216, 161, 21);
				frmJamblAdd.getContentPane().add(cbParameter);
				cbParameter.setVisible(false);
				
				JComboBox<Object> cdMethods = new JComboBox<Object>();
				cdMethods.setBounds(10, 136, 161, 21);
				frmJamblAdd.getContentPane().add(cdMethods);
				cdMethods.setModel(new DefaultComboBoxModel<Object>(new String[] {"Choose a Method:"}));
				cdMethods.setVisible(false);
				cdMethods.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent arg0) {
						cbParameter.setVisible(true);
						lblParameter.setVisible(true);
				}
				});
				
				JComboBox<Object> cbClasses = new JComboBox<Object>();
				cbClasses.setModel(new DefaultComboBoxModel<Object>(new String[] {"Choose a class:"}));
				cbClasses.setBounds(10, 74, 161, 21);
				frmJamblAdd.getContentPane().add(cbClasses);
				cbClasses.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent arg0) {
						cdMethods.setVisible(true);
						lblMethod.setVisible(true);
				}
				});
				saved = false;
				
			}
		});
		
		//////////////////////////////////////////////////////////////////////// Change Parameter Button
		JButton btnChangeParameter = new JButton("Change");
		btnChangeParameter.setBounds(10, 325, 97, 21);
		frmJambl.getContentPane().add(btnChangeParameter);
		btnChangeParameter.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
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
				
				JLabel lblParameter = new JLabel("Parameter Name:");
				lblParameter.setFont(new Font("Tahoma", Font.PLAIN, 15));
				lblParameter.setBounds(10, 177, 136, 13);
				frmJamblAdd.getContentPane().add(lblParameter);
				lblParameter.setVisible(false);
				
				JLabel lblNewParameterName = new JLabel("New Parameter Name:");
				lblNewParameterName.setFont(new Font("Tahoma", Font.PLAIN, 15));
				lblNewParameterName.setBounds(9, 237, 158, 13);
				frmJamblAdd.getContentPane().add(lblNewParameterName);
				lblNewParameterName.setVisible(false);
				
				////////////////////////////
				//******* Text Box *******//
				////////////////////////////

				JTextField textParameter = new JTextField();
				textParameter.setBounds(8, 258, 161, 19);
				frmJamblAdd.getContentPane().add(textParameter);
				textParameter.setColumns(10);
				textParameter.setVisible(false);
				
				
				///////////////////////////
				//******* Buttons *******//
				///////////////////////////
				
				// Change Parameter Button
				JButton btnChangeParameter = new JButton("Change Parameter");
				btnChangeParameter.setFont(new Font("Tahoma", Font.PLAIN, 15));
				btnChangeParameter.setBounds(11, 299, 190, 21);
				frmJamblAdd.getContentPane().add(btnChangeParameter);
				btnChangeParameter.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
					}
				});
				
			    // Cancel Button
				JButton btnCancel = new JButton("Cancel");
				btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 15));
				btnCancel.setBounds(224, 298, 190, 21);
				frmJamblAdd.getContentPane().add(btnCancel);
				btnCancel.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						frmJamblAdd.dispose();
					}
				});
				
				//////////////////////////////
				//******* Combo Boxes*******//
				//////////////////////////////
				
				JComboBox<Object> cbParameters = new JComboBox<Object>();
				cbParameters.setModel(new DefaultComboBoxModel<Object>(new String[] {"Choose a parameter", "Parameter1"}));
				cbParameters.setBounds(10, 200, 161, 21);
				frmJamblAdd.getContentPane().add(cbParameters);
				cbParameters.setVisible(false);
				cbParameters.addItemListener(new ItemListener() {
					public void itemStateChanged(ItemEvent arg0) {
						textParameter.setVisible(true);
						lblNewParameterName.setVisible(true);
					}
				});	
				
				JComboBox<Object> cbMethods = new JComboBox<Object>();
				cbMethods.setBounds(10, 136, 161, 21);
				frmJamblAdd.getContentPane().add(cbMethods);
				cbMethods.setModel(new DefaultComboBoxModel<Object>(new String[] {"Choose a method:", "Method1"})); 
				cbMethods.setVisible(false);
				cbMethods.addItemListener(new ItemListener() {
					public void itemStateChanged(ItemEvent arg0) {
						cbParameters.setVisible(true);
						lblParameter.setVisible(true);
					}
				});

				
				JComboBox<Object> cbClasses = new JComboBox<Object>();
				cbClasses.setModel(new DefaultComboBoxModel<Object>(new String[] {"Choose a class:", "Class1"}));
				cbClasses.setBounds(10, 74, 161, 21);
				frmJamblAdd.getContentPane().add(cbClasses);
				cbClasses.addItemListener(new ItemListener() {
					public void itemStateChanged(ItemEvent arg0) {
						cbMethods.setVisible(true);
						lblMethod.setVisible(true);
					}
				});
				saved = false;
			}
		});
		
		//////////////////////////////////////////////////////////////////////// Add Method Button
		JButton btnAddMethod = new JButton("Add");
		btnAddMethod.setBounds(220, 256, 97, 21);
		frmJambl.getContentPane().add(btnAddMethod);
		btnAddMethod.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				JFrame frmJamblAdd = new JFrame("JAMBL - Add Class");
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
				
				JLabel lblMethodName = new JLabel("Method Name");
				lblMethodName.setFont(new Font("Tahoma", Font.PLAIN, 15));
				lblMethodName.setBounds(27, 78, 106, 18);
				frmJamblAdd.getContentPane().add(lblMethodName);
				lblMethodName.setVisible(false);
				
				JLabel lblClass = new JLabel("Class:");
				lblClass.setFont(new Font("Tahoma", Font.PLAIN, 15));
				lblClass.setBounds(30, 49, 45, 13);
				frmJamblAdd.getContentPane().add(lblClass);
				
				JLabel lblMethodType = new JLabel("Method Type:");
				lblMethodType.setFont(new Font("Tahoma", Font.PLAIN, 15));
				lblMethodType.setBounds(27, 101, 106, 19);
				frmJamblAdd.getContentPane().add(lblMethodType);
				lblMethodType.setVisible(false);
				
				////////////////////////////////
				///******* Text Boxes *******///
				////////////////////////////////
				
				JTextField methodNameBox = new JTextField();
				methodNameBox.setBounds(132, 80, 227, 19);
				frmJamblAdd.getContentPane().add(methodNameBox);
				methodNameBox.setColumns(10);
				frmJamblAdd.setVisible(true);
				methodNameBox.setVisible(false);
				
				JTextField methodTypeBox = new JTextField();
				methodTypeBox.setColumns(10);
				methodTypeBox.setBounds(132, 103, 227, 19);
				frmJamblAdd.getContentPane().add(methodTypeBox);
				methodTypeBox.setVisible(false);
				
				///////////////////////////
				//******* Buttons *******//
				///////////////////////////
				
				////////////////////////////////////////////////////////////// Add Method Button
				JButton btnAddMethod = new JButton("Add Method");
				btnAddMethod.setFont(new Font("Tahoma", Font.PLAIN, 15));
				btnAddMethod.setBounds(85, 136, 132, 21);
				frmJamblAdd.getContentPane().add(btnAddMethod);
				btnAddMethod.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						frmJamblAdd.dispose();
					}
				});
				
				////////////////////////////////////////////////////////////// Cancel Button
				JButton btnCancel = new JButton("Cancel");
				btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 15));
				btnCancel.setBounds(227, 136, 132, 21);
				frmJamblAdd.getContentPane().add(btnCancel);
				btnCancel.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						frmJamblAdd.dispose();
					}
				});

				//////////////////////////////
				//******* Combo Boxes*******//
				//////////////////////////////

				JComboBox<Object> comboBoxClasses = new JComboBox<Object>();
				comboBoxClasses.setModel(new DefaultComboBoxModel<Object>(new String[] {"Choose a class: ", "Class1"}));
				comboBoxClasses.setBounds(85, 47, 132, 21);
				frmJamblAdd.getContentPane().add(comboBoxClasses);
				comboBoxClasses.addItemListener(new ItemListener() {
					public void itemStateChanged(ItemEvent arg0) {
						lblMethodName.setVisible(true);
						lblMethodType.setVisible(true);
						methodNameBox.setVisible(true);
						methodTypeBox.setVisible(true);
					}
				});
				saved = false;
			}
		});
		
		//////////////////////////////////////////////////////////////////////// Change Method Button
		JButton btnRefactor = new JButton("Change");
		btnRefactor.setBounds(220, 289, 97, 21);
		frmJambl.getContentPane().add(btnRefactor);
		btnRefactor.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				JFrame frmJamblAdd = new JFrame("JAMBL - Change Method Type");
				frmJamblAdd.setTitle("JAMBL - Change Method");
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
				
				JLabel lblNewLabel = new JLabel("New Method Type:");
				lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
				lblNewLabel.setBounds(10, 202, 146, 13);
				frmJamblAdd.getContentPane().add(lblNewLabel);
				lblNewLabel.setVisible(false);
				
				JLabel lblMethod= new JLabel("Method Name:");
				lblMethod.setFont(new Font("Tahoma", Font.PLAIN, 12));
				lblMethod.setBounds(10, 113, 161, 13);
				frmJamblAdd.getContentPane().add(lblMethod);
				lblMethod.setVisible(false);
				
				//////////////////////////////
				//******* Text Field *******//
				//////////////////////////////
				
				JTextField textField = new JTextField();
				textField.setBounds(142, 201, 265, 19);
				frmJamblAdd.getContentPane().add(textField);
				textField.setColumns(10);
				textField.setVisible(false);
				
				///////////////////////////
				//******* Buttons *******//
				///////////////////////////
				
				////////////////////////////////////////////////////////////// Change Method Button
				JButton btnChangeMethod = new JButton("Change Method");
				btnChangeMethod.setFont(new Font("Tahoma", Font.PLAIN, 15));
				btnChangeMethod.setBounds(10, 253, 190, 21);
				frmJamblAdd.getContentPane().add(btnChangeMethod);
				btnChangeMethod.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
					}
				});
				
				////////////////////////////////////////////////////////////// Cancel Button
				JButton btnCancel = new JButton("Cancel");
				btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 15));
				btnCancel.setBounds(233, 253, 190, 21);
				frmJamblAdd.getContentPane().add(btnCancel);
				btnCancel.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						frmJamblAdd.dispose();
					}
				});
				
				//////////////////////////////
				//******* Combo Boxes*******//
				//////////////////////////////
				
				JComboBox<Object> Methods = new JComboBox<Object>();
				Methods.setModel(new DefaultComboBoxModel<Object>(new String[] {"Choose a method:", "Method1"}));
				Methods.setBounds(10, 136, 161, 21);
				frmJamblAdd.getContentPane().add(Methods);
				Methods.setVisible(false);
				Methods.addItemListener(new ItemListener() {
					public void itemStateChanged(ItemEvent arg0) {
						textField.setVisible(true);
						lblNewLabel.setVisible(true);
					}
				});
				
				
				JComboBox<Object> Classes = new JComboBox<Object>();
				Classes.setModel(new DefaultComboBoxModel<Object>(new String[] {"Choose a class:", "Class1", "Class2"}));
				Classes.setBounds(10, 74, 161, 21);
				frmJamblAdd.getContentPane().add(Classes);
				Classes.addItemListener(new ItemListener() {
					public void itemStateChanged(ItemEvent arg0) {
						Methods.setVisible(true);
						lblMethod.setVisible(true);
					}
				});
				saved = false;
			}
		});
		
		//////////////////////////////////////////////////////////////////////// Delete Method Button
		JButton btnDeleteMethod = new JButton("Delete");
		btnDeleteMethod.setBounds(220, 355, 97, 21);
		frmJambl.getContentPane().add(btnDeleteMethod);
		btnDeleteMethod.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
				
				///////////////////////////
				//******* Buttons *******//
				///////////////////////////
				
				////////////////////////////////////////////////////////////// Add Class Button
				JButton btnDeleteMethod = new JButton("Delete Method");
				btnDeleteMethod.setForeground(new Color(255, 0, 0));
				btnDeleteMethod.setFont(new Font("Tahoma", Font.PLAIN, 15));
				btnDeleteMethod.setBounds(85, 221, 132, 21);
				frame.getContentPane().add(btnDeleteMethod);
				btnDeleteMethod.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						frame.dispose();
					}
				});
				
				////////////////////////////////////////////////////////////// Cancel Button
				JButton btnCancel = new JButton("Cancel");
				btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 15));
				btnCancel.setBounds(227, 221, 132, 21);
				frame.getContentPane().add(btnCancel);
				
			
				//////////////////////////////
				//******* Combo Boxes*******//
				//////////////////////////////
				
				
				JComboBox<Object> comboBoxClasses = new JComboBox<Object>();
				comboBoxClasses.setBounds(10, 77, 207, 21);
				frame.getContentPane().add(comboBoxClasses);
				
				JComboBox<Object> comboBoxMethods = new JComboBox<Object>();
				comboBoxMethods.setBounds(10, 130, 207, 21);
				frame.getContentPane().add(comboBoxMethods);
				btnCancel.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						frame.dispose();
					}
				});
				saved = false;
			}
		});
	
		
		//////////////////////////////////////////////////////////////////////// Rename Method Button
		JButton btnRenameMethod = new JButton("Rename");
		btnRenameMethod.setBounds(220, 322, 97, 21);
		frmJambl.getContentPane().add(btnRenameMethod);
		btnRenameMethod.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame frmJamblAdd = new JFrame("JAMBL - Change Field Name");
				frmJamblAdd.setTitle("JAMBL - Rename Method");
				frmJamblAdd.setBounds(100, 100, 447, 321);
				frmJamblAdd.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				frmJamblAdd.getContentPane().setLayout(null);
				frmJamblAdd.setVisible(true);
				
				////////////////////////////
				///******* Labels *******///
				////////////////////////////
				
				JLabel lblAddClass = new JLabel("Choose a class and choose the method");
				lblAddClass.setFont(new Font("Tahoma", Font.PLAIN, 18));
				lblAddClass.setBounds(10, 10, 338, 13);
				frmJamblAdd.getContentPane().add(lblAddClass);
				
				JLabel lblChooseM = new JLabel("* Choose a Field name");
				lblChooseM.setForeground(new Color(255, 0, 0));
				lblChooseM.setBounds(181, 140, 167, 13);
				frmJamblAdd.getContentPane().add(lblChooseM);
				lblChooseM.setVisible(false);
				
				JLabel lblClassName = new JLabel("Choose a class name:");
				lblClassName.setFont(new Font("Tahoma", Font.PLAIN, 15));
				lblClassName.setBounds(10, 33, 219, 51);
				frmJamblAdd.getContentPane().add(lblClassName);
				
				JLabel lblNewMethod = new JLabel("New Method Name:");
				lblNewMethod.setFont(new Font("Tahoma", Font.PLAIN, 15));
				lblNewMethod.setBounds(10, 202, 146, 13);
				frmJamblAdd.getContentPane().add(lblNewMethod);
				lblNewMethod.setVisible(false);
				
				JLabel lblMethod= new JLabel("Method Name:");
				lblMethod.setFont(new Font("Tahoma", Font.PLAIN, 12));
				lblMethod.setBounds(10, 113, 161, 13);
				frmJamblAdd.getContentPane().add(lblMethod);
				lblMethod.setVisible(false);
				
				//////////////////////////////
				///******* Text Box *******///
				//////////////////////////////
				
				JTextField textField = new JTextField();
				textField.setBounds(142, 201, 265, 19);
				frmJamblAdd.getContentPane().add(textField);
				textField.setColumns(10);
				textField.setVisible(false);
			
				///////////////////////////
				//******* Buttons *******//
				///////////////////////////
				
				/// Change Method Name Button
				JButton btnChangeMethod = new JButton("Change Method Name");
				btnChangeMethod.setFont(new Font("Tahoma", Font.PLAIN, 15));
				btnChangeMethod.setBounds(10, 253, 190, 21);
				frmJamblAdd.getContentPane().add(btnChangeMethod);
				btnChangeMethod.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
					}
				});
				
				// Cancel Button
				JButton btnCancel = new JButton("Cancel");
				btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 15));
				btnCancel.setBounds(233, 253, 190, 21);
				frmJamblAdd.getContentPane().add(btnCancel);
				btnCancel.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						frmJamblAdd.dispose();
					}
				});
				
				JComboBox<Object> Methods = new JComboBox<Object>();
				Methods.setModel(new DefaultComboBoxModel<Object>(new String[] {"Choose a method:", "Method1"}));
				Methods.setBounds(10, 136, 161, 21);
				frmJamblAdd.getContentPane().add(Methods);
				Methods.setVisible(false);
				Methods.addItemListener(new ItemListener() {
					public void itemStateChanged(ItemEvent arg0) {
						textField.setVisible(true);
						lblNewMethod.setVisible(true);
					}
				});
					
				JComboBox<Object> Classes = new JComboBox<Object>();
				Classes.setModel(new DefaultComboBoxModel<Object>(new String[] {"Choose a class:", "Class1", "Class2"}));
				Classes.setBounds(10, 74, 161, 21);
				frmJamblAdd.getContentPane().add(Classes);
				Classes.addItemListener(new ItemListener() {
					public void itemStateChanged(ItemEvent arg0) {
						Methods.setVisible(true);
						lblMethod.setVisible(true);
					}
				});
				saved = false;
			}
		});
		
		//////////////////////////////////////////////////////////////////////// Add Field Button
		JButton btnAddField = new JButton("Add");
		btnAddField.setBounds(220, 437, 97, 21);
		frmJambl.getContentPane().add(btnAddField);
		btnAddField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
				
				JLabel lblField = new JLabel("Field Name:");
				lblField.setFont(new Font("Tahoma", Font.PLAIN, 15));
				lblField.setBounds(10, 108, 108, 13);
				frame.getContentPane().add(lblField);
				lblField.setVisible(false);
				
				JLabel lblFieldType = new JLabel("Field Type:");
				lblFieldType.setFont(new Font("Tahoma", Font.PLAIN, 15));
				lblFieldType.setBounds(10, 148, 108, 18);
				frame.getContentPane().add(lblFieldType);
				lblFieldType.setVisible(false);
				
				//////////////////////////////
				//******* Text Boxes *******//
				//////////////////////////////
				
				JTextField fieldNameBox = new JTextField();
				fieldNameBox.setBounds(121, 107, 227, 19);
				fieldNameBox.setColumns(10);
				frame.getContentPane().add(fieldNameBox);
				fieldNameBox.setVisible(false);
				
				JTextField fieldTypeBox = new JTextField();
				fieldTypeBox.setColumns(10);
				fieldTypeBox.setBounds(121, 147, 227, 19);
				frame.getContentPane().add(fieldTypeBox);
				fieldTypeBox.setVisible(false);
				
				//////////////////////////////
				//******* Combo Boxes*******//
				//////////////////////////////
				JComboBox<Object> comboBoxClasses = new JComboBox<Object>();
				comboBoxClasses.setModel(new DefaultComboBoxModel<Object>(getList("Class", null, null)));
				comboBoxClasses.setBounds(10, 66, 124, 21);
				frame.getContentPane().add(comboBoxClasses);
				comboBoxClasses.addItemListener(new ItemListener() {
					public void itemStateChanged(ItemEvent arg0) {
						lblField.setVisible(true);
						lblFieldType.setVisible(true);
						fieldNameBox.setVisible(true);
						fieldTypeBox.setVisible(true);
					}
				});
				
				///////////////////////////
				//******* Buttons *******//
				///////////////////////////
				
				// Add Field Button
				JButton btnAddField = new JButton("Add Field");
				btnAddField.setFont(new Font("Tahoma", Font.PLAIN, 15));
				btnAddField.setBounds(85, 204, 132, 21);
				frame.getContentPane().add(btnAddField);
				btnAddField.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(!fieldNameBox.getText().equals("") && !fieldTypeBox.getText().equals("")) {
							controller.addField(comboBoxClasses.getSelectedItem().toString(), fieldNameBox.getText(), fieldTypeBox.getText());
							frame.dispose();
						}
						else
						{
							fieldText();
						}

					}
				});
				
				/// Cancel Button
				JButton btnCancel = new JButton("Cancel");
				btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 15));
				btnCancel.setBounds(227, 204, 132, 21);
				frame.getContentPane().add(btnCancel);
				btnCancel.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						frame.dispose();
					}
				});
				

				saved = false;
			}
		});
		
		//////////////////////////////////////////////////////////////////////// Change Field Type Button
		JButton btnChangeFieldType = new JButton("Edit Type");
		btnChangeFieldType.setBounds(220, 470, 97, 21);
		frmJambl.getContentPane().add(btnChangeFieldType);
		btnChangeFieldType.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame frmJamblAdd = new JFrame("JAMBL - Change Field Type");
				frmJamblAdd.setTitle("JAMBL - Change Field Type");
				frmJamblAdd.setBounds(100, 100, 447, 321);
				frmJamblAdd.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				frmJamblAdd.getContentPane().setLayout(null);
				frmJamblAdd.setVisible(true);
				

				////////////////////////////
				///******* Labels *******///
				////////////////////////////
				
				JLabel lblAddClass = new JLabel("Choose a class and choose the field name.");
				lblAddClass.setFont(new Font("Tahoma", Font.PLAIN, 18));
				lblAddClass.setBounds(10, 10, 371, 13);
				frmJamblAdd.getContentPane().add(lblAddClass);
				
				JLabel lblChooseM = new JLabel("* Choose a Field name");
				lblChooseM.setForeground(new Color(255, 0, 0));
				lblChooseM.setBounds(181, 140, 167, 13);
				frmJamblAdd.getContentPane().add(lblChooseM);
				lblChooseM.setVisible(false);
				
				JLabel lblClassName = new JLabel("Choose a class name:");
				lblClassName.setFont(new Font("Tahoma", Font.PLAIN, 15));
				lblClassName.setBounds(10, 33, 219, 51);
				frmJamblAdd.getContentPane().add(lblClassName);
				
				JLabel lblNewFType = new JLabel("New Field Type:");
				lblNewFType.setFont(new Font("Tahoma", Font.PLAIN, 15));
				lblNewFType.setBounds(10, 202, 146, 13);
				frmJamblAdd.getContentPane().add(lblNewFType);
				lblNewFType.setVisible(false);
				
				JLabel lblField= new JLabel("Field Name:");
				lblField.setFont(new Font("Tahoma", Font.PLAIN, 15));
				lblField.setBounds(10, 113, 161, 13);
				frmJamblAdd.getContentPane().add(lblField);
				lblField.setVisible(false);
				
				////////////////////////////
				//******* Text Box *******//
				////////////////////////////
				
				JTextField textFieldType = new JTextField();
				textFieldType.setBounds(142, 201, 265, 19);
				frmJamblAdd.getContentPane().add(textFieldType);
				textFieldType.setColumns(10);
				textFieldType.setVisible(false);
				
				//////////////////////////////
				//******* Combo Boxes*******//
				//////////////////////////////
				
				JComboBox<Object> Fields = new JComboBox<Object>();
				Fields.setBounds(10, 136, 161, 21);
				frmJamblAdd.getContentPane().add(Fields);
				Fields.setVisible(false);
				Fields.addItemListener(new ItemListener() {
					public void itemStateChanged(ItemEvent arg0) {
						textFieldType.setVisible(true);
						lblNewFType.setVisible(true);
					}
				});
				
				
				JComboBox<Object> Classes = new JComboBox<Object>();
				Classes.setModel(new DefaultComboBoxModel<Object>(getList("Class", null, null)));
				Classes.setBounds(10, 74, 161, 21);
				frmJamblAdd.getContentPane().add(Classes);
				Classes.addItemListener(new ItemListener() {
					public void itemStateChanged(ItemEvent arg0) {
						Fields.setModel(new DefaultComboBoxModel<Object>(getList("Field", Classes.getSelectedItem().toString(), null)));
						Fields.setVisible(true);
						lblField.setVisible(true);
					}
				});
				///////////////////////////
				//******* Buttons *******//
				///////////////////////////
				
				////////////////////////////////////////////////////////////// Change Method Button
				JButton btnChangeField = new JButton("Change Field");
				btnChangeField.setFont(new Font("Tahoma", Font.PLAIN, 15));
				btnChangeField.setBounds(10, 253, 190, 21);
				frmJamblAdd.getContentPane().add(btnChangeField);
				btnChangeField.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						controller.changeFieldType(Classes.getSelectedItem().toString(), Fields.getSelectedItem().toString(), textFieldType.getText());
						frmJamblAdd.dispose();
					}
				});
				
				////////////////////////////////////////////////////////////// Cancel Button
				JButton btnCancel = new JButton("Cancel");
				btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 15));
				btnCancel.setBounds(233, 253, 190, 21);
				frmJamblAdd.getContentPane().add(btnCancel);
				btnCancel.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						frmJamblAdd.dispose();
					}
				});
				

				saved = false;
			}
		});
		
		//////////////////////////////////////////////////////////////////////// Delete Field Button
		JButton btnDeleteField = new JButton("Delete");
		btnDeleteField.setBounds(220, 536, 97, 21);
		frmJambl.getContentPane().add(btnDeleteField);
		btnDeleteField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame frmJamblAdd = new JFrame("JAMBL - Delete Field Name");
				frmJamblAdd.setBounds(100, 100, 447, 258);
				frmJamblAdd.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				frmJamblAdd.getContentPane().setLayout(null);
				frmJamblAdd.setVisible(true);
				
				////////////////////////////
				///******* Labels *******///
				////////////////////////////
				
				JLabel lblAddClass = new JLabel("Choose a class and choose the field.");
				lblAddClass.setFont(new Font("Tahoma", Font.PLAIN, 18));
				lblAddClass.setBounds(10, 10, 338, 13);
				frmJamblAdd.getContentPane().add(lblAddClass);
				
				JLabel lblClassName = new JLabel("Choose a class name:");
				lblClassName.setFont(new Font("Tahoma", Font.PLAIN, 15));
				lblClassName.setBounds(10, 33, 219, 51);
				frmJamblAdd.getContentPane().add(lblClassName);
				
				JLabel lblField= new JLabel("Field Name:");
				lblField.setFont(new Font("Tahoma", Font.PLAIN, 15));
				lblField.setBounds(10, 113, 161, 13);
				frmJamblAdd.getContentPane().add(lblField);
				lblField.setVisible(false);
				
				//////////////////////////////
				//******* Combo Boxes*******//
				//////////////////////////////
				
				JComboBox<Object> cbFields = new JComboBox<Object>();
				
				cbFields.setBounds(10, 136, 161, 21);
				frmJamblAdd.getContentPane().add(cbFields);
				cbFields.setVisible(false);
				cbFields.addItemListener(new ItemListener() {
					public void itemStateChanged(ItemEvent arg0) {
						
					}
				});
				
				JComboBox<Object> Classes = new JComboBox<Object>();
				Classes.setModel(new DefaultComboBoxModel<Object>(getList("Class", null, null)));
				Classes.setBounds(10, 74, 161, 21);
				frmJamblAdd.getContentPane().add(Classes);
				Classes.addItemListener(new ItemListener() {
					public void itemStateChanged(ItemEvent arg0) {
						cbFields.setModel(new DefaultComboBoxModel<Object>(getList("Field", Classes.getSelectedItem().toString(), null)));
					}
				});
				
				///////////////////////////
				//******* Buttons *******//
				///////////////////////////
				
				//////////////////////////////////////////////////////////////  CDelete Field
				JButton btnDeleteField = new JButton("Delete Field");
				btnDeleteField.setForeground(new Color(255, 0, 0));
				btnDeleteField.setFont(new Font("Tahoma", Font.PLAIN, 15));
				btnDeleteField.setBounds(10, 189, 190, 21);
				frmJamblAdd.getContentPane().add(btnDeleteField);
				btnDeleteField.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent e) {
						if(!(Classes.getSelectedIndex() == -1) && !(cbFields.getSelectedIndex() == -1)) {
							controller.deleteField(Classes.getSelectedItem().toString(), cbFields.getSelectedItem().toString());
							frmJamblAdd.dispose();
						}

					}
				});
				
				////////////////////////////////////////////////////////////// Cancel Button
				JButton btnCancel = new JButton("Cancel");
				btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 15));
				btnCancel.setBounds(233, 189, 190, 21);
				frmJamblAdd.getContentPane().add(btnCancel);
				btnCancel.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						frmJamblAdd.dispose();
					}
				});
				

				saved = false;
			}
		});
		
		//////////////////////////////////////////////////////////////////////// Rename Field Button
		JButton btnRenameField = new JButton("Rename");
		btnRenameField.setBounds(220, 503, 97, 21);
		frmJambl.getContentPane().add(btnRenameField);
		btnRenameField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame frmJamblAdd = new JFrame("JAMBL - Change Field Name");
				frmJamblAdd.setTitle("JAMBL - Rename Field");
				frmJamblAdd.setBounds(100, 100, 447, 321);
				frmJamblAdd.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				frmJamblAdd.getContentPane().setLayout(null);
				frmJamblAdd.setVisible(true);
				
				////////////////////////////
				///******* Labels *******///
				////////////////////////////
				
				JLabel lblAddClass = new JLabel("Choose a class and choose the field.");
				lblAddClass.setFont(new Font("Tahoma", Font.PLAIN, 18));
				lblAddClass.setBounds(10, 10, 338, 13);
				frmJamblAdd.getContentPane().add(lblAddClass);
				
				JLabel lblChooseM = new JLabel("* Choose a Field name");
				lblChooseM.setForeground(new Color(255, 0, 0));
				lblChooseM.setBounds(181, 140, 167, 13);
				frmJamblAdd.getContentPane().add(lblChooseM);
				lblChooseM.setVisible(false);
				
				JLabel lblClassName = new JLabel("Choose a class name:");
				lblClassName.setFont(new Font("Tahoma", Font.PLAIN, 15));
				lblClassName.setBounds(10, 33, 219, 51);
				frmJamblAdd.getContentPane().add(lblClassName);
				
				JLabel lblNewField = new JLabel("New Field Name:");
				lblNewField.setFont(new Font("Tahoma", Font.PLAIN, 15));
				lblNewField.setBounds(10, 202, 146, 13);
				frmJamblAdd.getContentPane().add(lblNewField);
				lblNewField.setVisible(false);
				
				JLabel lblMethod= new JLabel("Field Name:");
				lblMethod.setFont(new Font("Tahoma", Font.PLAIN, 12));
				lblMethod.setBounds(10, 113, 161, 13);
				frmJamblAdd.getContentPane().add(lblMethod);
				lblMethod.setVisible(false);
				
				//////////////////////////////
				///******* Text Box *******///
				//////////////////////////////
				
				JTextField textField = new JTextField();
				textField.setBounds(142, 201, 265, 19);
				frmJamblAdd.getContentPane().add(textField);
				textField.setColumns(10);
				textField.setVisible(false);
			
				JComboBox<Object> Fields = new JComboBox<Object>();
				Fields.setBounds(10, 136, 161, 21);
				frmJamblAdd.getContentPane().add(Fields);
				Fields.setVisible(false);
				Fields.addItemListener(new ItemListener() {
					public void itemStateChanged(ItemEvent arg0) {
						textField.setVisible(true);
						lblNewField.setVisible(true);
					}
				});
				
				JComboBox<Object> Classes = new JComboBox<Object>();
				Classes.setModel(new DefaultComboBoxModel<Object>(getList("Class", null, null)));
				Classes.setBounds(10, 74, 161, 21);
				frmJamblAdd.getContentPane().add(Classes);
				Classes.addItemListener(new ItemListener() {
					public void itemStateChanged(ItemEvent arg0) {
						Fields.setModel(new DefaultComboBoxModel<Object>(getList("Field", Classes.getSelectedItem().toString(), null)));
						Fields.setVisible(true);
						lblMethod.setVisible(true);
						
					}
				});
				///////////////////////////
				//******* Buttons *******//
				///////////////////////////
				
				// Change Field Name Button
				JButton btnChangeMethod = new JButton("Change Field Name");
				btnChangeMethod.setFont(new Font("Tahoma", Font.PLAIN, 15));
				btnChangeMethod.setBounds(10, 253, 190, 21);
				frmJamblAdd.getContentPane().add(btnChangeMethod);
				btnChangeMethod.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(!textField.getText().equals("")) {
							controller.renameField(Classes.getSelectedItem().toString(), Fields.getSelectedItem().toString(), textField.getText());
							frmJamblAdd.dispose();
						}
					}
				});
				
		        // Cancel Button
				JButton btnCancel = new JButton("Cancel");
				btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 15));
				btnCancel.setBounds(233, 253, 190, 21);
				frmJamblAdd.getContentPane().add(btnCancel);
				btnCancel.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						frmJamblAdd.dispose();
					}
				});
				
			}
		});
	
		
		////////////////////////////////////////////////////////////// Save assurance window, under construction!
		frmJambl.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent windowEvent){
	      
	         } 
		});
	}
	
	public void updateTextAreaMain() {
		
	}

	//////////////////////////////////
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
		JOptionPane.showMessageDialog(f, "Failed to delete field...", "Error",JOptionPane.ERROR_MESSAGE);
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
	 * Returns a list of objects beginning with "select a <insert item type here>"
	 * 
	 * @param type The type of list to get (either Class, Field, Method, or Param (for parameter)
	 * @param className The name of a class to get a method, field, etc. Can be null if not needed
	 * @param methodName The name of a method to get parameters from. can be null if not needed
	*/
	public String[] getList(String type, String className, String methodName) {
		if(type.equals("Class")) {
			String[] classes = controller.getClassNames();
			int j = 0;
			String[] list = new String[classes.length + 1];
			list[0] = "Choose a class:";
			for(int i = 1; i < list.length; i++)
	        {
	            list[i] = classes[j];
	            j++;
	        }
			return list;
		} else if (type.equals("Field")) {
			String[] fields = controller.getFields(className);
			int j = 0;
			String[] list = new String[fields.length + 1];
			list[0] = "Choose a field:";
			for(int i = 1; i < list.length; i++)
	        {
	            list[i] = fields[j];
	            j++;
	        }
			return list;
		} else if (type.equals("Method")) {
			String[] methods = controller.getMethods(className);
			int j = 0;
			String[] list = new String[methods.length + 1];
			list[0] = "Choose a method:";
			for(int i = 1; i < list.length; i++)
	        {
	            list[i] = methods[j];
	            j++;
	        }
			return list;
		} else if (type.equals("Param")) {
			String[] params = controller.getParameters(className, methodName);
			int j = 0;
			String[] list = new String[params.length + 1];
			list[0] = "Choose a parameter:";
			for(int i = 1; i < list.length; i++)
	        {
	            list[i] = params[j];
	            j++;
	        }
			return list;
		}
		
		return null; // Shouldn't be able to return a string[] if otherwise
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
        JOptionPane.showMessageDialog(f,"Relation type changed to"+ newType + "!", "Alert", JOptionPane.WARNING_MESSAGE);
	}
	public void relDeleted() {
		JOptionPane.showMessageDialog(f, "Relationship deleted successfully", "Info",JOptionPane.INFORMATION_MESSAGE);

	}
	
}

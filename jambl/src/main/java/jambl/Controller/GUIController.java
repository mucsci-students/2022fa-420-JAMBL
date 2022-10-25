package jambl.Controller;
import jambl.Model.*;
import jambl.Model.Class;
import jambl.View.*;

import java.util.HashSet;
import java.util.Iterator;

/*
 * @projectDescription A controller specifically for use with the GUI
 * 
 * @creator John Shenk
 * @coauthors Meba Shimelis, Alex Peiffer, Lauryn Simmons, Ben Slinghof
 * @version 0.0.1
 * @dateLastModified October 3, 2022
 */

import java.util.*;

import javax.swing.JButton;
import javax.swing.event.SwingPropertyChangeSupport;

import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.io.*;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class GUIController {
	
		Model model;
		//GUIView GUI;
		
		public HashSet<Relationship> relationships = new HashSet<Relationship>();
		HashSet<draggableBox> classBoxes = new HashSet<draggableBox>();
		
		/*
		 * Constructs a new GUIController
		 */
		public GUIController(Model MODEL) {
			model = MODEL;
			
		}

		/*Creates a view and makes it visible to user. (Main window)*/
		/* Creates action listener for every button on Main window */
		public void start(){
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						GUIView GUINow = new GUIView();
						GUINow.setVisible();
						

						// Adding a Class Action Listener
						GUINow.addClassBtn().addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								
								
								addClassAction(GUINow.addingClassWindow(), GUINow);
								
							}

						});

						// Deleting Class Action Listener
						GUINow.delClassBtn().addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								deleteClassAction(GUINow.deletingClassWindow(), GUINow);
							}

						});

						// Renaming a Class Action Listener
						GUINow.renClassBtn().addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								renClassAction(GUINow.renamingClassWindow(), GUINow);	
							}

						});

						// Adding Rel Action Listener
						GUINow.btnAddRelationship.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								addingRelsAction(GUINow.addingRelsWindow(), GUINow);
								
							}

						});

						GUINow.btnDeleteRel.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								deletingRelsAction(GUINow.deletingRelsWindow(), GUINow);
								
							}

						});

						GUINow.btnChangeType.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								changingRelsAction(GUINow.changingRelsWindow(), GUINow);
							}

						});

						GUINow.btnAddMethod.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								addingMethodAction(GUINow.addingMethodWindow(), GUINow);
							}

						});

						GUINow.btnDeleteMethod.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								deletingMethodAction(GUINow.deletingMethodWindow(), GUINow);
							}

						});

						GUINow.btnRenameMethod.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								renamingMethodAction(GUINow.renamingMethodWindow(), GUINow);
							}

						});

						GUINow.btnRefactor.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								changingMethodAction(GUINow.changingMethodWindow(), GUINow);
							}

						});

						GUINow.btnAddParameter.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								addingParamAction(GUINow.addingParamWindow(), GUINow);
							}

						});

						GUINow.btnChangeParameter.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								changingParamAction(GUINow.changingParamWindow(), GUINow);
							}

						});

						GUINow.btnDeleteParameter.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								deletingParamAction(GUINow.deletingParamWindow(), GUINow);
							}

						});

						GUINow.btnAddField.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								addingFieldAction(GUINow.addingFieldWindow(), GUINow);
							}

						});

						GUINow.btnChangeFieldType.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								editingFieldAction(GUINow.editingFieldWindow(), GUINow);
							}

						});

						GUINow.btnDeleteField.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								deletingFieldAction(GUINow.deletingFieldWindow(), GUINow);
								
							}

						});

						GUINow.btnRenameField.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								renamingFieldAction(GUINow.renamingFieldWindow(), GUINow);
							}

						});


						// Load Model Action Listener
						GUINow.btnLoad.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								loadAction(GUINow.loadWindow(), GUINow);
							}

						});

						// Save Model Action Listener
						GUINow.btnSave.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								saveAction(GUINow.saveWindow(), GUINow);
							}

						});

						GUINow.btnListClass.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								listAClassAction(GUINow.listAClassWindow(), GUINow);
							
							}

						});

						// Listing Class Action Listener
						GUINow.btnListAll.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								GUINow.getMainArea().setText(listAllAction());
				
								
							}

						});

						GUINow.btnListRelationships.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								GUINow.getMainArea().setText(listRelationships());
							}

						});

						// undo button listener
						GUINow.btnUndo.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								GUINow.getMainArea().setText("undo was clicked");
				
								
							}

						});

						// redo button listener
						GUINow.btnRedo.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								GUINow.getMainArea().setText("redo was clicked");
								
							}

						});



					} catch (Exception e) {
						
						e.printStackTrace();
						
					}
				}
			});	

			
		}

		public String[] getClassNames() {
	    	return model.getClassList();
	    }
	    
	    /*
	     *  Function for GUI to add class to model
	     */
	    public void addClass(String name, GUIView GUI) {
	    	if(model.getClass(name) == null) // Class does not exist already
			{		
	    		model.addClass(name);
	    		GUI.classCreate(name);
				sendBox(name, GUI);
			}
			else
			{
				GUI.classExist();
			}
	    }
	    
	    /*
	     * Function for GUI to rename class in the model
	     */
	    public void renameClass(String name1, String name2, GUIView GUI) {
	    	if(model.getClass(name2) == null) 
			{
				model.renameClass(name1, name2);
				GUI.classRename(name1, name2);
			}
			else
			{
				GUI.classExist();
			}
	    }
	    
	    /*
	     * Function for GUI to delete class in model
	     */
	    public void deleteClass(String name, GUIView GUI) {
	    		model.deleteClass(model.getClass(name));
	    		GUI.classDelete(name);
				GUI.removeBox(name);
			
	    }

	    
	    /*
	     * Function for getting list of fields from class
	     */
	    public String[] getFields(String className) {
	    	return model.getFieldList(className);
	    }
	    
	    /*
	     * Function for getting list of fields from class
	     */
	    public String[] getMethods(String className) {
	    	return model.getMethodList(className);
	    }
	    
	    /*
	     * Function for getting list of fields from class
	     */
	    public String[] getParameters(String className, String methodName) {
	    	return model.getParameterList(className, methodName);
	    }
	    
	    
	    
	    /////////// ***** Field Methods ****** ////////////
	    public void addField(String className, String fieldName, String fieldType, GUIView GUI) {
	    	Class get = model.getClass(className);
	    	if(get.addField(fieldName, fieldType))
	    		GUI.fieldAdd(fieldName, className);
	    	else
	    		GUI.fieldAdd(fieldName, className);
	    }
	    
	    public void renameField(String className, String oldName, String newName, GUIView GUI) {
	    	Class cls = model.getClass(className);
			Field fld = cls.getField(newName);
			if (fld != null) {
	    		GUI.fieldExist();
			} else {
				cls.getField(oldName).setFieldName(newName);
	    		GUI.fieldRename(oldName, newName, className);
	    	}
		}
			
	    
	    public void deleteField(String className, String fieldName, GUIView GUI) {
	    	if(model.getClass(className).deleteField(fieldName)) {
	    		GUI.fieldDelete(fieldName, className);
	    	}
	    	else
	    	{
	    		GUI.deleteFieldFailure();
	    	}
	    }
	    
	    public void changeFieldType(String className, String fieldName, String newFieldType, GUIView GUI) {
	    	model.getClass(className).getField(fieldName).setFieldType(newFieldType);
	    	GUI.fieldTypeChange(className, fieldName, newFieldType);
	    }

	    /////////// ***** Method methods ****** ////////////
		public void addMethod (String className, String methodName, String methodReturn, GUIView GUI) {
			Class cls = model.getClass(className);
			if (cls.getMethod(methodName) != null) {
				GUI.methodExist();
			}else if (cls.addMethod(methodName, methodReturn)) {
				GUI.methodAdd(className, methodName);
			} else {
			GUI.methodActionFailure("add");
			}
		}
		public void deleteMethod (String className, String methodName, GUIView GUI) {
			Class cls = model.getClass(className);
			Method mtd = cls.getMethod(methodName);
			if (cls.deleteMethod(mtd)) {
				GUI.methodDelete(className, methodName);
			} else {
				GUI.methodActionFailure("delete");
			}
		}

		public void renameMethod (String className, String oldMtdName, String newMtdName, GUIView GUI) {
			if (oldMtdName.toUpperCase().equals(newMtdName.toUpperCase())) {
				GUI.methodExist();
			}else {
				Class cls = model.getClass(className);
				Method mtd = cls.getMethod(oldMtdName);
				if (cls.renameMethod(mtd, newMtdName)) {
					GUI.methodRename(className, oldMtdName, newMtdName);
				}else {
					GUI.methodActionFailure("rename");
			}
			}
		}

		public void changeMethodReturn (String className, String methodName, String returnType, GUIView GUI) {
			Class cls = model.getClass(className);
			Method mtd = cls.getMethod(methodName);
			if (cls.changeMethodreturn(mtd, returnType)) {
				GUI.methodRetype(className, methodName, returnType);
			}else {
				GUI.methodActionFailure("change return type of");
			}
		}
	
   
	     /////////// ***** Relationship Methods ****** ////////////

		public void addRelationship (String origin, String destination, String typeName, GUIView GUI) {
			Class cls = model.getClass(origin);		
			Relationship rel = cls.getRelationship(destination);
			if (rel != null) {
				GUI.relExists();				
			} else {
				cls.addRelationship(model.getClass(destination), typeName.toUpperCase());
				GUI.addedRel(origin, destination);
				addRelationshipGUI(origin, destination, typeName, GUI);

			}
		}


		public void deleteRelationship (String origin, String destination, GUIView GUI) {
			Class cls = model.getClass(origin);
			Relationship rel = cls.getRelationship(destination);
			if (rel == null) {
				GUI.relationshipNotExist();
			} else {
				cls.deleteRelationship(destination);
				GUI.relDeleted();
			}
				
		}

		public void editRelationshipType(String origin, String destination, String newType, GUIView GUI) {
			Relationship rel = model.getClass(origin).getRelationship(destination);
			if (rel == null) {
				GUI.relationshipNotExist();
		
			} else if (rel.getRelType().equals(newType.toUpperCase())) {
				GUI.relExists();
			}else {
				rel.setRelType(newType);     

		   	    GUI.relTypeEdited(model.getClass(destination).TypefullName(newType.toUpperCase()));
			}
		}


  
		public void save( String fileName){
			Save saving = new Save(model);
			JSONObject fileObj = new JSONObject();
			fileObj.put("classes", saving.classes());
			fileObj.put("relationships", saving.relationships());
	
			try{
				// creates new file  if ther is not one
				FileWriter file = new FileWriter(fileName);
				// turns object to string and save to file
				file.write(fileObj.toJSONString());
				file.close();
			}catch(Exception e){
				System.out.println("Could not write file" + e);
			}
		}
	
	
	
		public void load(String fileName){
			
			 Load load = new Load();
			 
			// get object of file contents
			JSONObject file = load.getFile(fileName);
	
			// adds the classes with the fields, methods and parameters ect.
			load.loadClasses(file);
	
			// loads relationships into classes
			this.model = load.loadRelationships(file);
	
		}



		public void addParameter(String class1, String method1, String name, String type, GUIView GUI){
			Class class2 = model.getClass(class1);
			Method method2 = class2.getMethod(method1);
			if(method2.addParameter(name, type)){
				GUI.paramAdd(method1, name, type);
			} else {
				GUI.addParamFailure();
			}
		}
		
		public void deleteParameter(String class1, String method1, String name, GUIView GUI){
			Class class2 = model.getClass(class1);
			Method method2 = class2.getMethod(method1);
			if(method2.deleteParameter(name)){
				GUI.paramDelete(method1, name);
			} else {
				GUI.deleteParamFailure();
			}
		}
		
		public void changeParameter(String class1, String method1, String oldname, String newname, String newtype, GUIView GUI){
			Class class2 = model.getClass(class1);
			Method method2 = class2.getMethod(method1);
			if(method2.changeParameter(oldname, newname, newtype)){
				GUI.paramChange(method1, oldname, newname, newtype);
			} else {
				GUI.changeParamFailure();
			}
		}
		
		public void removeAllParameter(String class1, String method1, GUIView GUI){
			Class class2 = model.getClass(class1);
			Method method2 = class2.getMethod(method1);
			if(method2.deleteAllParameter()){
				GUI.paramDeleteAll(method1);
			} else {
				GUI.deleteAllParamFailure();
			}
		}
	

	public String listAllClasses () {
        String list ="CLASSES \n===============\n";
        for (Class ele: model.getClasses()) {
          list = list +  listClass(ele);
        }
		return list;
	}
	public String listClass(Class cls){
		String className = cls.getClassName();
		String list = "      ";
        list = list + className + "\n===============\n";
		list = list +"     Fields:\n";
        
        for (Field fld: cls.getFields()) {
            String fieldType = fld.getFieldType();
            String fieldName = fld.getFieldName();
			list = list +"     * " + fieldType + " " + fieldName + "\n";
        }
        
        list = list +"\n     Methods:\n";
        
        for (Method mtd: cls.getMethods()) {
            String returnType = mtd.getReturnType();
            String methodName = mtd.getMethodName();
            list = list +"     * " + returnType + " " + methodName + " (";
            HashSet<Parameter> params = mtd.getParameters();
            int count = params.size();
            if (count == 0) {
                list = list + ")\n";
            } else {
                for (Parameter par: params) {
                    list = list + par.getParamType() + " " + par.getParamName();
                    count --;
                    if (count > 0) {
                        list = list +", ";
                    } else {
                       list = list + ")\n";
                    }
                }
            }
        }
              
        list = list +  "\n     Relationships:\n";
        
        for (Relationship ele: cls.getRelationships()) {
            String dest = ele.getDestination().getClassName();
            String type = ele.getFullType().toLowerCase();
        	list = list + "     * " + className + " --" + type + "--> " + dest + "\n"+ "\n\n";
		}
		list = list + "\n";
		return list;
	}
	
	/*
	 * A function for displaying the relationships that exist in the model
	 * 
	 * @author John Shenk
	 * @return list A String displaying all of the relationships
	 */
	public String listRelationships() {
        String list = "      ";
        list = list +  "\n     Relationships:\n";
	    for(Class cls : model.getClasses()) {
	        for (Relationship ele: cls.getRelationships()) {
	            String dest = ele.getDestination().getClassName();
	            String type = ele.getFullType().toLowerCase();
	            list = list + "     * " + cls.getClassName() + " --" + type + "--> " + dest + "\n"+ "\n\n";
	        }
	    }
	    return list;
	}
	
	
	/*
	 * Gets a class - Primarily used for the List A Class Window
	 * @author John Shenk
	 * @param className the name of the class to get
	 * @return a Class of the specified name
	 */
	public Class getClass(String className) {
	    return model.getClass(className);
	}
	
	



		/***********************ACTION LISTENERS FOR SECONDARY WINDOWS*************************** */

				
		// adding class functionality
		public void addClassAction(JFrame frame , GUIView view){
			view.btnAddClass.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String text = view.getTextBox().getText();
					if(!text.equals(""))
					{
						addClass(text, view);
						frame.dispose();
					}
					view.saved = false;

				}
			});

			view.btnCancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
						frame.dispose();
				}
			});
			

		}


		public void deleteClassAction(JFrame frame , GUIView view){
			view.comboBoxClasses.setModel(new DefaultComboBoxModel<Object>(getList("Class", null, null)));

			view.btnDeleteClass.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(!view.comboBoxClasses.getSelectedItem().equals("Choose a class:")) {
						deleteClass(view.comboBoxClasses.getSelectedItem().toString(), view);
						frame.dispose();
					}
					else
					{
						view.classSelect();
					}
						
				}
			});

			// if Cancel button clicked
			view.btnCancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frame.dispose();
				}
			});

		}



		public void renClassAction(JFrame frame , GUIView view){


			view.cbClasses.setModel(new DefaultComboBoxModel<Object>(getList("Class", null, null)));
				view.cbClasses.addItemListener(new ItemListener() {
							public void itemStateChanged(ItemEvent arg0) {
								view.textFieldClassName.setVisible(true);
								view.lblNewName.setVisible(true);
							}
				});

				view.btnRenameClass.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(!view.cbClasses.getSelectedItem().toString().equals("Choose a class:")) {
							
							if(!view.textFieldClassName.getText().equals("")) {
								renameClass(view.cbClasses.getSelectedItem().toString(), view.textFieldClassName.getText(), view );
								
								frame.dispose();
							}

						}
						else
						{
							view.classSelect();
						}
					}
				});

                view.btnCancel.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						frame.dispose();
					}
				});
			
			

		}


		public void addingRelsAction(JFrame frame , GUIView view){
			view.comboBoxClass1.setModel(new DefaultComboBoxModel<Object>(getList("Class", null, null)));
			view.comboBoxClass2.setModel(new DefaultComboBoxModel<Object>(getList("Class", null, null)));
			
			/* Combobox listener */
			view.cbRelationships.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent arg0) {
					view.comboBoxClass1.setVisible(true);
					view.comboBoxClass2.setVisible(true);
					view.lblClass1.setVisible(true);
					view.lblClass2.setVisible(true);
				}
			});

			view.btnAddRelationship.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(!view.comboBoxClass1.getSelectedItem().equals("Choose a class:") || !view.comboBoxClass2.getSelectedItem().equals("Choose a class:") ) {

						////////////////////////////////////////////////////////
						addRelationship(view.comboBoxClass1.getSelectedItem().toString(), 
						view.comboBoxClass2.getSelectedItem().toString(), view.cbRelationships.getSelectedItem().toString(), view);
						/////////////////////////////////////////////////////////////
						frame.dispose();
					}
					else
					{
						view.classSelect();
					}
				}
			});
			
			
			/*Cancel Listener */
			view.btnCancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frame.dispose();
				}
			});

			view.saved = false;

		}

		/*Deleting Rel Action */
		public void deletingRelsAction(JFrame frame , GUIView view){
			view.cdClass2.setModel(new DefaultComboBoxModel<Object>(getList("Class", null, null)));
			view.cbClass1.setModel(new DefaultComboBoxModel<Object>(getList("Class", null, null)));
			
			view.cbClass1.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent arg0) {
					view.cdClass2.setVisible(true);
					view.lblClass2.setVisible(true);
				}
			});

			view.btnDeleteRelationship.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(!view.cbClass1.getSelectedItem().equals("Choose a class:") || !view.cdClass2.getSelectedItem().equals("Choose a class:") ) {

						////////////////////////////////////////////////////////
						deleteRelationship(view.cbClass1.getSelectedItem().toString(), 
						view.cdClass2.getSelectedItem().toString(), view);
						/////////////////////////////////////////////////////////////

						frame.dispose();
					}
					else
					{
						view.classSelect();
					}

				}
			});

	
	
			view.btnCancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					frame.dispose();
				}
			});

			view.saved = false;
	

		}
	


		public void changingRelsAction(JFrame frame , GUIView view){
			view.cbClass2.setModel(new DefaultComboBoxModel<Object>(getList("Class", null, null)));
			view.cbClass1.setModel(new DefaultComboBoxModel<Object>(getList("Class", null, null)));
			
			view.cbClass1.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent arg0) {
					view.cbClass2.setVisible(true);
					view.lblClass2.setVisible(true);
				}
			});

			view.bteditRelType.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					if(!view.cbClass1.getSelectedItem().equals("Choose a class:") || !view.cbClass2.getSelectedItem().equals("Choose a class:") ) {
						////////////////////////////////////////////////////////
						editRelationshipType(view.cbClass1.getSelectedItem().toString(), 
						view.cbClass2.getSelectedItem().toString(), view.cbRelationships.getSelectedItem().toString(),view);
						/////////////////////////////////////////////////////////////
						view.frmJamblChange.dispose();
					}
					else
					{
						view.classSelect();
					}


					view.frmJamblChange.dispose();
				}
			});

			view.btnCancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					view.frmJamblChange.dispose();
				}
			});
			

			view.saved = false;
		}
	


		public void addingMethodAction(JFrame frame , GUIView view){
			view.comboBoxClasses.setModel(new DefaultComboBoxModel<Object>(getList("Class", null, null)));
			view.comboBoxClasses.addItemListener(new ItemListener() {
					public void itemStateChanged(ItemEvent arg0) {
						view.lblMethodName.setVisible(true);
						view.lblMethodType.setVisible(true);
						view.methodNameBox.setVisible(true);
						view.methodTypeBox.setVisible(true);
					}
				});

				view.btnAddMethod.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						addMethod(view.comboBoxClasses.getSelectedItem().toString(), view.methodNameBox.getText(), view.methodTypeBox.getText(), view);
						view.frmJamblAdd.dispose();
					}
				});
				
				
				view.btnCancel.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						view.frmJamblAdd.dispose();
					}
				});
				view.saved = false;
	
		}
	


		public void deletingMethodAction(JFrame frame , GUIView view){
			view.Methods.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent arg0) {
					
				}
			});
			
			view.Classes.setModel(new DefaultComboBoxModel<Object>(getList("Class", null, null)));
			view.Classes.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent arg0) {
					view.Methods.setModel(new DefaultComboBoxModel<Object>(getList("Method", view.Classes.getSelectedItem().toString(), null)));
					view.Methods.setVisible(true);
					view.lblMethods.setVisible(true);
				}
			});


			
			view.btnDeleteMethod.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(!(view.Classes.getSelectedIndex() == -1) && !(view.Methods.getSelectedIndex() == -1)) {
						deleteMethod(view.Classes.getSelectedItem().toString(), view.Methods.getSelectedItem().toString(), view);
						frame.dispose();
					}
				}
			});
			
						
			view.btnCancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frame.dispose();
				}
			});
			view.saved = false;
	
		}
	


		public void renamingMethodAction(JFrame frame , GUIView view){
	
			view.Classes.setModel(new DefaultComboBoxModel<Object>(getList("Class", null, null)));
				view.Methods.addItemListener(new ItemListener() {
					public void itemStateChanged(ItemEvent arg0) {
						view.textField.setVisible(true);
						view.lblNewMethod.setVisible(true);
					}
				});
					
				
				
				view.Classes.addItemListener(new ItemListener() {
					public void itemStateChanged(ItemEvent arg0) {
						view.Methods.setModel(new DefaultComboBoxModel<Object>(getList("Method", view.Classes.getSelectedItem().toString(), null)));
						view.Methods.setVisible(true);
						view.lblMethod.setVisible(true);
					}
				});

				
				view.btnChangeMethod.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						renameMethod(view.Classes.getSelectedItem().toString(), view.Methods.getSelectedItem().toString(), view.textField.getText(), view);
						view.frmJamblAdd2.dispose();
					}
				});
				
				
				view.btnCancel.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						view.frmJamblAdd2.dispose();
					}
				});

				view.saved = false;
		}


	
		public void changingMethodAction(JFrame frame , GUIView view){
			view.Classes.setModel(new DefaultComboBoxModel<Object>(getList("Class", null, null)));
			view.Methods.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent arg0) {
					view.textField.setVisible(true);
					view.lblNewLabel.setVisible(true);
				}
			});
			
			
			
			view.Classes.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent arg0) {
					view.Methods.setModel(new DefaultComboBoxModel<Object>(getList("Method", view.Classes.getSelectedItem().toString(), null)));
					view.Methods.setVisible(true);
					view.lblMethod.setVisible(true);
				}
			});
			
			
			view.btnChangeMethod.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					changeMethodReturn(view.Classes.getSelectedItem().toString(), view.Methods.getSelectedItem().toString(), view.textField.getText(), view);
					view.frmJamblAdd.dispose();
				}
			});
			
			
			view.btnCancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					view.frmJamblAdd.dispose();
				}
			});
			view.saved = false;

		}
	
		public void addingParamAction(JFrame frame , GUIView view){
	
			view.cbClasses.setModel(new DefaultComboBoxModel<Object>(getList("Class", null, null)));
				
			view.cbClasses.addItemListener(new ItemListener() {
							public void itemStateChanged(ItemEvent arg0) {
								view.cbMethods.setModel(new DefaultComboBoxModel<Object>(getList("Method", view.cbClasses.getSelectedItem().toString(), null)));
								view.cbMethods.setVisible(true);
								view.lblMethod.setVisible(true);
							}
				});
		
				
				
				view.btnAddParameter.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(!view.textParameter.getText().equals("") && !view.textParamType.getText().equals("")) {
							addParameter(view.cbClasses.getSelectedItem().toString(), view.cbMethods.getSelectedItem().toString(), view.textParameter.getText(), view.textParamType.getText(), view);
							frame.dispose();
						}
					}
				});
				
				
				view.btnCancel.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						frame.dispose();
					}
				});
				
				view.saved = false;
		}
	
		public void deletingParamAction(JFrame frame , GUIView view){
			view.cbParameter.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent arg0) {

				}
				});
			
				
			view.cdMethods.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				view.cbParameter.setModel(new DefaultComboBoxModel<Object>(getList("Param", view.cls, view.cdMethods.getSelectedItem().toString())));
				view.cbParameter.setVisible(true);
				view.lblParameter.setVisible(true);
			}
			});
			
			view.cbClasses.setModel(new DefaultComboBoxModel<Object>(getList("Class", null, null)));
			view.cbClasses.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				view.cls = view.cbClasses.getSelectedItem().toString();
				view.cdMethods.setModel(new DefaultComboBoxModel<Object>(getList("Method", view.cls, null)));
				view.cdMethods.setVisible(true);
				view.lblMethod.setVisible(true);
			}
			});
			
			
			view.btnRemoveParameter.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(!(view.cbClasses.getSelectedIndex() == -1) && !(view.cdMethods.getSelectedIndex() == -1) && !(view.cbParameter.getSelectedIndex() == -1)) {
						deleteParameter(view.cbClasses.getSelectedItem().toString(), view.cdMethods.getSelectedItem().toString(), view.cbParameter.getSelectedItem().toString(), view);
						frame.dispose();
					}
				}
			});
			
			
			view.btnCancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frame.dispose();
				}
			});
			
			
			view.btnDeleteAll.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(!(view.cbClasses.getSelectedIndex() == -1) && !(view.cdMethods.getSelectedIndex() == -1)){
						removeAllParameter(view.cbClasses.getSelectedItem().toString(), view.cdMethods.getSelectedItem().toString(), view);
						frame.dispose();
					}
				}
			});
			
			
			view.saved = false;
			
			
	
		}
	
		public void changingParamAction(JFrame frame , GUIView view){
					
			view.cbParameters.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent arg0) {
					view.lblNewParameterType.setVisible(true);
					view.textParameter.setVisible(true);
					view.textParamType.setVisible(true);
					view.lblNewParameterName.setVisible(true);
				}
			});	
			
			
			view.cbMethods.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent arg0) {
					view.cbParameters.setModel(new DefaultComboBoxModel<Object>(getList("Param", view.cls, view.cbMethods.getSelectedItem().toString())));
					view.cbParameters.setVisible(true);
					view.lblParameter.setVisible(true);
				}
			});

			
			
			view.cbClasses.setModel(new DefaultComboBoxModel<Object>(getList("Class", null, null)));
			
			view.cbClasses.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent arg0) {
					view.cls = view.cbClasses.getSelectedItem().toString();
					view.cbMethods.setModel(new DefaultComboBoxModel<Object>(getList("Method", view.cls, null)));
					view.cbMethods.setVisible(true);
					view.lblMethod.setVisible(true);
				}
			});
			
			
			view.btnChangeParameter.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					changeParameter(view.cbClasses.getSelectedItem().toString(), view.cbMethods.getSelectedItem().toString(), view.cbParameters.getSelectedItem().toString(), view.textParameter.getText(), view.textParamType.getText(), view);
					frame.dispose();
				}
			});
			
			
			view.btnCancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frame.dispose();
				}
			});
			
		
			view.saved = false;
		}
	

		/*Field Action listeners */
		public void addingFieldAction(JFrame frame , GUIView view){
			view.comboBoxClasses.setModel(new DefaultComboBoxModel<Object>(getList("Class", null, null)));
				
				
			view.comboBoxClasses.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent arg0) {
					view.lblField.setVisible(true);
					view.lblFieldType.setVisible(true);
					view.fieldNameBox.setVisible(true);
					view.fieldTypeBox.setVisible(true);
				}
			});
			
			
			view.btnAddField.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(!view.fieldNameBox.getText().equals("") && !view.fieldTypeBox.getText().equals("")) {
						addField(view.comboBoxClasses.getSelectedItem().toString(), view.fieldNameBox.getText(), view.fieldTypeBox.getText(), view);
						frame.dispose();
					}
					else
					{
						view.fieldText();
					}

				}
			});
			
			
			view.btnCancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frame.dispose();
				}
			});
			

			view.saved = false;
	
		}
	


		public void deletingFieldAction(JFrame frame , GUIView view){
			view.cbFields.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent arg0) {
					
				}
			});
			view.Classes.setModel(new DefaultComboBoxModel<Object>(getList("Class", null, null)));
			
			view.Classes.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent arg0) {
					view.cbFields.setModel(new DefaultComboBoxModel<Object>(getList("Field", view.Classes.getSelectedItem().toString(), null)));
					view.cbFields.setVisible(true);
					view.lblField.setVisible(true);
				}
			});
			
			
			view.btnDeleteField.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(!(view.Classes.getSelectedIndex() == -1) && !(view.cbFields.getSelectedIndex() == -1)) {
						deleteField(view.Classes.getSelectedItem().toString(), view.cbFields.getSelectedItem().toString(), view);
						view.frmJamblAdd3.dispose();
					}

				}
			});
			
		   
			view.btnCancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					view.frmJamblAdd3.dispose();
				}
			});
			

			view.saved = false;
	
		}
	
		public void renamingFieldAction(JFrame frame , GUIView view){
			view.Fields.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent arg0) {
					view.textField.setVisible(true);
					view.lblNewField.setVisible(true);
				}
			});
			
			
			view.Classes.setModel(new DefaultComboBoxModel<Object>(getList("Class", null, null)));
			
			view.Classes.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent arg0) {
					view.Fields.setModel(new DefaultComboBoxModel<Object>(getList("Field", view.Classes.getSelectedItem().toString(), null)));
					view.Fields.setVisible(true);
					view.lblMethod.setVisible(true);
					
				}
			});
			
			view.btnChangeMethod.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(!view.textField.getText().equals("")) {
						renameField(view.Classes.getSelectedItem().toString(), view.Fields.getSelectedItem().toString(), view.textField.getText(), view);
						view.frmJamblAdd4.dispose();
					}
				}
			});
			
			
			view.btnCancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					view.frmJamblAdd4.dispose();
				}
			});
			
	
		}

		public void editingFieldAction(JFrame frame , GUIView view){
			view.Fields.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent arg0) {
					view.textFieldType.setVisible(true);
					view.lblNewFType.setVisible(true);
				}
			});
			
			
			
			view.Classes.setModel(new DefaultComboBoxModel<Object>(getList("Class", null, null)));
			
			view.Classes.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent arg0) {
					view.Fields.setModel(new DefaultComboBoxModel<Object>(getList("Field", view.Classes.getSelectedItem().toString(), null)));
					view.Fields.setVisible(true);
					view.lblField.setVisible(true);
				}
			});
			
			view.btnChangeField.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					changeFieldType(view.Classes.getSelectedItem().toString(), view.Fields.getSelectedItem().toString(), view.textFieldType.getText(), view);
					view.frmJamblAdd5.dispose();
				}
			});
			
			
			view.btnCancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					view.frmJamblAdd5.dispose();
				}
			});
			

			view.saved = false;

		}
	

		public void saveAction(JFrame frame , GUIView view){
			view.btnSave.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String text = view.txtDefaulttxt.getText();
					if(!text.equals("")){
						save(text);
						frame.dispose();
					}
					else
					{
						System.out.println("Outside if statement");
					}
				}
			});
			
			
			view.btnCancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frame.dispose();
				}
			});
			view.saved = true;
	
		}
	
		public void loadAction(JFrame frame , GUIView view){
			final JFileChooser fc = new JFileChooser();

			view.btnBrowse.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//In response to a button click:
					int returnVal = fc.showOpenDialog(null);
					
					if (returnVal == JFileChooser.APPROVE_OPTION) {
						File file = fc.getSelectedFile();
						view.textField.setText(file.getAbsolutePath()); 
					}
				}
			});
			
	
			view.btnDefault.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					view.textField.setText("JAMBL.json");
				}
			});
	
			
			view.btnLoad.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					String text = view.textField.getText();
					if(!text.equals("")){
						
						load(text);
						frame.dispose();
					}
					else
					{}
				}
			});

			view.btnCancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frame.dispose();
				}
			});

			view.saved = false;
				
		}



		public void listAClassAction(JFrame frame , GUIView view){
			view.cbClasses.setModel(new DefaultComboBoxModel<Object>(getList("Class", null, null)));
			view.btnListClass.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//view.textAreaMain.setText(listClass(model.getClass(view.cbClasses.getSelectedItem().toString())));
					frame.dispose();
				}
			});
		
			
			view.btnCancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frame.dispose();
				}
			});

		}




		public String listAllAction () {
			String list ="CLASSES \n===============\n";
			for (Class ele: model.getClasses()) {
			  list = list +  listClass(ele);
			}
			return list;
		}



		public void saveAssurance(){
			////////////////////////////////////////////////////////////// Save assurance window, under construction!
		/*frmJambl.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent windowEvent){
	      
	         } 
		}); */
		}
		
		///////////////////////////////     
		//// ****GUI FUNCTIONS**** ////
		///////////////////////////////     

		/*
	 * Returns a list of objects beginning with "select a <insert item type here>"
	 * 
	 * @param type The type of list to get (either Class, Field, Method, or Param (for parameter)
	 * @param className The name of a class to get a method, field, etc. Can be null if not needed
	 * @param methodName The name of a method to get parameters from. can be null if not needed
	*/
	public String[] getList(String type, String className, String methodName) {
		if(type.equals("Class")) {
			String[] classes = model.getClassList();
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
			String[] fields = model.getFieldList(className);
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
			String[] methods = model.getMethodList(className);
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
			String[] params = model.getParameterList(className, methodName);
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

	/**
	 * 
	 * @param className The name of the class to send a box of to the GUIView
	 * @param gui The gui in question
	 * @return n/a
	 * @precondition The class "className" exists
	 */
	public void sendBox(String className, GUIView gui){
		gui.makeBox(model.getClass(className).getBox());
	}
	
	
	public void addRelationshipGUI (String origin, String destination, String typeName, GUIView GUI){

		draggableBox class1 = null;
		draggableBox class2 = null;

		Iterator<draggableBox> itr = classBoxes.iterator();
		while(itr.hasNext()){
			draggableBox next = itr.next();
			if(next.getName().equals(origin)){
				class1 = model.getClass(origin).getBox();
			}
			if (next.getName().equals(destination)){
				class2 = model.getClass(destination).getBox();
			}
			GUI.diagramArea.setBox(class1, class2, Relationship.Type.AGGR);
			GUI.reDraw();
	}
	
	
}






}



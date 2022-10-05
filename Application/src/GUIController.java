/*
 * @projectDescription A controller specifically for use with the GUI
 * 
 * @authors	John Shenk
 * @version 0.0.1
 * @dateLastModified October 3, 2022
 */

import java.util.*;

import javax.swing.JButton;

import java.io.*;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class GUIController {
	
		Model model;
		GUIView GUI;
		
		/*
		 * Constructs a new GUIController
		 */
		public GUIController(Model MODEL, GUIView gui) {
			model = MODEL;
			GUI = gui;
		}
				
		
		
		///////////////////////////////     
		//// ****GUI FUNCTIONS**** ////
		///////////////////////////////     
	    public String[] getClassNames() {
	    	return model.getClassList();
	    }
	    
	    /*
	     *  Function for GUI to add class to model
	     */
	    public void addClass(String name) {
	    	if(model.getClass(name) == null) // Class does not exist already
			{		
	    		model.addClass(name);
	    		GUI.classCreate(name);
			}
			else
			{
				GUI.classExist();
			}
	    }
	    
	    /*
	     * Function for GUI to rename class in the model
	     */
	    public void renameClass(String name1, String name2) {
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
	    public void deleteClass(String name) {
	    		model.deleteClass(model.getClass(name));
	    		GUI.classDelete(name);
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
	    public void addField(String className, String fieldName, String fieldType) {
	    	Class get = model.getClass(className);
	    	if(get.addField(fieldName, fieldType))
	    		GUI.fieldAdd(fieldName, className);
	    	else
	    		GUI.fieldAdd(fieldName, className);
	    }
	    
	    public void renameField(String className, String oldName, String newName) {
	    	boolean ok = model.getClass(className).renameField(oldName, newName);
	    	if(ok) {
	    		GUI.fieldRename(oldName, newName, className);
	    	}
	    	else 
	    	{
	    		GUI.fieldExist();
	    	}
	    	
	    }
	    
	    public void deleteField(String className, String fieldName) {
	    	if(model.getClass(className).deleteField(fieldName)) {
	    		GUI.fieldDelete(fieldName, className);
	    	}
	    	else
	    	{
	    		GUI.deleteFieldFailure();
	    	}
	    }
	    
	    public void changeFieldType(String className, String fieldName, String newFieldType) {
	    	model.getClass(className).getField(fieldName).setFieldType(newFieldType);
	    	GUI.fieldTypeChange(className, fieldName, newFieldType);
	    }
	    

		/*********************************** NEEDS TESTING ***************************************/
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
				System.out.println("UML Diagram Saved!");
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
	
	/****************************************************************************/
	    
}

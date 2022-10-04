import java.util.HashSet;
import java.util.Iterator;

/*
 * @projectDescription A controller specifically for use with the GUI
 * 
 * @authors	John Shenk
 * @version 0.0.1
 * @dateLastModified October 3, 2022
 */
public class GUIController {
	
		Model model;
		GUIView GUI;
		public HashSet<Relationship> relationships = new HashSet<Relationship>();
		
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
	    
	     /////////// ***** Relationship Methods ****** ////////////

		public void addRelationship (String origin, String destination, String typeName) {
					
			/*if (model.getClass(origin) == null ) {

				GUI.originNotExist();
				
			} else if (model.getClass(destination) == null ) {

				GUI.destinationNotExist();
			} else if ((model.getClass(origin)).isrelationshipExist(destination, typeName) == true ) {
				GUI.relExists();
			}
			else { }*/

			    boolean added = true; 
				model.getClass(origin).addRelationship((model.getClass(destination)), typeName);
				added = true;
				if(added){ 
				GUI.addedRel(origin, destination);
			
				}
		}


		public void deleteRelationship (String origin, String destination) {
			
			/*if (model.getClass(origin) == null ) {

				GUI.originNotExist();
				
			} else if (model.getClass(destination) == null ) {

				GUI.destinationNotExist();

			} else { */
				Iterator<Relationship> relItr = relationships.iterator();
				while (relItr.hasNext()) {
					Relationship ele = relItr.next();
					(ele.getDestination()).getClassName().equals(destination); 
						relItr.remove();
				}
				GUI.relDeleted();
				
		}

		public void editRelationshipType(String origin, String destination, String newType) {

			if ((model.getClass(origin)).isrelationshipExist(destination, newType) == true ) {
					
				GUI.relExists();
				
			} else{
				Iterator<Relationship> relItr = relationships.iterator();
				while (relItr.hasNext()) {
				Relationship ele = relItr.next();
				ele.setRelType(newType); 
				}      

		   	    GUI.relTypeEdited();
			}
		}

}

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

		//////////////////////////////////////////////
		//////////// add Relationship ///////////////

		public void addRelationship (String origin, String destination, String typeName) {
			// sets boolean to true unless an error is found
			
			
			
			if (model.getClass(origin) == null ) {

				GUI.originNotExist();
				
			} else if (model.getClass(destination) == null ) {

				GUI.destinationNotExist();
			} else if ((model.getClass(origin)).isrelationshipExist(destination, typeName) == true ) {
				GUI.relExists();
			}
			else {
				model.getClass(origin).addRelationship((model.getClass(destination)), typeName);
			}
			

			
				
		}



}

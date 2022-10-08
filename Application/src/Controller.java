/*
 * @projectDescription	A program for adding classes to a database
 * 
 * @authors	John Shenk, Benjamin Slinghoff, Lauryn Simmons, Alex Peiffer, Meba Shimelis
 * @version 0.0.1
 * @dateLastModified September 13, 2022
 */

import java.util.*;

import javax.swing.JButton;

import java.io.*;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Controller {
   
    private Model model = new Model();
    private View view;
    private GUIView GUI;

    public static enum Command {
    START ("START"), //initial starting state Command not to be displayed in HELP
    ADDCL ("ADDCL"), //add class
    DELCL ("DELCL"), //delete class
    RENCL ("RENCL"), //rename class
    ADDREL ("ADDREL"), //add relationship
    DELREL ("DELREL"), //delete relationship
    RELTYPE ("RELTYPE"), //edit relationship type
    ADDFLD ("ADDFLD"), //add field
    DELFLD ("DELFLD"), //delete field
    RENFLD ("RENFLD"), //rename field
    FLDTYPE ("FLDTYPE"), //field return type
    ADDMTD ("ADDMTD"), //add method
    DELMTD ("DELMTD"), //delete method
    RENMTD ("RENMTD"), //rename Method 
    MTDTYPE ("MTDTYPE"), //Method return type 
    ADDPAR ("ADDPAR"), //add Parameter
    DELPAR ("DELPAR"), //delete Parameter
    CHGPAR ("CHGPAR"), //change Parameter type and name
    SAVE ("SAVE"), //save diagram
    LOAD ("LOAD"), //load diagram
    LISTALL ("LISTALL"), //list all classes
    LISTCLA ("LISTCLA"), //list all attributes of a class
    LISTREL ("LISTREL"), //list all relationships between classes
    HELP ("HELP"), //shows the command list and how to use them
    EXIT ("EXIT") ; //quits the program

    private String name;

    private Command (String name) {
        this.name = name;
    }

    public String toString() {
       return this.name;
    }
   }


    public Controller (Model model , View view) {

    this.model = model;
    // initialized the CLI view
    this.view  = view;

   }
    
    public Controller (Model model, GUIView gui) {
    	this.model = model;
    	GUI = gui;
    }

    /*
	 * @name commandExecute
	 * @description	Reads a command and executes that command
	 * @param curerentCmd
	*/
    public void commandExecute (Command currentCmd) {
        Scanner scanner = new Scanner(System.in);
        String name1;
        String name2;
        String name3;
        String name4;
        String name5;
        String name7;
        Class class1;
        Class class2;
        Class classCheck;
        Method method1;
        Method methodCheck;
        Method methodCheck2;
        String fileName;
        boolean returned;
        String typeName;
        

        switch (currentCmd) {

            case START: 
                break;

            case ADDCL:
            
                // prompts user and stores input in name1 variable
                name1 = view.inputAdd("Class");
                classCheck = model.getClass(name1);
                // if input not blank add class
                if ((!name1.isBlank()) && (classCheck == null)) {
                    // adds class
                     model.addClass(name1);
                     // Checks to see if class was succesfully added
                     if(model.getClass(name1) != null){
                        // if class successfully added notify user
                        view.Added("Class", name1);
                     }else{
                        view.Failed("Class", "Adding");
                     }
                     
                } else {

                    if(classCheck != null){
                        view.exists("Class", name1);
                    }else{
                        // if input is empty return invalid input message
                        view.invalid();
                    }  
                }
                break;

            case DELCL:

                // prompts user and stores input in name1 variable
               name1 = view.inputDel("Class");
               classCheck = model.getClass(name1);
                // checks to see if input was blank
                if ((!name1.isBlank()) && (classCheck != null) ) {
                    model.deleteClass(classCheck);
                    // if class deleted returned equals true and user is notified
                    if(model.getClass(name1) == null){
                        view.Deleted("Class", name1);
                        
                    }else{ // if class not found returned is false and user is notified
                        view.Failed("Class", "Deleting");
                    }
                
                } else {
                    //tells user input was invalid
                    if(name1.isBlank()){
                        
                        view.invalid();
                    }else{
                        view.notExists("Class", name1);
                    }  
                }
                break;

            case RENCL:
              // prompts user and stores input in name1 variable
              name1 = view.inputRen("Class");
              classCheck = model.getClass(name1);
                if (!name1.isBlank()) {
                    // checks if class exists
                    if(classCheck == null){
                        view.notExists("Class", name1);
                        return;
                    }
                    } else {
                        view.invalid();
                        return;
                    }
               
                name2 = view.inputNewName("Class Name");
                classCheck = model.getClass(name2);
                if (!name2.isBlank()) {
                    if(classCheck == null){
                        model.renameClass(name1, name2);
                        view.renamed("Class", name1 , name2);
                    }else{
                        view.exists("Class", name2);
                    }
                
                } else {
                    view.invalid();
                }
                break;


            case ADDFLD:
                name1 = view.inputClassName(); //gets class name from user
                if (name1.isBlank()) { //checks for blank input
                    view.invalid();
                    break;
                }
                class1 = model.getClass(name1); //gets Class with name entered; null if not found
                if (class1 == null) { //checks if class exists and exits if doesn't
                    view.notExists("Class", name1);
                    break;
                } else {
                    name2 = view.inputFieldName(); //gets the name for the field
                    if (name2.isBlank()) { //checks for blank input
                        view.invalid();
                        break;
                    }
                    
                    if (class1.getField(name2) != null) { //checks if field already exists and exits if does
                        view.exists("Field", name2);
                        break;
                    } else {
                        name3 = view.inputFieldType(); //gets type for the field
                        if (name3.isBlank()) { //checks for blank input
                            view.invalid();
                            break;
                        }
                        boolean added = class1.addField(name2, name3); //adds it to the fields set
                        if (added) {
                            view.Added(name3, name2); //prints success messaage
                        }
                        break;
                    }
                }
                
            case DELFLD:
                name1 = view.inputClassName(); //gets class name from user
                if (name1.isBlank()) { //checks for blank input
                    view.invalid();
                    break;
                }
                if (name1.isBlank()) { //checks for blank input
                    view.invalid();
                    break;
                }
                class1 = model.getClass(name1); //gets Class with name entered; null if not found
                if (class1 == null) { //checks if class exists and exits if doesn't
                    view.notExists("Class", name1);
                    break;
                } else {
                    name2 = view.inputFieldName(); //gets field name from user
                    if (name2.isBlank()) { //checks for blank input
                        view.invalid();
                        break;
                    }
                    if (class1.getField(name2) == null) { //checks if field exists and exits if doesn't
                        view.notExists("Field", name2);
                        break;
                    } else {
                        boolean removed = class1.deleteField(name2); //removes the field from the set
                        if (removed) {
                            view.Deleted("Field", name2); //prints success message
                        }
                        break;
                    }
                } 

            case RENFLD:
                name1 = view.inputClassName(); //gets class name from user
                if (name1.isBlank()) { //checks for blank input
                    view.invalid();
                    break;
                }
                class1 = model.getClass(name1); //gets Class with name entered; null if not found
                if (class1 == null) { //checks if class exists and exits if doesn't
                    view.notExists("Class", name1);
                    break;
                } else {
                    name2 = view.inputFieldName(); //gets old field name from user
                    if (name2.isBlank()) { //checks for blank input
                        view.invalid();
                        break;
                    }
                    if (class1.getField(name2) == null) { //checks if field exists and exits if doesn't
                        view.notExists("Field", name2);
                        break;
                    } else {
                        name3 = view.inputNew("name", "Field"); //get new field name from user
                        if (name3.isBlank()) { //checks for blank input
                            view.invalid();
                            break;
                        }
                        if (class1.getField(name3) != null) { //checks if a field already exists with that name exits if does
                            view.exists("Field", name3);
                            break;
                        } else {
                            boolean renamed = class1.renameField(name2, name3); //changes the field name
                            if (renamed) {
                                view.Renamed("Field", name2, name3); //prints success message
                            }
                            break;
                        }
                    }
                }  

            case FLDTYPE:
                name1 = view.inputClassName(); //gets class name from user
                if (name1.isBlank()) { //checks for blank input
                    view.invalid();
                    break;
                }
                class1 = model.getClass(name1); //gets Class with name entered; null if not found
                if (class1 == null) { //checks if class exists and exits if doesn't
                    view.notExists("Class", name1);
                    break;
                } else {
                    name2 = view.inputFieldName(); //gets field name from user
                    if (name2.isBlank()) { //checks for blank input
                        view.invalid();
                        break;
                    }
                    if (class1.getField(name2) == null) { //checks if field exists and exits if doesn't
                        view.notExists("Field", name2);
                        break;
                    } else {
                        name3 = view.inputNew("type", "Field"); //get new field type from user
                        if (name3.isBlank()) { //checks for blank input
                            view.invalid();
                            break;
                        }
                        if ((class1.getField(name2).getFieldType().toUpperCase()).equals(name3.toUpperCase())) { //checks if the current type is the new type, exits if same
                            view.exists("Field type", name3);
                            break;
                        } else {
                            boolean changed = class1.changefieldType(name2, name3); //changes the field type
                            if (changed) {
                                view.Retyped("Field type", name2, name3); //prints success message
                            }
                            break;
                        }
                    }
                } 

            case ADDMTD:
                 // prompts user for the class the method will be added to
                 name1 = view.inputNameOf("Class" , "Method", "receiving");
                 // finds the class
                 classCheck = model.getClass(name1);
                 
                 // if input was blank of class not found it returns an error message and exits
                 if ((name1.isBlank()) || (classCheck == null)) {

                    if(name1.isBlank()){

                        // if input is empty return invalid input message
                        view.invalid();
                        return;
                    }else{
                        
                        view.notExists("Class", name1);
                        return;
                    }  
                }

                //prompts user for Method name
                name2 = view.inputAdd("Method");
                // tries to find method
                methodCheck = classCheck.getMethod(name2);

                // If method already exists or user input was empty prints error and exits
                if ((name2.isBlank()) || (methodCheck != null)) {

                    if(name2.isBlank()){

                        // if input is empty return invalid input message
                        view.invalid();
                        return;
                    }else{
                        
                        view.exists("Method", name2);
                        return;
                    }  
                }else{
                    // prompts user for method type and adds the method
                    name3 = view.inputAdd("Method Return Type");
                    classCheck.addMethod(name2, name3);
                }

                // Checks to see if the method was added successfully and notifies user
                if(classCheck.getMethod(name2) != null){
                    view.Added(name2, "Method");
                }else {
                    view.Failed("Method", "Adding");
                }
                
                break; 
        
            case DELMTD:

                 // prompts user for the class the method will be deleted from
                 name1 = view.inputNameOf("Class" , "Method", "deleting");
                 // finds the class
                 classCheck = model.getClass(name1);
                 
                 // if input was blank of class not found it returns an error message and exits
                 if ((name1.isBlank()) || (classCheck == null)) {

                    if(name1.isBlank()){
                        // if input is empty return invalid input message
                        view.invalid();
                        return;
                    }else{
                        
                        view.notExists("Class", name1);
                        return;
                    }    
                }

                //prompts user for Method name
                name2 = view.inputDel("Method");
                // tries to find method
                methodCheck = classCheck.getMethod(name2);

                // If method doesn't exists or user input was empty prints error and exits
                if ((name2.isBlank()) || (methodCheck == null)) {

                    if(name2.isBlank()){
                        
                        view.invalid();
                        return;
                    }else{
                        // if input is empty return invalid input message
                        view.notExists("Method", name2);
                        return;
                    }  
                }else{
                    // deleted method
                    classCheck.deleteMethod(methodCheck);
                }

                // Checks to see if the method was deleted successfully and notifies user
                if(classCheck.getMethod(name2) == null){
                    view.Deleted(name2, "Method");
                }else {
                    view.Failed("Method", "Deleting");
                }
                
                
                break; 
    
            case RENMTD:
                 // prompts user for the class renmaing the method
                 name1 = view.inputNameOf("Class" , "Method", "renaming");
                 // finds the class
                 classCheck = model.getClass(name1);
                 
                 // if input was blank of class not found it returns an error message and exits
                 if ((name1.isBlank()) || (classCheck == null)) {

                    if(name1.isBlank()){
                        // if input is empty return invalid input message
                        view.invalid();
                        return;
                    }else{
                        
                        view.notExists("Class", name1);
                        return;
                    }  
                }

                //prompts user for Method name
                name2 = view.inputRen("Method");
                // tries to find method
                methodCheck = classCheck.getMethod(name2);

                // If method doesn't exists or user input was empty prints error and exits
                if ((name2.isBlank()) || (methodCheck == null)) {

                    if(name2.isBlank()){
                        
                        view.invalid();
                        return;
                    }else{
                        // if input is empty return invalid input message
                        view.notExists("Method", name2);
                        return;
                    }  
                }else{
                    name3 = view.inputNewName("Method Name");
                    methodCheck2 = classCheck.getMethod(name3);

                    if ((name3.isBlank()) || (methodCheck2 != null)) {

                        if(name2.isBlank()){
                            view.invalid();
                            return;
                        }else{
                            // if input is empty return invalid input message
                            view.exists("Method", name3);
                            return;
                        }  
                    }else{
                        // rename method
                        classCheck.renameMethod(methodCheck, name3);
                    }          
                }

                // Checks to see if the method was renamed successfully and notifies user
                if((classCheck.getMethod(name3) != null) && (classCheck.getMethod(name2)== null)){
                    view.renamed("Method", name2, name3);
                }else {
                    view.Failed("Method", "Renaming");
                }
                break;

            case MTDTYPE:

                 // prompts user for the class to change return type 
                 name1 = view.inputNameOf("Class" , "Method", "Changing Return Type of");
                 // finds the class
                 classCheck = model.getClass(name1);
                 
                 // if input was blank of class not found it returns an error message and exits
                 if ((name1.isBlank()) || (classCheck == null)) {

                    if(name1.isBlank()){
                        // if input is empty return invalid input message
                        view.invalid();
                        return;
                    }else{
                        
                        view.notExists("Class", name1);
                        return;
                    }  
                }

                //prompts user for Method name
                name2 = view.inputRen("Method");
                // tries to find method
                methodCheck = classCheck.getMethod(name2);

                // If method doesn't exists or user input was empty prints error and exits
                if ((name2.isBlank()) || (methodCheck == null)) {

                    if(name2.isBlank()){
                        
                        view.invalid();
                        return;
                    }else{
                        // if input is empty return invalid input message
                        view.notExists("Method", name2);
                        return;
                    }  
                }else{
                    name3 = view.inputNewName("Return Type");

                    if (name3.isBlank()) {
                         view.invalid();
                        return;
                    }else{
                        //changed Method reurn type
                        classCheck.changeMethodreturn(methodCheck, name3);
                        // Check to see if type succesfully changed
                        if(classCheck.getMethod(name2).getReturnType().equals(name3)){
                            view.renamed("Method Return Type", "", name3);
                            return;
                        }else{
                            view.Failed("Method Return Type", "Changing");
                        }
                        
                    }  
             
                }
                
                break; 

            case ADDREL:
                name1 =  view.inputAddOriginClass();
               
                class1 = model.getClass(name1);
                if (class1 == null ) {
                    view.originNotExist();
                    break;
                }
                name2 = view.inputAddDestinationClass();
                if (name2.isBlank()) { //checks for blank input
                    view.invalid();
                    break;
                }
                class2 = model.getClass(name2);
                if (class2 == null) {
                    view.destinationNotExist();
                    break;
                }

                typeName = view.inputAddType();
                if (typeName.isBlank()) { //checks for blank input
                    view.invalid();
                    break;
                }
                
                if (class1.isRelationshipExist(name2)){
                    view.relExists();
                    break;
                } 
                if (!class1.isValidType(typeName)){ 
                    view.relTypeCheck(typeName);
                } else {
                    returned = class1.addRelationship(class2, typeName);
                    // notifies user that relationship was added
                    if(returned){
                        view.AddedRel(class1.getClassName(), class2.getClassName(), typeName);
                    }
                } 
                break;

            case DELREL:
                
                name1 = view.inputDelOriginClass();
                
                if (model.getClass(name1) == null) {
                    view.originNotExist();
                    break;
                }
                name2 = view.inputDelDestinationClass();
                if (name2.isBlank()) { //checks for blank input
                    view.invalid();
                    break;
                }
                if (model.getClass(name2) == null) {
                    view.destinationNotExist();
                    break;
                } else {
                    model.getClass(name1).deleteRelationship(name2);
                    view.relDeleted();
                } 
                break;

            case RELTYPE:
                name1 =  view.inputAddOriginClass();
                if (name1.isBlank()) { //checks for blank input
                    view.invalid();
                    break;
                }
                class1 = model.getClass(name1);           
                if (class1 == null) {
                    view.originNotExist();
                    break;
                }
                name2 = view.inputAddDestinationClass();
                if (name2.isBlank()) { //checks for blank input
                    view.invalid();
                    break;
                }
                class2 = model.getClass(name2); 
                if (class2 == null) {
                    view.destinationNotExist();
                    break;
                }
                Relationship rel = class1.getRelationship(name2);
                if (rel == null) {
                    view.relNoExist();
                break;
            } 
                typeName = view.inputAddType();
                if (typeName.isBlank()) { //checks for blank input
                    view.invalid();
                    break;
                }
                if (!class1.isValidType(typeName)) { 
                    view.relTypeCheck(typeName);
                    break;
                }
                if (rel.getRelType().equals(typeName.toUpperCase())) {
                    view.exists("Relationship type", typeName);
                    break;
                }
                class1.editRelationshipType(name2, typeName);
                view.relTypeEdited(typeName);
                
                break;

           case ADDPAR:
                name5 = view.inputClassName(); //gets Class name from user
                if (name5.isBlank()) { //checks for blank input
                    view.invalid();
                    break;
                }
                class1 = model.getClass(name5); //gets Class with name entered; null if not found
                if (class1 == null) { //checks if class exists and exits if doesn't
                    view.notExists("Class", name5);
                    break;
                } else {
                    name1 = view.inputMethodName(); //gets Method name from user
                    if (name1.isBlank()) { //checks for blank input
                        view.invalid();
                        break;
                    }
                    method1 = class1.getMethod(name1); //gets Method with name entered; null if not found
                    if (method1 == null) { //checks if method exists and exits if doesn't
                        view.notExists("Method", name1);
                        break;
                    } else {
                        name2 = view.inputParameterName(); //gets the name for the parameter
                        if (name2.isBlank()) { //checks for blank input
                            view.invalid();
                            break;
                        }
                        if (method1.getParameter(name2) != null) { //checks if parameter already exists and exits if does
                            view.exists("Parameter", name2);
                            break;
                        } else {
                            name3 = view.inputParameterType(); //gets type for the parameter
                            if (name3.isBlank()) { //checks for blank input
                                view.invalid();
                                break;
                            }
                            boolean added = method1.addParameter(name2, name3); //adds it to the parameters set
                            if (added) {
                                view.Added(name3, name2); //prints success messaage
                            }
                            break;
                        }
                    }
                }



            case DELPAR:
                name5 = view.inputClassName(); //gets Class name from user
                if (name5.isBlank()) { //checks for blank input
                    view.invalid();
                    break;
                }
                class1 = model.getClass(name5); //gets Class with name entered; null if not found
                if (class1 == null) { //checks if class exists and exits if doesn't
                    view.notExists("Class", name5);
                    break;
                } else {
                    name1 = view.inputMethodName(); //gets Method name from user
                    if (name1.isBlank()) { //checks for blank input
                        view.invalid();
                        break;
                    }
                    method1 = class1.getMethod(name1); //gets Method with name entered; null if not found
                    if (method1 == null) { //checks if method exists and exits if doesn't
                        view.notExists("Method", name1);
                        break;
                    } else {
                        name7 = view.inputDeleteAll();//gets whether user wants to delete all parameters or just one
                        if (name7.isBlank()) { //checks for blank input
                            view.invalid();
                            break;
                        }
                        if(name7.toUpperCase().equals("YES")){
                            boolean removed = method1.deleteAllParameter(); //removes all parameters from the set
                            if (removed) {
                                view.Deleted("All", "Parameter"); //prints success message
                            }
                            break;
                        } else if(name7.toUpperCase().equals("NO")){
                            name2 = view.inputParameterName(); //gets parameter name from user
                            if (name2.isBlank()) { //checks for blank input
                                view.invalid();
                                break;
                            }
                            if (method1.getParameter(name2) == null) { //checks if parameter exists and exits if doesn't
                                view.notExists("Parameter", name2);
                                break;
                            } else {
                                boolean removed = method1.deleteParameter(name2); //removes the parameter from the set
                                if (removed) {
                                    view.Deleted("Parameter", name2); //prints success message
                                }
                                break;
                            } 
                        }
                    }
                } 

            case CHGPAR:
                name5 = view.inputClassName(); //gets Class name from user
                if (name5.isBlank()) { //checks for blank input
                    view.invalid();
                    break;
                }
                class1 = model.getClass(name5); //gets Class with name entered; null if not found
                if (class1 == null) { //checks if class exists and exits if doesn't
                    view.notExists("Class", name5);
                    break;
                } else {
                    name1 = view.inputMethodName(); //gets Method name from user
                    if (name1.isBlank()) { //checks for blank input
                        view.invalid();
                        break;
                    }
                    method1 = class1.getMethod(name1); //gets Method with name entered; null if not found
                    if (method1 == null) { //checks if method exists and exits if doesn't
                        view.notExists("Method", name1);
                        break;
                    } else {
                        name2 = view.inputParameterName(); //gets old parameter name from user
                        if (name2.isBlank()) { //checks for blank input
                            view.invalid();
                            break;
                        }
                        if (method1.getParameter(name2) == null) { //checks if parameter exists and exits if doesn't
                            view.notExists("Parameter", name2);
                            break;
                        } else {
                            name3 = view.inputNew("name", "Parameter"); //get new parameter name from user
                            if (name3.isBlank()) { //checks for blank input
                                view.invalid();
                                break;
                            }
                            if (method1.getParameter(name3) != null) { //checks if a parameter already exists with that name exits if does
                                view.exists("Parameter", name3);
                                break;
                            } else {
                                name4 = view.inputNew("type", "Parameter"); //get new parameter type from user
                                if (name4.isBlank()) { //checks for blank input
                                    view.invalid();
                                    break;
                                }
                                boolean changed = method1.changeParameter(name2, name3, name4); //changes the parameter name and type
                                if (changed) {
                                    view.ParameterChange(name2, name3, name4); //prints success message
                                }
                                break;
                            }
                        }
                    }
                       } 
            
            case SAVE:
                //Prompts user for file
                fileName = view.savePrompt();
                // Checks if user wants default file
                if(fileName.isBlank()){
                    
                    save(model, "JAMBL.json");
                }else{
                    // else save to inputted file
                    save(model, fileName);
                }
                
                break;


            case LOAD:
                
                //prompts user for file
                fileName = view.loadPrompt();
                // checks of its default
                if(fileName.isBlank()){
                    load("JAMBL.json");
                }else{
                    // otherwise loads file into current model
                    load(fileName);
                }
                view.loaded();
                break;

            case LISTALL:
                view.listAllClasses(model);
                break;

            case LISTCLA:
                name1 = view.inputClassListed();
                if (model.getClass(name1) == null) {
                    view.notExists("Class", name1);
                    break;
                }else {
                    Class cls = model.getClass(name1);
                    view.listClass(cls);
                }
                break;
            
            case LISTREL:
                view.listRelationship(model);
                break;

            case HELP:
                view.printHelp();
                break;

            case EXIT:
            do {
            name1 = view.exitPrompt();
            if (name1.toUpperCase().equals("YES")) {
                  //Prompts user for file
                  fileName = view.savePrompt();
                  // Checks if user wants default file
                  if(fileName.isBlank()) {
                      
                      save(model, "JAMBL.json");
                  }else{
                      // else save to inputted file
                      save(model, fileName);
                  }
            }
            } while (!name1.toUpperCase().equals("YES") && !name1.toUpperCase().equals("NO"));
            break;

        }

    }

    /*
   	 * @name isValidCmd
   	 * @description	Determines if the command passed in is among the valid commands
   	 * @param otherName The name of the command to check for validity
   	 * @return A boolean value; dependent on the validity of otherName
   	*/
    public boolean isValidCmd (String otherName) {
        boolean validCmd = false;
        for (Command cmd: Command.values()) {
            if (cmd.toString().equals(otherName)) {
                
                validCmd = true;
            }
        }
        return validCmd;
    }
    
    
/*********************************** NEEDS TESTING ***************************************/
    public void save(Model model, String fileName){
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
        this.model = load.loadRelationships(file); ;

    }

/******************************************************************************************/
    

}
        



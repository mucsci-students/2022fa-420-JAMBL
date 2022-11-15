package jambl.Controller.Commands;
import java.util.ArrayList;

import jambl.Controller.History;
import jambl.Model.*;
import jambl.View.*;
import jambl.Model.Class;

public class RetypeCommand implements Command1{
    String name1;
    String name2;
    String name3;
    View view;
    Class classCheck;
    Class class1;
    Class class2;
    Method methodCheck;
    Method methodCheck2;
    History history;
    Model model;
    String element;
    String typeName;
    ArrayList<String> tabArray;

    public RetypeCommand(History hist, Model mod, String ele, View v){
        history = hist;
        model = mod;
        element = ele;
        view = v;
    }

    public void execute(){
        if(element.equals("rel")){
            retypeRel();
        }else if(element.equals("fld")){
            retypeField();
        }else if(element.equals("mtd")){
            retypeMethod();
        }else{
            System.out.println("not a renamble element");
        }
       

    }

    public void retypeRel(){
        name1 =  view.inputAddOriginClass();
            if (name1.isBlank()) { //checks for blank input
                view.invalid();
                return;
            }
            class1 = model.getClass(name1);           
            if (class1 == null) {
                view.originNotExist();
                return;
            }
            name2 = view.inputAddDestinationClass();
            if (name2.isBlank()) { //checks for blank input
                view.invalid();
                return;
            }
            class2 = model.getClass(name2); 
            if (class2 == null) {
                view.destinationNotExist();
                return;
            }
            Relationship rel = class1.getRelationship(name2);
            if (rel == null) {
                view.relNoExist();
                return;
                } 
            typeName = view.inputAddType();
            if (typeName.isBlank()) { //checks for blank input
                view.invalid();
                return;
            }
            if (!class1.isValidType(typeName)) { 
                view.relTypeCheck(typeName);
                return;
            }
            if (rel.getRelType().equals(typeName.toUpperCase())) {
                view.exists("Relationship type", typeName);
                return;
            }
            history.saveState(model);
            class1.editRelationshipType(name2, typeName);
            view.relTypeEdited(class2.TypefullName(typeName));
    
}

    public void retypeField(){
        name1 = view.inputClassName(); //gets class name from user
        if (name1.isBlank()) { //checks for blank input
            view.invalid();
            return;
        }
        class1 = model.getClass(name1); //gets Class with name entered; null if not found
        if (class1 == null) { //checks if class exists and exits if doesn't
            view.notExists("Class", name1);
            return;
        } else {
            name2 = view.inputFieldName(); //gets field name from user
            if (name2.isBlank()) { //checks for blank input
                view.invalid();
                return;
            }
            if (class1.getField(name2) == null) { //checks if field exists and exits if doesn't
                view.notExists("Field", name2);
                return;
            } else {
                name3 = view.inputNew("type", "Field"); //get new field type from user
                if (name3.isBlank()) { //checks for blank input
                    view.invalid();
                    return;
                }
                if ((class1.getField(name2).getFieldType().toUpperCase()).equals(name3.toUpperCase())) { //checks if the current type is the new type, exits if same
                    view.exists("Field type", name3);
                    return;
                } else {
                    history.saveState(model);
                    boolean changed = class1.changefieldType(name2, name3); //changes the field type
                    // update type tab completion
                    if (changed) {
                        tabArray = view.getArray("Type");
                        if(!tabArray.contains(name3)){
                            tabArray.add(name3);
                            view.setArray(tabArray, "Type");
                        }
                        view.Retyped("Field type", name2, name3); //prints success message
                    }
                    return;
                }
            }
        } 

    }

    public void retypeMethod(){
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
            name3 = view.inputType("Return Type");

            if (name3.isBlank()) {
                 view.invalid();
                return;
            }else{
                history.saveState(model);
                //changed Method reurn type
                classCheck.changeMethodreturn(methodCheck, name3);
                // Check to see if type succesfully changed
                if(classCheck.getMethod(name2).getReturnType().equals(name3)){
                    // update type tab completion
                    tabArray = view.getArray("Type");
                    if(!tabArray.contains(name3)){
                        tabArray.add(name3);
                        view.setArray(tabArray, "Type");
                    }
                    view.renamed("Method Return Type", "", name3);
                    return;
                }else{
                    view.Failed("Method Return Type", "Changing");
                }
                
            }  
     
        }
        
    }

      
}


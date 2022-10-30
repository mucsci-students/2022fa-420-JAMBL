package jambl.Controller.Commands;
import jambl.Controller.History;
import jambl.Model.*;
import jambl.View.*;
import jambl.Model.Class;

public class RenameCommand implements Command1{
    String name1;
    String name2;
    String name3;
    String name4;
    String name5;
    Method method1;
    View view = new View();
    Class classCheck;
    Class class1;
    Method methodCheck;
    Method methodCheck2;
    History history;
    Model model;
    String element;

    public RenameCommand(History hist, Model mod, String ele){
        history = hist;
        model = mod;
        element = ele;
    }

    public void execute(){
        if(element.equals("cl")){
            renameClass();
        }else if(element.equals("fld")){
            renameField();
        }else if(element.equals("mtd")){
            renameMethod();
        }else if(element.equals("par")){
            changePar();
        }else{
            System.out.println("not a renamble element");
        }
       

    }

    public void renameClass(){
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
                   history.saveState(model);
                   model.renameClass(name1, name2);
                   view.renamed("Class", name1 , name2);
               }else{
                   view.exists("Class", name2);
               }
           
           } else {
               view.invalid();
           }

    }

    public void renameField(){
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
            name2 = view.inputFieldName(); //gets old field name from user
            if (name2.isBlank()) { //checks for blank input
                view.invalid();
                return;
            }
            if (class1.getField(name2) == null) { //checks if field exists and exits if doesn't
                view.notExists("Field", name2);
                return;
            } else {
                name3 = view.inputNew("name", "Field"); //get new field name from user
                if (name3.isBlank()) { //checks for blank input
                    view.invalid();
                    return;
                }
                if (class1.getField(name3) != null) { //checks if a field already exists with that name exits if does
                    view.exists("Field", name3);
                    return;
                } else {
                    history.saveState(model);
                    boolean renamed = class1.renameField(name2, name3); //changes the field name
                    if (renamed) {
                        view.Renamed("Field", name2, name3); //prints success message
                    }
                    return;
                }
            }
        }  

    }

    public void renameMethod(){
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
               history.saveState(model);
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

    }

    public void changePar(){
        name5 = view.inputClassName(); //gets Class name from user
        if (name5.isBlank()) { //checks for blank input
            view.invalid();
            return;
        }
        class1 = model.getClass(name5); //gets Class with name entered; null if not found
        if (class1 == null) { //checks if class exists and exits if doesn't
            view.notExists("Class", name5);
            return;
        } else {
            name1 = view.inputMethodName(); //gets Method name from user
            if (name1.isBlank()) { //checks for blank input
                view.invalid();
                return;
            }
            method1 = class1.getMethod(name1); //gets Method with name entered; null if not found
            if (method1 == null) { //checks if method exists and exits if doesn't
                view.notExists("Method", name1);
                return;
            } else {
                name2 = view.inputParameterName(); //gets old parameter name from user
                if (name2.isBlank()) { //checks for blank input
                    view.invalid();
                    return;
                }
                if (method1.getParameter(name2) == null) { //checks if parameter exists and exits if doesn't
                    view.notExists("Parameter", name2);
                    return;
                } else {
                    name3 = view.inputNew("name", "Parameter"); //get new parameter name from user
                    if (name3.isBlank()) { //checks for blank input
                        view.invalid();
                        return;
                    }
                    if (method1.getParameter(name3) != null) { //checks if a parameter already exists with that name exits if does
                        view.exists("Parameter", name3);
                        return;
                    } else {
                        name4 = view.inputNew("type", "Parameter"); //get new parameter type from user
                        if (name4.isBlank()) { //checks for blank input
                            view.invalid();
                            return;
                        }
                        history.saveState(model);
                        boolean changed = method1.changeParameter(name2, name3, name4); //changes the parameter name and type
                        if (changed) {
                            view.ParameterChange(name2, name3, name4); //prints success message
                        }
                        return;
                    }
                }
            }
         } 
    }

      
}


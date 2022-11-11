package jambl.Controller.Commands;
import java.util.ArrayList;

import jambl.Controller.History;
import jambl.Model.*;
import jambl.View.*;
import jambl.Model.Class;

public class MethodCommand implements Command2{
    String name1;
    String name2;
    String name3;
    View view;
    Class classCheck;
    History history;
    Model model;
    Method methodCheck;
    ArrayList<String> tabArray;

    public MethodCommand(History hist, Model mod, View v){
        history = hist;
        model = mod;
        view = v;
    }

    public void execute(){
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
            name3 = view.inputType("Method Return Type");
            history.saveState(model);
            classCheck.addMethod(name2, name3);

        }

        // Checks to see if the method was added successfully and notifies user
        if(classCheck.getMethod(name2) != null){

            // updates tab completion
            tabArray = view.getArray("Method");
            tabArray.add(name2);
            view.setArray(tabArray, "Method");

            tabArray = view.getArray("Type");
            if(!tabArray.contains(name3)){
                tabArray.add(name3);
                view.setArray(tabArray, "Type");
            }

            view.Added(name2, "Method");
        }else {
            view.Failed("Method", "Adding");
        }
        
        
    }

    public void unexecute(){
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
             history.saveState(model);
             // deleted method
             classCheck.deleteMethod(methodCheck);
         }

         // Checks to see if the method was deleted successfully and notifies user
         if(classCheck.getMethod(name2) == null){

            // updates tab completion
            tabArray = view.getArray("Method");
            tabArray.remove(name2);
            view.setArray(tabArray, "Method");
            
            view.Deleted(name2, "Method");
         }else {
            view.Failed("Method", "Deleting");
         }
    }
}

package jambl.Controller.Commands;

import java.util.ArrayList;

import jambl.Controller.History;
import jambl.Model.*;
import jambl.View.*;
import jambl.Model.Class;

public class ClassCommand implements Command2 {
    History history;
    Model model;
    View view;
    String name1;
    Class classCheck;

    public ClassCommand(History hist, Model mod, View v){
        history = hist;
        model = mod;
        view = v;
    }

    public void execute(){
         // prompts user and stores input in name1 variable
         name1 = view.inputAdd("Class");
         classCheck = model.getClass(name1);
         // if input not blank add class
         if ((!name1.isBlank()) && (classCheck == null)) {
              history.saveState(model);
             // adds class
              model.addClass(name1);

              // Checks to see if class was succesfully added
              if(model.getClass(name1) != null){
                
                // updates tab completion
                ArrayList<String> tabArray = view.getArray("Class");
                tabArray.add(name1);
                view.setArray(tabArray, "Class");

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

    }

    public void unexecute(){
        
          // prompts user and stores input in name1 variable
          name1 = view.inputDel("Class");
          classCheck = model.getClass(name1);
           // checks to see if input was blank
           if ((!name1.isBlank()) && (classCheck != null) ) {
               history.saveState(model);
               model.deleteClass(classCheck);
               // if class deleted returned equals true and user is notified
               if(model.getClass(name1) == null){
                   view.Deleted("Class", name1);

                   // updates tab completion
                    ArrayList<String> tabArray = view.getArray("Class");
                    tabArray.remove(name1);
                    view.setArray(tabArray, "Class");
                   
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

    }


    
}

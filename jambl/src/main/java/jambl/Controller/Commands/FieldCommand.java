package jambl.Controller.Commands;
import java.util.ArrayList;

import jambl.Controller.History;
import jambl.Model.*;
import jambl.View.*;
import jambl.Model.Class;

public class FieldCommand implements Command2{
    String name1;
    String name2;
    String name3;
    View view;
    Class class1;
    History history;
    Model model;
    ArrayList<String> tabArray;

    public FieldCommand(History hist, Model mod, View v){
        history = hist;
        model = mod;
        view = v;
    }

    public void execute(){
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
            name2 = view.inputAdd("Field"); //gets the name for the field
            if (name2.isBlank()) { //checks for blank input
                view.invalid();
                return;
            }
            
            if (class1.getField(name2) != null) { //checks if field already exists and exits if does
                view.exists("Field", name2);
                return;
            } else {
                name3 = view.inputFieldType(); //gets type for the field
                if (name3.isBlank()) { //checks for blank input
                    view.invalid();
                    return;
                }
                history.saveState(model);
                boolean added = class1.addField(name2, name3); //adds it to the fields set
                if (added) {
                    // updates tab completion
                    tabArray = view.getArray("Field");
                    tabArray.add(name2);
                    view.setArray(tabArray, "Field");

                    // updates tab completion
                    tabArray = view.getArray("Type");
                    if(!tabArray.contains(name3)){
                        tabArray.add(name3);
                        view.setArray(tabArray, "Type");
                    }
                    

                    view.Added(name3, name2); //prints success messaage
                }
                return;
            }
        }

    }

    public void unexecute(){
        name1 = view.inputClassName(); //gets class name from user
        if (name1.isBlank()) { //checks for blank input
            view.invalid();
            return;
        }
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
                history.saveState(model);
                boolean removed = class1.deleteField(name2); //removes the field from the set
                if (removed) {

                    // updates tab completion
                    tabArray = view.getArray("Field");
                    tabArray.remove(name2);
                    view.setArray(tabArray, "Field");

                    view.Deleted("Field", name2); //prints success message
                }
                return;
            }
        } 

    }
}

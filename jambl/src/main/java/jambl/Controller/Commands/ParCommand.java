package jambl.Controller.Commands;
import jambl.Controller.History;
import jambl.Model.*;
import jambl.View.*;
import jambl.Model.Class;

public class ParCommand implements Command2{
    
    String name1;
    String name2;
    String name3;
    String name5;
    String name7;
    View view = new View();
    Class class1;
    Method method1;
    History history;
    Model model;

    public ParCommand(History hist, Model mod){
        history = hist;
        model = mod;
    }

    @Override
    public void execute(){
        
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
                name2 = view.inputParameterName(); //gets the name for the parameter
                if (name2.isBlank()) { //checks for blank input
                    view.invalid();
                    return;
                }
                if (method1.getParameter(name2) != null) { //checks if parameter already exists and exits if does
                    view.exists("Parameter", name2);
                    return;
                } else {
                    name3 = view.inputParameterType(); //gets type for the parameter
                    if (name3.isBlank()) { //checks for blank input
                        view.invalid();
                        return;
                    }
                    history.saveState(model);
                    boolean added = method1.addParameter(name2, name3); //adds it to the parameters set
                    if (added) {
                        view.Added(name3, name2); //prints success messaage
                    }
                    return;
                }
            }
        }
       

    }

    @Override
    public void unexecute(){

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
                name7 = view.inputDeleteAll();//gets whether user wants to delete all parameters or just one
                if (name7.isBlank()) { //checks for blank input
                    view.invalid();
                    return;
                }
                if(name7.toUpperCase().equals("YES")){
                    history.saveState(model);
                    boolean removed = method1.deleteAllParameter(); //removes all parameters from the set
                    if (removed) {
                        view.Deleted("All", "Parameter"); //prints success message
                    }
                    return;
                } else if(name7.toUpperCase().equals("NO")){
                    name2 = view.inputParameterName(); //gets parameter name from user
                    if (name2.isBlank()) { //checks for blank input
                        view.invalid();
                        return;
                    }
                    if (method1.getParameter(name2) == null) { //checks if parameter exists and exits if doesn't
                        view.notExists("Parameter", name2);
                        return;
                    } else {
                        history.saveState(model);
                        boolean removed = method1.deleteParameter(name2); //removes the parameter from the set
                        if (removed) {
                            view.Deleted("Parameter", name2); //prints success message
                        }
                        return;
                    } 
                }
            }
        } 
    }


}






package jambl.Controller.Commands;
import jambl.Controller.History;
import jambl.Model.*;
import jambl.View.*;
import jambl.Model.Class;

public class RelCommand implements Command2{
    String name1;
    String name2;
    String name3;
    String typeName;
    Boolean returned;
    View view;
    Class class1;
    Class class2;
    History history;
    Model model;

    public RelCommand(History hist, Model mod, View v){
        history = hist;
        model = mod;
        view = v;
    }

    
    @Override
    public void execute(){
        name1 =  view.inputAddOriginClass();
               
        class1 = model.getClass(name1);
        if (class1 == null ) {
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

        typeName = view.inputAddType();
        if (typeName.isBlank()) { //checks for blank input
            view.invalid();
            return;
        }
        
        if (class1.isRelationshipExist(name2)){
            view.relExists();
            return;
        } 
        if (!class1.isValidType(typeName)){ 
            view.relTypeCheck(typeName);
        } else {
            history.saveState(model);
            returned = class1.addRelationship(class2, typeName);
            // notifies user that relationship was added
            if(returned){
                view.AddedRel(class1.getClassName(), class2.getClassName(), class2.TypefullName(typeName));
            }
        } 

    }

    @Override
    public void unexecute(){
        name1 = view.inputDelOriginClass();
                
        if (model.getClass(name1) == null) {
            view.originNotExist();
            return;
        }
        name2 = view.inputDelDestinationClass();
        if (name2.isBlank()) { //checks for blank input
            view.invalid();
            return;
        }
        if (model.getClass(name2) == null) {
            view.destinationNotExist();
            return;
        } else {
            history.saveState(model);
            model.getClass(name1).deleteRelationship(name2);
            view.relDeleted();
        } 
        return;
    }
}

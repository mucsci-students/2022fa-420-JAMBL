package jambl.Controller.Commands;

import java.util.ArrayList;
import java.util.HashSet;

import jambl.Controller.History;
import jambl.Controller.Load;
import jambl.Controller.Memento;
import jambl.Model.Model;
import jambl.Model.Parameter;
import jambl.Model.Class;
import jambl.Model.Field;
import jambl.Model.Method;
import jambl.View.*;

public class DoCommand implements Command2 {

    History history;
    Model model;
    View view;
    ArrayList<String> tabClasses = new ArrayList<String>();
    ArrayList<String> tabMethods = new ArrayList<String>();
    ArrayList<String> tabFields = new ArrayList<String>();
    ArrayList<String> tabParams = new ArrayList<String>();
    ArrayList<String> tabTypes = new ArrayList<String>();


    
    public DoCommand(History hist, Model mod, View v){
        history = hist;
        model = mod;
        view = v;


    }

    public void execute(){
        Memento redo = history.redoState(this.model); //saves the current state of model and gets the redo state
        if (redo == null) { // if no redos available nothing happens
            return;
        } else {
            Load newState = new Load(); //new loading object to load the redo state
            newState.loadClasses(redo.getState()); //loads that classes of the redo state
            this.model = newState.loadRelationships(redo.getState()); //loads the relationships of the redo state

            // updates tab completion
            updateTabs();
        }

    }

    public void unexecute(){
        Memento undo = history.undoState(this.model); //saves the current state of the model and gets the undo state
                if (undo == null) { //if there are no undos available nothing happens
                    return;
                } else {
                    Load newState = new Load(); // new loading object to load the undo state
                    newState.loadClasses(undo.getState()); //loads the classes of the undo state
                    this.model = newState.loadRelationships(undo.getState()); //loads the relationships of the undo state and

                    // updates tab completion
                    updateTabs();
                }

    }

    public Model getModel(){
        return this.model;
    }

    public void updateTabs(){
        HashSet<Class> classes = this.model.getClasses();
        String type;
        for(Class aClass : classes){
            tabClasses.add(aClass.getClassName());
            HashSet<Field> fields = aClass.getFields();
            HashSet<Method> methods = aClass.getMethods();

            for(Field aField : fields){
                tabFields.add(aField.getFieldName());
                type = aField.getFieldType();
                if(!tabTypes.contains(type)){
                    tabTypes.add(type);
                }
            }

            for(Method aMethod : methods){
                tabMethods.add(aMethod.getMethodName());
                type = aMethod.getReturnType();
                if(!tabTypes.contains(type)){
                    tabTypes.add(type);
                }

                HashSet<Parameter> params = aMethod.getParameters();
                for(Parameter aParam : params){
                    tabParams.add(aParam.getParamName());
                    type = aParam.getParamType();
                    if(!tabTypes.contains(type)){
                        tabTypes.add(type);
                    }


                }

            }
        }

        view.setArrays(tabClasses, tabFields, tabMethods, tabParams, tabTypes);
    }


}

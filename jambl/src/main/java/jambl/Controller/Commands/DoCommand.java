package jambl.Controller.Commands;

import jambl.Controller.History;
import jambl.Controller.Load;
import jambl.Controller.Memento;
import jambl.Model.Model;

public class DoCommand implements Command2 {

    History history;
    Model model;

    
    public DoCommand(History hist, Model mod){
        history = hist;
        model = mod;

    }

    public void execute(){
        Memento redo = history.redoState(this.model); //saves the current state of model and gets the redo state
        if (redo == null) { // if no redos available nothing happens
            return;
        } else {
            Load newState = new Load(); //new loading object to load the redo state
            newState.loadClasses(redo.getState()); //loads that classes of the redo state
            this.model = newState.loadRelationships(redo.getState()); //loads the relationships of the redo state
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
                }

    }

    public Model getModel(){
        return this.model;
    }


}

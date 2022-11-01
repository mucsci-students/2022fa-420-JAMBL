package jambl.Controller;

import java.util.*;
import jambl.Model.*;

/*
 * @projectDescription	A program to make UML diagrams
 * 
 * @authors	John Shenk, Benjamin Slinghoff, Lauryn Simmons, Alex Peiffer, Meba Shimelis
 * @version 0.0.1
 * @dateLastModified October 22, 2022
 * 
 * @classDescription This class is used to manage all the save states of the program for undo/redo
 */

public class History {

    private Stack<Memento> undo = new Stack<Memento>();
    private Stack<Memento> redo = new Stack<Memento>();
    private boolean undoCalled = false; //denotes whether an undo has been called so the redo stack can be flushed upon a new change

    /*********************************************************************
    *This method captures the current state of the model and puts it on the
    *undo stack.  
    *Parameters: Model state is the model before a change is made.
    *Returns:
    *Prerequisites: Change to model should not have been completed when this method is called.
    **********************************************************************/
    public void saveState (Model state) {
        if (undoCalled) { //clears the redo stack if undo had been made and then a new change occured
            redo.clear();
            undoCalled = false; //resets the marker
        }
        undo.push(new Memento(state)); //adds the state as a Memento to the undo stack
    }

    /*********************************************************************
    *This method performs the undo functionality by adding current state to 
    *redo stack and popping the previous state from the undo stack to be returned.
    *Parameters: Model state is the current model before undo command
    *Returns: returns a Memento that is the previous state of the model from before last action
    *Prerequisites: a change should have been done before a undo can be performed
    **********************************************************************/
    public Memento undoState (Model state) {
        if (undo.empty()) { //if there are no undos in the stack null is returned
            return null;
        } else {
            undoCalled = true; //set the marker
            Model oldState = state;
            redo.push(new Memento(oldState)); //creates a new Memento and puts it on the redo stack
            return undo.pop(); //pops and returns the Memento from undo stack
        }
    }

    /*********************************************************************
    *This method performs the redo functionality by adding current state to 
    *undo stack and popping the previous state from the redo stack to be returned.
    *Parameters: Model state is the current model before redo command
    *Returns: returns a Memento that is the previous state of the model from before an undo
    *Prerequisites: undo should have been done already before a redo can be performed
    **********************************************************************/
    public Memento redoState (Model state) {
        if (redo.empty()) { //if there are no redos then it returns null
            return null;
        }
        undo.push(new Memento(state)); //push the current state back onto the undo stack
        return redo.pop(); //pop and return a Memento from the redo stack
    }
    
    /*********************************************************************
    *This method clears the action history of the current program for when a 
    *different file is loaded.
    *Parameters: 
    *Returns: 
    *Prerequisites: should be used after a load command
    **********************************************************************/
    public void newWorkflow () {
        undo.clear();
        redo.clear();
        undoCalled = false;
    }
}

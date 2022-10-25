package jambl.Controller;

import org.json.simple.JSONObject;

import jambl.Model.*;

/*
 * @projectDescription	A program to make UML diagrams
 * 
 * @authors	John Shenk, Benjamin Slinghoff, Lauryn Simmons, Alex Peiffer, Meba Shimelis
 * @version 0.0.1
 * @dateLastModified October 22, 2022
 * 
 * @classDescription This class is used to capture the state of the diagram before a change is made
 */
 

public class Memento {

    private JSONObject state = new JSONObject();

    //constructor for a Memento takes a Model as parameter
    public Memento (Model model) {
        Save save = new Save (model);
        state.put("classes", save.classes());
        state.put("relationships", save.relationships());
    }

    //getter for the state of the Memento
    public JSONObject getState() {
        return state;
    }
}

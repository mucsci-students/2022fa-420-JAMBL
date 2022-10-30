package jambl.Controller;
import jambl.Controller.Commands.ClassCommand;
import jambl.Controller.Commands.DoCommand;
import jambl.Controller.Commands.ExitCommand;
import jambl.Controller.Commands.FieldCommand;
import jambl.Controller.Commands.HelpCommand;
import jambl.Controller.Commands.ListCommand;
import jambl.Controller.Commands.LoadCommand;
import jambl.Controller.Commands.MethodCommand;
import jambl.Controller.Commands.ParCommand;
import jambl.Controller.Commands.RelCommand;
import jambl.Controller.Commands.RenameCommand;
import jambl.Controller.Commands.RetypeCommand;
import jambl.Controller.Commands.SaveCommand;
import jambl.Model.*;
import jambl.Model.Class;
import jambl.View.*;
/*
 * @projectDescription	A program for adding classes to a database
 * 
 * @authors	John Shenk, Benjamin Slinghoff, Lauryn Simmons, Alex Peiffer, Meba Shimelis
 * @version 0.0.1
 * @dateLastModified September 13, 2022
 */

import java.util.*;

import javax.swing.JButton;

import java.io.*;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Controller {
   
    private Model model = new Model();
    private View view;
    private GUIView GUI;
    private History history = new History ();

    public static enum Command {
    START ("START"), //initial starting state Command not to be displayed in HELP
    ADDCL ("ADDCL"), //add class
    DELCL ("DELCL"), //delete class
    RENCL ("RENCL"), //rename class
    ADDREL ("ADDREL"), //add relationship
    DELREL ("DELREL"), //delete relationship
    RELTYPE ("RELTYPE"), //edit relationship type
    ADDFLD ("ADDFLD"), //add field
    DELFLD ("DELFLD"), //delete field
    RENFLD ("RENFLD"), //rename field
    FLDTYPE ("FLDTYPE"), //field return type
    ADDMTD ("ADDMTD"), //add method
    DELMTD ("DELMTD"), //delete method
    RENMTD ("RENMTD"), //rename Method 
    MTDTYPE ("MTDTYPE"), //Method return type 
    ADDPAR ("ADDPAR"), //add Parameter
    DELPAR ("DELPAR"), //delete Parameter
    CHGPAR ("CHGPAR"), //change Parameter type and name
    SAVE ("SAVE"), //save diagram
    LOAD ("LOAD"), //load diagram
    LISTALL ("LISTALL"), //list all classes
    LISTCLA ("LISTCLA"), //list all attributes of a class
    LISTREL ("LISTREL"), //list all relationships between classes
    UNDO ("UNDO"), //Undo most recent change
    REDO ("REDO"), //Redo most recent undo
    HELP ("HELP"), //shows the command list and how to use them
    EXIT ("EXIT") ; //quits the program

    private String name;

    private Command (String name) {
        this.name = name;
    }

    public String toString() {
       return this.name;
    }
   }


    public Controller (Model model , View view) {

    this.model = model;
    // initialized the CLI view
    this.view  = view;

   }
    
    public Controller (Model model, GUIView gui) {
    	this.model = model;
    	GUI = gui;
    }

    /*
	 * @name commandExecute
	 * @description	Reads a command and executes that command
	 * @param curerentCmd
	*/
    public void commandExecute (Command currentCmd) {
        Scanner scanner = new Scanner(System.in);
        String name1;
        String name2;
        String name3;
        String name4;
        String name5;
        String name7;
        Class class1;
        Class class2;
        Class classCheck;
        Method method1;
        Method methodCheck;
        Method methodCheck2;
        String fileName;
        boolean returned;
        String typeName;
        

        switch (currentCmd) {

            case START: 
                break;

            case ADDCL:
                // creates a class command object and adds class by executing the command
                ClassCommand addcl = new ClassCommand(history, model, view);
                addcl.execute();
                break;

            case DELCL:

                // creates a class command object and deletes class by unexecuting the addcl
                ClassCommand delcl = new ClassCommand(history, model, view);
                delcl.unexecute();
                break;

            case RENCL:

                RenameCommand rencl = new RenameCommand(history, model, "cl", view);
                rencl.execute();
                break;


            case ADDFLD:

                // Created Field commmand object adds class by executing
                FieldCommand addfld = new FieldCommand(history, model, view);
                addfld.execute();
                break;
                
            case DELFLD:

                // Created Field commmand object deleted class by unexecuting
                FieldCommand delfld = new FieldCommand(history, model, view);
                delfld.unexecute();
                break;

            case RENFLD:

                RenameCommand renfld = new RenameCommand(history, model, "fld", view);
                renfld.execute();
                break;

            case FLDTYPE:

                RetypeCommand fldtype = new RetypeCommand(history, model,"fld", view);
                fldtype.execute();
                break;

            case ADDMTD:

                // Create a Method command object can add method by executing
                MethodCommand addmtd = new MethodCommand(history, model, view);
                addmtd.execute();
                break; 
        
            case DELMTD:

                // Creates a Method command object and deletes by unexecuting command
                MethodCommand delmtd = new MethodCommand(history, model, view);
                delmtd.unexecute();
                break; 
    
            case RENMTD:

                RenameCommand renmtd = new RenameCommand(history, model, "mtd", view);
                renmtd.execute();
                break;

            case MTDTYPE:
            
                RetypeCommand mtdtype = new RetypeCommand(history, model,"mtd", view);
                mtdtype.execute();
                break; 

            case ADDREL:
                
                RelCommand addrel = new RelCommand(history, model, view);
                addrel.execute();
                break;

            case DELREL:

                RelCommand delrel = new RelCommand(history, model, view);
                delrel.unexecute();
                break;

            case RELTYPE:

                RetypeCommand reltype = new RetypeCommand(history, model,"rel", view);
                reltype.execute();
                break;

           case ADDPAR:

                ParCommand addpar = new ParCommand(history, model, view);
                addpar.execute();
                break;

            case DELPAR:

                ParCommand delpar = new ParCommand(history, model, view);
                delpar.unexecute();
                break;

            case CHGPAR:

               RenameCommand chgpar = new RenameCommand(history, model, "par", view);
               chgpar.execute();
               break;
            
            case SAVE:

                SaveCommand save = new SaveCommand(model, view);
                save.execute(); 
                break;

            case LOAD:

                LoadCommand load = new LoadCommand(history, model, view);
                load.execute();
                this.model = load.getModel();
                break;

            case LISTALL:

                ListCommand listall = new ListCommand(model, "all", view);
                listall.execute();
                break;

            case LISTCLA:

                ListCommand listcla = new ListCommand(model, "cla", view);
                listcla.execute();
                break;
            
            case LISTREL:

                ListCommand listrel = new ListCommand(model, "rel", view);
                listrel.execute();
                break;
            
            case REDO:

                DoCommand redo = new DoCommand(history, model);
                redo.execute();
                this.model = redo.getModel();
                break;
            
            case UNDO:

                DoCommand undo = new DoCommand(history, model);
                undo.unexecute();
                this.model = undo.getModel();
                break;
                
            case HELP:

                HelpCommand help = new HelpCommand(view);
                help.execute();
                break;

            case EXIT:

                ExitCommand exit = new ExitCommand(model, view);
                exit.execute();
                break;

        }

    }

    /*
   	 * @name isValidCmd
   	 * @description	Determines if the command passed in is among the valid commands
   	 * @param otherName The name of the command to check for validity
   	 * @return A boolean value; dependent on the validity of otherName
   	*/
    public boolean isValidCmd (String otherName) {
        boolean validCmd = false;
        for (Command cmd: Command.values()) {
            if (cmd.toString().equals(otherName)) {
                
                validCmd = true;
            }
        }
        return validCmd;
    }
    
    

    public void save(Model model, String fileName){
        Save saving = new Save(model);
        JSONObject fileObj = new JSONObject();
        fileObj.put("classes", saving.classes());
        fileObj.put("relationships", saving.relationships());

        try{
            // creates new file  if ther is not one
            FileWriter file = new FileWriter(fileName);
            // turns object to string and save to file
            file.write(fileObj.toJSONString());
            file.close();
            
        }catch(Exception e){
            System.out.println("Could not write file" + e);
        }
    }


    // CAN BE DELETED
   /* public void load(String fileName){
        
         Load load = new Load();
         
        // get object of file contents
        JSONObject file = load.getFile(fileName);

        // adds the classes with the fields, methods and parameters ect.
        load.loadClasses(file);

        // loads relationships into classes
        this.model = load.loadRelationships(file);

    } */


    // Get model for testing
    
    public Model getModel(){
       return this.model;
    }
    

}
        



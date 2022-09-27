
/*
 * @projectDescription	A program for adding classes to a database
 * 
 * @authors	John Shenk, Benjamin Slinghoff, Lauryn Simmons, Alex Peiffer, Meba Shimelis
 * @version 0.0.1
 * @dateLastModified September 13, 2022
 */

import java.util.*;


import java.util.*;
import java.io.*;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Controller {
   
    private Model model = new Model();
    private View view;

    public static enum Command {
    START ("START"), //initial starting state Command not to be displayed in HELP
    ADDCL ("ADDCL"), //add class
    DELCL ("DELCL"), //delete class
    RENCL ("RENCL"), //rename class
    ADDREL ("ADDREL"), //add relationship
    DELREL ("DELREL"), //delete relationship
    ADDATT ("ADDATT"), //add attribute
    DELATT ("DELATT"), //delete attribute
    RENATT ("RENATT"), //rename attribute
    SAVE ("SAVE"), //save diagram
    LOAD ("LOAD"), //load diagram
    LISTALL ("LISTALL"), //list all classes
    LISTCLA ("LISTCLA"), //list all attributes of a class
    LISTREL ("LISTREL"), //list all relationships between classes
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
        Class class1;
        Class class2;
        String fileName;
        boolean returned;
        String typeName;
        

        switch (currentCmd) {

            case START: 
                break;

            case ADDCL:
            
                // prompts user and stores input in name1 variable
                name1 = view.inputAddClass();
                // if input not blank add class
                if (!name1.isBlank()) {
                    returned = model.addClass(name1);
                    
                    if(returned){
                        
                        // if class successfully added notify user
                        view.Added("Class", name1);
                        
                    }else{
                        // if the added class returns false
                        view.exists("Class" , name1);    
                    }
                    
                } else {
                    // if input is empty return invalid input message
                    view.invalid();
                }
                break;

            case DELCL:

                // prompts user and stores input in name1 variable
               name1 = view.inputDelClass();
                // checks to see if input was blank
                if (!name1.isBlank()) {
                    returned = model.deleteClass(name1);
                    // if class deleted returned equals true and user is notified
                    if(returned){
                        view.Deleted("Class", name1);
                        
                    }else{ // if class not found returned is false and user is notified
                        view.notExists("Class", name1);
                    }
                
                } else {
                    //tells user input was invalid
                    view.invalid();
                }
                break;

            case RENCL:
              // prompts user and stores input in name1 variable
              name1 = view.inputRenClass();
                if (!name1.isBlank()) {
                    // continue as normal
                    } else {
                        view.invalid();
                        return;
                    }
                System.out.println("New name: ");
                name2 = scanner.nextLine();
                if (!name2.isBlank()) {
                model.renameClass(name1, name2);
                } else {
                    view.invalid();
                }
                break;
            case ADDREL:
                name1 =  view.inputAddOriginClass();
                name2 = view.inputAddDestinationClass();
                class1 = model.getClass(name1);
                class2 = model.getClass(name2);
                if (class1 == null) {
                    view.originNotExist();
                    break;
                } else if (class2 == null) {
                    view.destinationNotExist();
                    break;
                } else {
                    typeName = view.inputAddType();
                    returned = class1.addRelationship(class2, typeName);
                    // notifies user that relationship was added
                    if(returned){
                        view.AddedRel(class1.getClassName(), class2.getClassName(), typeName);
                    }
                } 
                break;

            case DELREL:
                
                name1 = view.inputDelOriginClass();
                
                name2 = view.inputDelDestinationClass();
                if (model.getClass(name1) == null) {
                    view.originNotExist();
                    break;
                } else if (model.getClass(name2) == null) {
                    view.destinationNotExist();
                    break;
                } else {
                    model.getClass(name1).deleteRelationship(name2);
                    //System.out.println("Relationship removed from " + name1 + " to " + name2 + "!");
                    view.relDeleted();
                } 
                break;

            case ADDATT:
                System.out.println("Name of Class receiving Attribute: ");
                name1 = scanner.nextLine();
                System.out.println("Name of Attribute: ");
                name2 = scanner.nextLine();
                
                if (!name2.isBlank()) {
                    if (model.getClass(name1) == null) {
                        System.out.println("Class does not exists! Addition of Attribute failed!");
                        break;
                    }
                    returned = model.getClass(name1).addAttribute(name2);
                    // if returned is true notifies user that attribute was added
                    if(returned){
                        view.Added("Attribute", name2);
                    }
                    
                } else {
                    // if input is blank notifes user that input was invalid
                    view.invalid();
                }
                
                break;
                
            case DELATT:
                System.out.println("Name of Class removing Attribute: ");
                name1 = scanner.nextLine();
                System.out.println("Name of Attribute to be removed: ");
                name2 = scanner.nextLine();
                
                if (model.getClass(name1) == null) {
                    System.out.println("Class does not exists! Removal of Attribute failed!");
                    break;
                } else {
                    model.getClass(name1).deleteAttribute(name2);
                } 
                break;

            case RENATT:
                System.out.println("Name of Class renaming Attribute: ");
                name1 = scanner.nextLine();
                System.out.println("Name of Attribute to be changed: ");
                name2 = scanner.nextLine();
                System.out.println("New name of Attribute: ");
                name3 = scanner.nextLine();
                class1 = model.getClass(name1);
                if (!name3.isBlank()) {
                    if (class1 == null) {
                        view.notExists("Class", name1);
                        break;
                    } else {
                        class1. renameAttribute(name2, name3);
                    }
                } else {
                   view.invalid();
                } 
                break;
            
            case SAVE:
                //Prompts user for file
                System.out.println("Input file you want to save to or press enter for dafault file.");
                fileName = scanner.nextLine();
                // Checks if user wants default file
                if(fileName.equals("")){
                    
                    save(model, "JAMBL.json");
                }else{
                    // else save to inputted file
                    save(model, fileName);
                }
                
                break;


            case LOAD:
                
                //prompts user for file
                System.out.println("Input file you want loaded or press enter for default file.");
                fileName = scanner.nextLine();
                // checks of its default
                if(fileName.toUpperCase().equals("")){
                    load("JAMBL.json");
                }else{
                    // otherwise loads file into current model
                    load(fileName);
                }
                view.loaded();
                break;

            case LISTALL:
                view.listAllClasses(model);
                break;

            case LISTCLA:
                name1 = view.inputClassListed();
                if (model.getClass(name1) == null) {
                    view.notExists("Class", name1);
                    break;
                }else {
                    Class cls = model.getClass(name1);
                    view.listClass(cls);
                }
                break;
            
            case LISTREL:
                view.listRelationship(model);
                break;

            case HELP:
                view.printHelp();
                break;

            case EXIT:
            System.out.println("Would you like to SAVE before quitting? (YES/NO)");
            name1 = scanner.nextLine();
            if (name1.toUpperCase().equals("YES")) {
                  //Prompts user for file
                  System.out.println("Name file you want to save to or press enter for default file.");
                  fileName = scanner.nextLine();
                  // Checks if user wants default file
                  if(fileName.equals("")) {
                      
                      save(model, "JAMBL.json");
                  }else{
                      // else save to inputted file
                      save(model, fileName);
                  }
            }
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
        JSONObject obj1 = new JSONObject();
        JSONObject obj2;
        HashSet<Class> classes = model.classes;
        HashSet<Attribute> atts;
        HashSet<Relationship> rels;
        HashSet<String> attSet = new HashSet<String>();
        HashSet<String> relSet = new HashSet<String>();
        Class curr;
        Relationship relationship;
        Attribute attribute;
        Iterator<Class> itClasses = classes.iterator();
        Iterator<Attribute> itAtts;
        Iterator<Relationship> itRels;
        String classStr = "";
        String attStr = "";
        String relsStr = "";
        
        //iterates through classes
        while(itClasses.hasNext()){
            curr = (Class) itClasses.next();
            classStr = curr.getClassName();
            atts = curr.attributes;
            rels = curr.relationships;
            itRels = rels.iterator();
            itAtts = atts.iterator();
            

            // iterate through relationship HashSet
            // Iterates through a class' relationships
            while(itRels.hasNext()){
                relationship = (Relationship) itRels.next();
                relSet.add(relationship.getDestination().getClassName());
                //relsStr = relationship.getDestination().getClassName() + ", " + relsStr;
            }
            // joins them into a string
            relsStr = String.join(", ", relSet);
            // cleared set for next class iteration
            relSet.clear();
            
            // Iterates through a class' attributes
            while(itAtts.hasNext()){
                attribute = (Attribute) itAtts.next();
                attSet.add(attribute.getAttName());
                //attStr = attStr + ", " + attribute.getAttName();
            }
            // joins into a string
            attStr = String.join(", ", attSet);
            // clears for next class iteration
            attSet.clear();
            //adds attributes and relationship to new object
            obj2 = new  JSONObject();
            obj2.put( "Attributes", attStr);
            obj2.put("Relationships", relsStr);
            // adds class and rel/att object to a new object
            obj1.put(classStr, obj2);
        }

        try{
            // creates new file  if ther is not one
            FileWriter file = new FileWriter(fileName);
            // turns object to string and save to file
            file.write(obj1.toJSONString());
            file.close();
            System.out.println("UML Diagram Saved!");
        }catch(Exception e){
            System.out.println("Could not write file" + e);
        }
        
    }


        public Model load(String file){
        Model lModel = new Model();
        JSONObject obj1;
        JSONObject obj2;
        JSONParser parser;
        Object fileContent;
        Set<Object> classesSet;
        Iterator<Object> itClasses;
        String currClass;
        String classAtts;
        String classRels;
        String typeName;

        File checkContent = new File(file);
        if(checkContent.length() == 0){
            return lModel;

        }else{
            // JSON object that will hold the Model Content
            obj1 = new JSONObject();
            // parser to scan through the file
            parser = new JSONParser();

            try{
                // gets file content
                fileContent = parser.parse(new FileReader(file));
                // sets the file content to a json object
                obj1 = (JSONObject) fileContent;
                classesSet = obj1.keySet();
                itClasses = classesSet.iterator();
                // creates the classes and adds to Model
                while(itClasses.hasNext()){
                    currClass = itClasses.next().toString();
                    model.addClass(currClass);
                }
                 for(Class aClass : model.classes){
                    // gets the object key value
                    obj2 = (JSONObject) obj1.get(aClass.getClassName());
                    classAtts = obj2.get("Attributes").toString();
                    classRels = obj2.get("Relationships").toString();

                   // System.out.println(classA);
                    // Splits obj2 strings into string arrays
                    String attArray[] = classAtts.split(", ");
                    String relArray[] = classRels.split(", ");
                    
                    // for every attribute in array adds it to current class
                    if(attArray.length > 0){
                        // for every element in the array add attribute if not empty
                        for(String att : attArray){
                            if(att.equals("")){
                            // do nothing
                            }else{
                                //add attribute to current class
                                aClass.addAttribute(att);
                            } 
                        }
                    }
                    
                    // for every relationship in array adds it to current class
                    if(relArray.length > 0){
                        // for every relationship add it to current class unless empty
                        
                        for(String rel : relArray){
                            if(rel.equals("")){
                                //do nothing
                            }else{
                                // add relationship to current class
                                typeName = null;
                                for (Relationship.Type type: Relationship.Type.values()){
                                    if (type.name().equals(typeName)){
                                        typeName =  type.name();
                                    }
                                }
                                aClass.addRelationship(model.getClass(rel), typeName);
                            }
                            // finds the destination class and adds relationshi   
                        } 
                    }  
                 }
                
            }catch(Exception e){
                System.out.println("Could not read file" + e);
            }
        }
        return lModel;
    } 

}
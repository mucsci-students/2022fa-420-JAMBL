
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
    LISTCLS ("LISTCLS"), //list all classes
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


    public Controller (Model model) {

    this.model = model;

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
        

        switch (currentCmd) {

            case START: 
                break;

            case ADDCL:
                System.out.println("Name of Class to be added: ");
                name1 = scanner.nextLine();
                if (!name1.isBlank()) {
                model.addClass(name1);
                } else {
                    System.out.println("Invalid name! Try again!");
                }
                break;

            case DELCL:
                System.out.println("Name of Class to be deleted: ");
                name1 = scanner.nextLine();
                if (!name1.isBlank()) {
                model.deleteClass(name1);
                } else {
                    System.out.println("Invalid name! Try again!");
                }
                break;

            case RENCL:
                System.out.println("Name of Class to be renamed: ");
                name1 = scanner.nextLine();
                System.out.println("New name: ");
                name2 = scanner.nextLine();
                if (!name2.isBlank()) {
                model.renameClass(name1, name2);
                } else {
                    System.out.println("Invalid name! Try again!");
                }
                break;

            case ADDREL:
                System.out.println("Name of origin Class in Relationship to be added: ");
                name1 = scanner.nextLine();
                System.out.println("Name of destination Class in Relationship to be added: ");
                name2 = scanner.nextLine();
                class1 = model.getClass(name1);
                class2 = model.getClass(name2);
                if (class1 == null) {
                    System.out.println("Origin Class does not exists! Addition of Relationship failed!");
                    break;
                } else if (class2 == null) {
                    System.out.println("Destination Class does not exists! Addition of Relationship failed!");
                    break;
                } else {
                    class1.addRelationship(class2);
                    
                } 
                break;

            case DELREL:
                System.out.println("Name of origin Class in Relationship to be deleted: ");
                name1 = scanner.nextLine();
                System.out.println("Name of destination Class in Relationship to be deleted: ");
                name2 = scanner.nextLine();
                if (model.getClass(name1) == null) {
                    System.out.println("Origin Class does not exists! Removal of Relationship failed!");
                    break;
                } else if (model.getClass(name2) == null) {
                    System.out.println("Destination Class does not exists! Removal of Relationship failed!");
                    break;
                } else {
                    model.getClass(name1).deleteRelationship(name2);
                    System.out.println("Relationship removed from " + name1 + " to " + name2 + "!");
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
                    model.getClass(name1).addAttribute(name2);
                } else {
                    System.out.println("Invalid name! Try again!");
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
                    model.getClass(name1).addAttribute(name2);
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
                        System.out.println("Class does not exists! Removal of Attribute failed!");
                        break;
                    } else {
                        class1. renameAttribute(name2, name3);
                    }
                } else {
                    System.out.println("Invalid name! Try again!");
                } 
                break;
            
            case SAVE:
                //Prompts user for file
                System.out.println("Input file you want to save to or enter DEFAULT");
                fileName = scanner.nextLine();
                // Checks if user wants default file
                if(fileName.equals("DEFAULT") || fileName.equals("default")){
                    
                    save(model, "JAMBL.json");
                }else{
                    // else save to inputted file
                    save(model, fileName);
                }
                
                break;


            case LOAD:
                
                //prompts user for file
                System.out.println("Input file you want loaded or input DEFAULT.");
                fileName = scanner.nextLine();
                // checks of its default
                if(fileName.toUpperCase().equals("DEFAULT")){
                    load("JAMBL.json");
                }else{
                    // otherwise loads file into current model
                    load(fileName);
                }
                break;

            case LISTCLS:
                listAllClasses(model);
                break;

            case LISTCLA:
                System.out.println("Name of Class to be listed: ");
                name1 = scanner.nextLine();
                System.out.println();
                if (model.getClass(name1) == null) {
                    System.out.println("Class does not exist!");
                    break;
                }else {
                    listClass(model.getClass(name1));
                }
                break;
            
            case LISTREL:
                listRelationship(model);
                break;

            case HELP:
                printHelp();
                break;

            case EXIT:
            System.out.println("Would you like to SAVE before quitting? (YES/NO)");
            name1 = scanner.nextLine();
            if (name1.toUpperCase().equals("YES")) {
                  //Prompts user for file
                  System.out.println("Name file you want to save to or enter DEFAULT");
                  fileName = scanner.nextLine();
                  // Checks if user wants default file
                  if(fileName.toUpperCase().equals("DEFAULT")) {
                      
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
   	 * @name listAllClasses
   	 * @description	Lists all of the classes loaded into the program
   	 * @param model The model containing the information about the classes
   	 * 
   	*/
    public void listAllClasses (Model model) {
        System.out.println();
        System.out.println("CLASSES");
        System.out.println("===============");
        for (Class ele: model.classes) {
            System.out.print("     ");
            listClass(ele);
        }
    }

    /*
   	 * @name listClass
   	 * @description	Lists all of the classes loaded into the program
   	 * @param model The model containing the information about the classes
   	*/
    public void listClass (Class cls) {
        String className = cls.getClassName();
        System.out.println(className);
        System.out.println("     ===============");
        System.out.println("     Attributes:");
        
        for (Attribute ele: cls.getAttributes()) {
            String att = ele.getAttName();
            System.out.println("     * " + att);
        }
        System.out.println();
        System.out.println("     Relationships:");
        
        for (Relationship ele: cls.getRelationships()) {
            String rel = ele.getDestination().getClassName();
            System.out.println("     * " + className + " ---> " + rel);
        }
        System.out.println();
        System.out.println();
    }

 
    /*
   	 * @name listRelationship	
   	 * @description	Lists all of the relationships between classes
   	 * @param model The model containing the information about the classes
   	*/
    public void listRelationship (Model model) {
        System.out.println();
        System.out.println("RELATIONSHIPS");
        System.out.println("=============");
        for (Class ele: model.classes) {
            if (ele.getRelationships().isEmpty()) {
                System.out.println(ele.getClassName() + " has no Relationships.");
            } else {
                for (Relationship rel: ele.getRelationships()) {
                    System.out.println(ele.getClassName() + " ---> " + rel.getDestination().getClassName());
                }
            }
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
    
    /*
   	 * @name printHelp
   	 * @description Displays the list of commands to use in the program
   	 * @param otherName
   	*/
    public void printHelp() {
        System.out.println();
		System.out.println("******** Description of Commands ********");

		System.out.println("***************************************************************************************");

		System.out.println("ADDCL   - This command adds a Class. You will be prompted for the name of the class.");

		System.out.println("***************************************************************************************");

		System.out.println("DELCL   - This command deletes a Class. You will be prompted for the name of the class.");

		System.out.println("***************************************************************************************");

		System.out.println("RENCL   - This command changes name of existing Class to a new name. You will be");
        System.out.println("          prompted for the old class name and the new class name.");


		System.out.println("***************************************************************************************");

		System.out.println("ADDREL  - This command adds a Relationship to a given Class. You will be prompted for ");
        System.out.println("          the name of the origin class and the name of the destination class.");


		System.out.println("***************************************************************************************");

		System.out.println("DELREL  - This command removes a Relationship between two classes. You will be prompted");
        System.out.println("          for the origin class name and the destination class name.");


		System.out.println("***************************************************************************************");

		System.out.println("ADDATT  - This command adds an Attribute to a Class. You will be prompted for the class");
        System.out.println("          name and an attribute name.");


		System.out.println("***************************************************************************************");

		System.out.println("DELATT  - This command will delete an Attribute from a Class. You will be prompted for");
        System.out.println("          a class name and an attribute name.");


		System.out.println("***************************************************************************************");

		System.out.println("RENATT  - This command changes name of existing Attribute of a Class to a new name.");
        System.out.println("          You will be prompted for the class name, the old attribute name and the new");
        System.out.println("          attribute name.");
      


		System.out.println("***************************************************************************************");

		System.out.println("SAVE    - This command saves the file in JSON format. You will be prompted for a file");
        System.out.println("          name.");


		System.out.println("***************************************************************************************");

		System.out.println("LOAD    - This command loads an existing JSON file. You will be prompted for a file");
        System.out.println("          name.");


		System.out.println("***************************************************************************************");

		System.out.println("LISTCLS - This command prints a list of all classes and their contents.");

		System.out.println("***************************************************************************************");

		System.out.println("LISTCLA - This command prints all contents of one class. You will be prompted for a");
        System.out.println("          class name.");


		System.out.println("***************************************************************************************");

		System.out.println("LISTRE  - This command prints all relationships between the classes.");

		System.out.println("***************************************************************************************");

		System.out.println("HELP    - This command shows the list of commands and what they do.");

		System.out.println("***************************************************************************************");

		System.out.println("EXIT    - This command quits the program.");

		System.out.println("***************************************************************************************");
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
                                aClass.addRelationship(model.getClass(rel));
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
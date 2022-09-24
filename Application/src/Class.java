/*
 * @projectDescription	A program for adding classes to a database
 * 
 * @authors	John Shenk, Benjamin Slinghoff, Lauryn Simmons, Alex Peiffer, Meba Shimelis
 * @version 0.0.1
 * @dateLastModified September 8, 2022
 */
 
import java.security.KeyRep.Type;
import java.util.*;

public class Class {

    private String className = "DEFAULT";
    public HashSet<Attribute> attributes = new HashSet<Attribute>();
    public HashSet<Relationship> relationships = new HashSet<Relationship>();
    View view = new View();
    String typeName;
    Type type; 
    

    //constructor with name as parameter
    public Class(String name){
        this.className = name;
        this.attributes = new HashSet<Attribute>();
        this.relationships = new HashSet<Relationship>();
    }

    //get Attribute set
    public HashSet<Attribute> getAttributes() {
        return attributes;
    }

    //get Relationship set
    public HashSet<Relationship> getRelationships() {
        return relationships;
    }

    //get Class Name
    public String getClassName(){

        return className;
    }
    
    // set class Name
    public void setClassName(String name){
    
        this.className = name;
    }


    // This method adds a Relationship to relationships
    // parameter Class
    public boolean addRelationship (Class destination, String typeName) {
        // sets boolean to true unless an error is found
        boolean add = true;
        if (relationships.isEmpty()) {
            relationships.add(new Relationship(destination, typeName));
           // System.out.println("Relationship added from " + className + " to " + destination.className + "!");
            return add;
        } else {
        
            for(Relationship ele: relationships) {
            
                if ((ele.getDestination()).getClassName().equals(destination.getClassName())) {
                    //System.out.println("Relationship already exists!");
                    view.relExists();
                    add = false;
                    return add;
                }
                if (add) {
                    relationships.add(new Relationship(destination, typeName));
                   // System.out.println("Relationship added from " + className + " to " + destination.className + "!");
                    
                } 
            }
        }
        return add;
    }
       
     

    // This method removes a Relationship from the HashSet relationships
    // Parameter String
    public void deleteRelationship (String name) {
        Iterator<Relationship> relItr = relationships.iterator();
        boolean removed = false;
        while (relItr.hasNext()) {
            Relationship ele = relItr.next();
            if ((ele.getDestination()).getClassName().equals(name)) {
                relItr.remove();
                removed = true;
            }
        }
        
        if (!removed) {
            System.out.println("Relation does not exist! Removal Failed!");
        }

    }

    public boolean addAttribute (String name) {
        // sets boolean add to be true unless error is found
        boolean add = true;
        // if attribute set is empty immediately add attribute
        if(attributes.isEmpty()) {
            attributes.add(new Attribute (name));
            return add;
        
        }else { // else iterate through and check to see if attribute already exists
            
            // if attribute name is found return sets add to false and returns false
            for (Attribute ele: attributes) {
                if(ele.getAttName().equals(name)) {
                    System.out.println("Attribute already exists!");
                    add = false;
                    return add;
                }
            }
            // if add is still true it adds attribute and returns true
            if(add) {
              this.attributes.add(new Attribute(name));
             // System.out.println("Attribute added to " + className + " called " + name + "!");
              
            }
            
            return add;    
       }
    } 

    public void deleteAttribute (String name) {
        Iterator<Attribute> attItr = attributes.iterator();
        boolean removed = false;
        while (attItr.hasNext()) {
            Attribute ele = attItr.next();
            if (ele.getAttName().equals(name)) {
                attItr.remove();
                removed = true;
            }
        }
        
        if (removed) {
            System.out.println ("Attribute " + name + " removed from " + this.getClassName() + "!");
        } else {
            System.out.println("Attribute " + name + " does not exist!");
        }

    }

    public void renameAttribute (String oldName, String newName) {
        Iterator<Attribute> attItr = attributes.iterator();
        boolean oldMatch = false;
        boolean newMatch = false;
        Attribute old = null;
        while (attItr.hasNext()) {
            Attribute ele = attItr.next();
            if (ele.getAttName().toUpperCase().equals(oldName.toUpperCase())) {
                oldMatch = true;
                old = ele;
            } else if ( ele.getAttName().toUpperCase().equals(newName.toUpperCase())) {
                newMatch = true;
            }
        }
        if (!oldMatch) {
            System.out.println("Attribute does not exist! Name change failed!");
        } else if (newMatch) {
            System.out.println("New Attribute name already exists! Name change failed!");
        } else {
            old.setAttName(newName);
            System.out.println("Attribute " + oldName + " changed to " + newName + "!");
        }
    }

}

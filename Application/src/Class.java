import java.util.*;

public class Class {

    private String className;
    private HashSet<Attribute> attributes = new HashSet<Attribute>();
    private HashSet<Relationship> relationships = new HashSet<Relationship>()

    //constructor with name as parameter
    public Class(name){
        this.className = name;
    }

   //get Class Name
    public String getClassName(){

        return className;
    }
    
    // set class Name
    public void setClassName(String name){
    
        this.className = name;
    }


    // This method adds a Class to relationships with the Class added being the destination
    // parameter Relationship
    public void addRelationship (Relationship newRel) {

        if (relationships.contains(newRel)) {
            System.out.println ("Relationship already exists!");
        } else {
           relationships.add(newRel);
        }

    }       

}

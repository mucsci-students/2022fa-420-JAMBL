import java.util.*;

public class Class {

    private String className;
    private HashSet<Attribute> attributes = new HashSet<Attribute>();
    private HashSet<Relationship> relationships = new HashSet<Relationship>();

    //code for constructor method needed

    //code for Attribute methods

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

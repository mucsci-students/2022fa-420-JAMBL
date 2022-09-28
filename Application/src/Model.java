
import java.util.*;

public class Model {

    HashSet<Class> classes;

    public Model(){
        // when load() is working it will taking ins a HashSet
        classes = new HashSet<Class>();
    }



    public boolean addClass (String className) {
       boolean add;
        Iterator<Class> itClasses = classes.iterator();
        Class aClass;

        // iterates through the HashSet
        while (itClasses.hasNext()) {
            aClass = (Class) itClasses.next();
            // if any of the class names match the notifies user
            
            if ((aClass.getClassName().toUpperCase()).equals(className.toUpperCase())) {
                // sets boolean to false
                add = false;
                // if class already exists exits method
                return add;
            }
        }
        // creates new class and addes it to the classes set
        Class newClass = new Class(className);
        classes.add(newClass);
        // notifies user
        add = true;
        return add;       
    }



    public boolean deleteClass (String className) {

        boolean delete = true;

        // finds the class
        Class foundClass = getClass(className);
        // checks if foundClass does not exist
        if(foundClass == null){
            // sets boolean to false
            delete = false;
            // exits method

            return delete;
            
        }else{

        
        for (Class ele: classes) {
            for (Relationship rel: ele.getRelationships()) {
                if (rel.getDestination().getClassName().toUpperCase().equals(className.toUpperCase())) {
                    ele.deleteRelationship(className);
                }
            }
        }
        
    
        // remove the class from the classes set
        classes.remove(foundClass);

       // return true;

        delete = true;
    }
        return delete;

    }

    

    public void renameClass (String oldName, String newName) {
        // finds the class
        Class foundClass = getClass(oldName);
        // to check in class name already exists
        Class checkClass = getClass(newName);
        //if class is found with the same name as newName 
        if(checkClass != null){
            // notifies user
            System.out.println("Class already exists! Name change failed!");
            //exits method
            return;
        }
        // checks if foundClass does not exist
        if(foundClass == null){
            //Notifies user
            System.out.println("Class does not exist! Name change failed!");
            // exits method
            return;
        }
        // change class name
        foundClass.setClassName(newName);
        System.out.println( oldName + " class changed to " + newName + "!");
    }


    
    public Class getClass(String name){
        // Creates an iterator
        Iterator<Class> itClasses = classes.iterator();
        // Initialized the class to be found
        Class found;
        // Iteratates through classes and returns the found class
        while(itClasses.hasNext()){
            // sets the current class to be compared
            found = itClasses.next();
            // compares the current class name with the one to be found
            if(found.getClassName().toUpperCase().equals(name.toUpperCase())){
                // returns found class
                return found;
            }     
        }
        // if class was not found returns null
        return null;
    }  

}

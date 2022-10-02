
import java.util.*;

public class Model {

    HashSet<Class> classes;

    public Model(){
        // when load() is working it will taking ins a HashSet
        classes = new HashSet<Class>();
    }



    public boolean addClass (String className) {
        boolean add;
        // creates new class and addes it to the classes set
        Class newClass = new Class(className);
        classes.add(newClass);
        add = true;
        return add;       
    }



    public boolean deleteClass (Class toDelete) {

        boolean delete = true;

        // delete relationships to class
        for (Class ele: classes) {
            for (Relationship rel: ele.getRelationships()) {
                if (rel.getDestination().getClassName().toUpperCase().equals(toDelete.getClassName().toUpperCase())) {
                    ele.deleteRelationship(toDelete.getClassName());
                }
            }
        }
        // remove the class from the classes set
        classes.remove(toDelete);
       // return true;
        delete = true;
        return delete;

    }

    

    public void renameClass (String oldName, String newName) {
        // change class name
        getClass(oldName).setClassName(newName);
        
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

    public HashSet<Class> getClasses(){
        return this.classes;
    }

    // Returns a string list of the class names.
    public String[] getClassList () {
    	int s = classes.size();
    	int i = 0;
    	String[] names = new String[s];
    	for(Class name : this.classes) {
    		names[i] = name.getClassName();
    		i++;
    	}
    	return names;
    }
}

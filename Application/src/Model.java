import java.util.*;
public class Model {

    HashSet<Class> classes;

    public Model(){
        // when load() is working it will taking ins a HashSet
        classes = new HashSet<Class>();
    }
    public void addClass (String className) {
       
        Iterator<Class> itClasses = classes.iterator();
        Class aClass;
        // iterates through the HashSet
        while (itClasses.hasNext()) {
            aClass = (Class) itClasses.next();
            // if any of the class names match the notifies user
            if (aClass.getClassName().equals(className)) {
                System.out.println("Class already exists!");
                // if class already exists exits method
                return;
            }
        }
        // creates new class and addes it to the classes set
        Class newClass = new Class(className);
        classes.add(newClass);
        // notifies user
        System.out.println("Class " + className + " added!");
            
    }
}

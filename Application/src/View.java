public class View {
    public View(){

    }

    public void notExists(String type, String name){
        System.out.println(type +" "+ name + " does not exist! Action Failed!");
    }

    public void invalid(){
        System.out.println("Invalid Input!");
    }
    public void invalidCmd(){
        System.out.println("Invalid Command! Try again!");
    }
    // take type and name and notifies user ot already exists
    public void exists(String type, String name){
        System.out.println( type + " "+ name + " already exist! Action Failed!");
    }
    // takes in type and name and notifies user the type was added
    public void Added(String type, String name){
        System.out.println(type +" " + name + " added successfully");
    }
    public void AddedRel(String source , String destination){
        System.out.println("Relationship added from " + source + " to " + destination + "!");
    }

    public void Deleted(String type , String name){
        System.out.println(type + " "+ name + " deleted successfully");
    }
    
    public void classRenamed(){
        System.out.println("Class renamed!");
    }

    public void attAdded(){
        System.out.println("Attribute added successfully");
    }

    public void attDeleted(){
        System.out.println("Attribute deleted successfully");
    }
    
    public void attRenamed(){
        System.out.println("Attribute renamed!");
    }

    public void relAdded(){
        System.out.println("Relationship added successfully");
    }

    public void relDeleted(){
        System.out.println("Relationship deleted successfully");
    }

    public void loaded(){
        System.out.println("Loading complete!");
    }
}

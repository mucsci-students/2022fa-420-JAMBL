import java.util.Scanner;

public class View {

    Scanner console = new Scanner(System.in);
    String input = "";
    
    public View(){

    }
    /*****************************Inputs From User****************************************/
    public String inputAddClass(){
        System.out.println("Name of Class to be added: ");
        input = console.nextLine();
        return input;
    }

    public String inputDelClass(){
        System.out.println("Name of Class to be deleted: ");
        input = console.nextLine();
        return input;
    }

    public String inputRenClass(){
        System.out.println("Name of Class to be renamed: ");
        input = console.nextLine();
        return input;
    }
  
    public String inputClassListed() {
        System.out.println("Name of Class to be listed: ");
        String className = console.nextLine();
        return className;
    }


    /*************************************************************************************/
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

    public void relExists(){
        System.out.println( "Relationship already exist! Action Failed!");
    }
    // takes in type and name and notifies user the type was added
    public void Added(String type, String name){
        System.out.println(type +" " + name + " added successfully");
    }
    public void AddedRel(String source , String destination, String typeName){
        System.out.println("Relationship added from " + source + " to " + destination + " with " +  typeName + " Type!");
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
        System.out.println("     " + className);
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

		System.out.println("LISTALL - This command prints a list of all classes and their contents.");

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

     // input from user to add origin class
     public String inputAddOriginClass(){
        System.out.println("Name of origin Class in Relationship to be added: ");
        input = console.nextLine();
        return input;
    }
    
    // input from user to add destination class
    public String inputAddDestinationClass(){
        System.out.println("Name of destination Class in Relationship to be added: ");
        input = console.nextLine();
        return input;
    }
    
    // add relationship parameter origin class doesnt exist
    public void originNotExist() {
    	System.out.println("Origin Class does not exists! Addition of Relationship failed!");
    }
    // add relationship parameter destination class doesnt exist
    public void destinationNotExist() {
    	System.out.println("Destination Class does not exists! Addition of Relationship failed!");
    }
    //input for relationshop type (String)
    public String inputAddType(){
        System.out.println("Name of Relationship Type to be added: ");
        input = console.nextLine();
        return input;
    }

}

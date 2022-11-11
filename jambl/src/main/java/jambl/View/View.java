package jambl.View;
import jambl.Model.*;
import jambl.Model.Class;

//import java.util.Scanner;
import java.util.*;

import org.jline.reader.LineReader;
import org.jline.reader.impl.history.*;
import org.jline.reader.impl.LineReaderImpl;
import org.jline.reader.impl.completer.StringsCompleter;


public class View {

   // Scanner console = new Scanner(System.in);
    String input = "";
    LineReaderImpl reader;
    DefaultHistory history;
    ArrayList<String> tabClasses = new ArrayList<String>();
    ArrayList<String> tabMethods = new ArrayList<String>();
    ArrayList<String> tabFields = new ArrayList<String>();
    ArrayList<String> tabParams = new ArrayList<String>();
    ArrayList<String> tabTypes = new ArrayList<String>();
    ArrayList<String> commands;
    
    

    public View(LineReaderImpl lineReader, ArrayList<String> comms){
        reader = lineReader;
        commands = comms;
       
        
    }
    /*****************************Inputs From User****************************************/
    public String inputAdd(String type){
        // updates completer to completer correct strings
        reader.setCompleter(null);
        
        input = reader.readLine("Name of "+ type +" to be added: ");

        // updates array for tab completion
        return input;
    }

    public String inputDel(String type){
        // gets the proper array for the element to be deleted and sets the completer
        ArrayList<String> currArray = getArray(type);
        reader.setCompleter(new StringsCompleter(currArray));
       
        input = reader.readLine("Name of "+ type +" to be deleted: ");
        // take away empty space if tab completion is used
        StringTokenizer token = new StringTokenizer(input);
        input = token.nextToken();
        return input;
    }

    public String inputRen(String type){
       // gets the proper array for the element to be deleted and sets the completer
       ArrayList<String> currArray = getArray(type);
       reader.setCompleter(new StringsCompleter(currArray));
        
        input = reader.readLine("Name of "+ type +" to be renamed: ");

        // take away empty space if tab completion is used
        StringTokenizer token = new StringTokenizer(input);
        input = token.nextToken();
        return input;
    }

    public String inputNewName(String type){

        // sets completer to null since new name is being added
        reader.setCompleter(null);

        input = reader.readLine("Enter New "+type+": ");

        // take away empty space if tab completion is used
        StringTokenizer token = new StringTokenizer(input);
        input = token.nextToken();

        return input;
    }

    public String inputType(String element){
         
         reader.setCompleter(new StringsCompleter(tabTypes));
 
         input = reader.readLine("Name of " + element + " to be added: ");
 
         // take away empty space if tab completion is used
         StringTokenizer token = new StringTokenizer(input);
         input = token.nextToken();
 
         return input;
    }

    public String inputNameOf(String element1 , String element2, String action){
        // gets the proper array for the element to be deleted and sets the completer
        ArrayList<String> currArray = getArray(element1);
        reader.setCompleter(new StringsCompleter(currArray));

        input = reader.readLine("Name of "+ element1 +" "+action +" "+ element2 +": ");

        // take away empty space if tab completion is used
        StringTokenizer token = new StringTokenizer(input);
        input = token.nextToken();

        return input;

    }
  
    public String inputClassListed() {
        // gets the proper array for Class and sets the completer
        ArrayList<String> currArray = getArray("Class");
        reader.setCompleter(new StringsCompleter(currArray));

        input = reader.readLine("Name of Class to be listed: ");

        // take away empty space if tab completion is used
        StringTokenizer token = new StringTokenizer(input);
        input = token.nextToken();

        return input;
    }

    // a prompt for a Class name. Generic can be used in many functions
    public String inputClassName() {
        // gets the proper array sets the completer
       // ArrayList<String> currArray = getArray("Class");
        reader.setCompleter(new StringsCompleter(tabClasses));

        input = reader.readLine("Name of Class: ");

        // take away empty space if tab completion is used
        StringTokenizer token = new StringTokenizer(input);
        input = token.nextToken();
        return input;
    }

    // a prompt for a Field name. Generic can be used in many functions
    public String inputFieldName() {

        //ArrayList<String> currArray = getArray("Field");
        reader.setCompleter(new StringsCompleter(tabFields));

        input = reader.readLine("Name of Field: ");

        // take away empty space if tab completion is used
        StringTokenizer token = new StringTokenizer(input);
        input = token.nextToken();

        return input;
    }

    //prompt for a Field type. Generic can be used in many functions
    public String inputFieldType() {
        reader.setCompleter(new StringsCompleter(tabTypes));
        input = reader.readLine("Type of Field: ");

        // take away empty space if tab completion is used
        StringTokenizer token = new StringTokenizer(input);
        input = token.nextToken();

        return input;
    }

    //promt for a new name or type based on parameters
    public String inputNew (String item, String object) {
        if(item.equals("type")){
            reader.setCompleter(new StringsCompleter(tabTypes));
        }else{
            reader.setCompleter(null);
        }
        
        //System.out.println("New " + item + " of " + object + ": ");
        input = reader.readLine("New " + item + " of " + object + ": ");

        // take away empty space if tab completion is used
        StringTokenizer token = new StringTokenizer(input);
        input = token.nextToken();
        
        return input;
    } 

    // a prompt for a Method name. Generic can be used in many functions
    public String inputMethodName(){
        reader.setCompleter(new StringsCompleter(tabMethods));
       // System.out.println("Name of Method: ");
        input = reader.readLine("Name of Method: ");

        // take away empty space if tab completion is used
        StringTokenizer token = new StringTokenizer(input);
        input = token.nextToken();

        return input;
    }
    
    //prompt for a Parameter type. Generic can be used in many functions
    public String inputParameterType(){
        reader.setCompleter(new StringsCompleter(tabTypes));
        //System.out.println("Type of Parameter: ");
        input = reader.readLine("Type of Parameter: ");

        // take away empty space if tab completion is used
        StringTokenizer token = new StringTokenizer(input);
        input = token.nextToken();

        return input;
    }

    // a prompt for a Parameter name. Generic can be used in many functions
    public String inputParameterName(){

        reader.setCompleter(new StringsCompleter(tabParams));
        //System.out.println("Name of Parameter: ");
        input = reader.readLine("Name of Parameter: ");

        // take away empty space if tab completion is used
        StringTokenizer token = new StringTokenizer(input);
        input = token.nextToken();

        return input;
    }

    public String inputDeleteAll(){
        reader.setCompleter(new StringsCompleter("yes", "no", "YES", "NO"));
        input = reader.readLine("Delete All Parameters?(yes/no): ");

        // take away empty space if tab completion is used
        StringTokenizer token = new StringTokenizer(input);
        input = token.nextToken();

        return input;
    }

    // input from user to add origin class
    public String inputAddOriginClass(){
        reader.setCompleter(new StringsCompleter(tabClasses));
        // System.out.println("Name of origin Class in Relationship to be added: ");
        input = reader.readLine("Name of origin Class in Relationship to be added: ");

        // take away empty space if tab completion is used
        StringTokenizer token = new StringTokenizer(input);
        input = token.nextToken();

        return input;
    }
    
    // input from user to add destination class
    public String inputAddDestinationClass(){
        reader.setCompleter(new StringsCompleter(tabClasses));
        //System.out.println("Name of destination Class in Relationship to be added: ");
        input = reader.readLine("Name of destination Class in Relationship to be added: ");

        // take away empty space if tab completion is used
        StringTokenizer token = new StringTokenizer(input);
        input = token.nextToken();

        return input;
    }
    
    public String inputDelOriginClass(){
        reader.setCompleter(new StringsCompleter(tabParams));
        input = reader.readLine("Name of origin Class in Relationship to be deleted: ");

        // take away empty space if tab completion is used
        StringTokenizer token = new StringTokenizer(input);
        input = token.nextToken();

        return input;
    }
    
    // input from user to add destination class
    public String inputDelDestinationClass(){
        reader.setCompleter(new StringsCompleter(tabParams));
        input = reader.readLine("Name of destination Class in Relationship to be deleted: ");

        // take away empty space if tab completion is used
        StringTokenizer token = new StringTokenizer(input);
        input = token.nextToken();

        return input;
    }

          //input for relationshop type (String)
    public String inputAddType(){
        reader.setCompleter(new StringsCompleter("AGGR", "aggr", "COMP", "comp", "INHE", "inhe", "REAL", "real"));
         input = reader.readLine("Name of Relationship Type to be added \n{AGGREGATION = \"AGGR\", COMPOSITION = \"COMP\", INHERITANCE = \"INHE\", REALIZATION = \"REAL\"}: ");

         // take away empty space if tab completion is used
         StringTokenizer token = new StringTokenizer(input);
         input = token.nextToken();

         return input.toUpperCase();
    }

    public String savePrompt() {
        //System.out.println("Input file you want to save to or press enter for default file.");
        return reader.readLine("Input file you want to save to or press enter for default file: ");
    }

    public String loadPrompt() {
        //System.out.println("Input file you want loaded or press enter for default file.");
        return reader.readLine("Input file you want loaded or press enter for default file: ");
    }

    public String exitPrompt() {
        reader.setCompleter(new StringsCompleter("yes", "no", "YES", "NO"));
        input = reader.readLine("Would you like to SAVE before quitting? (YES/NO): ");

        // take away empty space if tab completion is used
        StringTokenizer token = new StringTokenizer(input);
        input = token.nextToken();

        return input;
    }

    /******************************************************* End of User Inputs ***************************************************************************/

    public void Failed(String type , String action){
        System.out.println(action +" " + type + " failed!");

    }

    public void renamed(String type, String oldName , String newName){
        System.out.println( oldName + " "+ type + " changed to " + newName + "!");
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

    public void relExists(){
        System.out.println( "Relationship already exist! Action Failed!");
    }

    public void relNoExist() {
        System.out.println("Relationship does not exist!");
    }

    // takes in type and name and notifies user the type was added
    public void Added(String type, String name){
        System.out.println(type +" " + name + " added successfully");
    }
    public void AddedRel(String source , String destination, String typeName){
        System.out.println("Relationship added from " + source + " to " + destination + " with " +  typeName.toLowerCase() + " Type!");
    }

    public void Deleted(String type , String name){
        System.out.println(type + " "+ name + " deleted successfully");
    }

    public void Renamed(String type, String oldName, String newName) {
        System.out.println(type + " " + oldName + " renamed to " + newName + " successfully!");
    }

    public void Retyped(String type, String name, String newType) {
        System.out.println(type + " for " + name  + " changed to " + newType + " successfully!");
    }

    public void ParameterChange(String oldName, String newName, String newType){
        System.out.println("Parameter " + oldName + " changed to " + newType + " " + newName + " successfully!");
    }
    
    public void classRenamed(){
        System.out.println("Class renamed!");
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
        for (Class ele: model.getClasses()) {
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
        System.out.println("     Fields:");
        
        for (Field fld: cls.getFields()) {
            String fieldType = fld.getFieldType();
            String fieldName = fld.getFieldName();
            System.out.println("     * " + fieldType + " " + fieldName);
        }
        System.out.println();
        System.out.println("     Methods:");
        
        for (Method mtd: cls.getMethods()) {
            String returnType = mtd.getReturnType();
            String methodName = mtd.getMethodName();
            System.out.print("     * " + returnType + " " + methodName + " (");
            HashSet<Parameter> params = mtd.getParameters();
            int count = params.size();
            if (count == 0) {
                System.out.println(")");
            } else {
                for (Parameter par: params) {
                    System.out.print(par.getParamType() + " " + par.getParamName());
                    count --;
                    if (count > 0) {
                        System.out.print(", ");
                    } else {
                        System.out.println(")");
                    }
                }
            }

        }
        System.out.println();       
        System.out.println("     Relationships:");
        
        for (Relationship ele: cls.getRelationships()) {
            String dest = ele.getDestination().getClassName();
            String type = ele.getFullType();
            System.out.println("     * " + className + " --" + type + "--> " + dest);
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
        for (Class ele: model.getClasses()) {
            if (ele.getRelationships().isEmpty()) {

            } else {
                for (Relationship rel: ele.getRelationships()) {
                    System.out.println(ele.getClassName() + " --" + rel.getFullType() + "--> " + rel.getDestination().getClassName());
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

		System.out.println("RENCL   - This command changes the name of an existing Class to a new name. You will be");
        System.out.println("          prompted for the old class name and the new class name.");


		System.out.println("***************************************************************************************");

        System.out.println("ADDFLD  - This command adds a Field to a Class. You will be prompted for a class name, ");
        System.out.println("          the field name and field type");

        System.out.println("***************************************************************************************");

        System.out.println("DELFLD  - This command deletes a Field from a Class. You will be prompted for the class");
        System.out.println("          name and the field name.");

        System.out.println("***************************************************************************************");

        System.out.println("RENFLD  - This command changes the name of an existing Field to a new name. You will be");
        System.out.println("          prompted for a class name, old field name and the new field name.");

        System.out.println("***************************************************************************************");

        System.out.println("FLDTYPE - This command changes the existing type of a Field. You will be prompted for a");
        System.out.println("           class name and a field name and a new field type.");

        System.out.println("***************************************************************************************");

		System.out.println("ADDMTD  - This command adds a Method to a Class. You will be prompted for a class name,");
        System.out.println("          method name and a return type.");
 
		System.out.println("***************************************************************************************");

        System.out.println("DELMTD  - This command deletes a Method from a Class. You will be prompted for a class ");
        System.out.println("          name and a method name.");
 
		System.out.println("***************************************************************************************");

        System.out.println("RENMTD  - This command changes the name of an existing Method. You will be prompted for");
        System.out.println("          a class name, the old method name and a new method name.");

        System.out.println("***************************************************************************************");

        System.out.println("MTDTYPE - This command changes the return type of an existsing Method. You will be ");
        System.out.println("          prompted for a class name, a method name and a new return type.");

        System.out.println("***************************************************************************************");

		System.out.println("ADDREL  - This command adds a Relationship to a given Class. You will be prompted for ");
        System.out.println("          an origin class name, a destination class name, and the relationship type.");
        System.out.println("          Type: Aggregation = \"AGGR\", Composition = \"COMP\", Inheritiance = \"INHE\","); 
        System.out.println("          Realization = \"REAL \" ");

		System.out.println("***************************************************************************************");

		System.out.println("DELREL  - This command removes a Relationship between two Classes. You will be prompted");
        System.out.println("          for an origin class name and a destination class name.");

        System.out.println("***************************************************************************************");

		System.out.println("RELTYPE - This command changes the Relationship Type between two Classes. You will be ");
        System.out.println("          prompted for an origin class, a destination class and a new relationship");
        System.out.println("          type.");

		System.out.println("***************************************************************************************");

		System.out.println("ADDPAR  - This command adds a Parameter to a Class. You will be prompted for a class ");
        System.out.println("          name, a method name, a parameter name and a parameter type.");

		System.out.println("***************************************************************************************");

		System.out.println("DELPAR  - This command will delete one or all Parameters from a Method. You will be ");
        System.out.println("          prompted for a class name and a method name. You will be asked if you want to");
        System.out.println("          delete all parameters. If no, you will be prompted for a parameter name.");

		System.out.println("***************************************************************************************");

		System.out.println("CHGPAR  - This command allows a Paramter name or type to be changed. You will be ");
        System.out.println("          prompted for a class name, a method name, the old parameter name, the new ");
        System.out.println("          parameter name and the new parameter type.");
      
		System.out.println("***************************************************************************************");
        //System.out.println("PARTYPE - This command returns the Method return type. You will be prompted for the name");
        //System.out.println("          of the class and the parameter name.");
        
		//System.out.println("***************************************************************************************");

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

		System.out.println("LISTREL  - This command prints all relationships between the classes.");

		System.out.println("***************************************************************************************");

		System.out.println("HELP    - This command shows the list of commands and what they do.");

		System.out.println("***************************************************************************************");

		System.out.println("EXIT    - This command quits the program.");

		System.out.println("***************************************************************************************");
    }

 
    // add relationship parameter origin class doesnt exist
    public void originNotExist() {
    	System.out.println("Origin Class does not exists! Addition of Relationship failed!");
    }
    // add relationship parameter destination class doesnt exist
    public void destinationNotExist() {
    	System.out.println("Destination Class does not exists! Addition of Relationship failed!");
    }

    public void relNotExists(){
        System.out.println( "Relationship doesn't exist! Action Failed!");
    }

    public void relTypeEdited(String typeName){
        System.out.println("Relation type changed to " + typeName.toLowerCase()  + "!");
    }    

    public void relTypeCheck(String typeName){
        System.out.println(typeName + " is invalid Relation type!");
    }  

    public void saved(){
        System.out.println("UML Diagram Saved!");
    }
    
   

    public ArrayList<String> getArray(String type){
        if(type.equals("Class")){
           return tabClasses;
        }else if(type.equals("Method")){
            return tabMethods;
        }else if(type.equals("Field")){
            return tabFields;
        }else if(type.equals("Type")){
            return tabTypes;
        }else{
            return tabParams;
        }  
    }

    public void setArray(ArrayList<String> array , String type){
        if(type.equals("Class")){
            tabClasses = array;
         }else if(type.equals("Method")){
            tabMethods = array;
         }else if(type.equals("Field")){
            tabFields = array;
         }else if(type.equals("Type")){
            tabTypes = array;
         }else{
            tabParams = array;
         }  
    }

    public void setArrays(ArrayList<String> classes, ArrayList<String> fields, ArrayList<String> methods, ArrayList<String> params, ArrayList<String> types  ){
        tabClasses = classes;
        tabFields = fields;
        tabMethods = methods;
        tabParams = params;
        tabTypes = types;

    }

}

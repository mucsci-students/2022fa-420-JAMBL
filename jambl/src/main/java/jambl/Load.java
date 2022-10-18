package jambl;
import java.util.*;
import java.io.*;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;

public class Load {

    Model model;

    Load(){
        this.model = new Model();
    }


    
    public JSONObject getFile(String fileName){

        JSONObject fileObj;
        JSONParser parser;
        Object fileContent;
       
        File checkContent = new File(fileName);
        if(checkContent.length() == 0){
            return null;

        }else{
            // JSON object that will hold the Model Content
            fileObj = new JSONObject();
            // parser to scan through the file
            parser = new JSONParser();

            try{
                // gets file content
                fileContent = parser.parse(new FileReader(fileName));
                // sets the file content to a json object
                fileObj = (JSONObject) fileContent;     
                
            }catch(Exception e){
                System.out.println("Could not read file" + e);
            }

            return fileObj;
        }

    }


    public void loadClasses(JSONObject file){
        JSONArray classesArray = (JSONArray) file.get("classes");
        JSONObject classObj;
        String className;
        
        // iterates through classes
        for(Object aClass : classesArray){
            // turns each element in array to a JSONOBject
            classObj = (JSONObject) aClass;
            
            // gets the name of the class
            className = (String) classObj.get("name");
            // loads the class
            model.addClass(className);
            // loads fields for current class
            loadFields(classObj, className);
            // loads parameters of current class
            loadMethods(classObj, className);
            // loads location of current class
            loadLocations(classObj, className);

        }
    }


    public void loadLocations(JSONObject aClass, String className){
        // finds the class to add Locations to
        Class currClass = model.getClass(className);

        JSONObject coordinate = (JSONObject) aClass.get("location");
        long x = (long) coordinate.get("x");
        long y = (long) coordinate.get("y");

        currClass.addX(x);
        currClass.addY(y);

    }
    public void loadFields(JSONObject aClass, String className){
        // finds the class to add fields to
        Class currClass = model.getClass(className);
        // gets array of field objects
        JSONArray fieldsArray = (JSONArray) aClass.get("fields");
        JSONObject fieldObj;
        String name;
        String type;
        // iterates through fields
        for(Object field : fieldsArray){
            fieldObj = (JSONObject) field;
            // gets name and type of each field
            name = (String) fieldObj.get("name");
            type = (String) fieldObj.get("type");
            // adds field to class
            currClass.addField(name, type);
        }
    }

    public void loadMethods(JSONObject aClass, String className){
         // finds the class to add fields to
         Class currClass = model.getClass(className);
         // gets array of field objects
         JSONArray methodsArray = (JSONArray) aClass.get("methods");
         JSONObject methodObj;
         String name;
         String return_type;

         // iterates through fields
         for(Object method : methodsArray){
            methodObj = (JSONObject) method;
             // gets name and type of each field
             name = (String) methodObj.get("name");
             return_type = (String) methodObj.get("return_type");
             // adds method to class
             currClass.addMethod(name, return_type);
             // loads the parameters of the current method
             loadParameters(methodObj, name, currClass);
         }

    }

    public void loadParameters(JSONObject aMethod, String methodName, Class currClass){
         
         // gets array of param objects
         JSONArray paramsArray = (JSONArray) aMethod.get("params");
         JSONObject paramObj;
         String name;
         String type;
        
         // iterates through parameters
         if(paramsArray != null){
            for(Object param : paramsArray){
                paramObj = (JSONObject) param;
                 // gets name and type of each field
                 name = (String) paramObj.get("name");
                 type = (String) paramObj.get("type");
                 // adds method to class
                 currClass.getMethod(methodName).addParameter(name, type);
             }

         }
         


    }

    public Model loadRelationships(JSONObject fileObj ){

        JSONObject relObj;
        String sourceName;
        String destName;
        String typeName;
        Class sourceClass;
        Class destClass;
        //gets array of relationship
        JSONArray relsArray = (JSONArray) fileObj.get("relationships");
        // iterates through relationships
        for(Object rel : relsArray){
            relObj = (JSONObject) rel;
            // gets source, destination and type of current relationship
            sourceName = (String) relObj.get("source");
            destName = (String) relObj.get("destination");
            typeName = (String) relObj.get("type");
            
            // finds the source class and destination class
            sourceClass = model.getClass(sourceName);
            destClass = model.getClass(destName);
            // adds the relationship
            sourceClass.addRelationship(destClass, typeName.toUpperCase());
        }
        return model;
    }
}

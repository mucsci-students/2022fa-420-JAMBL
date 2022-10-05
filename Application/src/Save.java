import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.util.*;
import java.io.*;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.parser.JSONParser;

public class Save {

    JSONObject FileObj = new JSONObject();
    Model model;
    
    

    Save(Model model){
        this.model = model;
    }

    public JSONArray classes(){
        JSONArray classesArray = new JSONArray();
        JSONArray fields;
        JSONArray methods;
        JSONObject classObj;
        Iterator<Class> itClasses = model.getClasses().iterator();
        Class curr;
        String className;
        
        while(itClasses.hasNext()){
            
            classObj = new JSONObject();
            curr = (Class) itClasses.next();
            className = curr.getClassName();
            fields = fields(curr);
            methods = methods(curr);
            classObj.put("fields", fields);
            classObj.put("methods", methods);
            classObj.put("name", className);
            classesArray.add(classObj);
        }
        return classesArray;

    } 


    public JSONArray fields(Class currClass){
        JSONArray fieldsArray = new JSONArray();
        JSONObject fieldObj;
        Iterator<Field> itFields = currClass.getFields().iterator();
        Field curr;
        String fieldName;
        String fieldType;
        
        while(itFields.hasNext()) {
            fieldObj = new JSONObject();
            curr = (Field) itFields.next();
            fieldName = curr.getFieldName();
            fieldType = curr.getFieldType();
            fieldObj.put("name", fieldName);
            fieldObj.put("type", fieldType);
            fieldsArray.add(fieldObj);
        }

        return fieldsArray;

    } 

    public JSONArray methods(Class currClass){
        JSONArray methodsArray = new JSONArray();
        JSONObject methodObj;
        Iterator<Method> itMethods = currClass.getMethods().iterator();
        Method curr;
        String methodName;
        String returnType;
        JSONArray params;
        
        while(itMethods.hasNext()) {
            methodObj = new JSONObject();
            curr = (Method) itMethods.next();
            methodName = curr.getMethodName();
            returnType = curr.getReturnType();
            params = params(curr);
            methodObj.put("name", methodName);
            methodObj.put("return_type", returnType);
            methodObj.put("params", params);
            methodsArray.add(methodObj);
        }

        return methodsArray;

    } 

    public JSONArray params(Method method){
        JSONArray paramsArray = new JSONArray();
        JSONObject paramObj;
        Iterator<Parameter> itParams = method.getParameters().iterator();
        Parameter curr;
        String paramName;
        String paramType;
        
        while(itParams.hasNext()) {
            paramObj = new JSONObject();
            curr = (Parameter) itParams.next();
            paramName = curr.getParamName();
            paramType = curr.getParamType();
            paramObj.put("name", paramName);
            paramObj.put("type", paramType);
            paramsArray.add(paramObj);
        }
        return paramsArray;
    } 

    public JSONArray relationships(){
        JSONArray relsArray = new JSONArray();
        JSONObject relsObj;
        Iterator<Relationship> itRels;
        Relationship curr;
        String sourceName;
        String destName;
        String relType;

        Iterator<Class> itClasses = model.getClasses().iterator();
        Class currClass;
        String className;


        while(itClasses.hasNext()){
            currClass = (Class) itClasses.next();
            itRels = currClass.getRelationships().iterator();
            while(itRels.hasNext()) {
                relsObj = new JSONObject();
                curr = (Relationship) itRels.next();
                sourceName = currClass.getClassName();
                destName = curr.getDestination().getClassName();
                relType = curr.getRelType();
                relsObj.put("source", sourceName);
                relsObj.put("destination", destName);
                relsObj.put("type", relType);
                relsArray.add(relsObj);
            }    
        }
        return relsArray;
    } 
}

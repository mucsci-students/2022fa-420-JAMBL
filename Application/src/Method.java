/*
 * @projectDescription	A program to make UML diagrams.
 * 
 * @authors	John Shenk, Benjamin Slinghoff, Lauryn Simmons, Alex Peiffer, Meba Shimelis
 * @version 0.0.1
 * @dateLastModified September 22, 2022
 * 
 * @classDescription This class represents Methods in a Class diagram
 */
import java.util.*;


public class Method {
    
    private String methodName;
    private String returnType;
    private HashSet<Parameter> parameters = new HashSet<Parameter> ();

    //constructs a Method with String for name and String for type
    public Method (String name, String type) {   
        this.methodName = name;
        this.returnType = type;
    }

    //returns the name of the Method
    public String getMethodName () {
        return methodName;
    }

    //sets the name of the Method to the given String
    public void setMethodName (String name) {
        this.methodName = name;
    }

    //returns the returnType of the Method
    public String getReturnType() {
        return returnType;
    }

    //sets the returnType of the Method to the given String
    public void setReturnType(String returnType) {
        this.returnType = returnType;
    }

    //returns the set of Parameters
    public HashSet<Parameter> getParameters() {
        return parameters;
    }

    public Parameter getParameter(String name){
        // Creates an iterator
        Iterator<Parameter> itParams = parameters.iterator();
        // Initialized the class to be found
        Parameter found;
        // Iteratates through classes and returns the found class
        while(itParams.hasNext()){
            // sets the current class to be compared
            found = itParams.next();
            // compares the current class name with the one to be found
            if(found.getParamName().toUpperCase().equals(name.toUpperCase())){
                // returns found class
                return found;
            }     
        }
        // if class was not found returns null
        return null;
    } 

    // Renames and retypes a parameter in this method
    public boolean changeParameter(String oldName, String newName, String newParamType) {
    	Iterator<Parameter> paramItr = parameters.iterator();
    	while (paramItr.hasNext()) {
            Parameter ele = paramItr.next();
            if (ele.getParamName().toUpperCase().equals(oldName.toUpperCase())) {
                ele.setParamName(newName);
                ele.setParamType(newParamType);
                return true;
            }
        }
        return false;
    }

    // Deletes a parameter from this method of the specified name
    public boolean deleteParameter(String name) {
    	Iterator<Parameter> paramItr = parameters.iterator();
        while (paramItr.hasNext()) {
            Parameter ele = paramItr.next();
            if (ele.getParamName().equals(name)) {
                paramItr.remove();
                return true; // Parameter successfully removed, return true
            }
        }
        return false; // Parameter not removed, return false
    }

    // Adds a parameter to this method. 
    public boolean addParameter(String paramName, String paramType) {
        if(parameters.isEmpty()) { // Empty hash set
    		parameters.add(new Parameter(paramName, paramType));
    		return true; // Parameter added successfully, return true
    	} else {
            this.parameters.add(new Parameter(paramName, paramType)); 
            return true; // Parameter added successfully, return true
        }
    }

    // Deletes all parameters from this method
    public boolean deleteAllParameter(){
        parameters = new HashSet<Parameter> ();
        if(parameters.isEmpty()) { // Empty hash set
            return true;
        }
        return false;
    }


}

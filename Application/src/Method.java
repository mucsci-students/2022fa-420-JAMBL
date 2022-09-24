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

}

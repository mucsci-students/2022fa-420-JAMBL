package jambl.Model;

/*
 * @projectDescription	A program to make UML diagrams
 * 
 * @authors	John Shenk, Benjamin Slinghoff, Lauryn Simmons, Alex Peiffer, Meba Shimelis
 * @version 0.0.1
 * @dateLastModified September 25, 2022
 * 
 * @classDescription This class represents a Class in a UML diagram
 */
 
import java.awt.Font;
import java.util.*;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import jambl.View.draggableBox;

public class Class {

    private String className = "DEFAULT";
    public HashSet<Field> fields = new HashSet<Field>();
    public HashSet<Method> methods = new HashSet<Method>();
    public HashSet<Relationship> relationships = new HashSet<Relationship>();
    public int x;
    public int y;


    //constructor with name as parameter
    public Class(String name){
        this.className = name;
        this.fields = new HashSet<Field>();
        this.relationships = new HashSet<Relationship>();
        x = 250;
        y = 250;
    }

    //get Method set
    public HashSet<Method> getMethods() {
        return methods;
    }

    
    //get Field set
    public HashSet<Field> getFields(){
    	return fields;
    }

    //get Relationship set
    public HashSet<Relationship> getRelationships() {
        return relationships;
    }

    //get Class Name
    public String getClassName(){

        return className;
    }
    
    // set class Name
    public void setClassName(String name){
    
        this.className = name;
    }


    // This method adds a Relationship to relationships
    // parameter Class
    public boolean addRelationship (Class destination, String typeName) {
        // sets boolean to true unless an error is found
        boolean add = true;
       
            relationships.add(new Relationship(destination, typeName));
           // System.out.println("Relationship added from " + className + " to " + destination.className + "!");
            return add;
    }
    
    public Field getField(String name){
        // Creates an iterator
        Iterator<Field> itFields = fields.iterator();
        // Initialized the class to be found
        Field found;
        // Iteratates through classes and returns the found class
        while(itFields.hasNext()){
            // sets the current class to be compared
            found = itFields.next();
            // compares the current class name with the one to be found
            if(found.getFieldName().toUpperCase().equals(name.toUpperCase())){
                // returns found class
                return found;
            }     
        }
        // if class was not found returns null
        return null;
    } 
     

    // This method removes a Relationship from the HashSet relationships
    // Parameter String
    public boolean deleteRelationship (String name) {
        Iterator<Relationship> relItr = relationships.iterator();
        boolean removed = false;
        while (relItr.hasNext()) {
            Relationship ele = relItr.next();
            (ele.getDestination()).getClassName().toUpperCase().equals(name.toUpperCase());
                relItr.remove();
                removed = true;
        }
		return removed;

    }

    // This method checks if there is a Relationship with a same name 
    public boolean isRelationshipExist(String destinationName){
        for(Relationship ele: relationships) {
            if (((ele.getDestination()).getClassName().toUpperCase().equals(destinationName.toUpperCase()))) {
                return true;
            } 
        }
        return false;
    }

    // This method finds a Relationship in the set and returns it when found 
    public Relationship getRelationship (String destinationName){
        for(Relationship ele: relationships) {
            if (((ele.getDestination()).getClassName().toUpperCase().equals(destinationName.toUpperCase()))) {
                return ele;
            } 
        }
        return null;
    }

    // this method edits the relationship type to a new type.
    //@param newType - the new relationship type that is changing 
    public void editRelationshipType(String destination, String newType) {
        Iterator<Relationship> relItr = relationships.iterator();
        while (relItr.hasNext()) {
            Relationship ele = relItr.next();
            if (ele.getDestination().getClassName().toUpperCase().equals(destination.toUpperCase())) {
                ele.setRelType(newType);
                break;
            }
        }      
         
    }


    // Sets the field type of the field 'fieldName' to 'newFieldType'
    // Should fail if the field does not exist or the new field type is the same as the field's type
    public boolean changefieldType(String fieldName, String newFieldType) {
    	Iterator<Field> fldItr = fields.iterator();
    	Field current = null;
    	while(fldItr.hasNext()) {
    		current = fldItr.next();
    		if(current.getFieldName().toUpperCase().equals(fieldName.toUpperCase())) {
    			current.setFieldType(newFieldType);
    			return true;
    		}
    	}
    	return false;   	
    }
    

    // Renames a field in this class of name 'oldName' to 'newName' 
    // pre-req. field to be changed must exist and new name must not already be a field
    public boolean renameField(String oldName, String newName) {
    	Iterator<Field> fldItr = fields.iterator();
    	while (fldItr.hasNext()) {
            Field ele = fldItr.next();
            if (ele.getFieldName().toUpperCase().equals(oldName.toUpperCase())) {
                ele.setFieldName(newName);
                return true;
            }
        }
        return false;
    }

    // Deletes a field form this class of the specified name
    public boolean deleteField(String name) {
    	Iterator<Field> fldItr = fields.iterator();
        while (fldItr.hasNext()) {
            Field ele = fldItr.next();
            if (ele.getFieldName().equals(name)) {
                fldItr.remove();
                return true; // Field successfully removed, return true
            }
        }
        return false; // Field not removed, return false
    }

    

    // Adds a field to this class. 
    public boolean addField(String fieldName, String fieldType) {
        if(fields.isEmpty()) { // Empty hash set
    		fields.add(new Field(fieldName, fieldType));
    		return true; // Field added successfully, return true
    	} else {
    	this.fields.add(new Field(fieldName, fieldType)); 
    	return true; // Field added successfully, return true
        }
    }

    // Adds a method to this class
    public boolean addMethod (String methodName, String returnType) {
        // Adds Method to HashSet
    	this.methods.add(new Method(methodName, returnType)); 
    	return true;
    }
    
    // Deletes a method from the Methods HashSet
    public boolean deleteMethod(Method method) {
        methods.remove(method);
        return true;
    }

    // Renames a method in this class from 'oldName' to 'newName' 
    // Should fail if the method 'oldName' does not exist OR if a method 'newName' already exists
    public boolean renameMethod(Method method, String newName) {
        
            method.setMethodName(newName);
            return true;
        
     }

    // Sets the return type of the Method to 'newReturnType'
    public boolean changeMethodreturn(Method method, String newReturnType) {

        method.setReturnType(newReturnType);
    	return true;
    	
    }

    public Method getMethod(String methodName){
        for (Method ele: methods) {
            if(ele.getMethodName().equals(methodName)) { // checking to see if method was found
                return ele; // if found returns method
            }
        }

        return null;
    }

    public boolean isValidType (String otherName) {
        boolean validType = false;
        for (Relationship.Type type: Relationship.Type.values()) {
            if (type.toString().equals(otherName)) {
                
                validType = true;
            }
        }
        return validType;
    }

    public String TypefullName (String otherName) {
        String fullName = null;

        for (Relationship.Type type: Relationship.Type.values()) {
            if (type.toString().equals(otherName)) {
                
                fullName = type.fullName();
            }
        }
        return fullName;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public void addX(int addedX){
        x = addedX;
    }

    public void addY(int addedY){
        y = addedY;
        
    }

    
}

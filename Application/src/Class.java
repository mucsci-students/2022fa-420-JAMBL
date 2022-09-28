/*
 * @projectDescription	A program to make UML diagrams
 * 
 * @authors	John Shenk, Benjamin Slinghoff, Lauryn Simmons, Alex Peiffer, Meba Shimelis
 * @version 0.0.1
 * @dateLastModified September 25, 2022
 * 
 * @classDescription This class represents a Class in a UML diagram
 */
 
import java.security.KeyRep.Type;
import java.util.*;

public class Class {

    private String className = "DEFAULT";
    public HashSet<Field> fields = new HashSet<Field>();
    public HashSet<Attribute> attributes = new HashSet<Attribute>();
    public HashSet<Method> methods = new HashSet<Method>();
    public HashSet<Relationship> relationships = new HashSet<Relationship>();
    View view = new View();

    //constructor with name as parameter
    public Class(String name){
        this.className = name;
        this.fields = new HashSet<Field>();
        this.attributes = new HashSet<Attribute>();
        this.relationships = new HashSet<Relationship>();
    }

    //get Method set
    public HashSet<Method> getMethods() {
        return methods;
    }

    //get Attribute set
    public HashSet<Attribute> getAttributes() {
        return attributes;
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
       
     

    // This method removes a Relationship from the HashSet relationships
    // Parameter String
    public boolean deleteRelationship (String name) {
        Iterator<Relationship> relItr = relationships.iterator();
        boolean removed = false;
        while (relItr.hasNext()) {
            Relationship ele = relItr.next();
            (ele.getDestination()).getClassName().equals(name); 
                relItr.remove();
                removed = true;
        }
		return removed;

    }

    public boolean isrelationshipExist(String name){
        boolean relExist = false;
        for(Relationship ele: relationships) {
            if ((ele.getDestination()).getClassName().equals(name)) {
                //System.out.println("Relationship already exists!");
               // view.relExists();
                relExist = false;
            } else {
                relExist = true;
            }
        }
        return relExist;
    }

    public boolean addAttribute (String name) {
        // sets boolean add to be true unless error is found
        boolean add = true;
        // if attribute set is empty immediately add attribute
        if(attributes.isEmpty()) {
            attributes.add(new Attribute (name));
            return add;
        
        }else { // else iterate through and check to see if attribute already exists
            
            // if attribute name is found return sets add to false and returns false
            for (Attribute ele: attributes) {
                if(ele.getAttName().equals(name)) {
                    System.out.println("Attribute already exists!");
                    add = false;
                    return add;
                }
            }
            // if add is still true it adds attribute and returns true
            if(add) {
              this.attributes.add(new Attribute(name));
             // System.out.println("Attribute added to " + className + " called " + name + "!"); 
            }
            
            return add;    
       }
    } 

    public void deleteAttribute (String name) {
        Iterator<Attribute> attItr = attributes.iterator();
        boolean removed = false;
        while (attItr.hasNext()) {
            Attribute ele = attItr.next();
            if (ele.getAttName().equals(name)) {
                attItr.remove();
                removed = true;
            }
        }
        
        if (removed) {
            System.out.println ("Attribute " + name + " removed from " + this.getClassName() + "!");
        } else {
            System.out.println("Attribute " + name + " does not exist!");
        }

    }

    public void renameAttribute (String oldName, String newName) {
        Iterator<Attribute> attItr = attributes.iterator();
        boolean oldMatch = false;
        boolean newMatch = false;
        Attribute old = null;
        while (attItr.hasNext()) {
            Attribute ele = attItr.next();
            if (ele.getAttName().toUpperCase().equals(oldName.toUpperCase())) {
                oldMatch = true;
                old = ele;
            } else if ( ele.getAttName().toUpperCase().equals(newName.toUpperCase())) {
                newMatch = true;
            }
        }
        if (!oldMatch) {
            System.out.println("Attribute does not exist! Name change failed!");
        } else if (newMatch) {
            System.out.println("New Attribute name already exists! Name change failed!");
        } else {
            old.setAttName(newName);
            System.out.println("Attribute " + oldName + " changed to " + newName + "!");
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
    			// Field type to change has the same name of the new field type
    			if(current.getFieldType().toUpperCase().equals(newFieldType.toUpperCase())) { 
    				System.out.println("Existing field type same as new field type. Field type change failed!");
    				return false;
    			}
    			// Field of specified name found
    			current.setFieldType(newFieldType);
    			System.out.println("The field " + current.getFieldName() + "'s type has been changed to " + current.getFieldType() + "!");
    			return true;
    		}
    	}
    	// Field of specified name not found
    	System.out.println("Field does not exist! Name change failed!"); 
    	return false;
    	
    }
    

    // Renames a field in this class of name 'oldName' to 'newName' 
    // Should fail if the field 'oldName' does not exist OR if a field 'newName' already exists
    public boolean renameField(String oldName, String newName) {
    	Iterator<Field> fldItr = fields.iterator();
    	boolean oldMatch = false;
        boolean newMatch = false;
        Field old = null;
    	while (fldItr.hasNext()) {
            Field ele = fldItr.next();
            if (ele.getFieldName().toUpperCase().equals(oldName.toUpperCase())) {
                oldMatch = true;
                old = ele;
            } else if ( ele.getFieldName().toUpperCase().equals(newName.toUpperCase())) {
                newMatch = true;
            }
        }
        if (!oldMatch) {
            System.out.println("Field does not exist! Name change failed!");
            return false;
        } else if (newMatch) {
            System.out.println("New Field name already exists! Name change failed!");
            return false;
        } else {
            old.setFieldName(newName);
            System.out.println("Field " + oldName + " changed to " + newName + "!");
            return true;
        }
     }

    // Deletes a field form this class of the specified name
    public boolean deleteField(String name) {
    	Iterator<Field> fldItr = fields.iterator();
        while (fldItr.hasNext()) {
            Field ele = fldItr.next();
            if (ele.getFieldName().equals(name)) {
                fldItr.remove();
                System.out.println ("Field " + name + " removed from " + this.getClassName() + "!");
                return true; // Field successfully removed, return true
            }
        }
        System.out.println("Field " + name + " does not exist!");
        return false; // Field not found, return false
    }

    

    // Adds a field to this class. 
    public boolean addField(String fieldName, String fieldType) {
    	if(fields.isEmpty()) { // Empty hash set
    		fields.add(new Field(fieldName, fieldType)); 
    		return true; // Field added successfully, return true
    	} else {
    		for (Field ele: fields) {
                if(ele.getFieldName().equals(fieldName)) { // Checking if field already exists
                    System.out.println("Field already exists!");
                    return false; // Field already exists, return false
                }
            }
    	}
    	this.fields.add(new Field(fieldName, fieldType)); // Field does not exist already; add this field
    	return true; // Field added successfully, return true
    }

    // Adds a method to this class
    public boolean addMethod (String methodName, String returnType) {
        if(methods.isEmpty()) { // Empty hash set
    		methods.add(new Method(methodName, returnType)); 
    		return true; // Method added successfully, return true
    	} else {
    		for (Method ele: methods) {
                if(ele.getMethodName().equals(methodName)) { // Checking if method already exists
                    System.out.println("Method already exists!");
                    return false; // Method already exists, return false
                }
            }
    	}
    	this.methods.add(new Method(methodName, returnType)); // Method does not exist already; add this field
    	return true; // Field added successfully, return true
    }
    
    // Deletes a method from this class of the specified name
    public boolean deleteMethod(String name) {
    	Iterator<Method> methItr = methods.iterator();
        while (methItr.hasNext()) {
            Method ele = methItr.next();
            if (ele.getMethodName().equals(name)) {
                methItr.remove();
                System.out.println ("Method " + name + " removed from " + this.getClassName() + "!");
                return true; // Method successfully removed, return true
            }
        }
        System.out.println("Method " + name + " does not exist!");
        return false; // Method not found, return false
    }

    // Renames a method in this class from 'oldName' to 'newName' 
    // Should fail if the method 'oldName' does not exist OR if a method 'newName' already exists
    public boolean renameMethod(String oldName, String newName) {
    	Iterator<Method> methItr = methods.iterator();
    	boolean oldMatch = false;
        boolean newMatch = false;
        Method old = null;
    	while (methItr.hasNext()) {
            Method ele = methItr.next();
            if (ele.getMethodName().toUpperCase().equals(oldName.toUpperCase())) {
                oldMatch = true;
                old = ele;
            } else if ( ele.getMethodName().toUpperCase().equals(newName.toUpperCase())) {
                newMatch = true;
            }
        }
        if (!oldMatch) {
            System.out.println("Method does not exist! Name change failed!");
            return false;
        } else if (newMatch) {
            System.out.println("New Method name already exists! Name change failed!");
            return false;
        } else {
            old.setMethodName(newName);
            System.out.println("Method " + oldName + " changed to " + newName + "!");
            return true;
        }
     }

    // Sets the return type of the Method 'methodName' to 'newReturnType'
    // Should fail if the Method does not exist or the new return type is the same as the current return type
    public boolean changeMethodreturn(String methodName, String newReturnType) {
    	Iterator<Method> methItr = methods.iterator();
    	Method current = null;
    	while(methItr.hasNext()) {
    		current = methItr.next();
    		if(current.getMethodName().toUpperCase().equals(methodName.toUpperCase())) {
    			// Existing return type is already new return type
    			if(current.getReturnType().toUpperCase().equals(newReturnType.toUpperCase())) { 
    				System.out.println("Existing return type same as new return type. Return type change failed!");
    				return false;
    			}
    			// Field of specified name found
    			current.setReturnType(newReturnType);
    			System.out.println("The method " + current.getMethodName() + "'s return type has been changed to " + current.getReturnType() + "!");
    			return true;
    		}
    	}
    	// Field of specified name not found
    	System.out.println("Method does not exist! Return type change failed!"); 
    	return false;
    	
    }

}

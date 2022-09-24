/*

This class is the representation of a relationship between two Class classes.
Stores the Class that is the destination of a relationship between two classes
*/

 /* @projectDescription	A program for adding classes to a database
 * 
 * @authors	John Shenk, Benjamin Slinghoff, Lauryn Simmons, Alex Peiffer, Meba Shimelis
 * @version 0.0.1
 * @dateLastModified September 13, 2022
 */


public class Relationship {
    /*
    This class is the representation of a relationship between two Class classes.
    Stores the Class that is the destination of a relationship between two classes
    */

        public enum Type {
            AGGREGATION, COMPOSITION, INHERITANCE, REALIZATION; 
        }
        
        // destination is the Class that receives the relationship from the origin class
        private Class destination;

        // relationshipType is the Type that this relationship is classified as
        private Type relationshipType;

        // sets the type of the relationship to the given string
        public void setRelType(Type type){
            this.relationshipType = type;
        }

        // returns the type of the relationship
        public Type getRelType(){
            return this.relationshipType;
        }
    
        // Constructor thats takes a Class as a parameter to set destination and a String to set type
        public Relationship (Class destination, Type type) {
            this.destination = destination;
            this.relationshipType = type;
        }
    
        // a method to get the Class that is the destination of a Relationship
        // returns Class
        public Class getDestination () {
            // returns the destination of the current class relationship
            return this.destination;
    
        }
    
    }
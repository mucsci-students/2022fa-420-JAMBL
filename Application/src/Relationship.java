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
            AGGR("AGGR", "AGGREGATION"), 
            COMP("COMP", "COMPOSITION"), 
            INHE("INHE", "INHERITANCE"), 
            REAL("REAL", "REALIZATION");

            private  String name;
             String fullName;

            private Type(String name, String fullName) {
                this.name = name;
                this.fullName = fullName;
            }
           
            public String toString(){
                return name;
            }
            public String fullName(){
                return fullName;
            }
    
        }
        
        // destination is the Class that receives the relationship from the origin class
        private Class destination;

        // relationshipType is the Type that this relationship is classified as
        private Type relationshipType;

        // sets the type of the relationship to the given string
        public void setRelType(String type){
            this.relationshipType = Type.valueOf(type.toUpperCase());
        }

        // returns the type of the relationship
        public String getRelType(){
            return this.relationshipType.toString();
        }
    
        // Constructor thats takes a Class as a parameter to set destination and a String to set type
        public Relationship (Class destination, String type) {
            this.destination = destination;
            this.relationshipType = Type.valueOf(type);
        }
    
        // a method to get the Class that is the destination of a Relationship
        // returns Class
        public Class getDestination () {
            // returns the destination of the current class relationship
            return this.destination;
    
        }

        public String getFullType(){
            return this.relationshipType.fullName();
        }
    
    }
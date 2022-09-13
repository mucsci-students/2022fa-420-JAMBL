/*
 * @projectDescription	A program for adding classes to a database
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
        // destination is the Class that receives the relationship from the origin class
        private Class destination;
    
        // Constructor thats takes a Class as a parameter to set destination
        public Relationship (Class destination) {
    
            this.destination = destination;
    
        }
    
        // a method to get the Class that is the destination of a Relationship
        // returns Class
        public Class getDestination () {
    
            return this.destination;
    
        }
    
    }
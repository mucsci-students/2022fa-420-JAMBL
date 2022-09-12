public class Attribute {
    
    String attName; //name of the Attribute

    //onstructor that takes String parameter and sets it as name
    public Attribute(String name) {

        attName = name;
    }  


   
    //sets attName to given String
    void setAttName (String name) {
        attName = name;
    }
	
    //returns attName
    String getAttName () {

        return attName;
    } 
}

package jambl.Model;

public class Parameter {
    
    //name of the Parameter
    String paramName;
    String paramType;

    //Constructor that takes String parameter name 
    
    public Parameter (String paramName, String paramType) {

        this.paramName = paramName;
        this.paramType = paramType;
    }  

    //sets Parameter's Name to given String
    public void setParamName (String paramName) {
    	
    	this.paramName = paramName;
    }

  //returns Parameter's Name
    public String getParamName() {

         return paramName;
     } 
    
	// sets Parameter's type to a given String
    public void setParamType (String paramType) {
    	
    	this.paramType = paramType;
    }
    //returns Parameter's Type
   public String getParamType() {

        return paramType;
    } 
    
}

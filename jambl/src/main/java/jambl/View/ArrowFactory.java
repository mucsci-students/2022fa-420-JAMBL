package jambl.View;

public class ArrowFactory {
    
   public static Arrow getArrow(String ArrowType){
    if(ArrowType == null){
       return null;
    }		
    if(ArrowType.equalsIgnoreCase("Realization")){
       return new realArrow();
       
    } else if(ArrowType.equalsIgnoreCase("Inheritance")){
       return new inheArrow();
       
    } else if(ArrowType.equalsIgnoreCase("Aggregation")){
       return new aggrArrow();

    } else if(ArrowType.equalsIgnoreCase("Composition")){
        return new compArrow();
     }
    
    return null;
 }
    
}

import java.util.*;
import java.io.*;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
public class Controller {
    public Controller(){

    }





    public void save(Model model){
        JSONObject obj1 = new JSONObject();
        JSONObject obj2;

        HashSet<Class> classes = model.classes;
        HashSet<Attribute> atts;
        HashSet<Relationship> rels;
        HashSet<String> attSet = new HashSet<String>();
        HashSet<String> relSet = new HashSet<String>();
        Class curr;
        Relationship relationship;
        Attribute attribute;
        Iterator<Class> itClasses = classes.iterator();
        Iterator<Attribute> itAtts;
        Iterator<Relationship> itRels;
        String classStr = "";
        String attStr = "";
        String relsStr = "";
        

        while(itClasses.hasNext()){
            curr = (Class) itClasses.next();
            classStr = curr.getClassName();
            atts = curr.attributes;
            rels = curr.relationships;
            itRels = rels.iterator();
            itAtts = atts.iterator();
            

            // iterate through relationship HashSet
            
            while(itRels.hasNext()){
                relationship = (Relationship) itRels.next();
                relSet.add(relationship.getDestination().getClassName());
                //relsStr = relationship.getDestination().getClassName() + ", " + relsStr;
            }
            relsStr = String.join(", ", relSet);
            relSet.clear();
            
            while(itAtts.hasNext()){
                attribute = (Attribute) itAtts.next();
                attSet.add(attribute.getAttName());
                //attStr = attStr + ", " + attribute.getAttName();
            }
            attStr = String.join(", ", attSet);
            attSet.clear();
            obj2 = new  JSONObject();
            obj2.put( "Attributes", attStr);
            obj2.put("Relationships", relsStr);
            obj1.put(classStr, obj2);
        }

        try{

            FileWriter file = new FileWriter("JAMBL.json");
            file.write(obj1.toJSONString());
            file.close();
            System.out.println("UML Diagram Saved!");
        }catch(Exception e){
            System.out.println("Could not write file" + e);
        }
        
    }
    

    
    
}

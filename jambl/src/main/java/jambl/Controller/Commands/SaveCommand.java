package jambl.Controller.Commands;

import java.io.FileWriter;

import org.json.simple.JSONObject;

import jambl.Controller.Save;
import jambl.Model.*;
import jambl.View.*;


public class SaveCommand implements Command1{
    
    View view = new View();
    Model model;
    String fileName;

    public SaveCommand(Model mod){
        
        model = mod;
    }

    public void execute(){
         //Prompts user for file
         fileName = view.savePrompt();
         // Checks if user wants default file
         if(fileName.isBlank()){
             
             save(model, "JAMBL.json");
         }else{
             // else save to inputted file
             save(model, fileName);
         }
       

    }

    public void save(Model model, String fileName){
        Save saving = new Save(model);
        JSONObject fileObj = new JSONObject();
        fileObj.put("classes", saving.classes());
        fileObj.put("relationships", saving.relationships());

        try{
            // creates new file  if ther is not one
            FileWriter file = new FileWriter(fileName);
            // turns object to string and save to file
            file.write(fileObj.toJSONString());
            file.close();
            //System.out.println("UML Diagram Saved!");
        }catch(Exception e){
            System.out.println("Could not write file" + e);
        }
    }
      
}

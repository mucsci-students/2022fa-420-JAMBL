package jambl.Controller.Commands;


import org.json.simple.JSONObject;


import jambl.Controller.Controller;
import jambl.Controller.History;
import jambl.Controller.Load;
import jambl.Model.Model;
import jambl.View.View;

public class LoadCommand implements Command1 {
    View view;
    History history;
    Model model;
    String fileName;
    Controller controller;
    
    public LoadCommand(History hist, Model mod, View v){
        model = mod;
        history = hist;
        view = v;
    }


    public void execute(){
        
        //prompts user for file
        fileName = view.loadPrompt();
        // checks of its default
        if(fileName.isBlank()){
            load("JAMBL.json");
        }else{
            // otherwise loads file into current model
            load(fileName);
        }
        view.loaded();
        history.newWorkflow();
    }

    
    public void load(String fileName){
        
        Load load = new Load();
        
       // get object of file contents
       JSONObject file = load.getFile(fileName);

       // adds the classes with the fields, methods and parameters ect.
       load.loadClasses(file);

       // loads relationships into classes
       this.model = load.loadRelationships(file);

   }

    public Model getModel(){
        return model;
    }

    
}

package jambl.Controller.Commands;



import java.util.ArrayList;
import java.util.HashSet;

import org.json.simple.JSONObject;


import jambl.Controller.Controller;
import jambl.Controller.History;
import jambl.Controller.Load;
import jambl.Model.Model;
import jambl.Model.Parameter;
import jambl.Model.Class;
import jambl.Model.Field;
import jambl.Model.Method;
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

       if(file == null){
        return;
       }else{
         // adds the classes with the fields, methods and parameters ect.
       load.loadClasses(file);

       // loads relationships into classes
       this.model = load.loadRelationships(file);

       String type;
       ArrayList<String> tabClasses = new ArrayList<String>();
       ArrayList<String> tabMethods = new ArrayList<String>();
       ArrayList<String> tabFields = new ArrayList<String>();
       ArrayList<String> tabParams = new ArrayList<String>();
       ArrayList<String> tabTypes = new ArrayList<String>();
       // sets tab completeion from a model
       HashSet<Class> classes = this.model.getClasses();
       if(classes != null){
           for(Class aClass : classes){
               tabClasses.add(aClass.getClassName());
       
               HashSet<Method> methods = aClass.getMethods();
               if(methods != null){
                   for(Method method : methods ){
                       tabMethods.add(method.getMethodName());
                       type = method.getReturnType();
                       if(!tabTypes.contains(type)){
                           tabTypes.add(type);
                       }
       
                       HashSet<Parameter> params = method.getParameters();
                       if(params != null){
                           for(Parameter param : params){
                               tabParams.add(param.getParamName());
                               
                               type = param.getParamType();
                               if(!tabTypes.contains(type)){
                                   tabTypes.add(type);
                               }
                           }
                       }
                       
                   }

               }
              
               
               HashSet<Field> fields = aClass.getFields();
               if(fields != null){
                   for(Field field : fields ){
                       tabFields.add(field.getFieldName());
                       type = field.getFieldType();
                       if(!tabTypes.contains(type)){
                           tabTypes.add(type);
                       }
                   }
               }
               
           }

       }

       view.setArrays(tabClasses, tabFields, tabMethods, tabParams, tabTypes);

       }

      

   }

    public Model getModel(){
        return model;
    }

    
}

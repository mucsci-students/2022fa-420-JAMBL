package jambl.Controller.Commands;

import jambl.Model.*;
import jambl.View.*;
import jambl.Model.Class;

public class ListCommand implements Command1{
    String name1;
    String name2;
    String name3;
    View view;
    Class class1;
    
    Model model;
    String element;

    public ListCommand(Model mod, String ele, View v){
        
        model = mod;
        element = ele;
        view = v;
    }

    public void execute(){
        if(element.equals("all")){
            view.listAllClasses(model);

        }else if(element.equals("cla")){
            name1 = view.inputClassListed();
            if (model.getClass(name1) == null) {
                view.notExists("Class", name1);
                return;
            }else {
                Class cls = model.getClass(name1);
                view.listClass(cls);
            }

        }else if(element.equals("rel")){
            view.listRelationship(model);

        }else{
            System.out.println("Can not be listed");
        }
       

    }

}

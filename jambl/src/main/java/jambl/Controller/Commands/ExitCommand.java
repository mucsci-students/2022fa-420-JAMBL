package jambl.Controller.Commands;

import jambl.Model.Model;
import jambl.View.View;

public class ExitCommand implements Command1 {
    String fileName;
    String name1;
    Model model;
    View view;
    
    public ExitCommand(Model mod, View v){
        model = mod;
        view = v;
    }

    public void execute(){
        do {
            name1 = view.exitPrompt();
            if (name1.toUpperCase().equals("YES")) {
                 SaveCommand save = new SaveCommand(model, view);
                 save.execute();
            }
            } while (!name1.toUpperCase().equals("YES") && !name1.toUpperCase().equals("NO"));

    }
    
}

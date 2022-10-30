package jambl.Controller.Commands;

import jambl.View.View;

public class HelpCommand implements Command1{
    View view;
    public HelpCommand(View v){
        view = v;
    }

    public void execute(){
        view.printHelp();
    }
    
}

package jambl.Controller.Commands;

import jambl.View.View;

public class HelpCommand implements Command1{
    View view = new View();
    public HelpCommand(){

    }

    public void execute(){
        view.printHelp();
    }
    
}

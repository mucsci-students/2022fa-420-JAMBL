package jambl;
import jambl.Model.*;
import jambl.Controller.*;
import jambl.View.*;

/*
 * @projectDescription	A program for adding classes to a database
 * 
 * @authors	John Shenk, Benjamin Slinghoff, Lauryn Simmons, Alex Peiffer, Meba Shimelis
 * @version 0.0.1
 * @dateLastModified September 13, 2022
 */
import java.util.*;
import org.jline.reader.impl.completer.StringsCompleter;
import org.jline.reader.LineReader;
import org.jline.reader.LineReaderBuilder;

public class Main {

    public static void main (String args[]) {
    	if(args.length != 0 && args[0].equals("--cli")) {
            Model model  = new Model();
            View view = new View();
            Controller controller = new Controller(model , view);
            StringsCompleter comp = new StringsCompleter("addcl","delcl", "rencl",
                                                                    "addfld", "delfld", "fldtype",
                                                                    "addmtd", "delmtd", "renmtd", "mtdtype",
                                                                    "addrel", "delrel", "reltype",
                                                                    "addpar", "delpar","chgpar",
                                                                    "save", "load", "help", "exit",
                                                                    "listall", "listcla", "listrel",
                                                                    "ADDCL","DELCL", "RENCL",
                                                                    "ADDFLD", "DELFLD", "FLDTYPE",
                                                                    "ADDMTD", "DELMTD", "RENMTD", "MTDTYPE",
                                                                    "ADDREL", "DELREL", "RELTYPE",
                                                                    "ADDPAR", "DELPAR","CHGPAR",
                                                                    "SAVE", "LOAD", "HELP", "EXIT",
                                                                    "LISTALL", "LISTCLA", "LISTREL",
                                                                    "UNDO", "undo","REDO", "Redo");
            LineReader reader = LineReaderBuilder.builder().completer(comp).build();
            System.out.println();
            System.out.println("Welcome to JAMBL UML Diagram Creator!");
            System.out.println("Please enter your first command. Enter LOAD to load an existing file.");
            System.out.println("Or enter HELP for list of commands.");
            
            String input = reader.readLine("JAMBL> ").toUpperCase();
            StringTokenizer token = new StringTokenizer(input);
            String userCmd = token.nextToken();

            Controller.Command currentCmd = Controller.Command.START;


            do { 
                if (!controller.isValidCmd(userCmd)) {
                    view.invalidCmd();
                } else {
                    currentCmd = Controller.Command.valueOf(userCmd);
                    controller.commandExecute(currentCmd);
                }
                if (currentCmd != Controller.Command.EXIT) {
                    
                    input = reader.readLine("JAMBL> ").toUpperCase();
                    token = new StringTokenizer(input);
                    userCmd = token.nextToken().toUpperCase();
                }
                
            } while (currentCmd != Controller.Command.EXIT);

            System.out.println("Thank you for using JAMBL UML Diagram Creator! Goodbye!");
            
            return;
    	}else if(args.length == 0){
            GUIMain.main(null);   	
    	}else{
    		System.out.println("Unidentified argument");
    		return;
        }
    }
}

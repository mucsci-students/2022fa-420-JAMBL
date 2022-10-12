/*
 * @projectDescription	A program for adding classes to a database
 * 
 * @authors	John Shenk, Benjamin Slinghoff, Lauryn Simmons, Alex Peiffer, Meba Shimelis
 * @version 0.0.1
 * @dateLastModified September 13, 2022
 */
import java.util.*;

public class Main {

    public static void main (String args[]) {
    	if(args.length != 0 && args[0].equals("--cli")) {
            Model model  = new Model();
            View view = new View();
            Controller controller = new Controller(model , view);
            System.out.println();
            System.out.println("Welcome to JAMBL UML Diagram Creator!");
            System.out.println("Please enter your first command. Enter LOAD to load an existing file.");
            System.out.println("Or enter HELP for list of commands.");
            System.out.print("JAMBL> ");
            Scanner scanner = new Scanner(System.in);
            String userCmd = scanner.nextLine().toUpperCase();
            Controller.Command currentCmd = Controller.Command.START;


            do { 
                if (!controller.isValidCmd(userCmd)) {
                    view.invalidCmd();
                } else {
                    currentCmd = Controller.Command.valueOf(userCmd);
                    controller.commandExecute(currentCmd);
                }
                if (currentCmd != Controller.Command.EXIT) {
                    System.out.print("JAMBL> ");
                    userCmd = scanner.nextLine().toUpperCase();
                }
                
            } while (currentCmd != Controller.Command.EXIT);

            System.out.println("Thank you for using JAMBL UML Diagram Creator! Goodbye!");
            scanner.close();
            return;
    	}else if(args.length == 0){
            GUIMain.main(null);   	
    	}else{
    		System.out.println("Unidentified argument");
    		return;
        }
    }
}

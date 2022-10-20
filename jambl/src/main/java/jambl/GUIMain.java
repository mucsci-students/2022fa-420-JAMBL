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

public class GUIMain {

    public static void main (String args[]) {
 //   	if(args[0].equals("--cli")) {
            Model model  = new Model();
            GUIController controller = new GUIController(model);
    	    controller.start();
    
    }
}


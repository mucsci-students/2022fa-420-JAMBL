/*
 * @projectDescription	A program for adding classes to a database
 * 
 * @authors	John Shenk, Benjamin Slinghoff, Lauryn Simmons, Alex Peiffer, Meba Shimelis
 * @version 0.0.1
 * @dateLastModified September 8, 2022
 */

//Java imports
import java.io.*;
import java.util.Scanner;

//MongoDB imports
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

//JSON imports
import org.json.simple.JSONObject;

public class Interface {
	
	//***** INFORMATION FOR THOSE UNFAMILIAR WITH MONGODB *****//
	/*
	 * I highly recommend downloading MongoDB Compass and putting in the connection string 
	 * 	to be able to view the database
	 * Do NOT change the connection string declared at the top of the main function
	*/
	public static void main(String[] args) throws IOException {
		
		/*
		//Connect to database using a connection String - DO NOT CHANGE THIS
		String connString = "mongodb+srv://JAMBL:se420@clusterjambl.4bnlbcs.mongodb.net/test";
		
		// Getting a MongoClient using a Client URI and the connection string
		// Used for retrieving info from DB
		
		MongoClientURI clientURI = getURI(connString);
		MongoClient client = getClient(clientURI);
		System.out.print("Success");
		*/
		
		// prompts user and stores input in variable (command)
		System.out.println("Welcome to JAMBL UML!");
        System.out.println("If you're just starting out enter help to get started!");
        Scanner console = new Scanner(System.in);
        System.out.print("JAMBL> ");
		String command = console.nextLine();
		
		while(!command.equals("exit")) {
			System.out.print("JAMBL> ");
			command = console.nextLine();
		}
		
		
		System.out.println("Goodbye!");
		console.close();


		
	}
	
	/*
	 * @name deleteClass
	 * @description	RDeletes a class of the specified name
	 * @param className The name of the class to be deleted
	 * @note command to delete class will be 'deletec'
	 */
	public static void deleteClass(String className) {
		System.out.println("Entered deleteClass!");
		return;
	}
	
	/*
	 * @name getURI
	 * @description	Returns a Mongo Client URI using a connection string
	 * @param conn	The connection string used to connect to the database
	 * @return A new Mongo Client URI
	 */
	public static MongoClientURI getURI(String conn)
	{
		return new MongoClientURI(conn);
	}

	/*
	 * @name getClient
	 * @description	Returns a Mongo Client using a client URI
	 * @param uri	The client URI used to get the client
	 * @return A new Mongo Client
	 */
	public static MongoClient getClient(MongoClientURI uri)
	{
		return new MongoClient(uri);
	}
}

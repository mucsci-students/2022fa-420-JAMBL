/*
 * @projectDescription	A program for adding classes to a database
 * 
 * @authors	John Shenk, Benjamin Slinghoff, Lauryn Simmons, Alex Peiffer, Meba Shimelis
 * @version 0.0.1
 * @dateLastModified September 8, 2022
 */


import java.io.*;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;


import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;

import org.json.simple.JSONObject;

public class Interface {
	
	//***** INFORMATION FOR THOSE UNFAMILIAR WITH MONGODB *****//
	/*
	 * I highly recommend downloading MongoDB Compass and putting in the connection string 
	 * 	to be able to view the database
	 * Do NOT change the connection string declared at the top of the main function
	*/
	@SuppressWarnings("rawtypes")
	public static void main(String[] args) throws IOException {
		
		//Connect to database using a connection String - DO NOT CHANGE THIS
		String connString = "mongodb+srv://JAMBL:se420@clusterjambl.4bnlbcs.mongodb.net/test";
		
		/*
		 * Getting a MongoClient using a Client URI and the connection string
		 * Used for retrieving info from DB
		 */
		MongoClientURI clientURI = getURI(connString);
		MongoClient client = getClient(clientURI);
		
		//System.out.print("Success");
		
		/*
		 * Gets the database
		 */
		MongoDatabase database = getDB("Classes", client);
		
		/*
		 * Gets the collection in the database
		 */
		MongoCollection collection = getDBColl(database, "Classes");
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
	
	// Returns a Mongo Database using the parameters name and client
	public static MongoDatabase getDB(String name, MongoClient client)
	{
		return client.getDatabase(name);
			
	}
	
	// Returns a Mongo Collection of Documents using a database and a name
	public static MongoCollection<Document> getDBColl(MongoDatabase database, String collection)
	{
		return database.getCollection(collection);
	}
	
}

/*
 * @projectDescription	A program for adding classes to a database
 * 
 * @authors	John Shenk, Benjamin Slinghoff, Lauryn Simmons, Alex Peiffer, Meba Shimelis
 * @version 0.0.1
 * @dateLastModified September 8, 2022
 */


import java.io.*;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

/*
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;

import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.conversions.Bson;
import com.mongodb.client.result.DeleteResult;
import static com.mongodb.client.model.Filters.eq;
import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoCursor;
//Create Document Objects
import org.bson.Document;
//Create Bson Objects (e.g. Bson filters)
import org.bson.conversions.Bson;
import static com.mongodb.client.model.Accumulators.sum;
import static com.mongodb.client.model.Accumulators.avg;
import static com.mongodb.client.model.Aggregates.group;
import static com.mongodb.client.model.Aggregates.limit;
import static com.mongodb.client.model.Aggregates.match;
import static com.mongodb.client.model.Aggregates.sort;
import static com.mongodb.client.model.Aggregates.unwind;
//eq method returns a Bson filter that tests if arg1 (logic) AND arg2
import static com.mongodb.client.model.Filters.and;
//and method returns a Bson filter that tests if arg1 = arg2
import static com.mongodb.client.model.Filters.eq;
//gt method returns a Bson filter that tests if arg1 > arg2
import static com.mongodb.client.model.Filters.gt;
import static com.mongodb.client.model.Filters.gte;
import static com.mongodb.client.model.Filters.lt;
import static com.mongodb.client.model.Filters.or;
import static com.mongodb.client.model.Sorts.ascending;
import static com.mongodb.client.model.Sorts.descending;
import java.util.Arrays;
//Create Cursor Object to visit all documents in one query result
import com.mongodb.client.MongoCursor;
// Create Index 
import com.mongodb.client.model.Indexes;
//project fields 
import static com.mongodb.client.model.Projections.*
*/

public class Interface {
	
	//***** INFORMATION FOR THOSE UNFAMILIAR WITH MONGODB *****//
	/*
	 * I highly recommend downloading MongoDB Compass and putting in the connection string 
	 * 	to be able to view the database
	 * Do NOT change the connection string declared at the top of the main function
	*/
	public static void main(String[] args) throws IOException {
		
		//Connect to database using a connection String - DO NOT CHANGE THIS
		String connString = "mongodb+srv://JAMBL:se420@clusterjambl.4bnlbcs.mongodb.net/test";
		/*
		 * Getting a MongoClient using a Client URI and the connection string
		 * Used for retrieving info from DB
		 */
		MongoClientURI clientURI = getURI(connString);
		MongoClient client = getClient(clientURI);
		System.out.print("Success");
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

// Name:		Working Title
// Authors: 	John Shenk, Benjamin Slinghoff, Lauryn Simmons, Alex Peiffer, Meba Shimelis
// Description:	A program used for adding classes to a database and displaying them in a orderly fashion.

import java.io.*;


import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
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
import static com.mongodb.client.model.Projections.*;

public class Interface {
	
}

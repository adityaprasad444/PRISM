package com.kh.IRA.Utilities;

import java.util.Arrays;

import org.bson.Document;

import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class DBHelper {

	public String host="devdb.kh3ira.com";
	public String user="test";
	public String database="iratest";
	public char[] password="iratest2019".toCharArray();
	public MongoClient mongoClient;
	public MongoDatabase db;

	public void startConnection() {

		MongoCredential credential = MongoCredential.createScramSha1Credential(user,database,password);
		mongoClient = new MongoClient(new ServerAddress(host, 27017),Arrays.asList(credential));
		db = mongoClient.getDatabase(database);
	}


	public void closeConnection() {

		mongoClient.close();
	}

	public void getdata(String table) {

		MongoCollection<Document> collection = db.getCollection(""+table);

		Document query = new Document();

		Block<Document> processBlock = new Block<Document>() {
			@Override
			public void apply(final Document document) {
				System.out.println(document);
			}
		};

		collection.find(query).forEach(processBlock);

	} 

	public void getdata(String table,String key,String Value,String field1,String field2, String field3 ) {

		MongoCollection<Document> collection = db.getCollection(""+table);

		Document query = new Document();
		query.append(key,Value);

		Document projection = new Document();
        projection.append(field1, "$"+field1);
        projection.append(field2, "$"+field2);
        projection.append(field3, "$"+field3);
        projection.append("_id", 0);
		
		Block<Document> processBlock = new Block<Document>() {
			@Override
			public void apply(final Document document) {
				System.out.println(document);
			}
		};

		collection.find(query).projection(projection).forEach(processBlock);

	} 

}

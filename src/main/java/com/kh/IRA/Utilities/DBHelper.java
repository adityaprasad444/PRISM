package com.kh.IRA.Utilities;

import java.util.Arrays;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoDatabase;

public class DBHelper {

	public String host="devdb.kh3ira.com";
	public String user="test";
	public String database="iratest";
	public char[] password="iratest2019".toCharArray();
	public MongoClient mongoClient;
	
	public void startConnection() {
		
		MongoCredential credential = MongoCredential.createScramSha1Credential(user,database,password);
		mongoClient = new MongoClient(new ServerAddress(host, 27017),Arrays.asList(credential));
		MongoDatabase db = mongoClient.getDatabase(database);
	}
	
	
	public void closeConnection() {
		
		mongoClient.close();
	}
	

	
	
}

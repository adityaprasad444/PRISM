package com.kh.IRA.Tests;

import com.kh.IRA.Utilities.DBHelper;

public class AdityaDB extends DBHelper {

	public static void main(String[] args) {
		DBHelper help=new DBHelper();
		
		help.startConnection();
		help.getdata("users","email","aditya.prasad@knowledgehut.co", "firstName","lastName", "email");
		help.closeConnection();

	}

}

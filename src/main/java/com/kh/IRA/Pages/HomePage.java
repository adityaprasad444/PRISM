package com.kh.IRA.Pages;

import com.kh.IRA.Utilities.Configreader;

public class HomePage {

	Configreader cr;
	public HomePage() {
		
		String proppath="//src//main//resources//com//kh//IRA//Locators//Homepage.properties";
		cr=new Configreader(proppath);
	}
	
	public  String getUsername() {
		return cr.getProperty("Username");
	}
	public  String getPassword() {
		return cr.getProperty("Password");
	}
	public  String getSubmit() {
		return cr.getProperty("Submit");
	}
}

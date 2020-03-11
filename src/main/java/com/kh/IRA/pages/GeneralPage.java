package com.kh.IRA.pages;

import com.kh.IRA.utilities.Configreader;

public class GeneralPage {

	Configreader cr;
	public GeneralPage() {
		
		String proppath="//src//main//resources//com//kh//IRA//Locators//General.properties";
		cr=new Configreader(proppath);
	}
	
	public  String geturl() {
		return cr.getProperty("URL");
	}
    public String getbrowser() {
    	return cr.getProperty("Browser");
    }
    public String getusername() {
    	return cr.getProperty("username");
    }
    public String getpassword() {
    	return cr.getProperty("password");
    }
}
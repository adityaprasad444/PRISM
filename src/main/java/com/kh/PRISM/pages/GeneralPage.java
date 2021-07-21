package com.kh.PRISM.pages;

import com.kh.PRISM.utilities.Configreader;

public class GeneralPage {

	Configreader cr;
	public GeneralPage() {
		
		String proppath="//src//main//resources//com//kh//PRISM//Locators//General.properties";
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
    public String getOs() {
    	return cr.getProperty("os");
    }
    public String getOsVersion() {
    	return cr.getProperty("osVersion");
    }
    public String getbrowserVersion() {
    	return cr.getProperty("browserVersion");
    }
}
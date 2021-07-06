package com.kh.PRISM.pages;

import com.kh.PRISM.utilities.Configreader;

public class DashboardPage {

	Configreader cr;
	public DashboardPage() {
		
		String proppath="//src//main//resources//com//kh//PRISM//Locators//Dashboard.properties";
		cr=new Configreader(proppath);
	}
	
	public  String getDashboard() {
		return cr.getProperty("Dashboard");
	}
	public  String profilecircle() {
		return cr.getProperty("profilecircle");
	}
	public  String profileitems() {
		return cr.getProperty("profileitems");
	}
	public  String logout() {
		return cr.getProperty("logout");
	}
}

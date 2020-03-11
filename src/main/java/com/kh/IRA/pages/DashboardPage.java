package com.kh.IRA.pages;

import com.kh.IRA.utilities.Configreader;

public class DashboardPage {

	Configreader cr;
	public DashboardPage() {
		
		String proppath="//src//main//resources//com//kh//IRA//Locators//Dashboard.properties";
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
}

package com.kh.IRA.Pages;

import com.kh.IRA.Utilities.Configreader;

public class DashboardPage {

	Configreader cr;
	public DashboardPage() {
		
		String proppath="//src//main//resources//com//kh//IRA//Locators//Dashboard.properties";
		cr=new Configreader(proppath);
	}
	
	public  String getDashboard() {
		return cr.getProperty("Dashboard");
	}
	public  String getLogout() {
		return cr.getProperty("Logout");
	}
}

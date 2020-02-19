package com.kh.IRA.Pages;

import com.kh.IRA.Utilities.Configreader;

public class CMSdashboardPage {

	Configreader cr;
	public CMSdashboardPage() {
		
		String proppath="//src//main//resources//com//kh//IRA//Locators//CMSDashBoard.properties";
		cr=new Configreader(proppath);
	}
	
	
	public  String CmsDashboard() {
		return cr.getProperty("CmsDashboard");
	}
	public  String cmsQuestionBank() {
		return cr.getProperty("QuestionBank");
	}
	public  String cmsAssessments() {
		return cr.getProperty("Assessments");
	}
	public  String cmsCourses() {
		return cr.getProperty("Courses");
	}
	public  String skillmap() {
		return cr.getProperty("skillmap");
	}
}

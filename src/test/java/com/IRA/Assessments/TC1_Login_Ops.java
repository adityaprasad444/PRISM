package com.IRA.Assessments;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.kh.IRA.pagehelper.CMSDashBoardHelper;
import com.kh.IRA.pagehelper.HomepageHelp;

public class TC1_Login_Ops extends HomepageHelp {

	CMSDashBoardHelper cdp=new CMSDashBoardHelper(); 
	
	@BeforeSuite(alwaysRun = true)
	public void begin() {
		browser();
	}
	
	@Test(priority=1)
	public void opsLogin() {
		url();
		loginFromProperty();
		//loginCMS("TestCredentials","ManagerLogin");
	}
	
	@Test(priority=2)
	public void navigateToAssessmentlist() {
		cdp.assessment();
	}
	
	@AfterSuite(alwaysRun = true)
	public void end() {
		destroy();
	}
}

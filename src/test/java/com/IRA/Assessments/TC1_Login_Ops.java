package com.IRA.Assessments;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.kh.IRA.pagehelper.CMSDashBoardHelper;
import com.kh.IRA.pagehelper.HomepageHelp;

public class TC1_Login_Ops extends HomepageHelp {

	CMSDashBoardHelper cdp=new CMSDashBoardHelper(); 
	
	@BeforeSuite
	public void begin() {
		browser();
	}
	
	@Test(priority=1)
	public void opsLogin() {
		url();
		loginCMS("TestCredentials","CALogin");
	}
	
	@Test(priority=2)
	public void navigateToAssessmentlist() {
		cdp.assessment();
	}
	
	@AfterSuite
	public void end() {
		
		//destroy();
	}
}

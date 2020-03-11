package com.kh.IRA.questionbank;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.kh.IRA.pagehelper.CMSDashBoardHelper;
import com.kh.IRA.pagehelper.HomepageHelp;
import com.kh.IRA.pages.CMSdashboardPage;

public class TC1_CMS_Login extends HomepageHelp {

	CMSDashBoardHelper cdp=new CMSDashBoardHelper(); 
	 
	@BeforeSuite
	public void begin() {
		browser();
	}
	
	@Test(priority=1)
	public void managerLogin() {
		url();
		loginCMS("TestCredentials","ManagerLogin");
	}
	
	@Test(priority=2)
	public void navigateToQuestionbankList() {
		cdp.questionBank();
	}
	
	@AfterSuite
	public void end() {
		System.out.println("After Suite done");
		destroy();
	}
	
}

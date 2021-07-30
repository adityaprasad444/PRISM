package com.kh.PRISM.Assessments;

import java.net.MalformedURLException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.kh.PRISM.pagehelper.CMSDashBoardHelper;
import com.kh.PRISM.pagehelper.HomepageHelp;

public class TC1_Login_Ops extends HomepageHelp {

	CMSDashBoardHelper cdp=new CMSDashBoardHelper(); 

	@BeforeSuite(alwaysRun = true)
	public void begin() throws MalformedURLException {
		browser();
	}

	@Test(priority=1)
	public void loginAndNavigate() {
		url();
		loginFromProperty();
		
	}

	@Test(priority=2)
	public void logout() {
		cdp.assessment();
	}
	
	@AfterSuite(alwaysRun = true)
	public void end() {
		cdp.Logout();
		destroy();
	}
}

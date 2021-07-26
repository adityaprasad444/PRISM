package com.PRISM.Assessments;

import java.net.MalformedURLException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import com.kh.PRISM.pagehelper.CMSDashBoardHelper;
import com.kh.PRISM.pagehelper.HomepageHelp;

public class TC1_Login_Ops extends HomepageHelp {

	CMSDashBoardHelper cdp=new CMSDashBoardHelper(); 

	@BeforeSuite(alwaysRun = true)
	public void begin() throws MalformedURLException {
		browser();
	}

	@BeforeTest
	public void loginAndNavigate() {
		url();
		loginFromProperty();
		cdp.assessment();
	}

	@AfterTest
	public void logout() {
		cdp.Logout();
	}
	
	@AfterSuite(alwaysRun = true)
	public void end() {
		destroy();
	}
}

package com.kh.PRISM.Assessments;

import java.io.FileNotFoundException;
import java.net.MalformedURLException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.kh.PRISM.pagehelper.CMSDashBoardHelper;
import com.kh.PRISM.pagehelper.CreateAssessmentHelper;
import com.kh.PRISM.pagehelper.HomepageHelp;
import com.kh.PRISM.utilities.EmailHelper;

public class TC1_Assessment extends CreateAssessmentHelper{

	CMSDashBoardHelper cdp=new CMSDashBoardHelper();
	HomepageHelp hp=new HomepageHelp();
	
	
	@BeforeSuite
	public void start() throws MalformedURLException {
		hp.browser();
		hp.url();
	}
	@BeforeMethod
	public void navigateToAssessments() {
		hp.loginFromProperty();
		cdp.assessment();
	}

	@AfterMethod
	public void logout() {
		cdp.logout();
	}
	
	@AfterSuite
	public void terminate() {
		EmailHelper.emailReportSend();
		destroy();
	}
	
	@Test(priority=1, enabled = false)
	public void createMock() throws FileNotFoundException {
		gotoCreatepage();
		fillAssessmentDetails("Mock");
	}

	@Test(priority=2,enabled = false)
	public void createGroup() throws FileNotFoundException {
		gotoCreatepage();
		fillAssessmentDetails("group");
	}
	
	@Test(priority=3,enabled = true) 
	public void createRegular() throws FileNotFoundException {
		gotoCreatepage();
		fillAssessmentDetails("regular");
	}
	
	@Test(priority=4,enabled = true)
	public void createRecall() throws FileNotFoundException {
		gotoCreatepage();
		fillAssessmentDetails("recall");
	}
	
	@Test(priority=5,enabled = true)
	public void createFree() throws FileNotFoundException {
		gotoCreatepage();
		fillAssessmentDetails("free");
	}
}

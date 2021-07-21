package com.kh.PRISM.learner;

import java.net.MalformedURLException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import com.kh.PRISM.pagehelper.DashboardHelper;
import com.kh.PRISM.pagehelper.HomepageHelp;


public class TC1_Login extends HomepageHelp{

	@BeforeSuite
	public void begin() throws MalformedURLException {
		browser();
	}
	
	@BeforeTest
	public void Login() {
		url();
		loginLMS("TestCredentials", "LearnerLogin");
	}
	
	@AfterTest
	public void Logout() {
		DashboardHelper.logout();
	}
	
	@AfterSuite
	public void end() {
		destroy();
	}
}


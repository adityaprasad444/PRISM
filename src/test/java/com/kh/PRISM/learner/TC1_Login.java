package com.kh.PRISM.learner;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.kh.PRISM.pagehelper.DashboardHelper;
import com.kh.PRISM.pagehelper.HomepageHelp;


public class TC1_Login extends HomepageHelp{

	@BeforeSuite
	public void begin() {
		browser();
	}
	
	@Test
	public void Login() {
		url();
		//loginFromProperty();
		loginLMS("TestCredentials", "LearnerLogin");
	}
	
	@AfterSuite
	public void end() {
		DashboardHelper.logout();
		destroy();
	}
}


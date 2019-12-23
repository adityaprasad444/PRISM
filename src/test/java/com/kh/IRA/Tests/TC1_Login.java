package com.kh.IRA.Tests;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.kh.IRA.PageHelper.DashboardHelper;
import com.kh.IRA.PageHelper.HomepageHelp;


public class TC1_Login extends HomepageHelp{

	@BeforeSuite
	public void begin() {
		browser();
	}
	
	@Test
	public void Login() {
		url();
		login();
	}
	
	@AfterSuite
	public void end() {
		DashboardHelper.logout();
		destroy();
	}
}


package com.kh.PRISM.skillmap;

import java.net.MalformedURLException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.kh.PRISM.pagehelper.HomepageHelp;

public class Login extends HomepageHelp {

	@BeforeSuite
	public void begin() throws MalformedURLException {
		browser();
	}
	
	@Test(groups = "skillmap")
	public void contentOpsLogin() {
		url();
		//loginCMS("TestCredentials","CALogin");
		loginFromProperty();
	}
	
	@AfterSuite
	public void end() {
		destroy();
	}
	
}

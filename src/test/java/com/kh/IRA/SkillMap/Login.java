package com.kh.IRA.SkillMap;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.kh.IRA.PageHelper.HomepageHelp;

public class Login extends HomepageHelp {

	@BeforeSuite
	public void begin() {
		browser();
	}
	
	@Test
	public void caLogin() {
		url();
		login("CMS","Login");
	}
	
	@AfterSuite
	public void end() {
		System.out.println("After Suite done");
		//destroy();
	}
	
}

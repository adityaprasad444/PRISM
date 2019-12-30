package com.kh.IRA.PageHelper;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;

import com.kh.IRA.Pages.GeneralPage;
import com.kh.IRA.Pages.HomePage;
import com.kh.IRA.TestBase.TestBase;
import com.kh.IRA.Utilities.ExcelReader;

public class HomepageHelp extends TestBase {

	public GeneralPage gp;
	public HomePage hp;
	
	public HomepageHelp() {
		
		gp=new GeneralPage();
		hp=new HomePage();
		asrt= new SoftAssert();
	}
	
	public void browser() {
		
		driver= initialization(gp.getbrowser());
		browsersettings();
	}
	
	public void url() {
		driver.get(gp.geturl());
		asrt.assertEquals(driver.getTitle(),"IRA","TitleNot Matched");
		asrt.assertAll();
	}
	
	public void login() {
		driver.findElement(By.xpath(hp.getUsername())).sendKeys(gp.getusername());
		driver.findElement(By.xpath(hp.getPassword())).sendKeys(gp.getpassword());
		driver.findElement(By.xpath(hp.getSubmit())).click();
		asrt.assertAll();
	}
	
	public void login1() {
	HashMap<String, String> data=ExcelReader.readTestData("Credentials", "Login");
	String username=data.get("UserName");
	String password=data.get("Password");
	driver.findElement(By.xpath(hp.getUsername())).sendKeys(username);
	driver.findElement(By.xpath(hp.getPassword())).sendKeys(password);
	driver.findElement(By.xpath(hp.getSubmit())).click();
	
	}
}

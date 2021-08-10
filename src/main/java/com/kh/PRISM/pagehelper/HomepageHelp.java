package com.kh.PRISM.pagehelper;

import java.net.MalformedURLException;
import java.util.HashMap;
import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;

import com.kh.PRISM.pages.CMSdashboardPage;
import com.kh.PRISM.pages.GeneralPage;
import com.kh.PRISM.pages.HomePage;
import com.kh.PRISM.testbase.TestBase;
import com.kh.PRISM.utilities.ExcelReader;

public class HomepageHelp extends TestBase {

	public GeneralPage gp;
	public HomePage hp;
	public CMSdashboardPage cdp;

	public HomepageHelp() {

		gp=new GeneralPage();
		hp=new HomePage();
		cdp= new CMSdashboardPage();
		asrt= new SoftAssert();
	}

	public void browser() throws MalformedURLException {
		driver=browserLaunch(gp.getbrowser());
		//driver= initializtion(gp.getOs(),gp.getOsVersion(), gp.getbrowser(), gp.getbrowserVersion());
		browsersettings();
	}

	public void url() {
		driver.get(gp.geturl());
		asrt.assertEquals(driver.getTitle(),"Prism - AI driven, full stack digital learning experience platform","TitleNot Matched");
		asrt.assertAll();
	}

	public void loginFromProperty() {
		driver.findElement(By.xpath(hp.getUsername())).sendKeys(gp.getusername());
		driver.findElement(By.xpath(hp.getPassword())).sendKeys(gp.getpassword());
		driver.findElement(By.xpath(hp.getSubmit())).click();
		asrt.assertAll();
	}

	public void loginCMS(String sheetName,String testName) {
		HashMap<String,String> data=ExcelReader.readTestData(sheetName, testName);
		String username=data.get("UserName");
		String password=data.get("Password");
		driver.findElement(By.xpath(hp.getUsername())).sendKeys(username);
		driver.findElement(By.xpath(hp.getPassword())).sendKeys(password);
		driver.findElement(By.xpath(hp.getSubmit())).click();
		waitUntilVisibilityOfElement(driver.findElement(By.xpath(cdp.cmsCourses())));
		String s=driver.getCurrentUrl();
		asrt.assertEquals(s, gp.geturl()+"publish/courses","Ops URL does not match");
		asrt.assertAll();
	}
	public void loginLMS(String sheetName,String testName) {
		HashMap<String,String> data=ExcelReader.readTestData(sheetName, testName);
		String username=data.get("UserName");
		String password=data.get("Password");
		driver.findElement(By.xpath(hp.getUsername())).sendKeys(username);
		driver.findElement(By.xpath(hp.getPassword())).sendKeys(password);
		driver.findElement(By.xpath(hp.getSubmit())).click();
		waitUntilVisibilityOfElement(driver.findElement(By.xpath(cdp.cmsCourses())));
		String s=driver.getCurrentUrl();
		asrt.assertEquals(s, gp.geturl()+"learner/dashboard","Ops URL does not match");
		asrt.assertAll();
	}
}

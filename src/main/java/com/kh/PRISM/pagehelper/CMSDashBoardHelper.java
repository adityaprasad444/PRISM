package com.kh.PRISM.pagehelper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import com.kh.PRISM.pages.CMSdashboardPage;
import com.kh.PRISM.pages.GeneralPage;
import com.kh.PRISM.testbase.TestBase;

public class CMSDashBoardHelper extends TestBase {

public CMSdashboardPage cdp;
public GeneralPage gp;
	
	public CMSDashBoardHelper() {
		cdp=new CMSdashboardPage();
		gp=new GeneralPage();
		asrt=new SoftAssert();
	}
	
	public void questionBank() {
		WebElement cdash=driver.findElement(By.xpath(cdp.CmsDashboard()));
		waitUntilVisibilityOfElement(cdash);
		cdash.findElement(By.xpath(cdp.cmsQuestionBank())).click();
		asrt.assertEquals(driver.getCurrentUrl(), gp.geturl()+"assessments/question-bank", "URL Not Matched");
		asrt.assertAll();
	}
	
	public void course() {
		WebElement cdash=driver.findElement(By.xpath(cdp.CmsDashboard()));
		waitUntilVisibilityOfElement(cdash);
		cdash.findElement(By.xpath(cdp.cmsCourses())).click();
		asrt.assertEquals(driver.getCurrentUrl(), gp.geturl()+"publish/courses", "URL Not Matched");
		asrt.assertAll();
	}
	
	public void assessment() {
		WebElement cdash=driver.findElement(By.xpath(cdp.CmsDashboard()));
		waitUntilVisibilityOfElement(cdash);
		cdash.findElement(By.xpath(cdp.cmsAssessments())).click();
		asrt.assertEquals(driver.getCurrentUrl(), gp.geturl()+"assessments/list", "URL Not Matched");
		asrt.assertAll();
	}
	
	public void skillMap() {
		WebElement cdash=driver.findElement(By.xpath(cdp.CmsDashboard()));
		waitUntilVisibilityOfElement(cdash);
		cdash.findElement(By.xpath(cdp.skillmap())).click();
		asrt.assertEquals(driver.getCurrentUrl(), gp.geturl()+"publish/skill-map", "URL Not Matched");
		asrt.assertAll();
	}
	
	public void Logout() {
		driver.findElement(By.xpath(cdp.profileicon())).click();
		driver.findElement(By.xpath(cdp.Logout())).click();
	}
}

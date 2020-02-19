package com.kh.IRA.PageHelper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import com.kh.IRA.Pages.CMSdashboardPage;
import com.kh.IRA.TestBase.TestBase;

public class CMSDashBoardHelper extends TestBase {

public static CMSdashboardPage cdp;
	
	public CMSDashBoardHelper() {
		cdp=new CMSdashboardPage();
		asrt=new SoftAssert();
	}
	
	public void questionBank() {
		WebElement cdash=driver.findElement(By.xpath(cdp.CmsDashboard()));
		cdash.findElement(By.xpath(cdp.cmsQuestionBank())).click();
		asrt.assertEquals(driver.getCurrentUrl(), "http://test.kh3ira.com/assessments/question-bank", "URL Not Matched");
		asrt.assertAll();
	}
	
	public void course() {
		WebElement cdash=driver.findElement(By.xpath(cdp.CmsDashboard()));
		cdash.findElement(By.xpath(cdp.cmsCourses())).click();
		asrt.assertEquals(driver.getCurrentUrl(), "http://test.kh3ira.com/publish/courses", "URL Not Matched");
		asrt.assertAll();
	}
	
	public void assessment() {
		WebElement cdash=driver.findElement(By.xpath(cdp.CmsDashboard()));
		cdash.findElement(By.xpath(cdp.cmsAssessments())).click();
		asrt.assertEquals(driver.getCurrentUrl(), "http://test.kh3ira.com/assessments", "URL Not Matched");
		asrt.assertAll();
	}
	
	public void skillMap() {
		WebElement cdash=driver.findElement(By.xpath(cdp.CmsDashboard()));
		cdash.findElement(By.xpath(cdp.skillmap())).click();
		asrt.assertEquals(driver.getCurrentUrl(), "http://test.kh3ira.com/publish/skill-map", "URL Not Matched");
		asrt.assertAll();
	}
}

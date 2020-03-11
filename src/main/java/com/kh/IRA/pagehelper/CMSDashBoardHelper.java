package com.kh.IRA.pagehelper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import com.kh.IRA.pages.CMSdashboardPage;
import com.kh.IRA.pages.GeneralPage;
import com.kh.IRA.testbase.TestBase;

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
		try {
			highlightElement(driver, cdash.findElement(By.xpath(cdp.cmsQuestionBank())));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		cdash.findElement(By.xpath(cdp.cmsQuestionBank())).click();
		asrt.assertEquals(driver.getCurrentUrl(), "http://test.kh3ira.com/assessments/question-bank", "URL Not Matched");
		asrt.assertAll();
	}
	
	public void course() {
		WebElement cdash=driver.findElement(By.xpath(cdp.CmsDashboard()));
		try {
			highlightElement(driver, cdash.findElement(By.xpath(cdp.cmsCourses())));
		} catch (InterruptedException e) {
		
			e.printStackTrace();
		}
		cdash.findElement(By.xpath(cdp.cmsCourses())).click();
		asrt.assertEquals(driver.getCurrentUrl(), "http://test.kh3ira.com/publish/courses", "URL Not Matched");
		asrt.assertAll();
	}
	
	public void assessment() {
		WebElement cdash=driver.findElement(By.xpath(cdp.CmsDashboard()));
		try {
			highlightElement(driver, cdash.findElement(By.xpath(cdp.cmsAssessments())));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		cdash.findElement(By.xpath(cdp.cmsAssessments())).click();
		asrt.assertEquals(driver.getCurrentUrl(), gp.geturl()+"/assessments/list", "URL Not Matched");
		asrt.assertAll();
	}
	
	public void skillMap() {
		WebElement cdash=driver.findElement(By.xpath(cdp.CmsDashboard()));
		try {
			highlightElement(driver, cdash.findElement(By.xpath(cdp.skillmap())));
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		cdash.findElement(By.xpath(cdp.skillmap())).click();
		asrt.assertEquals(driver.getCurrentUrl(), "http://test.kh3ira.com/publish/skill-map", "URL Not Matched");
		asrt.assertAll();
	}
}

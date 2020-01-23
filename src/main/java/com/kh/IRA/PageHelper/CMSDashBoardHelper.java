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
	
	
}

package com.kh.IRA.Utilities;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.kh.IRA.TestBase.TestBase;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Listnershelp extends TestBase implements ITestListener{
	ExtentReports reports;
	ExtentTest test;
	 
	
	@Override
	public void onTestStart(ITestResult result) {
		logHelper.startTestCase(result.getMethod().getMethodName());
		test = reports.startTest(result.getMethod().getMethodName());
		test.log(LogStatus.INFO, result.getMethod().getMethodName() + "Test is started");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		logHelper.addMessage("Test Success : " +result.getName());
		test.log(LogStatus.PASS, result.getMethod().getMethodName() + "Test is passed");
	}
	@Override
	public void onTestFailure(ITestResult result) {
		String dest = null;
		logHelper.addMessage("Test Failed : " +result.getName());
		try {
			dest=Screenshothelp.takeScreenshot();
		} catch (IOException e) {
			e.printStackTrace();
		}
		test.log(LogStatus.FAIL, result.getMethod().getMethodName() + "Test is failed");
		test.log(LogStatus.INFO, "Snapshot below: " + test.addScreenCapture(dest));
	}
	@Override
	public void onTestSkipped(ITestResult result) {
		logHelper.addMessage("Test Skipped : " +result.getName());
		test.log(LogStatus.SKIP, result.getMethod().getMethodName() + "Test is Skipped");
	}
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		 // Not required

	}
	@Override
	public void onStart(ITestContext context) {
		logHelper.addMessage("Test Started");
		logHelper.addMessage("------------------");
		reports = new ExtentReports(new SimpleDateFormat("yyyy-MM-dd hh-mm-ss").format(new Date()) +"_IRA Test Report.html");
	}
	@Override
	public void onFinish(ITestContext context) {
		logHelper.addEndMessage();
		reports.endTest(test);
		reports.flush();
	}
}
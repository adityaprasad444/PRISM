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
	

	public void onTestStart(ITestResult result) {
		System.out.println("Test Started : " +result.getMethod().getMethodName());
		test = reports.startTest(result.getMethod().getMethodName());
		test.log(LogStatus.INFO, result.getMethod().getMethodName() + "Test is started");
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("Test Success : " +result.getName());
		test.log(LogStatus.PASS, result.getMethod().getMethodName() + "Test is passed");
	}

	public void onTestFailure(ITestResult result) {
		String dest = null;
		System.out.println("Test Failed : " +result.getName());
		try {
			dest=Screenshothelp.takeScreenshot();
		} catch (IOException e) {
			e.printStackTrace();
		}
		test.log(LogStatus.FAIL, result.getMethod().getMethodName() + "Test is failed");
		test.log(LogStatus.INFO, "Snapshot below: " + test.addScreenCapture(dest));
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("Test Skipped : " +result.getName());
		test.log(LogStatus.SKIP, result.getMethod().getMethodName() + "Test is Skipped");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onStart(ITestContext context) {
		System.out.println("Test Started");
		System.out.println("------------------");
		reports = new ExtentReports(new SimpleDateFormat("yyyy-MM-dd hh-mm-ss").format(new Date()) +"_IRA Test Report.html");
	}

	public void onFinish(ITestContext context) {
		System.out.println("------------------");
		System.out.println("Test Ended");
		reports.endTest(test);
		reports.flush();
	}
}
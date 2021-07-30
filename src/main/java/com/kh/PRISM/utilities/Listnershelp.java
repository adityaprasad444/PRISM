package com.kh.PRISM.utilities;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.kh.PRISM.testbase.TestBase;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Listnershelp extends TestBase implements ITestListener{
	ExtentReports reports;
	ExtentTest test;
	Logger log = Logger.getLogger(Listnershelp.class);
	
	@Override
	public void onTestStart(ITestResult result) {
		log.info(result.getMethod().getMethodName());
		test = reports.startTest(result.getMethod().getMethodName());
		test.log(LogStatus.INFO, result.getMethod().getMethodName() + "Test is started");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String dest = null;
		log.info("Test Success : " +result.getName());
		try {
			dest=Screenshothelp.takeScreenshot();
		} catch (IOException e) {
			log.info("context", e);

		}
		
		test.log(LogStatus.PASS, result.getMethod().getMethodName() + "Test is passed");
		test.log(LogStatus.INFO, "Screenshot below: " + test.addScreenCapture(dest));
		
	}
	@Override
	public void onTestFailure(ITestResult result) {
		String dest = null;
		log.fatal("Test Failed : " +result.getName());
		try {
			dest=Screenshothelp.takeScreenshot();
		} catch (IOException e) {
			log.info("context", e);

		}
		test.log(LogStatus.FAIL, result.getMethod().getMethodName() + "Test is failed");
		test.log(LogStatus.INFO, "Snapshot below: " + test.addScreenCapture(dest));
	}
	@Override
	public void onTestSkipped(ITestResult result) {
		log.debug("Test Skipped : " +result.getName());
		test.log(LogStatus.SKIP, result.getMethod().getMethodName() + "Test is Skipped");
	}
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		 // Not required

	}
	@Override
	public void onStart(ITestContext context) {
		log.info("Test Started");
		log.info("------------------");
		try {
			myScreenRecorder.startRecording("IRA");
		} catch (Exception e) {
			e.printStackTrace();
		}
		reports = new ExtentReports(new SimpleDateFormat("yyyy-MM-dd hh-mm-ss").format(new Date()) +"_IRA Test Report.html");
	}
	@Override
	public void onFinish(ITestContext context) {
		log.info("------------------");
		try {
			myScreenRecorder.stopRecording();
		} catch (Exception e) {
			e.printStackTrace();
		}
		log.info("Test Ended");
		reports.endTest(test);
		reports.flush();
	}
}
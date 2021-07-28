package com.kh.PRISM.utilities;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.kh.PRISM.testbase.TestBase;

public class Listnershelp extends TestBase implements ITestListener{
	ExtentReports reports;
	ExtentTest test;
	Logger log = Logger.getLogger(Listnershelp.class);
	
	@Override
	public void onTestStart(ITestResult result) {
		log.info(result.getMethod().getMethodName());
		test = reports.createTest(result.getMethod().getMethodName());
		test.log(Status.INFO, result.getMethod().getMethodName() + "Test is started");
	}
	@Override
	public void onTestSuccess(ITestResult result) {
		String dest = null;
		log.info("Test Success : " +result.getName());
		try {
			dest=Screenshothelp.takeScreenshotBase64();
		} catch (IOException e) {
			log.info("context", e);
		}
		test.log(Status.PASS, result.getMethod().getMethodName() + "Test is Passed" +MediaEntityBuilder.createScreenCaptureFromBase64String(dest).build());
	}
	@Override
	public void onTestFailure(ITestResult result) {
		String dest = null;
		log.fatal("Test Failed : " +result.getName());
		try {
			dest=Screenshothelp.takeScreenshotBase64();
		} catch (IOException e) {
			log.info("context", e);
		}
		test.log(Status.FAIL, result.getMethod().getMethodName() + "Test is failed" +MediaEntityBuilder.createScreenCaptureFromBase64String(dest).build());
	}
	@Override
	public void onTestSkipped(ITestResult result) {
		log.debug("Test Skipped : " +result.getName());
		test.log(Status.SKIP, result.getMethod().getMethodName() + "Test is Skipped");
	}
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		 // Not required
	}
	@Override
	public void onStart(ITestContext context) {
		log.info("Test Started");
		reports = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter(new SimpleDateFormat("yyyy-MM-dd hh-mm-ss").format(new Date()) +"_PRISM Test Report.html");
		reports.attachReporter(spark);
		reports.setSystemInfo("OS", "Windows 10 pro");
		reports.setSystemInfo("Environment", "Test (QA)");
		reports.setSystemInfo("CreatedBY", "Aditya Prasad Y");
	}
	@Override
	public void onFinish(ITestContext context) {
		log.info("------------------");
		log.info("Test Ended");
		reports.flush();
	}
}

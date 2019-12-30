package com.kh.IRA.TestBase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public static WebDriver driver;
	public SoftAssert asrt;

	public static WebDriver initialization(String browserName){


		if(browserName.equals("chrome")){
			WebDriverManager.chromedriver().setup();	
			driver = new ChromeDriver();
		}
		else if(browserName.equals("ff")){
			WebDriverManager.firefoxdriver().setup();	
			driver = new FirefoxDriver(); 
		}
		else if(browserName.equals("ie")){
			WebDriverManager.iedriver().setup();	
			driver = new InternetExplorerDriver(); 
		}
		else if(browserName.equals("edge")){
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver(); 
		}
		return driver;

	}
	public static void browsersettings() {
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	public static void destroy() {
		driver.close();
		driver.quit();
	}

}

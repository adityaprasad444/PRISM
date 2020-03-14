package com.kh.IRA.testbase;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public static WebDriver driver = null;
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
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		//driver.manage().timeouts().setScriptTimeout(45, TimeUnit.SECONDS);
	}

	public static void destroy() {
		driver.close();
		driver.quit();
	}

	public static void waitUntilVisibilityOfElement(WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	
	public static void highlightElement(WebDriver driver, WebElement element) throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.border='4px solid yellow'", element);
		Thread.sleep(1000);
		js.executeScript("arguments[0].style.border=''", element);
	}

	public static String readSnackbar() {
		WebDriverWait wait=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.presenceOfElementLocated((By.xpath("//div[contains(@class, 'MuiSnackbar-root')]"))));
		WebElement snackbar=driver.findElement(By.xpath("//div[contains(@class, 'MuiSnackbar-root')]"));
		String message=snackbar.getText();
		return message;
	}
	
	public static String randomString(int n) {
		
		// chose a Character random from this String 
        String random = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"+"0123456789"+"abcdefghijklmnopqrstuvxyz"; 
  
        // create StringBuffer size of AlphaNumericString 
        StringBuilder sb = new StringBuilder(n); 
  
        for (int i = 0; i < n; i++) { 
  
            // generate a random number between 
            // 0 to AlphaNumericString variable length 
            int index = (int)(random.length()* Math.random()); 
  
            // add Character one by one in end of sb 
            sb.append(random.charAt(index)); 
        } 
  
        return sb.toString(); 
    } 

	public static String getDateAndTime()
	{
		SimpleDateFormat scrDateFormat=new SimpleDateFormat("ddMMyyyyHHmmss");
		String date=scrDateFormat.format(new Date());
		return date;
	}
	
	
}

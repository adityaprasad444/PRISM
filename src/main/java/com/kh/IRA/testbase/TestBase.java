package com.kh.IRA.testbase;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public static WebDriver driver = null;
	public SoftAssert asrt;

	
	  public static WebDriver initialization(String browserName){
	  
	  if(browserName.equalsIgnoreCase("chrome")){
	  WebDriverManager.chromedriver().setup();
	  driver = new ChromeDriver(); } 
	  else if(browserName.equalsIgnoreCase("ff")){
	  WebDriverManager.firefoxdriver().setup();
	  driver = new FirefoxDriver(); }
	  else if(browserName.equalsIgnoreCase("edge")){
	  WebDriverManager.edgedriver().setup();
	  driver = new EdgeDriver(); } 
	  return driver;
	  
	  }
	 	
	
	/*public static WebDriver initialization(String browserName){
		
		if(browserName.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver","./src/main/resources/com/kh/IRA/Drivers/chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("FF")) {
			System.setProperty("webdriver.gecko.driver", "./src/main/resources/com/kh/IRA/Drivers/geckodriver.exe");
			driver=new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", "./src/main/resources/com/kh/IRA/Drivers/msedgedriver.exe");
			driver=new EdgeDriver();
		}
		return driver;
	}
	*/
	public static void browsersettings() {
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(45, TimeUnit.SECONDS);
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

	public static String readSnackbar() {
		WebDriverWait wait=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.presenceOfElementLocated((By.xpath("//div[contains(@class, 'MuiSnackbar-root')]"))));
		WebElement snackbar=driver.findElement(By.xpath("//div[contains(@class, 'MuiSnackbar-root')]"));
		return snackbar.getText();
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
		return scrDateFormat.format(new Date());
	}

	public static String dateTimeWithAddedMinutes(String Timezone, int minutes) {

		DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm");
		df.setTimeZone(TimeZone.getTimeZone(Timezone));
		LocalDateTime dateTime = LocalDateTime.now().plus(Duration.of(minutes, ChronoUnit.MINUTES));
		Date tmfn = Date.from(dateTime.atZone(ZoneId.systemDefault()).toInstant());
		return df.format(tmfn);
	}


	public static void mailinatorHelp(String email,String subject) {

		driver.findElement(By.xpath("//input[@id='addOverlay']")).sendKeys(email);
		driver.findElement(By.xpath("//button[@id='go-to-public']")).click();
		List<WebElement> mails=driver.findElements(By.xpath("//tr[@class='even pointer ng-scope']"));
		driver.findElement(By.xpath("//a[@class='cc-btn cc-dismiss']")).click();
		for (int i=1;i<=mails.size();i++) {
			WebElement emailsubject=driver.findElement(By.xpath("//tr[@class='even pointer ng-scope']["+i+"]/td[4]/a"));
			if (emailsubject.getText().equalsIgnoreCase(subject)){
				emailsubject.click();
			}		
		}

		
	}
}

package com.kh.IRA.pagehelper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.asserts.SoftAssert;

import com.kh.IRA.pages.CreateAssessmentPage;
import com.kh.IRA.pages.GeneralPage;
import com.kh.IRA.testbase.TestBase;
import com.kh.IRA.utilities.ExcelReader;

public class CreateAssessmentHelper extends TestBase{

	public CreateAssessmentPage cap;
	public GeneralPage gp;
	public Random rand = new Random();
	public CreateAssessmentHelper() {
		cap=new CreateAssessmentPage();
		gp=new GeneralPage();
		asrt=new SoftAssert();
	}

	public void gotoCreatepage() {
		WebElement create= driver.findElement(By.xpath(cap.createAssessment()));
		waitUntilVisibilityOfElement(create);
		create.click();
		waitUntilVisibilityOfElement(driver.findElement(By.xpath(cap.assessmetName())));
		asrt.assertEquals(driver.getCurrentUrl(), gp.geturl()+"/assessments/create", "Create Page URL not matched");
		asrt.assertAll();
	}

	public void fillData(String Testname) {

		HashMap<String, String> data=ExcelReader.readTestData("CreateAssessment", Testname);
		String s1=data.get("Name");
		String d1=getDateAndTime();
		String s2=s1+d1;
		WebElement name= driver.findElement(By.xpath(cap.assessmetName()));
		waitUntilVisibilityOfElement(name);
		name.sendKeys(s2);
		List <WebElement> des=driver.findElements(By.xpath(cap.assessmentDescription()));
		des.get(0).clear();
		des.get(0).sendKeys(data.get("Description")+d1);
		des.get(1).clear();
		des.get(1).sendKeys(data.get("Instructions"));
	}

	//0-Regular, 1- Group, 2-Mock & 3- Recall_Quiz
	public void fillAssessmentDetails(String type) {

		if(type.equalsIgnoreCase("Mock")) {
			String mock="CreateMock";
			fillData(mock);
			selectAssessmentType(2);
			selectNoOfAttempts();
			selectPassPercentage(mock);
			selectTimerAndSetTime(mock);
			driver.findElement(By.xpath(cap.saveAndNext())).click();

		}else if(type.equalsIgnoreCase("Group")) {
			String group="CreateGroup";
			fillData(group);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
			selectAssessmentType(1);
			selectlogo();
			selectNoOfAttempts();
			selectPassPercentage(group);
			selectTimerAndSetTime(group);
			selectTimeZone(group);
			selectTime(group);
			driver.findElement(By.xpath(cap.saveAndNext())).click();

		}else if (type.equalsIgnoreCase("Recall")) {

			fillData("CreateRecall");
			selectAssessmentType(3);
			driver.findElement(By.xpath(cap.saveAndNext())).click();

		}else if(type.equalsIgnoreCase("Regular")) {

			fillData("CreateRegular");
			selectAssessmentType(0);
			selectNoOfAttempts();
			selectPassPercentage("CreateRegular");
			selectTimerAndSetTime("CreateRegular");
			driver.findElement(By.xpath(cap.saveAndNext())).click();
		}
	}

	//Selecting Assesssment Type based on the Integer Value passed 0-Regular, 1- Group, 2-Mock & 3- Recall_Quiz
	public void selectAssessmentType(int i) {
		List <WebElement> assessmentType=driver.findElements(By.xpath(cap.assessmentType()));
		assessmentType.get(i).click();
	}

	//Selecting number of Attempts from Dropdown list
	public void selectNoOfAttempts() {
		driver.findElement(By.xpath(cap.noOfAttempts())).click();
		List<WebElement> attempt=driver.findElements(By.xpath(cap.attemptList()));
		int num= rand.nextInt(attempt.size());
		attempt.get(num).click();
		System.out.println("limit set to: "+attempt.get(num));
	}

	//sending pass percentage 
	public void selectPassPercentage(String testName) {
		HashMap<String, String> data=ExcelReader.readTestData("CreateAssessment", testName);
		driver.findElement(By.xpath(cap.passPercentage())).sendKeys(data.get("PassPercentage"));
	}

	//selectig assessment level timer and sending time from excel
	public void selectTimerAndSetTime(String testName) {
		HashMap<String, String> data=ExcelReader.readTestData("CreateAssessment", testName);
		driver.findElement(By.xpath(cap.assessmentTimer())).isSelected();
		driver.findElement(By.xpath(cap.assessmentTimer())).click();
		driver.findElement(By.xpath(cap.assessmentTime())).sendKeys(data.get("Time"));
	}

	//selecting timezone using Attempt list locator for ddl list
	public void selectTimeZone(String testName) {
		HashMap<String, String> data=ExcelReader.readTestData("CreateAssessment", testName);
		driver.findElement(By.xpath(cap.timeZone())).click();
		List<WebElement> zones=driver.findElements(By.xpath(cap.attemptList()));
		for (WebElement zone : zones)
		{
			if (zone.getText().equals(data.get("TimeZone")))
			{
				zone.click(); // click the desired Timezone
				break;
			}
		}
	}

	//Adding Start & End Time for the assessment
	public void selectTime(String testName) {
		HashMap<String, String> data=ExcelReader.readTestData("CreateAssessment", testName);
		List <WebElement> times=driver.findElements(By.xpath(cap.timeFields()));
		System.out.println(times);
		WebElement startTime=times.get(0);
		WebElement endTime=times.get(1);
		startTime.sendKeys(data.get("StartTime"));
		endTime.sendKeys(data.get("EndTime"));
	}

	//selecting logo
	public void selectlogo() {
		String filepath = "C:\\Users\\AdityaPrasad\\Desktop\\SeleniumScript\\IRA\\src\\main\\resources\\com\\kh\\IRA\\TestData\\";
		Screen s = new Screen();
		Pattern fileInputTextBox = new Pattern(filepath + "FileTextBox.PNG");
		Pattern openButton = new Pattern(filepath + "OpenButton.PNG");

		driver.findElement(By.xpath(cap.selectlogo())).click();

		try {
			s.wait(fileInputTextBox, 20);
		} catch (FindFailed e) {

			e.printStackTrace();
		}
		try {
			s.type(fileInputTextBox, filepath +"Kh_Logo.png");
		} catch (FindFailed e) {

			e.printStackTrace();
		}
		try {
			s.click(openButton);
		} catch (FindFailed e) {

			e.printStackTrace();
		}


		driver.findElement(By.xpath(cap.logoUpload())).click();
	}

	public void selectQuestions() {

		driver.findElement(By.xpath(cap.selectQuestion())).click();
		//Selecting page size to 50 records
		WebElement ddl=driver.findElement(By.xpath(cap.ddlPagination()));
		waitUntilVisibilityOfElement(ddl);
		ddl.click();
		driver.findElement(By.xpath(cap.pagesize50())).click();

		while(driver.findElement(By.xpath(cap.previouspage())).isDisplayed()) {

			List <WebElement> cb =driver.findElements(By.xpath(cap.selectCheckbox()));

			for (int i=1;i<cb.size();i++) { 

				driver.findElement(By.xpath(cap.c1()+i+cap.c2())).click();
				//if i=2 then 2 checkboxes will be clicked.
				if(i==2) {
					break;
				}

			}
			WebElement element = driver.findElement(By.xpath(cap.confirmSelection()));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
			try { 
				Thread.sleep(1000);
				if(driver.findElement(By.xpath(cap.nextpage())).isDisplayed()) {
					Thread.sleep(1000);
					driver.findElement(By.xpath(cap.nextpage())).click();
					Thread.sleep(2000);
				}

			}catch(Exception e){

				e.printStackTrace();
			}
			try {
				if(driver.findElement(By.xpath(cap.lastpagedisablednext())).isDisplayed()) {
					break;
				}
			}catch(Exception e) { }
		} // while end

		driver.findElement(By.xpath(cap.confirmSelection())).click();
		driver.findElement(By.xpath(cap.createAssessment1())).click();
	} 

}

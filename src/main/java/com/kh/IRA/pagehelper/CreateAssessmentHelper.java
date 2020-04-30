package com.kh.IRA.pagehelper;

import java.util.HashMap;
import java.util.List;
import java.util.Random;
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
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
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

	//1-Regular, 2- Group, 3-Mock , 4- Recall_Quiz & 5-Free Assessment
	public void fillAssessmentDetails(String type) {

		if(type.equalsIgnoreCase("Mock")) {
			String mock="CreateMock";
			fillData(mock);
			selectAssessmentType(3);
			selectlogo();
			selectNoOfAttempts();
			selectPassPercentage(mock);
			selectTimerAndSetTime(mock, 1);
			driver.findElement(By.xpath(cap.saveAndNext())).click();
			selectQuestions(mock);

		}else if(type.equalsIgnoreCase("Group")) {
			String group="CreateGroup";
			fillData(group);
			selectAssessmentType(2);
			selectlogo();
			driver.findElement(By.xpath(cap.sender())).sendKeys("Automation Group Email");
			selectNoOfAttempts();
			selectPassPercentage(group);
			selectTimerAndSetTime(group, 1);
			selectTimeZone(group);
			selectTime(group);
			driver.findElement(By.xpath(cap.saveAndNext())).click();
			selectQuestions(group);
		}else if (type.equalsIgnoreCase("Recall")) {
			String recall="CreateRecall";
			fillData(recall);
			selectAssessmentType(4);
			driver.findElement(By.xpath(cap.saveAndNext())).click();
			selectQuestions(recall);

		}else if(type.equalsIgnoreCase("Regular")) {
			String regular="CreateRegular";
			fillData(regular);
			selectAssessmentType(1);
			selectNoOfAttempts();
			selectPassPercentage(regular);
			selectTimerAndSetTime(regular, 2);
			driver.findElement(By.xpath(cap.saveAndNext())).click();
			selectQuestions(regular);
		}else if(type.equalsIgnoreCase("Free")) {
			String free="Create Free";
			fillData(free);
			selectAssessmentType(5);
			selectNoOfAttempts();
			selectPassPercentage(free);
			selectTimerAndSetTime(free, 1);
			driver.findElement(By.xpath(cap.saveAndNext())).click();
			selectQuestions(free);
		}

	}

	//Selecting Assessment Type based on the Integer Value passed 1-Regular, 2- Group, 3-Mock , 4- Recall_Quiz & 5-Free Assessment
	public void selectAssessmentType(int i) {
		driver.findElement(By.xpath(cap.assessmentType())).click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(By.xpath(cap.ddl1()+i+cap.c2())).click();
	}

	//Selecting number of Attempts from Dropdown list
	public void selectNoOfAttempts() {
		driver.findElement(By.xpath(cap.noOfAttempts())).click();
		List<WebElement> attempt=driver.findElements(By.xpath(cap.attemptList()));
		int num= rand.nextInt(attempt.size());
		attempt.get(num).click();
	}

	//sending pass percentage 
	public void selectPassPercentage(String testName) {
		HashMap<String, String> data=ExcelReader.readTestData("CreateAssessment", testName);
		driver.findElement(By.xpath(cap.passPercentage())).sendKeys(data.get("PassPercentage"));
	}

	//selecting timer and sending time from excel 1-Assessment Level, 2-Non timed.
	public void selectTimerAndSetTime(String testName,int i) {
		HashMap<String, String> data=ExcelReader.readTestData("CreateAssessment", testName);
		driver.findElement(By.xpath(cap.assessmentTimer())).click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(By.xpath(cap.ddl1()+i+cap.c2())).click();
		if (i==1) {
		driver.findElement(By.xpath(cap.assessmentTime())).sendKeys(data.get("Time"));
		}
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

	public void selectQuestions(String testName) {

		HashMap<String, String> data=ExcelReader.readTestData("CreateAssessment", testName);

		driver.findElement(By.xpath(cap.selectQuestion())).click();
		//Selecting page size to 50 records
		WebElement ddl=driver.findElement(By.xpath(cap.ddlPagination()));
		waitUntilVisibilityOfElement(ddl);
		ddl.click();
		driver.findElement(By.xpath(cap.pagesize50())).click();

		//while loop start
		while(driver.findElement(By.xpath(cap.previouspage())).isDisplayed()) {
			List <WebElement> cb =driver.findElements(By.xpath(cap.selectCheckbox()));


			for (int i=1;i<cb.size();i++) { //This will click on the checkbox of given size in if loop.

				driver.findElement(By.xpath(cap.c1()+i+cap.c2())).click();	
				if (i==1){
					break; 
				}
			}
			//getting selected questions count in the question select page
			String questions=driver.findElement(By.xpath(cap.questionsSelected())).getText().substring(19, 21).trim();
			System.out.println("Selected Questions: "+questions);
			WebElement element = driver.findElement(By.xpath(cap.confirmSelection()));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
			int selectedquestions=Integer.parseInt(questions);

			if(selectedquestions==Integer.parseInt(data.get("Number of Questions"))) {
				break;
			}else { 
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
			} 
		}// while end
		driver.findElement(By.xpath(cap.confirmSelection())).click();
		driver.findElement(By.xpath(cap.createAssessment1())).click();

	}
}
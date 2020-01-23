package com.kh.IRA.PageHelper;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Region;
import org.sikuli.script.Screen;
import org.testng.asserts.SoftAssert;

import com.kh.IRA.Pages.CreateMCQPage;
import com.kh.IRA.TestBase.TestBase;
import com.kh.IRA.Utilities.ExcelReader;

public class CreateMCQhelper extends TestBase{

	public static CreateMCQPage mcq;


	public CreateMCQhelper() {
		mcq=new CreateMCQPage();
		asrt=new SoftAssert();

	}

	public void createQuestion() {

		driver.findElement(By.xpath(mcq.CreateQuestion())).click();
	}

	public void selectQuestionType(String type) throws FindFailed {
		Actions act = new Actions(driver);
		Screen s=new Screen();
		WebElement to= driver.findElement(By.xpath(mcq.Space()));

		if(type=="MCQ") {

			driver.switchTo().defaultContent();
			System.out.println(driver.findElement(By.xpath(mcq.MCQ())).getLocation());
			System.out.println(to.getLocation());
			
			  act.moveToElement(driver.findElement(By.xpath(mcq.MCQ())));
			  act.clickAndHold(driver.findElement(By.xpath(mcq.MCQ()))).build().perform();
			  System.out.println(driver.findElement(By.xpath(mcq.MCQ())).getLocation());
			  act.moveToElement(to).build().perform();
			  System.out.println(to.getLocation());
			  act.moveByOffset(699, 344).build().perform();
			  act.release().build().perform();
			  act.release(driver.findElement(By.xpath(mcq.MCQ())));
			  act.build().perform();
			 

			//act.dragAndDropBy(driver.findElement(By.xpath(mcq.MCQ())), 640, 250);
			//s.dragDrop(driver.findElement(By.xpath(mcq.MMCQ())), Region.create(640, 250, 0, 0));

			System.out.println("MCQ Selected");
		}
		else if(type=="MMCQ")
		{

			act.dragAndDrop(driver.findElement(By.xpath(mcq.MMCQ())), to).build().perform();
			System.out.println("MMCQ Selected");
		}
		else if(type=="CodeLab")
		{
			act.dragAndDrop(driver.findElement(By.xpath(mcq.CodeLab())), to).build().perform();
			System.out.println();
		}
	}

	private Object Location(int i, int j) {
		// TODO Auto-generated method stub
		return null;
	}

	public void fillQuestionData() {
		HashMap<String, String> data=ExcelReader.readTestData("MCQ","MCQ");		
		driver.findElement(By.xpath(mcq.Question())).sendKeys(data.get("Question"));
		driver.findElement(By.xpath(mcq.Option1())).sendKeys(data.get("Option1"));
		driver.findElement(By.xpath(mcq.Option2())).sendKeys(data.get("Option2"));
		driver.findElement(By.xpath(mcq.Option3())).sendKeys(data.get("Option3"));
		driver.findElement(By.xpath(mcq.Option4())).sendKeys(data.get("Option4"));
		driver.findElement(By.xpath(mcq.Next())).click();
	}


}

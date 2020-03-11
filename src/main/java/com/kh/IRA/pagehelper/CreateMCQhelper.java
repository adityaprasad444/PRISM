package com.kh.IRA.pagehelper;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.sikuli.script.FindFailed;
import org.testng.asserts.SoftAssert;

import com.kh.IRA.pages.CreateMCQPage;
import com.kh.IRA.testbase.TestBase;
import com.kh.IRA.utilities.ExcelReader;

public class CreateMCQhelper extends TestBase{

	public static CreateMCQPage mcq;

	public CreateMCQhelper() {
		mcq=new CreateMCQPage();
		asrt=new SoftAssert();
	}

	public void createQuestion() {

		driver.findElement(By.xpath(mcq.createQuestion())).click();
	}

	public void selectQuestionType(String type) throws FindFailed, InterruptedException {
		Actions act = new Actions(driver);
		WebElement to= driver.findElement(By.xpath(mcq.space()));

		if(type=="MCQ") {

			dragAndDrop(driver.findElement(By.xpath(mcq.mcq())), to);

			/*
			 * driver.switchTo().defaultContent();
			 * System.out.println(driver.findElement(By.xpath(mcq.MCQ())).getLocation());
			 * System.out.println(to.getLocation());
			 * 
			 * act.moveToElement(driver.findElement(By.xpath(mcq.MCQ())));
			 * act.clickAndHold(driver.findElement(By.xpath(mcq.MCQ()))).build().perform();
			 * System.out.println(driver.findElement(By.xpath(mcq.MCQ())).getLocation());
			 * act.moveToElement(to).build().perform();
			 * System.out.println(to.getLocation()); act.moveByOffset(699,344).build().perform(); act.release().build().perform();
			 * act.release(driver.findElement(By.xpath(mcq.MCQ()))); act.build().perform();
			 */


			//act.dragAndDropBy(driver.findElement(By.xpath(mcq.MCQ())), 640, 250);
			//s.dragDrop(driver.findElement(By.xpath(mcq.MMCQ())), Region.create(640, 250, 0, 0));

			System.out.println("MCQ Selected");
		}
		else if(type=="MMCQ")
		{

			act.dragAndDrop(driver.findElement(By.xpath(mcq.mmcq())), to).build().perform();
			System.out.println("MMCQ Selected");
		}
		else if(type=="CodeLab")
		{
			act.dragAndDrop(driver.findElement(By.xpath(mcq.codeLab())), to).build().perform();
			System.out.println();
		}
	}

	public void fillQuestionData() {
		HashMap<String, String> data=ExcelReader.readTestData("MCQ","MCQ");		
		driver.findElement(By.xpath(mcq.question())).sendKeys(data.get("Question"));
		driver.findElement(By.xpath(mcq.option1())).sendKeys(data.get("Option1"));
		driver.findElement(By.xpath(mcq.option2())).sendKeys(data.get("Option2"));
		driver.findElement(By.xpath(mcq.option3())).sendKeys(data.get("Option3"));
		driver.findElement(By.xpath(mcq.option4())).sendKeys(data.get("Option4"));
		driver.findElement(By.xpath(mcq.next())).click();
	}

	public static void dragAndDrop(WebElement fromWebElement,
			WebElement toWebElement) throws InterruptedException {
		Actions builder = new Actions(driver);
		builder.clickAndHold(fromWebElement).moveToElement(toWebElement)
		.perform();
		Thread.sleep(2000);
		builder.release(toWebElement).build().perform();
	}

}

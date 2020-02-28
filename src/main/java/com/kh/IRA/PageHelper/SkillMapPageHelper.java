package com.kh.IRA.PageHelper;

import java.util.HashMap;
import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;

import com.kh.IRA.Pages.SkillMapPage;
import com.kh.IRA.TestBase.TestBase;
import com.kh.IRA.Utilities.ExcelReader;
import com.kh.IRA.Utilities.RandomDataGenerator;

public class SkillMapPageHelper extends TestBase {
	
	public SkillMapPage smp;	
	
	public SkillMapPageHelper() {
		
		smp=new SkillMapPage();
		asrt= new SoftAssert();
	}
	
	public void createSkill(String sheetName,String testName) {
		int random=RandomDataGenerator.getRandomNumber();
		HashMap<String, String> data=ExcelReader.readTestData(sheetName, testName);
		String s1=data.get("Skill");
		String skill=s1+ Integer.toString(random);
		waitUntilVisibilityOfElement(driver.findElement(By.xpath(smp.addnewskill())));
		driver.findElement(By.xpath(smp.addnewskill())).click();
		driver.findElement(By.xpath(smp.textbox())).sendKeys(skill);
		driver.findElement(By.xpath(smp.addbutton())).click();
		String message=readSnackbar();
		asrt.assertEquals(message, skill+" Skill Added.", "Skill added not matching");	
	}
	public void createSubSkill(String sheetName,String testName) {
		int random=RandomDataGenerator.getRandomNumber();
		HashMap<String, String> data=ExcelReader.readTestData(sheetName, testName);
		String s1=data.get("Subskill");
		String subskill=s1+ Integer.toString(random);
		waitUntilVisibilityOfElement(driver.findElement(By.xpath(smp.addsubskill())));
		driver.findElement(By.xpath(smp.addsubskill())).click();
		driver.findElement(By.xpath(smp.textbox())).sendKeys(subskill);
		driver.findElement(By.xpath(smp.addbutton())).click();
		String message=readSnackbar();
		asrt.assertEquals(message, subskill+" Sub-Skill Added.", "SubSkill added not matching");	
	}
	public void createComptency(String sheetName,String testName) {
		int random=RandomDataGenerator.getRandomNumber();
		HashMap<String, String> data=ExcelReader.readTestData(sheetName, testName);
		String s1=data.get("Competency");
		String competency=s1+ Integer.toString(random);
		waitUntilVisibilityOfElement(driver.findElement(By.xpath(smp.addcompetency())));
		driver.findElement(By.xpath(smp.addcompetency())).click();
		driver.findElement(By.xpath(smp.textbox())).sendKeys(competency);
		driver.findElement(By.xpath(smp.addbutton())).click();
		String message=readSnackbar();
		asrt.assertEquals(message, competency+" Competency Added.", "Competency added not matching");	
	}
}
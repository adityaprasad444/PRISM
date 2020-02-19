package com.kh.IRA.PageHelper;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;

import com.kh.IRA.Pages.SkillMapPage;
import com.kh.IRA.TestBase.TestBase;
import com.kh.IRA.Utilities.ExcelReader;

public class SkillMapPageHelper extends TestBase {
	
	public SkillMapPage smp;	
	public ExcelReader er;
	public SkillMapPageHelper() {
		
		smp=new SkillMapPage();
		asrt= new SoftAssert();
		String path="//src//main//resources//com//kh//IRA//TestData//TestData.xlsx";
		er=new ExcelReader(path);
	}
	
	public void createSkill(String sheetName,String testName) {
		HashMap<String, String> data=er.readTestData(sheetName, testName);
		driver.findElement(By.xpath(smp.addnewskill())).click();
		driver.findElement(By.xpath(smp.textbox())).sendKeys(data.get("Skill"));
		driver.findElement(By.xpath(smp.addbutton())).click();	
	}
	public void createSubSkill(String sheetName,String testName) {
		HashMap<String, String> data=er.readTestData(sheetName, testName);
		driver.findElement(By.xpath(smp.addsubskill())).click();
		driver.findElement(By.xpath(smp.textbox())).sendKeys(data.get("Subskill"));
		driver.findElement(By.xpath(smp.addbutton())).click();
	}
	public void createComptency(String sheetName,String testName) {
		HashMap<String, String> data=er.readTestData(sheetName, testName);
		driver.findElement(By.xpath(smp.addcompetency())).click();
		driver.findElement(By.xpath(smp.textbox())).sendKeys(data.get("Competency"));
		driver.findElement(By.xpath(smp.addbutton())).click();
	}
}

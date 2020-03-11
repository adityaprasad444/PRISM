package com.kh.IRA.pagehelper;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import com.kh.IRA.pages.SkillMapPage;
import com.kh.IRA.testbase.TestBase;
import com.kh.IRA.utilities.ExcelReader;
import com.kh.IRA.utilities.RandomDataGenerator;



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
	
	public void edit() {
		
		waitUntilVisibilityOfElement(driver.findElement(By.xpath(smp.editbutton())));
		List<WebElement> editicon= driver.findElements(By.xpath(smp.editbutton()));
		System.out.println("Total edit icons: "+editicon.size());
		
		for (int i=0;i<editicon.size();i++) {
			String s=randomString(8);
			editicon.get(i).click();
			String type=driver.findElement(By.xpath(smp.popup())).getText();
			driver.findElement(By.xpath(smp.textbox())).clear();
			driver.findElement(By.xpath(smp.textbox())).sendKeys(s);
	
			driver.findElement(By.xpath(smp.save())).click();
	
			String[] words=type.split("-");
			String value=words[0].substring(16).trim();
			if(value.equalsIgnoreCase("Skill")) {
				
				String message=readSnackbar();
				asrt.assertEquals(message, s+" Skill Updated Successfully.", "Edited data not matching");
				
			}else if(value.equalsIgnoreCase("Subskill")) {
				
				String message=readSnackbar();
				asrt.assertEquals(message, s+" Sub-Skill Updated Successfully.", "Edited data not matching");
			}
			else if(value.equalsIgnoreCase("Competency")){
				
				String message=readSnackbar();
				asrt.assertEquals(message, s+" Competency Updated Successfully.", "Edited data not matching");
			}
		}
		
	}
	
	public void searchBox() {
		waitUntilVisibilityOfElement(driver.findElement(By.xpath(smp.searchbox())));
		WebElement search=driver.findElement(By.xpath(smp.searchbox()));
		search.click();
		search.sendKeys(Keys.ARROW_UP);
		search.sendKeys(Keys.ENTER);
		
	}
}
